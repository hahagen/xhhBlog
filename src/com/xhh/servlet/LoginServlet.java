package com.xhh.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xhh.dao.StuDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		ServletContext sc = this.getServletContext();
		HttpSession session = request.getSession(true);
		String stuId = request.getParameter("stuId");
		System.out.println(stuId+"----");
		String stuPwd = request.getParameter("password");
		session.setAttribute("stuId", stuId);
		System.out.println(session.getAttribute("stuId"));
		try {
			int returnvalue = StuDao.CheckStu(stuId,stuPwd);
			if(returnvalue !=-1) {
			}else {
				request.setAttribute("error", "IDªÚ’ﬂ√‹¬Î¥ÌŒÛ");
				rd = sc.getRequestDispatcher("/error.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		rd =sc.getRequestDispatcher("/DisplayAllCourseServlet");
		rd.forward(request, response);

	}
	
}
