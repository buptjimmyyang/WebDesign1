package bean;

import java.io.Serializable;

public class s_course implements Serializable {//设置复合主键必须添加Serializable接口
private int s_id;
private int c_id;

public int getS_id() {
	return s_id;
}
public void setS_id(int s_id) {
	this.s_id = s_id;
}
public int getC_id() {
	return c_id;
}
public void setC_id(int c_id) {
	this.c_id = c_id;
}


}
