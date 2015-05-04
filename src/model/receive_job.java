package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bean.HibernateSessionFactory;
import bean.s_job;

import com.opensymphony.xwork2.ActionContext;

public class receive_job {
	private String t_course;
	private String t_title;
	private String t_grade;
	private int currentpage;
	private List records=new ArrayList();
	public String getT_course() {
		return t_course;
	}
	public void setT_course(String t_course) {
		this.t_course = t_course;
	}
	
	public String getT_title() {
		return t_title;
	}
	public void setT_title(String t_title) {
		this.t_title = t_title;
	}
	public String getT_grade() {
		return t_grade;
	}
	public void setT_grade(String t_grade) {
		this.t_grade = t_grade;
	}
	
public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	
public List getRecords() {
		return records;
	}
	public void setRecords(List records) {
		this.records = records;
	}
public String execute(){
	if(t_course!=null)
	{ActionContext.getContext().getSession().put("l1", t_course);
	ActionContext.getContext().getSession().put("l2", t_title);
	ActionContext.getContext().getSession().put("l3", t_grade);
	}
	else
		{t_course=(String) ActionContext.getContext().getSession().get("l1");
		t_title=(String) ActionContext.getContext().getSession().get("l2");
		t_grade=(String) ActionContext.getContext().getSession().get("l3");
		}
	System.out.print(t_course+t_title+t_grade+""+currentpage);
	int rows=2;
	Session session=HibernateSessionFactory.getSession();
	String hql=" from s_job where c_name = :t_course and grade = :t_grade and topic = :t_title order by datetime desc";//查出老师所教授的课程名
	Query query =session.createQuery(hql);
	query.setFirstResult((currentpage-1)*rows);
	query.setMaxResults(rows);
	query.setString("t_course", t_course);
	query.setString("t_grade", t_grade);
	query.setString("t_title", t_title);
	List<s_job> u=query.list();
	for(s_job s:u)
		records.add(s);
	session.close();
	ActionContext.getContext().getSession().put("s_job", records);
	return "success";
}
}
