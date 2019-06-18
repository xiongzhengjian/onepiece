package com.wistron.pojo.vo;


public class SoftrollRespinVo {
	private int softrollrespin_id;
	private String owner;
	private String chassis;
	private String platform;
	
	private String test_function;
	
	
	private String schedule;
	private String bios_version;
	private String image_build_id;
	private String test_plan;
	private String tester;
	public SoftrollRespinVo() {
		super();
	}
	public SoftrollRespinVo(String owner, String chassis, String platform, String test_function, String schedule,
			String bios_version, String image_build_id, String test_plan, String tester) {
		super();
		this.owner = owner;
		this.chassis = chassis;
		this.platform = platform;
		this.test_function = test_function;
		this.schedule = schedule;
		this.bios_version = bios_version;
		this.image_build_id = image_build_id;
		this.test_plan = test_plan;
		this.tester = tester;
	}
	public SoftrollRespinVo(int softrollrespin_id, String owner, String chassis, String platform, String test_function,
			String schedule, String bios_version, String image_build_id, String test_plan, String tester) {
		super();
		this.softrollrespin_id = softrollrespin_id;
		this.owner = owner;
		this.chassis = chassis;
		this.platform = platform;
		this.test_function = test_function;
		this.schedule = schedule;
		this.bios_version = bios_version;
		this.image_build_id = image_build_id;
		this.test_plan = test_plan;
		this.tester = tester;
	}
	public int getSoftrollrespin_id() {
		return softrollrespin_id;
	}
	public void setSoftrollrespin_id(int softrollrespin_id) {
		this.softrollrespin_id = softrollrespin_id;
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
	public String getTest_function() {
		return test_function;
	}
	public void setTest_function(String test_function) {
		this.test_function = test_function;
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
		return "SoftrollRespinVo [softrollrespin_id=" + softrollrespin_id + ", owner=" + owner + ", chassis=" + chassis
				+ ", platform=" + platform + ", test_function=" + test_function + ", schedule=" + schedule
				+ ", bios_version=" + bios_version + ", image_build_id=" + image_build_id + ", test_plan=" + test_plan
				+ ", tester=" + tester + "]";
	}
	
	
	
	
	
	
}
