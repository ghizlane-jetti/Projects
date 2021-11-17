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
@ManagedBean(name="findp")
@RequestScoped
 public class Findp {
	private String fromm;
	private String too;
	private String datee;
	String SQL;
	public Findp() {}
	public Findp(String fromm,String too,String datee)
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

	public List<Findp> getFindpath1() throws ClassNotFoundException , SQLException
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

	List<Findp> reservation = new ArrayList<Findp>();
	PreparedStatement ptsm = con.prepareStatement("Select * from addpath");
	ResultSet rs= ptsm.executeQuery();
	while(rs.next())
	{
    Findp att = new Findp();
    att.setfromm(rs.getString("fromm"));
    att.settoo(rs.getString("too"));
    att.setdatee(rs.getString("datee"));
	reservation.add(att);

	}
	 
	return reservation;

	}

	}

	 
	 
 

