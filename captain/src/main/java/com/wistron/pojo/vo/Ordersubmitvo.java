package com.wistron.pojo.vo;

import java.util.List;

public class Ordersubmitvo {
	private Ordersubmit oder;
	private List<Ordersubmit> orderlist;

	public Ordersubmitvo() {
		super();
	}

	public Ordersubmitvo(Ordersubmit oder) {
		super();
		this.oder = oder;
	}

	public Ordersubmit getOder() {
		return oder;
	}

	public void setOder(Ordersubmit oder) {
		this.oder = oder;
	}
	

	public List<Ordersubmit> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(List<Ordersubmit> orderlist) {
		this.orderlist = orderlist;
	}

	@Override
	public String toString() {
		return "Ordersubmitvo [orderlist=" + orderlist + "]";
	}
	
	
	
}
