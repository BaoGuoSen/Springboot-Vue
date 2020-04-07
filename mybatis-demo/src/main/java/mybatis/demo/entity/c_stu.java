package mybatis.demo.entity;

public class c_stu {
	private int cflag;
	private int uid;
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
	public c_stu(int cflag, int uid) {
		super();
		this.cflag = cflag;
		this.uid = uid;
	}
	
	public c_stu()
	{
		super();
	}
}
