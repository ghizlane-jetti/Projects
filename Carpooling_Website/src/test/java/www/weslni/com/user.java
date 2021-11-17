package www.weslni.com;


import javax.faces.application.FacesMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.faces.component.UIComponent;
import javax.faces.validator.ValidatorException;



@ManagedBean(name = "user")
@RequestScoped
public class user  {
	String SQL;

    private String username;
    private String password1;
    private String password2;
    private String email;
    private String phone;
    private String gender;
    

   

    

    public String getusername() {
        return username;
    }

    public void setusername(String usernname) {
        this.username = usernname;
    }

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
        this.password1 = password1;}
        
    public String getpassword2() {
            return password2;
        }

        public void setpassword2(String password2) {
            this.password2 = password2;
    }
        public String getgender() {
            return gender;
        }

        public void setgender(String gender) {
            this.gender = gender;
        }
        public String getphone() {
            return phone;
        }

        public void setphone(String phone) {
            this.phone = phone;
        }
        public void validateemail(FacesContext context, UIComponent component, Object value) {

            
                
            }
        
       
            
            
    public String add() {
    
    	int i = 0;
            try {
            PreparedStatement ps = null;
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "ghizlane@18");

                        SQL = "INSERT INTO inscription(username, email, password1, password2, phone, gender) VALUES(?,?,?,?,?,?)";
                
                        ps = con.prepareStatement(SQL);
                        ps.setString(1, username);
                        ps.setString(2, email);
                        ps.setString(3, password1);
                        ps.setString(4, password2);
                        ps.setString(5, phone);
                        ps.setString(6, gender);
                        i = ps.executeUpdate();
                    
                
            } catch (Exception e) {
                System.out.println(e);
            } 
        if (i > 0) {
            return "success";
        } else
            return "unsuccess";
    }

}