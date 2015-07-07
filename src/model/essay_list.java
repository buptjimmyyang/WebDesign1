package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bean.HibernateSessionFactory;
import bean.s_job;
import bean.t_essay;
import bean.user;

import com.opensymphony.xwork2.ActionContext;

public class essay_list {
	private int currentpage;
	private int totalpage;
	int rows=2;//设置一页显示的行数
	
public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

public String execute(){
	total();
	int id=(Integer)ActionContext.getContext().getSession().get("u_id");
	
	Session session=HibernateSessionFactory.getSession();
	String hql=" from t_essay where t_id = :id order by datetime desc";
	Query query =session.createQuery(hql);
	query.setFirstResult((currentpage-1)*rows);
	query.setMaxResults(rows);
	query.setInteger("id", id);
	List<t_essay> u=query.list();
	
	ActionContext.getContext().getSession().put("essay_list", u);
	session.close();
	return "success";
}
public void total(){
	int id=(Integer)ActionContext.getContext().getSession().get("u_id");
	
	Session session=HibernateSessionFactory.getSession();
	String hql=" from t_essay where t_id = :id order by datetime desc";
	Query query =session.createQuery(hql);
	
	query.setInteger("id", id);
	List<t_essay> u=query.list();
	totalpage=u.size()/rows+1;
	session.close();
	
	List<Integer> l=new ArrayList<Integer>();
	for(int i=0;i<totalpage;i++)
		l.add(i+1);
	ActionContext.getContext().getSession().put("totalpage",l);
	
}
}
