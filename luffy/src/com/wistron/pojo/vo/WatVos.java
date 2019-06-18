package com.wistron.pojo.vo;

import java.util.List;

/**
 * Receive multiple data from the page
 * @author slim2
 *
 */
public class WatVos {
	
	
	private List<WatVo> watVos;

	public WatVos() {
		super();
	}

	public List<WatVo> getWatVos() {
		return watVos;
	}

	public void setWatVos(List<WatVo> watVos) {
		this.watVos = watVos;
	}

	@Override
	public String toString() {
		return "WatVos [watVos=" + watVos + "]";
	}
	
	
	

	


	
	
	
	
	
}
