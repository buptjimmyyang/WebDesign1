package modelFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.HibernateSessionFactory;
import bean.s_job;
import bean.user;

public class stu_upsave {
public static void save(int s_id,String t_name,String course,String filename,String path,String grade ,String topic){
	Session session=HibernateSessionFactory.getSession();
	String hql="select id from teacher where name = :name";
	Query query =session.createQuery(hql);
	query.setString("name",t_name);
	List<Integer> u=query.list();
	
	int t_id=u.get(0);
	
	s_job sjob=new s_job();
	sjob.setC_name(course);
	sjob.setGrade(grade);
	sjob.setReal_title(path);
	sjob.setS_id(s_id);
	sjob.setT_id(t_id);
	sjob.setTitle(filename);
	sjob.setDatetime(new Date());
	sjob.setTopic(topic);
	Transaction tx=null;
	
	try{
		
		tx=session.beginTransaction();
		session.save(sjob);
		tx.commit();
		
		
	}
	catch(Exception e){
		
		
		tx.rollback();
		
	}
	finally{
		
		session.close();
	}
	
	
}
}
