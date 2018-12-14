package com.xhh.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;
import com.xhh.beans.Student;
import com.xhh.utils.DBConnection;

public class StuDao {
	private DBConnection dbconn;
	public StuDao() {
		setDbconn(new DBConnection());
	}
	public void setDbconn(DBConnection dbConn) {
		this.dbconn = dbconn;
	}
	public DBConnection getDBconn() {
		return dbconn;
	}
	//ÑéÖ¤
	public static int CheckStu(String stuId,String stuPwd) throws SQLException {
		Connection conn =null;
		PreparedStatement pstmt = null;
		
		int returnvalue = -1;
		conn = DBConnection.GetConnection();
		String sql = "select stuName as tt from students where stuId='"+stuId+"'and stuPwd='"+stuPwd+"'";
		pstmt = DBConnection.getStatement(conn, sql);
		ResultSet rs =  (ResultSet) DBConnection.executeQuery(pstmt);
		if(rs.next()) {
			returnvalue = -1;
		}
		return returnvalue;
		
	}
	//×¢²á
	public static int addStu(Student Students) {
		int returnvalue = -1;
		System.err.println(Students);
		try {
			String stuId = new String((Students.getStuId()).getBytes("iso-8859-1"),"gbk");
			String stuName = new String((Students.getStuName()).getBytes("iso-8859-1"),"gbk");
			String stuSex = new String((Students.getStuSex()).getBytes("iso-8859-1"),"gbk");
			String stuInstitute = new String((Students.getStuInstitute()).getBytes("iso-8859-1"),"gbk");
			String stuPwd = new String((Students.getStuPwd()).getBytes("iso-8859-1"),"gbk");
			String sql = "insert into students values('"+stuId+"','"+stuName+"','"+stuSex+"','"+stuInstitute+"','"+stuPwd+"')";
			returnvalue = DBConnection.executeUpdate(sql);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return returnvalue;
		
	}
}
