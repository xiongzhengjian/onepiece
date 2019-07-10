package com.wistron.pojo;

import java.util.Date;

public class Wat {
	private int wat_id;
	private String owner;
	private String chassis;
	private String platform;
	private String device_name;
	private String pn_sn;	
	private Date start;
	private Date end;
	private String bios_version;
	private String image_build_id;
	private String test_plan;
	private String tester;
	
	public Wat() {
		super();
	}
	public Wat(String owner, String chassis, String platform, String device_name, String pn_sn, Date start, Date end,
			String bios_version, String image_build_id, String test_plan, String tester) {
		super();
		this.owner = owner;
		this.chassis = chassis;
		this.platform = platform;
		this.device_name = device_name;
		this.pn_sn = pn_sn;
		this.start = start;
		this.end = end;
		this.bios_version = bios_version;
		this.image_build_id = image_build_id;
		this.test_plan = test_plan;
		this.tester = tester;
	}
	public Wat(int wat_id, String owner, String chassis, String platform, String device_name, String pn_sn, Date start,
			Date end, String bios_version, String image_build_id, String test_plan, String tester) {
		super();
		this.wat_id = wat_id;
		this.owner = owner;
		this.chassis = chassis;
		this.platform = platform;
		this.device_name = device_name;
		this.pn_sn = pn_sn;
		this.start = start;
		this.end = end;
		this.bios_version = bios_version;
		this.image_build_id = image_build_id;
		this.test_plan = test_plan;
		this.tester = tester;
	}
	public int getWat_id() {
		return wat_id;
	}
	public void setWat_id(int wat_id) {
		this.wat_id = wat_id;
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
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	public String getPn_sn() {
		return pn_sn;
	}
	public void setPn_sn(String pn_sn) {
		this.pn_sn = pn_sn;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
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
		return "Wat [wat_id=" + wat_id + ", owner=" + owner + ", chassis=" + chassis + ", platform=" + platform
				+ ", device_name=" + device_name + ", pn_sn=" + pn_sn + ", start=" + start + ", end=" + end
				+ ", bios_version=" + bios_version + ", image_build_id=" + image_build_id + ", test_plan=" + test_plan
				+ ", tester=" + tester + "]";
	}
	
	
	
	
	
	
	
}
