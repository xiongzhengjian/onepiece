package com.wistron.pojo.vo;

import java.util.List;

import com.wistron.pojo.Bios;
/**
 * Receive multiple data from the page
 * @author slim2
 *
 */
public class BiosVos {
	
	
	private List<BiosVo> biosVos;
	
	
	public BiosVos() {
		super();
	}


	public List<BiosVo> getBiosVos() {
		return biosVos;
	}


	public void setBiosVos(List<BiosVo> biosVos) {
		this.biosVos = biosVos;
	}


	@Override
	public String toString() {
		return "BiosVos [biosVos=" + biosVos + "]";
	}
	
	
	
	
}
