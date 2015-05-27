package view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

	public String execute() throws ParseException{
		int id=(Integer) ActionContext.getContext().getSession().get("u_id");
		ActionContext.getContext().getSession().put("u_id", id);
		int rows=2;//设置每页显示两行
		String grade= (String) ActionContext.getContext().getSession().get("s_grade");
		Session session=HibernateSessionFactory.getSession();
		String hql="from t_job where grade= :grade order by datetime desc";
		Query query=session.createQuery(hql);
		query.setFirstResult((currentrows-1)*rows);
		query.setMaxResults(rows);
		query.setString("grade",grade);
		List<t_job> u1=query.list();
		for(t_job t:u1)
		{String datetime=t.getDatetime().toLocaleString();
			
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//	String time_str = df.format(t.getDatetime().getTime());
		Date time=df.parse(datetime);
		t.setDatetime(time);
		//System.out.println(datetime);
		//t.setDatetime(datetime);
			records.add(t);
		
			
		}
			
		session.close();
		
		return "login_c";
	}
}
