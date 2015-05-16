package modelFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.HibernateSessionFactory;

public class delete_student {
private String ids;

public String getIds() {
	return ids;
}

public void setIds(String ids) {
	this.ids = ids;
}
public String execute(){
	String ides[]=ids.split(",");//获得id数组
	Session session=HibernateSessionFactory.getSession();
	for(int i=0;i<ides.length;i++)//批量删除student数据
	{
		Transaction tx=session.beginTransaction();
		String hql="delete from student where id = :id";
		Query	query=session.createQuery(hql);
			query.setInteger("id", Integer.parseInt(ides[i]));
			query.executeUpdate();
			tx.commit();
		
	}
	
	for(int i=0;i<ides.length;i++)//同时删除学生登录user信息表批量删除数据
	{
		Transaction tx=session.beginTransaction();
		String hql="delete from user where id = :id";
		Query	query=session.createQuery(hql);
			query.setInteger("id", Integer.parseInt(ides[i]));
			query.executeUpdate();
			tx.commit();
		
	}
	for(int i=0;i<ides.length;i++)//同时删除学生选课信息表批量删除数据
	{
		Transaction tx=session.beginTransaction();
		String hql="delete from s_course where s_id = :id";
		Query	query=session.createQuery(hql);
			query.setInteger("id", Integer.parseInt(ides[i]));
			query.executeUpdate();
			tx.commit();
		
	}
	session.close();
	return null;
}
}
