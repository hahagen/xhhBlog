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

import com.xhh.beans.Student;
import com.xhh.dao.StuCouDao;

@WebServlet("/DelCouServlet")
public class DelCouServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DelCouServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		ServletContext sc = this.getServletContext();
		String couId = request.getParameter("couId");
		String stuId = request.getParameter("stuId");
		HttpSession session =request.getSession(true);
		//if(session.getAttribute("stuId") != null) {
			//String stuId = (session.getAttribute("stuId")).toString();
			try {
				int returnvalue = StuCouDao.delCourse(stuId, couId);
				if(returnvalue == 1) {
					request.setAttribute("error", "É¾³ý³É¹¦");
				}else {
					request.setAttribute("error", "É¾³ýÊ§°Ü");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		//}
		rd = sc.getRequestDispatcher("/student/delsucess.jsp");
		rd.forward(request, response);
	}

}
