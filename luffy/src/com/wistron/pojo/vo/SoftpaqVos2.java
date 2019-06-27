package com.wistron.pojo.vo;

import java.util.List;

/**
 * Receive multiple data from the page
 * @author slim2
 *
 */
public class SoftpaqVos2 {
	
	
	private List<SoftpaqVo2> softpaqVos;
	
	
	public SoftpaqVos2() {
		super();
	}


	public List<SoftpaqVo2> getSoftpaqVos() {
		return softpaqVos;
	}


	public void setSoftpaqVos(List<SoftpaqVo2> softpaqVos) {
		this.softpaqVos = softpaqVos;
	}


	@Override
	public String toString() {
		return "SoftpaqVos [softpaqVos=" + softpaqVos + "]";
	}


	


	
	
	
	
	
}
