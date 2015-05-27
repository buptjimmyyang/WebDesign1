package view;

import com.opensymphony.xwork2.ActionContext;

public class t_login {
	private int dis;
	
public int getDis() {
		return dis;
	}

	public void setDis(int dis) {
		this.dis = dis;
	}

public String execute(){
	int id =(Integer) ActionContext.getContext().getSession().get("u_id");
	 ActionContext.getContext().getSession().put("u_id", id);
	if(dis==0)
		return "s0";//top
	else if(dis==1)
		return "s1";//left
	else 
		return "s2";//right
}
}
