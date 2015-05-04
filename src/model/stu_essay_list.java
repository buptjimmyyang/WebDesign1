package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bean.HibernateSessionFactory;
import bean.t_essay;

import com.opensymphony.xwork2.ActionContext;

public class stu_essay_list {

	private int  currentpage;

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	
	public String execute(){
		List<Integer> tid=new ArrayList<Integer>();
		int id=(Integer)ActionContext.getContext().getSession().get("u_id");
		Session session=HibernateSessionFactory.getSession();
		String hql="select c_id from s_course where s_id = :id";
		Query query =session.createQuery(hql);
		
		query.setInteger("id", id);
		List<Integer> u=query.list();
		for(Integer i:u)
		{
			hql="select t_id from course where c_id = :id";
			query =session.createQuery(hql);
			
			query.setInteger("id", i);
			List<Integer> u1=query.list();
			for(Integer j:u1)
			{
				tid.add(j);
			}
				
		}
		int m=0;
		int rows=2;
		List<t_essay> essay_list=new ArrayList<t_essay>();
		for(m=0;m<tid.size();m++)
		{hql=" from t_essay where t_id = :id order by datetime desc";
		query =session.createQuery(hql);
		query.setFirstResult((currentpage-1)*rows);
		query.setMaxResults(rows);
		query.setInteger("id", tid.get(m));
		List<t_essay> u2=query.list();
		for(t_essay t:u2)
		{
			essay_list.add(t);
			
		}
			
	}
		ActionContext.getContext().getSession().put("essay_list",essay_list);
		return "success";
	}
}
