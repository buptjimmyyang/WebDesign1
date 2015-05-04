package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;

public class down_load {
	
private  String filepath;
private String filename;

public String getFilepath() {
	return filepath;
}
public void setFilepath(String filepath) {
	this.filepath = filepath;
}


public void setFilename(String filename) {
	this.filename = filename;
}
public String getFilename() throws UnsupportedEncodingException{
    return  URLEncoder.encode(filename,"utf-8");//设置文件名编码问题
}

public InputStream getDownload1() {
	System.out.print(filename);
	return ServletActionContext.getServletContext().getResourceAsStream(filepath);
}
public String execute(){
	
	return "success";
}
}
