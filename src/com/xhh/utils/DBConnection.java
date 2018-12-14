package com.xhh.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/mysqls";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
 
    public static Connection GetConnection () {
    	Connection conn = null;
    	try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    	
    	try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return conn;
    }
    
    public static void close(Connection conn) {
    	try {
    		if(conn!=null && !conn.isClosed())
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public static PreparedStatement getStatement(Connection conn, String strsql) {
    	if(strsql==null || "".equals(strsql)) {
    		System.out.println("SQL为空……");
    		return null;
    	}
    	if(conn==null) {
    		System.out.println("连接为空……");
    		return null;
    	}
    	
    	try {
			return conn.prepareStatement(strsql, 
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public static ResultSet executeQuery(PreparedStatement pstmt) {
    	try {
    		if(pstmt!=null)
    			return pstmt.executeQuery();
    	} catch (Exception e) {
    		e.printStackTrace();
		}
    	return null;
    }
    
    public static int executeUpdate(String sql) {
    	int returnvalue = 0;
    	Connection conn = DBConnection.GetConnection();
    	
    	try {
			Statement stmt = conn.createStatement();
			returnvalue = stmt.executeUpdate(sql);
			return returnvalue;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return -1;
		}
    }
    
    public static void close(Statement stmt) {
    	try {
    		if(stmt!=null) {
    			stmt.close();
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    }
    
    
    public static void close(ResultSet rs) {
    	try {
    		if(rs!=null) {
    			rs.close();
    		}
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
}