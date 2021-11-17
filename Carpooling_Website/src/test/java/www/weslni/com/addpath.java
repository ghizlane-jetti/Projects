package www.weslni.com;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.*;
import java.util.Date.*;
import java.sql.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ManagedBean(name = "addpath")
@RequestScoped
public class addpath  {
	String SQL;

    private String fromm;
    private String too;
    private String datee;
    private String heure;
    private String price;
    public List<?> allData;
    
    

   

    

    public String getfromm() {
        return fromm;
    }

    public void setfromm(String fromm) {
        this.fromm = fromm;
    }

    public String gettoo() {
        return too;
    }

    public void settoo(String too) {
        this.too = too;
    }

    public String getdatee() {
        return datee;
    }

    public void setdatee(String datee) {
        this.datee = datee;
    }

    public String getheure() {
        return heure;
    }
    public void setheure(String heure) {
        this.heure = heure;
    }
    

    public void setprice(String price) {
        this.price = price;}
        
    public String getprice() {
            return price;
        }

       
            
    public String add() {
    
    	int i = 0;
            try {
            PreparedStatement ps = null;
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "ghizlane@18");

                        SQL = "INSERT INTO addpath(fromm, too, datee, heure, price) VALUES(?,?,?,?,?)";
                
                        ps = con.prepareStatement(SQL);
                        ps.setString(1, fromm);
                        ps.setString(2, too);
                        ps.setString(3, datee);
                        ps.setString(4, heure);
                        ps.setString(5, price);
                       
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