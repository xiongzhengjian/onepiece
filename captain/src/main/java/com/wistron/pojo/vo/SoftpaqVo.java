package com.wistron.pojo.vo;


public class SoftpaqVo {
	private int softpaq_id;
	private String owner;
	private String chassis;
	private String platform;
	private String sp_number;
	private String softpaq_title;
	private String version;
	private String schedule;
	private String bios_version;
	private String image_build_id;
	private String test_plan;
	private String tester;
	public SoftpaqVo() {
		super();
	}
	public SoftpaqVo(String owner, String chassis, String platform, String sp_number, String softpaq_title,
			String version, String schedule, String bios_version, String image_build_id, String test_plan,
			String tester) {
		super();
		this.owner = owner;
		this.chassis = chassis;
		this.platform = platform;
		this.sp_number = sp_number;
		this.softpaq_title = softpaq_title;
		this.version = version;
		this.schedule = schedule;
		this.bios_version = bios_version;
		this.image_build_id = image_build_id;
		this.test_plan = test_plan;
		this.tester = tester;
	}
	public SoftpaqVo(int softpaq_id, String owner, String chassis, String platform, String sp_number,
			String softpaq_title, String version, String schedule, String bios_version, String image_build_id,
			String test_plan, String tester) {
		super();
		this.softpaq_id = softpaq_id;
		this.owner = owner;
		this.chassis = chassis;
		this.platform = platform;
		this.sp_number = sp_number;
		this.softpaq_title = softpaq_title;
		this.version = version;
		this.schedule = schedule;
		this.bios_version = bios_version;
		this.image_build_id = image_build_id;
		this.test_plan = test_plan;
		this.tester = tester;
	}
	public int getSoftpaq_id() {
		return softpaq_id;
	}
	public void setSoftpaq_id(int softpaq_id) {
		this.softpaq_id = softpaq_id;
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
	public String getSp_number() {
		return sp_number;
	}
	public void setSp_number(String sp_number) {
		this.sp_number = sp_number;
	}
	public String getSoftpaq_title() {
		return softpaq_title;
	}
	public void setSoftpaq_title(String softpaq_title) {
		this.softpaq_title = softpaq_title;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
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
		return "SoftpaqVo [softpaq_id=" + softpaq_id + ", owner=" + owner + ", chassis=" + chassis + ", platform="
				+ platform + ", sp_number=" + sp_number + ", softpaq_title=" + softpaq_title + ", version=" + version
				+ ", schedule=" + schedule + ", bios_version=" + bios_version + ", image_build_id=" + image_build_id
				+ ", test_plan=" + test_plan + ", tester=" + tester + "]";
	}
	
	
	
	
	
	
}
