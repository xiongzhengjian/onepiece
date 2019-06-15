package com.wistron.pojo.vo;


public class BiosVo {
	private int bios_id;
	private String owner;
	private String chassis;
	private String platform;
	private String test_type;
	private String schedule;	
	private String bios_version;
	private String image_build_id;
	private String test_plan;
	private String tester;
	
	public BiosVo() {
		super();
	}
	
	

	public BiosVo(int bios_id, String chassis, String platform, String test_type, String schedule, String bios_version,
			String image_build_id, String test_plan, String tester) {
		super();
		this.bios_id = bios_id;
		this.chassis = chassis;
		this.platform = platform;
		this.test_type = test_type;
		this.schedule = schedule;
		this.bios_version = bios_version;
		this.image_build_id = image_build_id;
		this.test_plan = test_plan;
		this.tester = tester;
	}



	public int getBios_id() {
		return bios_id;
	}
	public void setBios_id(int bios_id) {
		this.bios_id = bios_id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
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
	public String getTest_type() {
		return test_type;
	}
	public void setTest_type(String test_type) {
		this.test_type = test_type;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getBios_version() {
		return bios_version;
	}
	public void setBios_version(String bios_version) {
		this.bios_version = bios_version;
	}
	public String getImage_build_id() {
		return image_build_id;
	}
	public void setImage_build_id(String image_build_id) {
		this.image_build_id = image_build_id;
	}
	public String getTest_plan() {
		return test_plan;
	}
	public void setTest_plan(String test_plan) {
		this.test_plan = test_plan;
	}
	public String getTester() {
		return tester;
	}
	public void setTester(String tester) {
		this.tester = tester;
	}
	@Override
	public String toString() {
		return "BiosVo [bios_id=" + bios_id + ", owner=" + owner + ", chassis=" + chassis + ", platform=" + platform
				+ ", test_type=" + test_type + ", schedule=" + schedule + ", bios_version=" + bios_version
				+ ", image_build_id=" + image_build_id + ", test_plan=" + test_plan + ", tester=" + tester + "]";
	}
	
	
	
	
	
	
	
}
