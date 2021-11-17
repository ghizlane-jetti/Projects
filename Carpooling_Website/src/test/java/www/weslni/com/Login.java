package www.weslni.com;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;


@ManagedBean(name="login")
@SessionScoped
public class Login {
	private String username;
    private String email;
    private String password1;
    private String Dbemail;
    private String Dbpassword;
    Connection connect;
    ResultSet resultat;
    Statement statement;
   
    String SQL;
 
    public String getemail() {
        return email;
    }
 
    public void setemail(String email) {
        this.email = email;
    }
 
    public String getpassword1() {
        return password1;
    }
 
    public void setpassword1(String password1) {
        this.password1 = password1;
    }
    public String getusername() {
        return username;
    }
 
    public void setusername(String username) {
        this.username = username;
    }
    public String getDbusername(String Dbemail)
    {return Dbemail;}
   
    public void setDbusername(String Dbemail)
    {this.Dbemail=Dbemail;}
   
    public String getDbpassword(String Dbpassword)
    {return Dbpassword;}
   
    public void setDbpassword(String Dbpassword)
    {this.Dbpassword=Dbpassword;}
   
    public void dbData(String email)
    {
    try
    {
    Class.forName("com.mysql.jdbc.Driver");
    connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","ghizlane@18");
    statement=connect.createStatement();
    SQL="Select * from inscription where email like ('"+email+"')";
    resultat = statement.executeQuery(SQL);
            resultat.next();
   
    Dbemail = resultat.getString(3).toString();
    Dbpassword = resultat.getString(4).toString();
    username = resultat.getString(2).toString();
    }
    catch(Exception ex)
    {
    ex.printStackTrace();
    System.out.println("Exception Occured in the process :" + ex);}
   }

   
   
   
    
    public String checkValidUser()
    {
        dbData(email);
 
        if(email.equalsIgnoreCase(Dbemail))
        {
 
            if(password1.equals(Dbpassword))
            {
            HttpSession session = SessionTest.getSession();
    session.setAttribute("email", email);

                return "success";
            }
            else
            {
                return "unsuccess";
            }
        }
        else
        {
            return "unsuccess";
     
        }
       
       
    }
   
    public String logout()
    { HttpSession session=SessionTest.getSession();
      session.invalidate();
      return "logout";
    }
}

