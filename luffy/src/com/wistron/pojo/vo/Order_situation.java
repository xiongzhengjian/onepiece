package com.wistron.pojo.vo;


/**
 * the vo class load message of oFood order situation
 * @author slim2
 *
 */
public class Order_situation {	
	
	
	private int department;
	//the amount of yes
	private  String yes;
	//the amount of no
	private String no;
	//the amout of undetermined
	private String undetermined;
	//the amount of order member
	private int order_amount;
	//the amount of free to order member
	private int free_order;
	//the amount of attendence member
	private int attendence;
	//the value of reservation rate
	private double reservation_rate;
	public Order_situation() {
		super();
	}
	public Order_situation(int department, String yes, String no, String undetermined, int order_amount, int free_order,
			int attendence, double reservation_rate) {
		super();
		this.department = department;
		this.yes = yes;
		this.no = no;
		this.undetermined = undetermined;
		this.order_amount = order_amount;
		this.free_order = free_order;
		this.attendence = attendence;
		this.reservation_rate = reservation_rate;
	}
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	public String getYes() {
		return yes;
	}
	public void setYes(String yes) {
		this.yes = yes;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getUndetermined() {
		return undetermined;
	}
	public void setUndetermined(String undetermined) {
		this.undetermined = undetermined;
	}
	public int getOrder_amount() {
		return order_amount;
	}
	public void setOrder_amount(int order_amount) {
		this.order_amount = order_amount;
	}
	public int getFree_order() {
		return free_order;
	}
	public void setFree_order(int free_order) {
		this.free_order = free_order;
	}
	public int getAttendence() {
		return attendence;
	}
	public void setAttendence(int attendence) {
		this.attendence = attendence;
	}
	public double getReservation_rate() {
		return reservation_rate;
	}
	public void setReservation_rate(double reservation_rate) {
		this.reservation_rate = reservation_rate;
	}
	@Override
	public String toString() {
		return "Order_situation [department=" + department + ", yes=" + yes + ", no=" + no + ", undetermined="
				+ undetermined + ", order_amount=" + order_amount + ", free_order=" + free_order + ", attendence="
				+ attendence + ", reservation_rate=" + reservation_rate + "]";
	}
	
	
	
}
