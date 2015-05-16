package modelFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.HibernateSessionFactory;

public class delete_s_course {
private String s_ids;
private String c_ids;

public String getS_ids() {
	return s_ids;
}

public void setS_ids(String s_ids) {
	this.s_ids = s_ids;
}

public String getC_ids() {
	return c_ids;
}

public void setC_ids(String c_ids) {
	this.c_ids = c_ids;
}

public String execute(){
	String s_id[]=s_ids.split(",");//获得id数组
	String c_id[]=c_ids.split(",");
	Session session=HibernateSessionFactory.getSession();
	for(int i=0;i<s_id.length;i++)//批量删除数据
	{
		Transaction tx=session.beginTransaction();
		String hql="delete from s_course where s_id = :s_id and c_id = :c_id";
		Query	query=session.createQuery(hql);
			query.setInteger("s_id", Integer.parseInt(s_id[i]));
			query.setInteger("c_id", Integer.parseInt(c_id[i]));
			query.executeUpdate();
			tx.commit();
		
	}
	session.close();
	return null;
}
}
