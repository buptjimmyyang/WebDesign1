package model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;

import bean.HibernateSessionFactory;

public class reply {
	private int t_id;
	private int essay_id;
	private int currentpage;
public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public int getEssay_id() {
		return essay_id;
	}

	public void setEssay_id(int essay_id) {
		this.essay_id = essay_id;
	}

public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

public String execute(){
	int rows=2;
	
	Session session=HibernateSessionFactory.getSession();
	String hql="  from reply where essay_id = :essay_id";//查出老师名
	Query query =session.createQuery(hql);
	query.setFirstResult((currentpage-1)*rows);
	query.setMaxResults(rows);
	query.setInteger("essay_id", essay_id);
	List<String> u=query.list();
	ActionContext.getContext().getSession().put("essay_content", u);
	ActionContext.getContext().getSession().put("essay_id", essay_id);
	return "success";
}
}
