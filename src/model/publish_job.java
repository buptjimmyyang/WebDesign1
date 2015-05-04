package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import modelFactory.publish_essay;
import modelFactory.save_publish;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;

import bean.HibernateSessionFactory;
import bean.s_job;

import com.opensymphony.xwork2.ActionContext;

public class publish_job {
private String c_name;
private String grade;
private String title;
private String content;
private File myFile;
private String myFileFileName;
public String getC_name() {
	return c_name;
}
public void setC_name(String c_name) {
	this.c_name = c_name;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public File getMyFile() {
	return myFile;
}
public void setMyFile(File myFile) {
	this.myFile = myFile;
}

public String getMyFileFileName() {
	return myFileFileName;
}
public void setMyFileFileName(String myFileFileName) {
	this.myFileFileName = myFileFileName;
}
public String execute() throws IOException{
	String savepath=null;
	String savename=title;
	int id=(Integer) ActionContext.getContext().getSession().get("u_id");
	if(myFileFileName==null)//设置上传文件名不能为空
	{savepath="no";
	}
	else{
		
	String teacher="";
	Session session=HibernateSessionFactory.getSession();
	String hql=" select name from teacher where id = :id";//查出老师名
	Query query =session.createQuery(hql);
	query.setInteger("id", id);
	List<String> u=query.list();
	teacher=u.get(0);
	session.close();
	InputStream is=new FileInputStream(myFile);
	String uploadPath=ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");//获取文件绝对路径
	File file=new File(uploadPath+"/"+teacher);
	if(!file.exists())
	file.mkdir();
File toFile=new File(uploadPath+"/"+teacher,savename);
	
	OutputStream os =new FileOutputStream(toFile);
	byte[] buffer=new byte[1024];
	int len=0;
	while((len=is.read(buffer))>0)
	os.write(buffer, 0, len);
	//System.out.print(id+""+grade+""+f_course+""+f_teacher+""+f_title+""+"----"+myFileFileName);
	is.close();
	os.close();
	savepath="/WEB-INF/upload/"+teacher+"/"+title;//若文件存在 保存文件地址
	}
	save_publish.save(id, title, content, grade, c_name, savepath);//将文件保存至t_job数据表中
	publish_essay.save_essay(title, c_name, id);
	return "success";
}
}
