package modelFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.HibernateSessionFactory;

public class delete_course {
private String c_ids;


public String getC_ids() {
	return c_ids;
}


public void setC_ids(String c_ids) {
	this.c_ids = c_ids;
}


public String execute(){
	String c_id[]=c_ids.split(",");//获得id数组
	Session session=HibernateSessionFactory.getSession();
	for(int i=0;i<c_id.length;i++)//批量删除数据
	{
		Transaction tx=session.beginTransaction();
		String hql="delete from course where c_id = :c_id";
		Query	query=session.createQuery(hql);
			query.setInteger("c_id", Integer.parseInt(c_id[i]));
			query.executeUpdate();
			tx.commit();
		
	}
	session.close();
	return null;
}
}
