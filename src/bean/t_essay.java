package bean;

import java.util.Date;

public class t_essay {

	private String title;
	private String content;
	private int t_id;
	private int essay_id;
	private Date datetime;
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
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	
	public int getEssay_id() {
		return essay_id;
	}
	public void setEssay_id(int essay_id) {
		this.essay_id = essay_id;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
}
