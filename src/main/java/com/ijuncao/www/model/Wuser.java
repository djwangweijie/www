package com.ijuncao.www.model;

public class Wuser {
	/**
	 * 用户id,姓名,密码
	 */
	private  int uid;
	private  String uname;
	private  String upwd;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public Wuser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wuser(String uname, String upwd) {
		super();
		this.uname = uname;
		this.upwd = upwd;
	}
	
	
	
}
