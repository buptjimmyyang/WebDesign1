package model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bean.HibernateSessionFactory;
import bean.r_score;

import com.opensymphony.xwork2.ActionContext;

public class teacherShowValue {
private String grade;

public String getGrade() {
	return grade;
}

public void setGrade(String grade) {
	this.grade = grade;
}
public String execute(){
	
	int tea_id=(Integer) ActionContext.getContext().getSession().get("u_id");
	
	Session session=HibernateSessionFactory.getSession();
	String hql=" from r_score where t_id =  :tea_id and grade = :grade order by s_id asc group by title";//根据教师号和班级查找学生成绩
	Query query =session.createQuery(hql);
	query.setInteger("tea_id",tea_id);
	query.setString("grade",grade);
	List<r_score> u=query.list();
	ActionContext.getContext().getSession().put("r_score", u);
	session.close();
	
	return "success";
}
}
