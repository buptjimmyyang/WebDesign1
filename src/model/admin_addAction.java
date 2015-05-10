package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import bean.user;
@SuppressWarnings("serial")
public class admin_addAction {
	
	private String table;
	private String name;
	private String result;
	private HttpServletResponse response;//写回响应
	private PrintWriter out;
	
public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
  public String execute() throws IOException {
	
	//System.out.println(table);
	user u=new user();
	 u.setId(111111);
	 u.setPassword("1111111");
	 u.setType("管理员");
	 List l=new ArrayList();
	 l.add(u);
	 JSONObject object =new JSONObject();
	 object.put("total", 1);
	 object.put("rows", l);
	//JSONObject json=new JSONObject().fromObject(u);
	System.out.println(object.toString());
	result=object.toString();
//	 
	response=ServletActionContext.getResponse();//设置响应数据
    response.setContentType("text/xml;charset=utf-8");
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Pargma","no-cache");
    response.setDateHeader("Expires",0);
    out = null;
    out = response.getWriter();
	out.write(result);
	 out.close();
	
return null;  //return 'success'会参数错误警告
}
}
