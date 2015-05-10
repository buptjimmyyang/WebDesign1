package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;

import bean.HibernateSessionFactory;
import bean.s_job;

public class searchAction {
private String table;
private int id;
private HttpServletResponse response;//写回响应
private PrintWriter out;
public String getTable() {
	return table;
}
public void setTable(String table) {
	this.table = table;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String execute() throws IOException{
	ActionContext.getContext().getSession().put("search_table", table);
	ActionContext.getContext().getSession().put("search_id", id);
	//System.out.println("table="+table+"id="+id);
	response=ServletActionContext.getResponse();//设置响应数据
    response.setContentType("text/html;charset=utf-8");
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Pargma","no-cache");
    response.setDateHeader("Expires",0);
    out = null;
    out = response.getWriter();
   
	if(table.equals("student"))
	{
		
		
		 out.write("student");
		    out.close();	
	}
	else if(table.equals("teacher"))
	{
		
		 out.write("teacher");
		    out.close();
	}
	else if(table.equals("s_course"))
	{
		
		 out.write("s_course");
		    out.close();
	}
	else if(table.equals("course"))
	{
		
		 out.write("course");
		    out.close();
	}
	
	return null;
}

}
