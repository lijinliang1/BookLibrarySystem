package com.eleven.booklibrary.model.vo;   
/**
* 创建时间：2018年6月1日 下午1:57:50
* 项目名称：BookLibrarySystem
* @author lijinliang
* @version 1.0
* 文件名称：BorrowBookCountVo.java
* 类说明：
*/
public class BorrowBookCountVo {
	private String borrowerName;
	private String bookName;
	private Integer borrowTimes;
	
	public String getBorrowerName() {
		return borrowerName;
	}
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Integer getBorrowTimes() {
		return borrowTimes;
	}
	public void setBorrowTimes(Integer borrowTimes) {
		this.borrowTimes = borrowTimes;
	}
}
