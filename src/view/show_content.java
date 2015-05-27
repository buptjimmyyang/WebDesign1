package view;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;

import bean.HibernateSessionFactory;
import bean.t_job;

public class show_content {
private int id;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
public String execute(){
	//System.out.print(id+"id===");
	Session session=HibernateSessionFactory.getSession();
	String hql="from t_job where id= :id ";
	Query query=session.createQuery(hql);
	query.setInteger("id", id);
	List<t_job> u1=query.list();
	session.close();
	ActionContext.getContext().getSession().put("job_content",u1.get(0));
	return "success";
}
}
