package com.wistron.pojo.vo;

public class Uservo{
	private int user_id;
	private String staffid;	
	private String name;
	private String enname;
	private char sex;
	private String email;
	//the foreign key of table User which is associated with table Dictionary
	private String department;
	//status of order a meal:0 default  1 done
	private int mealstatus;
	//is the member attendance:1 default, 0 dosn't attendance
	private int attendance;
	//dictionary message
	private String dept;
	
	
	
	
	public Uservo() {
		super();
	}
	public Uservo(int user_id, String staffid, String name, String enname, char sex, String email, String department,
			int mealstatus, int attendance) {
		super();
		this.user_id = user_id;
		this.staffid = staffid;
		this.name = name;
		this.enname = enname;
		this.sex = sex;
		this.email = email;
		this.department = department;
		this.mealstatus = mealstatus;
		this.attendance = attendance;
	}
	public Uservo(int user_id, String staffid, String name, String enname, char sex, String email, String department) {
		super();
		this.user_id = user_id;
		this.staffid = staffid;
		this.name = name;
		this.enname = enname;
		this.sex = sex;
		this.email = email;
		this.department = department;
		
	}	
	
	public Uservo(int user_id, String staffid, String name, String enname, char sex, String email, String department,
			int mealstatus) {
		super();
		this.user_id = user_id;
		this.staffid = staffid;
		this.name = name;
		this.enname = enname;
		this.sex = sex;
		this.email = email;
		this.department = department;
		this.mealstatus = mealstatus;
	}	

	
	public Uservo(String staffid, String name, String enname, char sex, String email, String department) {
		super();		
		this.staffid = staffid;
		this.name = name;
		this.enname = enname;
		this.sex = sex;
		this.email = email;
		this.department = department;
	}
	public int getUser_id() {
		return user_id;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getMealstatus() {
		return mealstatus;
	}
	public void setMealstatus(int mealstatus) {
		this.mealstatus = mealstatus;
	}
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Uservo [user_id=" + user_id + ", staffid=" + staffid + ", name=" + name + ", enname=" + enname
				+ ", sex=" + sex + ", email=" + email + ", department=" + department + ", mealstatus=" + mealstatus
				+ ", attendance=" + attendance + ", dept=" + dept + "]";
	}
	
	
	
	
	
	

}
