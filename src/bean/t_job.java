package bean;

import java.util.Date;

public class t_job {
private int id;
private int t_id;
private String title;
private String content;
private String grade;
private Date datetime;
private String c_name;
private String real_title;
public String getReal_title() {
	return real_title;
}
public void setReal_title(String real_title) {
	this.real_title = real_title;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getT_id() {
	return t_id;
}
public void setT_id(int t_id) {
	this.t_id = t_id;
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
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public Date getDatetime() {
	return datetime;
}
public void setDatetime(Date datetime) {
	this.datetime = datetime;
}
public String getC_name() {
	return c_name;
}
public void setC_name(String c_name) {
	this.c_name = c_name;
}
}
