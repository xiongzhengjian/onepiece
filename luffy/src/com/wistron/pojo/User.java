package com.wistron.pojo;

public class User{
	private int user_id;
	private String staffid;	
	private String name;
	private String enname;
	private char sex;
	private String email;
	private int department;
	public int getUser_id() {
		return user_id;
	}
	
	public User() {
		super();
	}

	public User(int user_id, String staffid, String name, String enname, char sex, String email, int department) {
		super();
		this.user_id = user_id;
		this.staffid = staffid;
		this.name = name;
		this.enname = enname;
		this.sex = sex;
		this.email = email;
		this.department = department;
	}
	public User(String staffid, String name, String enname, char sex, String email, int department) {
		super();		
		this.staffid = staffid;
		this.name = name;
		this.enname = enname;
		this.sex = sex;
		this.email = email;
		this.department = department;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getStaffid() {
		return staffid;
	}
	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnname() {
		return enname;
	}
	public void setEnname(String enname) {
		this.enname = enname;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", staffid=" + staffid + ", name=" + name + ", enname=" + enname + ", sex="
				+ sex + ", email=" + email + ", department=" + department + "]";
	}
	
	
	
	

}
