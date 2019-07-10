package com.wistron.pojo.vo;

/**
 * Use this VO to transfer data from the meal table to the Personal page
 * @author slim2
 *
 */
public class Mealvo {
	private int meal_id;
	//current date
	private String date;
	//WCQ
	private String site;
	//the foreign key of table meal which is associated with table user 
	private int user;
	//0 breakfast; 1 lunch;  2 dinner
	private int type;
	//0 wanted ; 1 want
	private int decide;
	public Mealvo() {
		super();
	}
	public Mealvo(int meal_id, String date, String site, int user, int type, int decide) {
		super();
		this.meal_id = meal_id;
		this.date = date;
		this.site = site;
		this.user = user;
		this.type = type;
		this.decide = decide;
	}
	public int getMeal_id() {
		return meal_id;
	}
	public void setMeal_id(int meal_id) {
		this.meal_id = meal_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
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
		return "Mealvo [meal_id=" + meal_id + ", date=" + date + ", site=" + site + ", user=" + user + ", type=" + type
				+ ", decide=" + decide + "]";
	}
	
	
	
	
	
	
	
}
