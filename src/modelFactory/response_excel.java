package modelFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import bean.course;
import bean.s_course;
import bean.student;
import bean.teacher;
import bean.user;

import com.opensymphony.xwork2.ActionContext;

public class response_excel {
	
	private String page;
	private String rows;
	private String table;
	private HttpServletResponse response;//写回响应
	private PrintWriter out;
	String response1=(String)ActionContext.getContext().getSession().get("response");
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

public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

public String execute() throws IOException{
//	System.out.print(page+rows);
	response=ServletActionContext.getResponse();//设置响应数据
    response.setContentType("text/xml;charset=utf-8");
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Pargma","no-cache");
    response.setDateHeader("Expires",0);
    out = null;
    out = response.getWriter();
	//
    if(table.equals("student"))
	student_pagediv();
    else if(table.equals("s_course"))
    	s_course_pagediv();
    else if(table.equals("teacher"))
    	teacher_pagediv();
    else if(table.equals("course"))
    	course_pagediv();
	return null;
}
//table=student 分页处理
public void student_pagediv() throws IOException{//分页处理函数
	JSONObject o1=JSONObject.fromObject(response1);//String-->jsonobject
	int total=o1.getInt("total");
	JSONArray l1= (JSONArray) o1.get("rows");//获取jsonarray
	student[] stu=(student[]) JSONArray.toArray(l1,student.class);//获取bean
	JSONObject result=new JSONObject();
	result.put("total", total);
	List<student> list=new ArrayList<student>();
	for(int i=(Integer.parseInt(page)-1)*Integer.parseInt(rows);i<Integer.parseInt(page)*Integer.parseInt(rows)&&i<total;i++)
		list.add(stu[i]);
	result.put("rows", list);
	
	out.write(result.toString());
	 out.close();
}
//table==teacher 分页处理
public void teacher_pagediv(){
	JSONObject o1=JSONObject.fromObject(response1);//String-->jsonobject
	int total=o1.getInt("total");
	JSONArray l1= (JSONArray) o1.get("rows");//获取jsonarray
	teacher[] tea=(teacher[]) JSONArray.toArray(l1,teacher.class);//获取bean
	JSONObject result=new JSONObject();
	result.put("total", total);
	List<teacher> list=new ArrayList<teacher>();
	for(int i=(Integer.parseInt(page)-1)*Integer.parseInt(rows);i<Integer.parseInt(page)*Integer.parseInt(rows)&&i<total;i++)
		list.add(tea[i]);
	result.put("rows", list);
	
	out.write(result.toString());
	 out.close();
}
//table==course 分页处理
public void course_pagediv(){
	JSONObject o1=JSONObject.fromObject(response1);//String-->jsonobject
	int total=o1.getInt("total");
	JSONArray l1= (JSONArray) o1.get("rows");//获取jsonarray
	course[] cou=(course[]) JSONArray.toArray(l1,course.class);//获取bean
	JSONObject result=new JSONObject();
	result.put("total", total);
	List<course> list=new ArrayList<course>();
	for(int i=(Integer.parseInt(page)-1)*Integer.parseInt(rows);i<Integer.parseInt(page)*Integer.parseInt(rows)&&i<total;i++)
		list.add(cou[i]);
	result.put("rows", list);
	
	out.write(result.toString());
	 out.close();
}
//table==s_course分页处理
public void s_course_pagediv(){
	JSONObject o1=JSONObject.fromObject(response1);//String-->jsonobject
	int total=o1.getInt("total");
	JSONArray l1= (JSONArray) o1.get("rows");//获取jsonarray
	s_course[] s_cou=(s_course[]) JSONArray.toArray(l1,s_course.class);//获取bean
	JSONObject result=new JSONObject();
	result.put("total", total);
	List<s_course> list=new ArrayList<s_course>();
	for(int i=(Integer.parseInt(page)-1)*Integer.parseInt(rows);i<Integer.parseInt(page)*Integer.parseInt(rows)&&i<total;i++)
		list.add(s_cou[i]);
	result.put("rows", list);
	
	out.write(result.toString());
	 out.close();
}
}
