package com.wistron.utils;

import java.util.List;

public class PageBean<T> {
	
	//current page
	private int currentPage;
	
	//number of data entries displayed per page
	private int pageItems;
	
	//total number of records
	private int totalRecord;
	
	//Total pages can be calculated by totalRecord and pageItems
	private int totalPage;
	
	//Starting the index,
	// which means we start with the number of rows in the database, and based on startIndex and pageSize, 
	//we know the two data of the limit statement, and we can get the data that needs to be displayed per page.
	private int startIndex;
	
	//place the data to be displayed per page in the list collection
	private List<T> list;
	
	private int start;
    private int end;
	public PageBean() {
		super();
	}
	
	public PageBean(int currentPage, int pageItems, int totalRecord) {
		super();
		this.currentPage = currentPage;
		this.pageItems = pageItems;
		this.totalRecord = totalRecord;
		
		//initialize tatalPage
		if(totalRecord%pageItems==0) {
			this.totalPage = totalRecord / pageItems;
		}else {
			this.totalPage = totalRecord / pageItems +1;
		}
		
		//start index
		this.startIndex = (currentPage-1)*pageItems;
		
		//sets the range value of the display page
		if(totalPage<=10) {
			this.end = this.totalPage;
		}else {
			//
			this.start = currentPage - 4;
			this.end = currentPage + 5;
			
			if(start < 0) {
				//exception: 比如当前页是第1页，或者第2页，那么就不如和这个规则，
				this.start = 1;
				this.end=10;
			}
			if(end >this.totalPage) {
				//exception: 比如当前页是倒数第2页或者最后一页，也同样不符合上面这个规则
				this.end = totalPage;
				this.start = end-10;
			}
			
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageItems() {
		return pageItems;
	}

	public void setPageItems(int pageItems) {
		this.pageItems = pageItems;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	
	
	
    
    
	
}
