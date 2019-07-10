package com.wistron.pojo.vo;

import java.util.List;

/**
 * Receive multiple data from the page
 * @author slim2
 *
 */
public class CommodityVos {
	
	
	private List<CommodityVo> commodityVos;
	
	
	public CommodityVos() {
		super();
	}


	public List<CommodityVo> getCommodityVos() {
		return commodityVos;
	}


	public void setCommodityVos(List<CommodityVo> commodityVos) {
		this.commodityVos = commodityVos;
	}


	@Override
	public String toString() {
		return "CommodityVos [commodityVos=" + commodityVos + "]";
	}


	
	
	
	
	
}
