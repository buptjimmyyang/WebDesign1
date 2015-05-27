package view;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;

import bean.HibernateSessionFactory;

public class fileup {
	private List<String> courses=new ArrayList();
	private List<String> teachers=new ArrayList();
	private List<Integer> t_ids=new ArrayList();
	private List<String> titles=new ArrayList();
	public String execute(){
		//���ѧ��Ϊid��ѡ�޵Ŀγ�
		int id=(Integer) ActionContext.getContext().getSession().get("u_id");
		String grade=(String) ActionContext.getContext().getSession().get("s_grade");
		Session session=HibernateSessionFactory.getSession();
		String hql="select c_id from s_course where s_id =  :id";
		Query query =session.createQuery(hql);
		query.setInteger("id",id);
		List<Integer> c_ids =query.list();
		int i;
		for(i=0;i<c_ids.size();i++)
		{//��ѯ��ʦ��
			hql="select t_id from course where c_id =  :c_id";
		query =session.createQuery(hql);
		query.setInteger("c_id",c_ids.get(i)); 
		for(int j=0;j<query.list().size();j++)
		t_ids.add((Integer) query.list().get(j));
		//��ѯ�γ���
		hql="select c_name from course where c_id =  :c_id";
		query =session.createQuery(hql);
		query.setInteger("c_id",c_ids.get(i)); 
		courses.add((String) query.list().get(0));
		}
		//��ѯ��ʦ��
		for(i=0;i<t_ids.size();i++)
		{hql="select name from teacher where id =  :id";
		query =session.createQuery(hql);
		query.setInteger("id",t_ids.get(i));
		teachers.add((String)query.list().get(0));
		}
		//��Ŀ��
		hql="select title from t_job where grade =  :grade";
		query =session.createQuery(hql);
		query.setString("grade",grade);
		for(i=0;i<query.list().size();i++)
		titles.add((String)query.list().get(i));
		//���session
		ActionContext.getContext().getSession().put("course", courses);
		
		ActionContext.getContext().getSession().put("teacher", teachers);
		ActionContext.getContext().getSession().put("title", titles);
		
//		System.out.println(courses);
//		System.out.println(teachers);
//		System.out.println(titles);
		return "fileup";
	}

}
