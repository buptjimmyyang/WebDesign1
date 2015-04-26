package view;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bean.HibernateSessionFactory;
import bean.t_job;

import com.opensymphony.xwork2.ActionContext;

public class slogin_c {
	private int currentrows;
	private List records=new ArrayList();
	public int getCurrentrows() {
		return currentrows;
	}

	public void setCurrentrows(int currentrows) {
		this.currentrows = currentrows;
	}

	public List getRecords() {
		return records;
	}

	public void setRecords(List records) {
		this.records = records;
	}

	public String execute(){
		String grade= (String) ActionContext.getContext().getSession().get("s_grade");
		Session session=HibernateSessionFactory.getSession();
		String hql="from t_job where grade= :grade";
		Query query=session.createQuery(hql);
		query.setFirstResult((currentrows-1)*1);
		query.setMaxResults(1);
		query.setString("grade",grade);
		List<t_job> u1=query.list();
		for(t_job t:u1)
		{
			records.add(t);
			System.out.print(t.getTitle());
			
		}
			
		session.close();
		
		return "login_c";
	}
}
