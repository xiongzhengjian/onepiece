package com.wistron.pojo;

public class Project {
	
	private int project_id;
	private String chassis;
	private String platform;
	private String sysId;
	private String brand;
	public Project() {
		super();
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getChassis() {
		return chassis;
	}
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getSysId() {
		return sysId;
	}
	public void setSysId(String sysId) {
		this.sysId = sysId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", chassis=" + chassis + ", platform=" + platform + ", sysId="
				+ sysId + ", brand=" + brand + "]";
	}
	
	
	
	
}
