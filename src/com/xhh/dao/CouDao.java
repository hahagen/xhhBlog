package com.xhh.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import com.xhh.beans.Course;



public class CouDao {
	public static ArrayList<Object> getAllCourse() throws Exception{
		ArrayList<Object> list= new ArrayList<Object>();
		String url="jdbc:mysql://localhost:3306/mysqls";
		String user="root";
		String password="123456";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(url,user,password);
		String sql="select * from courses";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		while(rst.next()) {
			Course course=null;
			String courseId=rst.getString("couId");
			String courseName = rst.getString("couName");
			String teacher =rst.getString("Teacher");
			String courseExp = rst.getString("couExp");
			int credit =rst.getInt("credit");
			course = new Course(courseId,courseName,teacher,courseExp,credit);
			list.add(course);
		}
		return list;
}
	public static ArrayList<Course> findCourse(String CouName,String Teacher) {
		Connection conn = com.xhh.utils.DBConnection.GetConnection();
		ArrayList<Course>courses= new ArrayList<Course>();
		
		try {
			String CouName1= new String(CouName.getBytes("iso-8859-1"),"gbk");
			String CouTeacher = new String(Teacher.getBytes("iso-8859-1"),"gbk");
			String sql = "select * from courses where couName ='"+CouName+"' or Teacher ='"+CouTeacher+"'";
			PreparedStatement pstmt = com.xhh.utils.DBConnection.getStatement(conn, sql);
			ResultSet rst = com.xhh.utils.DBConnection.executeQuery(pstmt);
			while(rst.next()) {
				Course course = null;
				String courseId = rst.getString("couId");
				String coursename =rst.getString("couName");
				String teacher = rst.getString("Teacher");
				String courseDes = rst.getString("couExp");
				int credit = rst.getInt("Credit");
				course  = new Course(courseId,coursename,teacher,courseDes,credit);
				courses.add(course);
				
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return courses;
}
}
