package com.wistron.pojo.vo;

import java.util.Date;

/**
 * use the vo Class to pack the values of order meals
 * @author slim2
 *
 */
public class Ordersubmit {
	//1 2 3 4 5 6 7 map to 周一 周二 周三  周四   周五   周六   周日 
	private Date weekday;
	//0 breakfast 1 lunch 2 dinner
	private int type;
	// 0 want  1 don't want 
	private int decide;
	public Ordersubmit() {
		super();
	}
	public Ordersubmit(Date weekday, int type, int decide) {
		super();
		this.weekday = weekday;
		this.type = type;
		this.decide = decide;
	}
	public Date getWeekday() {
		return weekday;
	}
	public void setWeekday(Date weekday) {
		this.weekday = weekday;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getDecide() {
		return decide;
	}
	public void setDecide(int decide) {
		this.decide = decide;
	}
	@Override
	public String toString() {
		return "Ordersubmit [weekday=" + weekday + ", type=" + type + ", decide=" + decide + "]";
	}
	
	
	
	
	
	
}
