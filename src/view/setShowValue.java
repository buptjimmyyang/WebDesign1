package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bean.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;

public class setShowValue {
public String execute(){
	List<String> grade= new ArrayList<String>();
	int id =(Integer) ActionContext.getContext().getSession().get("u_id");
	Session session=HibernateSessionFactory.getSession();
	String hql="select c_name from course where t_id =  :id";//根据教师号查找教师所教授课程名
	Query query =session.createQuery(hql);
	query.setInteger("id",id);
	List<String> u=query.list();
	ActionContext.getContext().getSession().put("course", u);
	hql="select c_id from course where t_id =  :id";//找到课程号
	query =session.createQuery(hql);
	query.setInteger("id",id);
	List<Integer> u1=query.list();
	
	 for(int i:u1)
	 {hql="select s_id from s_course where c_id =  :id";//根据课程号找到学生号
	 query =session.createQuery(hql);
		query.setInteger("id",i);
		List<Integer> u2=query.list();
		for(int j:u2)
		{hql="select grade from student where id =  :id";//根据学生号找到班级
		 query =session.createQuery(hql);
			query.setInteger("id",j);
			List<String> u3=query.list();
			grade.add(u3.get(0));
		//	System.out.println("---");
		//	System.out.println("grade="+u3.get(0));
		}
	 
	 }
	 //消除重复班级
	 HashSet h  =   new  HashSet(grade); 
	    grade.clear(); 
	    grade.addAll(h); 
	 ActionContext.getContext().getSession().put("grade", grade);
	 session.close();
	
	return "success";
}
}
