package com.wistron.pojo.vo;


/**
 * the vo class load message of today oFood order situation
 * @author slim2
 *
 */
public class OrderSituation {	
	private String dept;
	//The number of employees
	private int employeesNum;
	//Number of people who have made a reservation
	private int orderedNum;
	//The number of people who haven't made a reservation yet
	private int notOrderedNum;
	//Reservation rate
	private String orderRate;
	
	
	
	public OrderSituation() {
		super();
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getEmployeesNum() {
		return employeesNum;
	}

	public void setEmployeesNum(int employeesNum) {
		this.employeesNum = employeesNum;
	}

	public int getOrderedNum() {
		return orderedNum;
	}

	public void setOrderedNum(int orderedNum) {
		this.orderedNum = orderedNum;
	}

	public int getNotOrderedNum() {
		return notOrderedNum;
	}

	public void setNotOrderedNum(int notOrderedNum) {
		this.notOrderedNum = notOrderedNum;
	}


	
	
	public String getOrderRate() {
		return orderRate;
	}

	public void setOrderRate(String orderRate) {
		this.orderRate = orderRate;
	}

	@Override
	public String toString() {
		return "OrderSituation [dept=" + dept + ", employeesNum=" + employeesNum + ", orderedNum=" + orderedNum
				+ ", notOrderedNum=" + notOrderedNum + ", orderRate=" + orderRate + "]";
	}
	
	
	
	
	
	
	
	
	
}
