package com.wistron.pojo.vo;

import java.util.List;

/**
 * Receive multiple data from the page
 * @author slim2
 *
 */
public class SoftpaqVos {
	
	
	private List<SoftpaqVo> softpaqVos;
	
	
	public SoftpaqVos() {
		super();
	}


	public List<SoftpaqVo> getSoftpaqVos() {
		return softpaqVos;
	}


	public void setSoftpaqVos(List<SoftpaqVo> softpaqVos) {
		this.softpaqVos = softpaqVos;
	}


	@Override
	public String toString() {
		return "SoftpaqVos [softpaqVos=" + softpaqVos + "]";
	}


	


	
	
	
	
	
}
