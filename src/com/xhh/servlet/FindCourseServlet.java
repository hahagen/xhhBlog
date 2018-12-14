package com.xhh.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xhh.beans.Course;
import com.xhh.dao.CouDao;



/**
 * Servlet implementation class FindCourseServlet
 */
@WebServlet("/FindCourseServlet")
public class FindCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindCourseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		ServletContext sc = this.getServletContext();
		String CourseName = request.getParameter("CouName");
		String Teacher = request.getParameter("Teacher");
		ArrayList<Course> list = CouDao.findCourse(CourseName, Teacher);
		if(list.size()>0) {
			request.setAttribute("list", list);
			System.out.println(list);
			rd = sc.getRequestDispatcher("/student/SelectCou.jsp");
		}else {
			request.setAttribute("error", "课程表未查到你要的信息！");
			rd = sc.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}

}
