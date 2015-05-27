package validatecode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class validateinput {
private String input;
private HttpServletResponse response;


public String getInput() {
	return input;
}

public void setInput(String input) {
	this.input = input;
}

public HttpServletResponse getResponse() {
	return response;
}

public void setResponse(HttpServletResponse response) {
	this.response = response;
}

public String execute() throws IOException{
	HttpSession s1= ServletActionContext.getRequest().getSession();
	 response=ServletActionContext.getResponse();
	    response.setContentType("text/xml;charset=utf-8");
	    response.setHeader("Cache-Control", "no-cache");
	    response.setHeader("Pargma","no-cache");
	    response.setDateHeader("Expires",0);
	    PrintWriter out=response.getWriter();
//��equels������֤ ������==
	    if(!input.equals(s1.getAttribute("validation_code")))
	    	out.write("验证码错误");
	    out.close();
	    
	return null;
}
}
