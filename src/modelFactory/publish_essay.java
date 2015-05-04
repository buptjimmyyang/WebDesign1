package modelFactory;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.HibernateSessionFactory;
import bean.t_essay;


public class publish_essay {
public static void save_essay(String title,String c_name,int t_id){
	
	Session session=HibernateSessionFactory.getSession();
	t_essay essay=new t_essay();
	essay.setTitle(c_name+"_"+title);
	essay.setT_id(t_id);
	essay.setContent("����鿴��ϸ����");
	essay.setDatetime(new Date());//����ʱ��
	

	Transaction tx=null;
	
	try{
		
		tx=session.beginTransaction();
		session.save(essay);
		tx.commit();
		
		
	}
	catch(Exception e){
		System.out.print("���ʧ�ܣ�����");
		
		tx.rollback();
		
	}
	finally{
		
		session.close();
	}
	
}
}
