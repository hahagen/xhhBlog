package com.xhh.beans;

public class StuCou {
	private String  stuId;
	private String 	couId;
	public StuCou() {
		super();
	}
	public StuCou(String stuId, String couId) {
		super();
		this.stuId = stuId;
		this.couId = couId;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getCouId() {
		return couId;
	}
	public void setCouId(String couId) {
		this.couId = couId;
	}
	
	
}
