package mybatis.demo.security02.model;

public class user_role {
	private int id;
	private int uid;
	private int rid;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	/**
	 * @return the rid
	 */
	public int getRid() {
		return rid;
	}
	/**
	 * @param rid the rid to set
	 */
	public void setRid(int rid) {
		this.rid = rid;
	}
	public user_role(int id, int uid, int rid) {
		super();
		this.id = id;
		this.uid = uid;
		this.rid = rid;
	}
	public user_role()
	{
		super();
	}
	
}
