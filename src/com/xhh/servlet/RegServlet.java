package com.xhh.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xhh.beans.Student;
import com.xhh.dao.StuDao;

@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		ServletContext sc = this.getServletContext();
		HttpSession session = request.getSession(true);
		String stuId = request.getParameter("stuId");
		String stuName = request.getParameter("stuName");
		String stuInstitute = request.getParameter("stuInstitute");
		String stuPwd = request.getParameter("stuPwd");
		String stuSex = request.getParameter("stuSex");
		Student stu = new Student(stuId,stuName,stuInstitute,stuPwd,stuSex);
		int returnvalue = StuDao.addStu(stu);
		if(returnvalue ==1) {
			
			session.setAttribute("student", stu);
			request.setAttribute("error", "×¢²á³É¹¦");
		}else {
			request.setAttribute("error", "×¢²áÊ§°Ü");
		
			}
		rd = sc.getRequestDispatcher("/student/login.jsp");//
		rd.forward(request, response);
}
}
