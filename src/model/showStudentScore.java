package model;

import java.util.List;
import bean.r_score;
import org.hibernate.Query;
import org.hibernate.Session;

import bean.HibernateSessionFactory;
import bean.user;

import com.opensymphony.xwork2.ActionContext;

public class showStudentScore {
	private int currentpage;
	
public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

public String execute(){
	int rows=2;
	int id=(Integer)ActionContext.getContext().getSession().get("u_id");
	Session session=HibernateSessionFactory.getSession();
	String hql="from r_score where s_id =  :id";
	Query query =session.createQuery(hql);
	query.setFirstResult((currentpage-1)*rows);
	query.setMaxResults(rows);
	query.setInteger("id",id);
	List<r_score> datas=query.list();
	session.close();
	ActionContext.getContext().getSession().put("r_score", datas);
	return "success";
}
}
