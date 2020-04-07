package mybatis.demo.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class work {
	private int cflag;
	private String title;
	private String content;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date date;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date deadline;
	private int wid;
	/**
	 * @return the cflag
	 */
	public int getCflag() {
		return cflag;
	}
	/**
	 * @param cflag the cflag to set
	 */
	public void setCflag(int cflag) {
		this.cflag = cflag;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	
	
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the deadline
	 */
	public Date getDeadline() {
		return deadline;
	}
	/**
	 * @param deadline the deadline to set
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	/**
	 * @return the wid
	 */
	public int getWid() {
		return wid;
	}
	/**
	 * @param wid the wid to set
	 */
	public void setWid(int wid) {
		this.wid = wid;
	}
	
	
	public work()
	{
		super();
	}
}
