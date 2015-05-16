package modelFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.HibernateSessionFactory;

public class updata_teacher {
	private int id;
	private String name;
	private String type;
	private String institute;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String execute(){
		//保存修改的学生信息
		Session session=HibernateSessionFactory.getSession();
		Transaction tx=session.beginTransaction();
		String hql="update teacher set name= :name ,type = :type ,institute = :institute where id = :id";
		Query	query=session.createQuery(hql);
			query.setInteger("id", id);
			query.setString("name", name);
			query.setString("type", type);
			query.setString("institute", institute);
			query.executeUpdate();
			tx.commit();
			session.close();
		
		return null;
	}
}
