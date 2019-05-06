package com.trasher.spring.model;

public class Report {
	private String month;
	private int count;
	
	public Report(String month, int count) {
		super();
		this.month = month;
		this.count = count;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Report [month=" + month + ", count=" + count + "]";
	}
	
	
}
