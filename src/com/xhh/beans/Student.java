package com.xhh.beans;

public class Student {
	private String stuId;
	private String stuName;
	private String stuInstitute;
	private String stuPwd;
	private String stuSex;
	public Student() {
		super();
	}
	public Student(String stuId, String stuName, String stuInstitute, String stuPwd, String stuSex) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuInstitute = stuInstitute;
		this.stuPwd = stuPwd;
		this.stuSex = stuSex;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuInstitute() {
		return stuInstitute;
	}
	public void setStuInstitute(String stuInstitute) {
		this.stuInstitute = stuInstitute;
	}
	public String getStuPwd() {
		return stuPwd;
	}
	public void setStuPwd(String stuPwd) {
		this.stuPwd = stuPwd;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	
	
}
