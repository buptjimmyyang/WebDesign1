package modelFactory;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.HibernateSessionFactory;
import bean.student;

public class updata_student {
private int id;
private String name;
private String type;
private String grade;
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
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public String execute(){
	//保存修改的学生信息
	Session session=HibernateSessionFactory.getSession();
	Transaction tx=session.beginTransaction();
	String hql="update student set name= :name ,type = :type ,grade = :grade where id = :id";
	Query	query=session.createQuery(hql);
		query.setInteger("id", id);
		query.setString("name", name);
		query.setString("type", type);
		query.setString("grade", grade);
		query.executeUpdate();
		tx.commit();
		session.close();
	
	return null;
}
}
