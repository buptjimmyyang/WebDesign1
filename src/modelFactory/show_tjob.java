package modelFactory;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;

import bean.HibernateSessionFactory;
import bean.t_job;
import bean.user;

public class show_tjob {
public static void showjob(int id){
	Session session=HibernateSessionFactory.getSession();
	String hql="select grade from student where id =  :id";
	Query query =session.createQuery(hql);
	query.setInteger("id",id);
	List<String> u=query.list();
	String grade=u.get(0);
//	hql="from t_job where grade= :grade";
//	query=session.createQuery(hql);
//	query.setString("grade",grade);
//	List<t_job> u1=query.list();
	
	session.close();
	ActionContext.getContext().getSession().put("s_grade",grade);
	ActionContext.getContext().getSession().put("u_id",id);
}
}
