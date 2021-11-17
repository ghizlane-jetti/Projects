package www.weslni.com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ManagedBean(name="dataAction")
@RequestScoped

public class DataAction {
private String fromm;
private String too;
private String datee;

String SQL;
public DataAction() {}
public DataAction(String fromm,String too,String datee)
{this.fromm=fromm;
 this.too=too;
 this.datee=datee;
}



public String getfromm()
{return fromm;}
public void setfromm(String fromm)
{this.fromm=fromm;}


public String gettoo()
{return too;}
public void settoo(String too)
{this.too=too;}


public String getdatee()
{return datee;}
public void setdatee(String datee)
{this.datee=datee;}




public List<DataAction> getreservation() throws ClassNotFoundException , SQLException
{
Connection con= null;
try {
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","ghizlane@18");

}

catch(SQLException ex)
{ System.out.println("in exec");
 System.out.println(ex.getMessage());
}

List<DataAction> reservations = new ArrayList<DataAction>();
PreparedStatement ptsm = con.prepareStatement("Select fromm,too,SUBSTRING(datee, 1, 10) AS datee from addpath");
ResultSet rs= ptsm.executeQuery();
while(rs.next())
{
DataAction action = new DataAction();
action.setfromm(rs.getString("fromm"));
action.settoo(rs.getString("too"));
action.setdatee(rs.getString("datee"));
reservations.add(action);

}
 
return reservations;

}

}