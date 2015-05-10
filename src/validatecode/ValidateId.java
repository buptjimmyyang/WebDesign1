package validatecode;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;

import bean.HibernateSessionFactory;
import bean.user;

public class ValidateId {
private int id;
private HttpServletResponse response;



public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
public void setResponse(HttpServletResponse response) {
	this.response = response;
}
public String execute() throws IOException{
	
	Session session=HibernateSessionFactory.getSession();
	String hql="from user where id =  :id";
	Query query =session.createQuery(hql);
	query.setInteger("id",id);
	List<user> u=query.list();
	//System.out.print("ajax����"+id);
	//����session
	//HttpSession s1= ServletActionContext.getRequest().getSession();
	 
	
	
	//System.out.println(ActionContext.getContext().getSession().get("backid"));
	session.close();
	//�޸������
    response=ServletActionContext.getResponse();
    response.setContentType("text/xml;charset=utf-8");
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Pargma","no-cache");
    response.setDateHeader("Expires",0);
    PrintWriter out=response.getWriter();
//    out.println("<response>");
//    out.println("<date>"+"1"+"</date>");
//    out.println("<date>"+2+"</date>");
//    out.println("</response>");
   // out.write("ajax response");
    if(u.isEmpty())
		
    out.write("用户名不存在！");
	
    out.close();
	return null;
}
}
