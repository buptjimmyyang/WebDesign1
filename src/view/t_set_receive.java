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
	String hql="select c_name from course where t_id =  :id";//�����ʦ�����ڵĿγ���
	Query query =session.createQuery(hql);
	query.setInteger("id",id);
	List<String> u=query.list();
	ActionContext.getContext().getSession().put("course", u);
	hql="select c_id from course where t_id =  :id";//�����ʦ�����ڿγ̵Ŀγ̺�
	query =session.createQuery(hql);
	query.setInteger("id",id);
	List<Integer> u1=query.list();
	
	 for(int i:u1)
	 {hql="select s_id from s_course where c_id =  :id";//���ƿγ̺��ҵ�ѧ��
	 query =session.createQuery(hql);
		query.setInteger("id",i);
		List<Integer> u2=query.list();
		for(int j:u2)
		{hql="select grade from student where id =  :id";//��ѧ���ҵ��༶��
		 query =session.createQuery(hql);
			query.setInteger("id",j);
			List<String> u3=query.list();
			grade.add(u3.get(0));
		}
	 
	 }
	 ActionContext.getContext().getSession().put("grade", grade);
	 hql="select  title from t_job  where t_id =  :id";//��ѯ��ʦ���ù�����Ŀ
	 query =session.createQuery(hql);
		query.setInteger("id",id);
		List<String> u4=query.list();
		ActionContext.getContext().getSession().put("title", u4);
		session.close();
	return "success";
}
}
