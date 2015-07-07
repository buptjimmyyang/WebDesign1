import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bean.HibernateSessionFactory;
import bean.t_essay;

import com.opensymphony.xwork2.ActionContext;


public class fenye {
	private int currentpage;
	private int totalpage;
	public int getCurrentpage() {
			return currentpage;
		}

		public void setCurrentpage(int currentpage) {
			this.currentpage = currentpage;
		}

	public int getTotalpage() {
			return totalpage;
		}

		public void setTotalpage(int totalpage) {
			this.totalpage = totalpage;
		}

	public String execute(){
		int id=(Integer)ActionContext.getContext().getSession().get("u_id");
		int rows=2;
		Session session=HibernateSessionFactory.getSession();
		String hql=" from t_essay where t_id = :id order by datetime desc";
		Query query =session.createQuery(hql);
//		query.setFirstResult((currentpage-1)*rows);
//		query.setMaxResults(rows);
		query.setInteger("id", id);
		List<t_essay> u=query.list();
		totalpage=u.size();
		ActionContext.getContext().getSession().put("essay_list", u);
		return "success";
	}
	
}
