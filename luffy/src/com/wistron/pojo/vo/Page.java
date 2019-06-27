package com.wistron.pojo.vo;

public class Page {

	private int offset;
	private int rows;
	public Page() {
		super();
	}
	public Page(int offset, int rows) {
		super();
		this.offset = offset;
		this.rows = rows;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "Page [offset=" + offset + ", rows=" + rows + "]";
	}
	
}
