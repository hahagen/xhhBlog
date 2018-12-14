package com.xhh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xhh.beans.Course;
import com.xhh.utils.DBConnection;




public class StuCouDao {
	public static int addCou(String stuId,String couId) throws ClassNotFoundException, SQLException
	{
		int returnvalue=-1;
		Connection conn = DBConnection.GetConnection();
		String sql ="insert into stucou values('"+stuId+"','"+couId+"')";
		returnvalue=DBConnection.executeUpdate(sql);
		return returnvalue;
	}
	public static  List<Object> getAllCourses(String stuId){
		List<Object> list = new ArrayList<Object>();
		Connection conn = DBConnection.GetConnection();
		try{
			String sql = "select * from courses where couId in(select couId from stucou where stuId='"+stuId+"')";
			PreparedStatement pstmt = DBConnection.getStatement(conn, sql);
			ResultSet rst = DBConnection.executeQuery(pstmt);
			if(null!=rst){
				while(rst.next()){
					Course course = null;
					String couId = rst.getString("couid");
					String couName = rst.getString("couname");
					String teacher = rst.getString("teacher");
					int credit = rst.getInt("credit");
					String courseDes = rst.getString("couexp");
					course = new Course(couId, couName, teacher, courseDes, credit);
					list.add(course);
				}
			}
			rst.close();
            pstmt.close();
            conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	public static List<Object> findMyCouOnly(String couName, String teacher,String stuId){
		List<Object> list = new ArrayList<Object>();
		Connection conn = DBConnection.GetConnection();
		try{
			String sql = "select * from sys_courses where COUID in(select couid from sys_stucou where stuid='"+stuId+"')";
			if(couName!=null&&!couName.equals("")){
				sql=sql+" and couname like '%"+couName+"%'";
			}
			if(teacher!=null&&!teacher.equals("")){
				sql=sql+" and teacher like '%"+teacher+"%'";
			}
			PreparedStatement pstmt = DBConnection.getStatement(conn, sql);
			System.out.println(sql);
			ResultSet rst = DBConnection.executeQuery(pstmt);
			if(null!=rst){
				while(rst.next()){
					Course course = null;
					String couId = rst.getString("couid");
					String couName1 = rst.getString("couname");
					String teacher1 = rst.getString("teacher");
					int credit = rst.getInt("credit");
					String courseDes = rst.getString("couexp");
					course = new Course(couId, couName1, teacher1, courseDes, credit);
					list.add(course);
				}
			}
			rst.close();
            pstmt.close();
            conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	public static int delCourse(String stuId,String couId) throws SQLException
	{
		int returnvalue = -1;
		Connection conn = DBConnection.GetConnection();
		String sql = "delete from stucou where  stuId='"+stuId+"' and couId= '"+couId+"' ";
		returnvalue = DBConnection.executeUpdate(sql);
		return returnvalue;
	}
	
}
