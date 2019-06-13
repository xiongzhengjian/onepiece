package com.wistron.pojo.vo;

import java.util.List;

import com.wistron.pojo.Bios;
/**
 * Receive multiple data from the page
 * @author slim2
 *
 */
public class BiosVo {
	
	
	private List<Bios> biosVos;
	
	
	public BiosVo() {
		super();
	}
	
	public List<Bios> getBiosVos() {
		return biosVos;
	}
	public void setBiosVos(List<Bios> biosVos) {
		this.biosVos = biosVos;
	}

	@Override
	public String toString() {
		return "BiosVo [biosVos=" + biosVos + "]";
	}
	
	
}
