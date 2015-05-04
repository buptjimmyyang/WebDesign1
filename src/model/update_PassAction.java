package model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;

public class update_PassAction {
	private String password1;
	private String password2;
	private String password3;
	
public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getPassword3() {
		return password3;
	}

	public void setPassword3(String password3) {
		this.password3 = password3;
	}

public String execute(){
	int id=(Integer) ActionContext.getContext().getSession().get("u_id");
	Session session=HibernateSessionFactory.getSession();
	String hql="select password from user where id =  :id";
	Query query =session.createQuery(hql);
	query.setInteger("id",id);
	List<String> u=query.list();
	String pd=u.get(0);
	
if(password1.equals(pd)&&password2.equals(password3))
{ActionContext.getContext().getSession().put("up_pass","更新密码成功！！");
	Transaction tx=session.beginTransaction();
hql="update user set password= :password3 where password = :pd and id = :id";
	query=session.createQuery(hql);
	query.setString("password3", password3);
	query.setString("pd", pd);
	query.setInteger("id", id);
	query.executeUpdate();
	tx.commit();
	session.close();
	return "success";
	}
else 
{ActionContext.getContext().getSession().put("up_pass","更新密码失败！！");
session.close();
	return "success";}
	
	
	
}
}
