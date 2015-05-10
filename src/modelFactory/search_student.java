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
import bean.s_job;
import bean.student;

import com.opensymphony.xwork2.ActionContext;

public class search_student {
	private String page;
	private String rows;
	private HttpServletResponse response;//写回响应
	private PrintWriter out;
	int id=(Integer)ActionContext.getContext().getSession().get("search_id");
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
	String hql=" from student where id like :id";//模糊查询
	Query query =session.createQuery(hql);
	query.setFirstResult((p-1)*r);
	query.setMaxResults(r);
	query.setString("id",id+"%");
	List<student> stus=query.list();
	 session.close();	
	 JSONObject object=new JSONObject();
	 object.put("total",stus.size());
	 object.put("rows", stus);
	 out.write(object.toString());
	 out.close();
		return null;
	}
}
