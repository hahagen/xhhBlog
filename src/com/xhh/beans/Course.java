package com.xhh.beans;

public class Course {

	private String couId;
	private String couName;
	private String Teacher;
	private String couExp;
	private int Credit;
	
	public String getCouId() {
		return couId;
	}
	public void setCouId(String couId) {
		this.couId = couId;
	}
	public String getCouName() {
		return couName;
	}
	public void setCouName(String couName) {
		this.couName = couName;
	}
	public String getTeacher() {
		return Teacher;
	}
	public void setTeacher(String teacher) {
		Teacher = teacher;
	}
	public String getCouExp() {
		return couExp;
	}
	public void setCouExp(String couExp) {
		this.couExp = couExp;
	}
	public int getCredit() {
		return Credit;
	}
	public void setCredit(int credit) {
		Credit = credit;
	}
	
	public Course(String couId, String couName, String teacher, String couExp, int credit) {
		super();
		this.couId = couId;
		this.couName = couName;
		Teacher = teacher;
		this.couExp = couExp;
		Credit = credit;
	}
	public Course() {
		super();
	}
	
	@Override
	public String toString() {
		return "Course [couId=" + couId + ", couName=" + couName + ", Teacher=" + Teacher + ", couExp=" + couExp
				+ ", Credit=" + Credit + "]";
	}
	
}
