package modelFactory;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.HibernateSessionFactory;
import bean.s_job;
import bean.t_job;

public class save_publish {
public static void save(int t_id,String title,String content,String grade,String c_name,String path){
	
	Session session=HibernateSessionFactory.getSession();
	t_job job=new t_job();
	job.setT_id(t_id);
	job.setTitle(title);
	job.setContent(content);
	job.setGrade(grade);
	job.setC_name(c_name);
	job.setReal_title(path);
	job.setDatetime(new Date());//����ʱ��
	

	Transaction tx=null;
	
	try{
		
		tx=session.beginTransaction();
		session.save(job);
		tx.commit();
		
		
	}
	catch(Exception e){
		System.out.print("保存publish失败");
		
		tx.rollback();
		
	}
	finally{
		
		session.close();
	}
	
	
}
}
