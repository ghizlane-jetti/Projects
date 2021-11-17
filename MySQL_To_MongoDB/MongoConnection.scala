import com.mongodb.casbah.MongoCollection
import com.mongodb.casbah.MongoConnection

object MongoFactory {
  private val SERVER     = "192.168.1.19"
  private val PORT       = 27017
  private val DATABASE   = "Animal"
   
  val connection = MongoConnection(SERVER)
  
  val conDB = connection(DATABASE)
  

}
