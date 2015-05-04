package model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.HibernateSessionFactory;
import bean.reply;

import com.opensymphony.xwork2.ActionContext;

public class add_reply {
	private String content;
	
public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

public String execute(){
	String type=(String)ActionContext.getContext().getSession().get("type");
	int id=(Integer)ActionContext.getContext().getSession().get("u_id");
	int essay_id=(Integer)ActionContext.getContext().getSession().get("essay_id");
	
	Session session=HibernateSessionFactory.getSession();
	reply rp=new reply();
   rp.setType(type);
   rp.setContent(content);
   rp.setEssay_id(essay_id);
   rp.setId(id);
   rp.setDatetime(new Date());//设置时间
	//System.out.print(type+"id="+id+"essay_id="+essay_id+"content="+content);

	Transaction tx=null;
	
	try{
		
		tx=session.beginTransaction();
		session.save(rp);
		tx.commit();
		
		
	}
	catch(Exception e){
		System.out.print("添加失败！！！");
		
		tx.rollback();
		
	}
	finally{
		
		session.close();
	}
	return "success";
}
}
