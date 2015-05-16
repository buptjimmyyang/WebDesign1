package model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;

import bean.HibernateSessionFactory;
import bean.s_job;

public class teacherValueAction {
private String t_course;
private String t_title;
private String t_grade;
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
public String execute()
{//查找所所教师班级所有学生信息
	ActionContext.getContext().getSession().put("t_course",t_course);
	ActionContext.getContext().getSession().put("t_title",t_title);
	ActionContext.getContext().getSession().put("t_grade",t_grade);
	Session session=HibernateSessionFactory.getSession();
	String hql="select id from student where grade= :grade";//查找要评分班级所有学生信息
	Query query =session.createQuery(hql);
	query.setString("grade", t_grade);
    List<Integer> All_Grade_Id=query.list();
	session.close();
	 ActionContext.getContext().getSession().put("All_Grade_Id",All_Grade_Id);
return"success";}
}
