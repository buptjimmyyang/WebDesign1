package modelFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;














import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;

import bean.HibernateSessionFactory;
import bean.course;
import bean.s_course;
import bean.student;
import bean.teacher;
import bean.user;
public class excel_Db {
	private String table;
	
public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

public String execute(){
	
    
	
	 
	if(table.equals("student"))//如果为学生
	{
		String response1= (String)ActionContext.getContext().getSession().get("response");
		
		JSONObject object =JSONObject.fromObject(response1);
		JSONArray array= (JSONArray) object.get("rows");
		student[] stus=(student[]) JSONArray.toArray(array,student.class);
		Session session=HibernateSessionFactory.getSession();//打开连接池准备写数据
		Transaction tx=null;
		int flag=0;
		try{
					for(student stu:stus)
					{
					
			    tx=session.beginTransaction();
			    session.save(stu);
			
		}
					session.flush();//批量存储数据若不符合条件则均不能添加到数据库
					session.clear();
					tx.commit();
				}
			catch(Exception e)
	         {flag=1;
				System.out.println("学生批量添加失败");
	          tx.rollback();}
		
	      if(flag==0)//添加student成功将数据添加到user
	      {for(student stu:stus)
			{
			user u=new user();
			u.setId(stu.getId());
			u.setPassword("1111");//学生用户设置密码为1111
			u.setType(stu.getType());
	       tx=session.beginTransaction();
	       session.save(u);
   }
			session.flush();//批量存储数据若不符合条件则均不能添加到数据库
			session.clear();
			tx.commit();
		}
	
	    	  
	      
	      session.close();
	    if(flag==1)
   		return "ffff";

	}else if(table.equals("s_course"))
	{
			String response1 = (String) ActionContext.getContext().getSession()
					.get("response");

			JSONObject object = JSONObject.fromObject(response1);
			JSONArray array = (JSONArray) object.get("rows");
			s_course[] scous = (s_course[]) JSONArray.toArray(array,
					s_course.class);
			Session session = HibernateSessionFactory.getSession();// 打开连接池准备写数据
			Transaction tx = null;
			int flag = 0;
			try {
				for (s_course scou : scous) {
					
					tx = session.beginTransaction();
					session.save(scou);
				}
				session.flush();// 批量存储数据若不符合条件则均不能添加到数据库
				session.clear();
				tx.commit();
			} catch (Exception e) {
				flag = 1;
				System.out.println("学生课程批量添加失败");
				tx.rollback();
			} finally {

				session.close();
			}
			if (flag == 1)
				return "ffff";

	}
	else if(table.equals("teacher"))
	{
String response1= (String)ActionContext.getContext().getSession().get("response");
		
		JSONObject object =JSONObject.fromObject(response1);
		JSONArray array= (JSONArray) object.get("rows");
		teacher[] teas=(teacher[]) JSONArray.toArray(array,teacher.class);
		Session session=HibernateSessionFactory.getSession();//打开连接池准备写数据
		Transaction tx=null;
		int flag=0;
		try{
					for(teacher tea:teas)
					{
			tx=session.beginTransaction();
			session.save(tea);
		}
					session.flush();//批量存储数据若不符合条件则均不能添加到数据库
					session.clear();
					tx.commit();
				}
			catch(Exception e)
	         {flag=1;
				System.out.println("教师批量添加失败");
	          tx.rollback();}
		
			
			
		
	  if(flag==0) 
	  {		for(teacher tea:teas)
		{
		  user u =new user();
		  u.setId(tea.getId());
		  u.setPassword("1111");//设置教师的默认密码也为1111
		  u.setType(tea.getType());
tx=session.beginTransaction();
session.save(u);
}
		session.flush();//批量存储数据若不符合条件则均不能添加到数据库
		session.clear();
		tx.commit();
	 }
	  session.close();
	if(flag==1)
   		return "ffff";
	}
	else if(table.equals("course"))
	{String response1= (String)ActionContext.getContext().getSession().get("response");
	
	JSONObject object =JSONObject.fromObject(response1);
	JSONArray array= (JSONArray) object.get("rows");
	course[] cous=(course[]) JSONArray.toArray(array,course.class);
	Session session=HibernateSessionFactory.getSession();//打开连接池准备写数据
	Transaction tx=null;
	int flag=0;
	try{
				for(course cou:cous)
				{
		tx=session.beginTransaction();
		session.save(cou);
	}
				session.flush();//批量存储数据若不符合条件则均不能添加到数据库
				session.clear();
				tx.commit();
			}
		catch(Exception e)
         {flag=1;
			System.out.println("教师课程批量添加失败");
          tx.rollback();}
	finally{
		
		 session.close();
	}
	if(flag==1)
   		return "ffff";
	}
	return null;
}
}
