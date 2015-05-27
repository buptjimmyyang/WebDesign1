package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bean.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;

public class t_set_receive {//级联查找数据
public String execute(){
	//System.out.print("start");
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
		{hql="select distinct grade from student where id =  :id";//根据学生号找到班级
		 query =session.createQuery(hql);
			query.setInteger("id",j);
			List<String> u3=query.list();
			grade.add(u3.get(0));
		//	System.out.println("---");
		//	System.out.println("grade="+u3.get(0));
		}
	 
	 }
	 //通过set去掉list中的重复值重复值
	 HashSet h  =   new  HashSet(grade); 
	    grade.clear(); 
	    grade.addAll(h); 
	 ActionContext.getContext().getSession().put("grade", grade);
	 hql="select  title from t_job  where t_id =  :id";//根据教师号找到教师所发布的题目
	 query =session.createQuery(hql);
		query.setInteger("id",id);
		List<String> u4=query.list();
		ActionContext.getContext().getSession().put("title", u4);
		session.close();
	return "success";
}
}
