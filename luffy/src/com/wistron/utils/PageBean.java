package com.wistron.utils;


public class PageBean {
	
	
	//total number of records
	private int totalRows;
	//Total pages can be calculated by totalRows and perPageRows
	private int totalPage;
	
	
	//the maximum number of rows returned per page
    private int perPageRows=10;
	//specifies the offset of the first row to return after flip over 
	private int offset;
	//place the data to be displayed per page in the list collection
    //private List<T> data;
	
    
	private int pageRangeStart;
	//current page
	private int currentPage;
    private int pageRangeEnd;
	
	
	
	public PageBean() {
		super();
	}
	
	public PageBean(int totalRows,int perPageRows,int currentPage) {
		super();
		this.currentPage = currentPage;
		this.perPageRows = perPageRows;
		this.totalRows = totalRows;
		
		//initialize tatalPage
//		if(totalRows>perPageRows && totalRows%perPageRows==0) {//Faulty logic 
		if(totalRows % perPageRows==0) {
			this.totalPage = totalRows / perPageRows;
		}else if(totalRows<perPageRows) {
			this.totalPage=1;
		}
		else{
			this.totalPage = totalRows / perPageRows +1;
		}
		
		//the offset of first row after flip over
		this.offset = (currentPage-1)*perPageRows;
		
		//sets the range value of the  paging
		if(totalPage<=5) {
			this.pageRangeStart = 1;
			this.pageRangeEnd = this.totalPage;
		}else {
			//
			this.pageRangeStart = currentPage - 2;
			this.pageRangeEnd = currentPage + 2;
			
			if(pageRangeStart <= 0) {
				//exception: 比如当前页是第1页，或者第2页，那么就不如和这个规则，
				this.pageRangeStart = 1;
				this.pageRangeEnd=5;
			}
			if(pageRangeEnd >this.totalPage) {
				//exception: 比如当前页是倒数第2页或者最后一页，也同样不符合上面这个规则
				this.pageRangeEnd = totalPage;
				this.pageRangeStart = pageRangeEnd-4;
			}
			
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}




	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}





	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageRangeStart() {
		return pageRangeStart;
	}

	public void setPageRangeStart(int pageRangeStart) {
		this.pageRangeStart = pageRangeStart;
	}

	public int getPageRangeEnd() {
		return pageRangeEnd;
	}

	public void setPageRangeEnd(int pageRangeEnd) {
		this.pageRangeEnd = pageRangeEnd;
	}

	public int getPerPageRows() {
		return perPageRows;
	}

	public void setPerPageRows(int perPageRows) {
		this.perPageRows = perPageRows;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	@Override
	public String toString() {
		return "PageBean [totalRows=" + totalRows + ", totalPage=" + totalPage + ", perPageRows=" + perPageRows
				+ ", offset=" + offset + ", pageRangeStart=" + pageRangeStart + ", currentPage=" + currentPage
				+ ", pageRangeEnd=" + pageRangeEnd + "]";
	}

	
	
	
    
    
	
}
