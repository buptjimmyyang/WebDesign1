package model;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.HibernateSessionFactory;
import bean.r_score;

import com.opensymphony.xwork2.ActionContext;

public class finish_value_score {
private int[] score;

public int[] getScore() {
	return score;
}

public void setScore(int[] score) {
	this.score = score;
}
public String execute(){
	String t_course=(String) ActionContext.getContext().getSession().get("t_course");
	String t_title=(String) ActionContext.getContext().getSession().get("t_title");
	String t_grade=(String) ActionContext.getContext().getSession().get("t_grade");
	ArrayList<Integer> id=(ArrayList<Integer>)ActionContext.getContext().getSession().get("All_Grade_Id");
	int tea_id=(Integer)ActionContext.getContext().getSession().get("u_id");
	
	//保存分数
	Session session=HibernateSessionFactory.getSession();
	Transaction tx=null;
	int flag=0;
	try{
	for(int i=0;i<score.length;i++)
	{r_score save=new r_score();
	save.setS_id(id.get(i));
	save.setT_id(tea_id);
	save.setC_name(t_course);
	save.setGrade(t_grade);
	save.setScore(score[i]);
	save.setTitle(t_title);
		
	 tx=session.beginTransaction();
		
		session.save(save);
		
	}
	session.flush();//批量存储数据若不符合条件则均不能添加到数据库
	session.clear();
	tx.commit();
	}
	catch(Exception e){
		flag=1;
		tx.rollback();
	}
	session.close();
	if(flag==1)
	ActionContext.getContext().getSession().put("up_pass", "已经评分，请不要重复打分");
	else
		ActionContext.getContext().getSession().put("up_pass", "打分成功");
	return "success";
}
}
