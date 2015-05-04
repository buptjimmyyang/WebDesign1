package view;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bean.HibernateSessionFactory;
import bean.s_job;
import bean.t_job;

import com.opensymphony.xwork2.ActionContext;

public class stu_uphistory {
	private int currentrows;
	private List<s_job> records=new ArrayList<s_job>();
	public int getCurrentrows() {
		return currentrows;
	}
	public void setCurrentrows(int currentrows) {
		this.currentrows = currentrows;
	}
	

public List<s_job> getRecords() {
		return records;
	}
	public void setRecords(List<s_job> records) {
		this.records = records;
	}
public String execute(){
	int rows=2;//设置一页显示的数目
	//System.out.print(currentrows);
	int id=(Integer) ActionContext.getContext().getSession().get("u_id");
	Session session=HibernateSessionFactory.getSession();
	String hql="from s_job where s_id= :id order by datetime desc";
	Query query=session.createQuery(hql);
	query.setFirstResult((currentrows-1)*rows);
	query.setMaxResults(rows);
	query.setInteger("id", id);
	List<s_job> u1=query.list();
	for(s_job s:u1)
		records.add(s);
	session.close();
	
	
	ActionContext.getContext().getSession().put("s_upHistory",records);
	return "success";
}
}
