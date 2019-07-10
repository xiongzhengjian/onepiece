package com.wistron.pojo;

import java.util.Date;

public class Softpaq2 {
	private int softpaq_id;
	private String owner;
	private Date start;
	private Date end;
	private String sp_number;
	private String softpaq_title;
	private String version;
	private String platform;
	private String sptest_tool_status;
	private String installation_status;
	private String function_status;
	private int products_sequence;
	private String mark;
	
	public Softpaq2() {
		super();
	}

	public Softpaq2(String owner, Date start, Date end, String sp_number, String softpaq_title, String version,
			String platform, String sptest_tool_status, String installation_status, String function_status,
			int products_sequence, String mark) {
		super();
		this.owner = owner;
		this.start = start;
		this.end = end;
		this.sp_number = sp_number;
		this.softpaq_title = softpaq_title;
		this.version = version;
		this.platform = platform;
		this.sptest_tool_status = sptest_tool_status;
		this.installation_status = installation_status;
		this.function_status = function_status;
		this.products_sequence = products_sequence;
		this.mark = mark;
	}

	public Softpaq2(int softpaq_id, String owner, Date start, Date end, String sp_number, String softpaq_title,
			String version, String platform, String sptest_tool_status, String installation_status,
			String function_status, int products_sequence, String mark) {
		super();
		this.softpaq_id = softpaq_id;
		this.owner = owner;
		this.start = start;
		this.end = end;
		this.sp_number = sp_number;
		this.softpaq_title = softpaq_title;
		this.version = version;
		this.platform = platform;
		this.sptest_tool_status = sptest_tool_status;
		this.installation_status = installation_status;
		this.function_status = function_status;
		this.products_sequence = products_sequence;
		this.mark = mark;
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

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getSptest_tool_status() {
		return sptest_tool_status;
	}

	public void setSptest_tool_status(String sptest_tool_status) {
		this.sptest_tool_status = sptest_tool_status;
	}

	public String getInstallation_status() {
		return installation_status;
	}

	public void setInstallation_status(String installation_status) {
		this.installation_status = installation_status;
	}

	public String getFunction_status() {
		return function_status;
	}

	public void setFunction_status(String function_status) {
		this.function_status = function_status;
	}

	public int getProducts_sequence() {
		return products_sequence;
	}

	public void setProducts_sequence(int products_sequence) {
		this.products_sequence = products_sequence;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Softpaq2 [softpaq_id=" + softpaq_id + ", owner=" + owner + ", start=" + start + ", end=" + end
				+ ", sp_number=" + sp_number + ", softpaq_title=" + softpaq_title + ", version=" + version
				+ ", platform=" + platform + ", sptest_tool_status=" + sptest_tool_status + ", installation_status="
				+ installation_status + ", function_status=" + function_status + ", products_sequence="
				+ products_sequence + ", mark=" + mark + "]";
	}
	
	
	
	
	
	
	
}
