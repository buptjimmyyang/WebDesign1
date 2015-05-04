package model;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import modelFactory.show_tjob;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;

import bean.HibernateSessionFactory;
import bean.user;

public class UserLoginAction {
private int id;
private String password;

private String type;
private String validatecode;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}




public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getValidatecode() {
	return validatecode;
}
public void setValidatecode(String validatecode) {
	this.validatecode = validatecode;
}
public String execute() throws UnsupportedEncodingException{
	//String validate=(String) ActionContext.getContext().getSession().get("validation_code");
	//ActionContext.getContext().getSession().put("userid", id);
//	System.out.println("输入验证码为"+validate);
//	System.out.println("真实验证码为"+validatecode);
//	System.out.println(type);
//	Session session=HibernateSessionFactory.getSession();
//	Criteria crit=session.createCriteria(user.class);
//	crit.add(Restrictions.eq("type", type));
//	List<user> u=crit.list();
//	for(user u1:u)
//	{
//		System.out.print(u1.getId()+" "+u1.getPassword()+u1.getType());
//	}
//	session.close();
	
	Session session=HibernateSessionFactory.getSession();
	String hql="from user where id =  :id";
	Query query =session.createQuery(hql);
	query.setInteger("id",id);
	List<user> u=query.list();
	session.close();
	user u1=u.get(0);
	//equels比较两个值是否相等 ==是否是同一对象的引用
	if(u.size()==0)
	{
		return "loginfail";
	}
		
	else
	{
		
		if(u1.getId()==id&&(u1).getPassword().equals(password)&&type.equals("学生")&&u1.getType().equals(type))
		{   ActionContext.getContext().getSession().put("u_id",id);
		ActionContext.getContext().getSession().put("type","学生");
			show_tjob.showjob(id);
			return "studentlogin";
			}
			
		else if(u1.getId()==id&&(u1).getPassword().equals(password)&&type.equals("老师")&&u1.getType().equals(type))
			{
			ActionContext.getContext().getSession().put("u_id",id);
			ActionContext.getContext().getSession().put("type","老师");
			return "teacherlogin";
			}
		else if(u1.getId()==id&&(u1).getPassword().equals(password)&&type.equals("管理员")&&u1.getType().equals(type))
			return "adminlogin";
		else 
		{
			return "loginfail";
		}
			
	}
	
}
}
