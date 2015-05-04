package view;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bean.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;

public class t_set_receive {
public String execute(){
	List<String> grade= new ArrayList<String>();
	int id =(Integer) ActionContext.getContext().getSession().get("u_id");
	Session session=HibernateSessionFactory.getSession();
	String hql="select c_name from course where t_id =  :id";//查出老师所教授的课程名
	Query query =session.createQuery(hql);
	query.setInteger("id",id);
	List<String> u=query.list();
	ActionContext.getContext().getSession().put("course", u);
	hql="select c_id from course where t_id =  :id";//查出老师所教授课程的课程号
	query =session.createQuery(hql);
	query.setInteger("id",id);
	List<Integer> u1=query.list();
	
	 for(int i:u1)
	 {hql="select s_id from s_course where c_id =  :id";//估计课程号找到学号
	 query =session.createQuery(hql);
		query.setInteger("id",i);
		List<Integer> u2=query.list();
		for(int j:u2)
		{hql="select grade from student where id =  :id";//由学号找到班级名
		 query =session.createQuery(hql);
			query.setInteger("id",j);
			List<String> u3=query.list();
			grade.add(u3.get(0));
		}
	 
	 }
	 ActionContext.getContext().getSession().put("grade", grade);
	 hql="select  title from t_job  where t_id =  :id";//查询老师布置过的题目
	 query =session.createQuery(hql);
		query.setInteger("id",id);
		List<String> u4=query.list();
		ActionContext.getContext().getSession().put("title", u4);
		session.close();
	return "success";
}
}
