package com.wistron.pojo;

import java.util.Date;

public class User{
	private int user_id;
	private String staffid;	
	private String password;
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
	private Date hireDate;
	
	//0 need't to remember user and password. 1 need remember
	private int remember;
	
	
	
	public User() {
		super();
	}
	
	public User(int user_id, String staffid, String password, String name, String enname, char sex, String email,
			String department, int mealstatus, int attendance, Date hireDate) {
		super();
		this.user_id = user_id;
		this.staffid = staffid;
		this.password = password;
		this.name = name;
		this.enname = enname;
		this.sex = sex;
		this.email = email;
		this.department = department;
		this.mealstatus = mealstatus;
		this.attendance = attendance;
		this.hireDate = hireDate;
	}

	public User(int user_id, String staffid, String name, String enname, char sex, String email, String department,
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
	public User(int user_id, String staffid, String name, String enname, char sex, String email, String department) {
		super();
		this.user_id = user_id;
		this.staffid = staffid;
		this.name = name;
		this.enname = enname;
		this.sex = sex;
		this.email = email;
		this.department = department;
		
	}	
	
	public User(int user_id, String staffid, String name, String enname, char sex, String email, String department,
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

	
	public User(String staffid, String name, String enname, char sex, String email, String department) {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	public int getRemember() {
		return remember;
	}

	public void setRemember(int remember) {
		this.remember = remember;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", staffid=" + staffid + ", password=" + password + ", name=" + name
				+ ", enname=" + enname + ", sex=" + sex + ", email=" + email + ", department=" + department
				+ ", mealstatus=" + mealstatus + ", attendance=" + attendance + ", hireDate=" + hireDate + ", remember="
				+ remember + "]";
	}

	
	
	
	
	
	
	
	
	
	

}
