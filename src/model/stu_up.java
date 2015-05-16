package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import modelFactory.stu_upsave;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class stu_up extends ActionSupport {
private String f_course;
private String f_teacher;
private String f_title;
private File myFile;

private String myFileFileName;
public String getF_course() {
	return f_course;
}
public void setF_course(String f_course) {
	this.f_course = f_course;
}
public String getF_teacher() {
	return f_teacher;
}
public void setF_teacher(String f_teacher) {
	this.f_teacher = f_teacher;
}
public String getF_title() {
	return f_title;
}
public void setF_title(String f_title) {
	this.f_title = f_title;
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
public String execute()  throws IOException{
	
	if(myFileFileName==null)//�����ϴ��ļ�����Ϊ��
	{ActionContext.getContext().getSession().put("stu_suc", "�ļ�����Ϊ���������ϴ�");
		return "stu_upsuccess";
	}
	int id=(Integer) ActionContext.getContext().getSession().get("u_id");
	String grade=(String) ActionContext.getContext().getSession().get("s_grade");
	String savename=id+"_"+this.getMyFileFileName();
	InputStream is=new FileInputStream(myFile);
String uploadPath=ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
String visaPath="/WEB-INF/upload/"+"/"+f_teacher+"/"+f_course+"/"+f_title+"/"+grade;
	String savePath=uploadPath+"/"+f_teacher+"/"+f_course+"/"+f_title+"/"+grade;

	File file=new File(uploadPath+"/"+f_teacher);
	if(!file.exists())
	file.mkdir();
	File subfile=new File(uploadPath+"/"+f_teacher+"/"+f_course)	;
	if(!subfile.exists())
	 subfile.mkdir();
	File ssfile=new File(uploadPath+"/"+f_teacher+"/"+f_course+"/"+f_title);
	if(!ssfile.exists())
	ssfile.mkdir();
     File fgrade=new File(uploadPath+"/"+f_teacher+"/"+f_course+"/"+f_title+"/"+grade);
		if(!fgrade.exists())
		fgrade.mkdir();
	  File content=new File(uploadPath+"/"+f_teacher+"/"+f_course+"/"+f_title+"/"+grade+"/"+savename);
			if(content.exists()){
				ActionContext.getContext().getSession().put("stu_suc", "�˴���ҵ�Ѿ��ϴ�,�벻Ҫ�ظ��ϴ�");
				return "stu_upsuccess";
			}
	
	File toFile=new File(savePath,savename);
	
	OutputStream os =new FileOutputStream(toFile);
	byte[] buffer=new byte[1024];
	int len=0;
	while((len=is.read(buffer))>0)
	os.write(buffer, 0, len);
	//System.out.print(id+""+grade+""+f_course+""+f_teacher+""+f_title+""+"----"+myFileFileName);
	is.close();
	os.close();
	//��������ݿ�
	stu_upsave.save(id, f_teacher, f_course,getMyFileFileName(), visaPath+"/"+id+"_"+getMyFileFileName(), grade,f_title);
	ActionContext.getContext().getSession().put("stu_suc", "已经上传文件给"+f_teacher+"成功");
	return "stu_upsuccess";
}
}
