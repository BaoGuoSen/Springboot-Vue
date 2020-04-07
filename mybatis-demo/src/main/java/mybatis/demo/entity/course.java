package mybatis.demo.entity;

import java.util.List;

import mybatis.demo.security02.model.User;

public class course {
	private String cname;
	private int cflag;
	private int uid;
	private List<User> users;
	private boolean state;
	private int wid;
	private String teacher;
	
	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}
	/**
	 * @return the teacher
	 */
	public String getTeacher() {
		return teacher;
	}
	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
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
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
	/**
	 * @return the state
	 */
	public boolean isState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(boolean state) {
		this.state = state;
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
	public course(String cname, int cflag, List<User> users, boolean state, int wid) {
		super();
		this.cname = cname;
		this.cflag = cflag;
		this.users = users;
		this.state = state;
		this.wid = wid;
	}
	public course()
	{
		super();
	}
}
