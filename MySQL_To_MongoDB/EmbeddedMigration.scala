import java.sql.{ Connection, DriverManager }
import com.mongodb.casbah.Imports._
import Common._
import com.mongodb.BasicDBObject

object migrating extends App {
  
  
  val url = "jdbc:mysql://10.5.1.27:3306/Animal"
  val driver = "com.mysql.jdbc.Driver"
  val username = "root"
  val password = "password"
  var connection: Connection = _
   try {
    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement
    val stat = connection.createStatement
    val parcours = connection.createStatement
    val statement_ref = connection.createStatement
    val stat_ref = connection.createStatement
    val stat_ref2 = connection.createStatement
    val parcours_ref = connection.createStatement
    var embedded : Boolean = false
    var ObjectRef = MongoDBObject.newBuilder.result
    var rs = statement.executeQuery("show tables;")
    while (rs.next) {
      var collection = rs.getString("Tables_in_Animal")
      println("table = %s".format(collection))
      var ligne = parcours.executeQuery("SELECT * FROM "+collection+" ;")
      while(ligne.next){
        val builder = MongoDBObject.newBuilder
        var des = stat.executeQuery("DESCRIBE "+collection+" ;")
          while(des.next){
            var l = des.getString("Field")
            var value = ligne.getObject(l)
            var rs_ref = statement_ref.executeQuery("show tables;")
            embedded = false
            while (rs_ref.next ) {
             
                  var collection_ref = rs_ref.getString("Tables_in_Animal")
                  if(collection != collection_ref && embedded == false){
                          
                          var des_ref = stat_ref.executeQuery("DESCRIBE "+collection_ref+" ;")
                          while(des_ref.next){
                          var l_ref = des_ref.getString("Field")
                          
                          if(l == (collection_ref+"_"+l_ref).toLowerCase()){
                              embedded = true
                              println("col_ref = %s".format(collection_ref))
                              println("l_ref = %s".format(l_ref))
                              println("like value = %s".format(value))
                              var ligne_ref = parcours_ref.executeQuery("SELECT * FROM "+collection_ref+" WHERE "+l_ref+" LIKE '"+value+"' ;")
                              while(ligne_ref.next){
                                  val builder_ref = MongoDBObject.newBuilder
                                  var des_ref = stat_ref2.executeQuery("DESCRIBE "+collection_ref+" ;")
                                  while(des_ref.next){
                                  var l_ref = des_ref.getString("Field")
                                  builder_ref += l_ref -> ligne_ref.getObject(l_ref)
                                  println("column_ref bbb= %s".format(l_ref))
            
                                 }
                                ObjectRef = builder_ref.result
                            }
                              println("key %s in  %s referes to %s in %s".format(l,collection,l_ref,collection_ref))
                              
                           }  
        
                          }
                        }
                }
                if(!embedded){
                builder += l -> value
                println("column = %s".format(l))}
                else{
                builder += l -> ObjectRef
                println("column = %s".format(l))
                }
            
       }
        MongoFactory.conDB(collection).save(builder.result)
      }
      
    }
  } catch {
    case e: Exception => e.printStackTrace
  }
  connection.close
  
 
  
}
  

  