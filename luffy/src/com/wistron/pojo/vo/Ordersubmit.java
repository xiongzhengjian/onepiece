package com.wistron.pojo.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.wistron.utils.DateUtils;

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
	private int user_id;
	private String today;
	private Date nextDay;
	
	public Ordersubmit() {
		super();
	}
	
	public Ordersubmit(int user_id) {
		super();
		this.user_id = user_id;
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
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public String getToday() {
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		return today;
	}		
	
	
	public Date getNextDay() throws ParseException {
		Date nextDay = DateUtils.dateAdd(new Date(), 1, false);
		return nextDay;	
	}
	

	@Override
	public String toString() {
		return "Ordersubmit [weekday=" + weekday + ", type=" + type + ", decide=" + decide + "]";
	}

	
	
	
	
	
	
	
}
