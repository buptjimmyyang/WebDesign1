package modelFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;

import bean.HibernateSessionFactory;
import bean.s_course;
import bean.teacher;

import com.opensymphony.xwork2.ActionContext;

public class search_s_course {
	private String page;
	private String rows;
	private HttpServletResponse response;//写回响应
	private PrintWriter out;
	int s_id=(Integer)ActionContext.getContext().getSession().get("search_id");
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String execute() throws IOException{
		
		int p=Integer.parseInt(page);
		int r=Integer.parseInt(rows);
	String table=(String)ActionContext.getContext().getSession().get("search_table");
	response=ServletActionContext.getResponse();//设置响应数据
    response.setContentType("text/html;charset=utf-8");
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Pargma","no-cache");
    response.setDateHeader("Expires",0);
    out = null;
    out = response.getWriter();
	Session session=HibernateSessionFactory.getSession();
	String hql=" from s_course where s_id like :s_id";//模糊查询
	Query query =session.createQuery(hql);
	query.setFirstResult((p-1)*r);
	query.setMaxResults(r);
	query.setString("s_id",s_id+"%");
	List<s_course> stus=query.list();
	
	Query query1 =session.createQuery(hql);//查询总的记录数
	query1.setString("s_id",s_id+"%");
	List<s_course> stus1=query1.list();//总的记录数保存在stus1
	 session.close();	
	 JSONObject object=new JSONObject();
	 object.put("total",stus1.size());
	 object.put("rows", stus);
	 out.write(object.toString());
	 out.close();
	
		return null;
	}
}
