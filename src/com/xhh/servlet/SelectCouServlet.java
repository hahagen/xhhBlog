package com.xhh.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xhh.beans.Course;
import com.xhh.dao.StuCouDao;


@WebServlet("/SelectCouServlet")
public class SelectCouServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectCouServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		ServletContext sc = this.getServletContext();
		String courseId = request.getParameter("couId");
		
		HttpSession session =request.getSession(true);
		String stuId = session.getAttribute("stuId").toString();
		System.out.println(stuId+"---"+courseId);
		try {
			int flag = StuCouDao.addCou(stuId,courseId);
			List<Object>courses = StuCouDao.getAllCourses(stuId);
			session.setAttribute("courses", courses);
			if(flag ==1) {
				//选课成功
				//rd = sc.getRequestDispatcher("/CourseSelected.jsp");
				rd = sc.getRequestDispatcher("/student/success.jsp");//页面为创建
				request.setAttribute("error", "选课成功");
			}else {
				request.setAttribute("error", "选课失败，请你重新选课");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		rd.forward(request, response);
		
	}
	}


