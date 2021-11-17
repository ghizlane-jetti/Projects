package www.weslni.com;


import javax.faces.context.FacesContext;


import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

public class SessionTest {
	public static HttpSession getSession() {
		return(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}
	public static HttpServletRequest getRequest() {
			return(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		}
	public static String getemail() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return session.getAttribute("email").toString();
	}
	public static String getuserid() {
		HttpSession session = getSession();
		if(session!=null)
			return (String) session.getAttribute("userid");
		else
			return null;
	}
	

}
