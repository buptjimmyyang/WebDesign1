package bean;

import java.io.Serializable;

public class r_score implements Serializable{//定义复合主键必须实现implements Serializable接口
private int s_id;
private int t_id;
private String title;
private int score;
private String grade;
private String c_name;

public int getS_id() {
	return s_id;
}
public void setS_id(int s_id) {
	this.s_id = s_id;
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
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public String getC_name() {
	return c_name;
}
public void setC_name(String c_name) {
	this.c_name = c_name;
}


}
