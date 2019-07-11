package com.wistron.pojo;

import java.util.Date;

public class Commodity {
	private int commodity_id;
	private String owner;
	private String chassis;
	private String platform;
	private String type;
	private String name;
	private String pn_sn;
	private Date start;
	private Date end;
	private String bios_version;
	private String image_build_id;
	private String test_plan;
	private String tester;
	public Commodity() {
		super();
	}
	
	public Commodity(String owner, String chassis, String platform, String type, String name, String pn_sn, Date start,
			Date end, String bios_version, String image_build_id, String test_plan, String tester) {
		super();
		this.owner = owner;
		this.chassis = chassis;
		this.platform = platform;
		this.type = type;
		this.name = name;
		this.pn_sn = pn_sn;
		this.start = start;
		this.end = end;
		this.bios_version = bios_version;
		this.image_build_id = image_build_id;
		this.test_plan = test_plan;
		this.tester = tester;
	}

	public Commodity(int commodity_id, String owner, String chassis, String platform, String type, String name,
			String pn_sn, Date start, Date end, String bios_version, String image_build_id, String test_plan,
			String tester) {
		super();
		this.commodity_id = commodity_id;
		this.owner = owner;
		this.chassis = chassis;
		this.platform = platform;
		this.type = type;
		this.name = name;
		this.pn_sn = pn_sn;
		this.start = start;
		this.end = end;
		this.bios_version = bios_version;
		this.image_build_id = image_build_id;
		this.test_plan = test_plan;
		this.tester = tester;
	}
	public int getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(int commodity_id) {
		this.commodity_id = commodity_id;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "Commodity{" +
				"commodity_id=" + commodity_id +
				", owner='" + owner + '\'' +
				", chassis='" + chassis + '\'' +
				", platform='" + platform + '\'' +
				", type='" + type + '\'' +
				", name='" + name + '\'' +
				", pn_sn='" + pn_sn + '\'' +
				", start=" + start +
				", end=" + end +
				", bios_version='" + bios_version + '\'' +
				", image_build_id='" + image_build_id + '\'' +
				", test_plan='" + test_plan + '\'' +
				", tester='" + tester + '\'' +
				'}';
	}
}
