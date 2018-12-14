package com.xhh.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xhh.beans.Course;
import com.xhh.dao.StuCouDao;
import com.xhh.utils.MyTools;
import com.xhh.utils.Paging;


/**
 * Servlet implementation class FindSelectedServlet
 */
@WebServlet("/FindSelectedServlet")
public class FindSelectedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindSelectedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		String stuId = request.getParameter("stuId");
		if(stuId!=null){
			List<Object> courses  = StuCouDao.getAllCourses(stuId);
			//ҳ�浱ǰҳ
	        int page=0;
	        //�õ��������ĵ�ǰҳ
	        String str_page=    request.getParameter("page");
	        // ������ҳ�Ĺ���һЩ���ݵĹ���bean
	        Paging paging=new Paging();
	        paging.setList(courses);//�����ݿ�õ����ݴ����list����
	        paging.setCount();//��������
	        paging.setPagesize(8);//һ��ҳ������ݶ�����
	        paging.setPagenumber();//�ܵ�ҳ����
	        paging.setEndpage();//���һҳ
	        paging.setIndexpage(1);//��һҳ
	        if (str_page!=null) {
	            //��ҳת�������ж����С
	            int pag=Integer.parseInt(str_page);
	            //�������㣬����������pagֵ������ǰҳpage
	            if (pag>=0) {
	                page=pag;
	                //���С�����ֵʱ�򣬽��䴫������ֵ��1�ڸ�ֵ����ǰҳ������һֱ�����һҳ
	                if (pag>(paging.getPagenumber()-1)) {
	                    page=pag-1;
	                }
	            }
	        }
	        paging.setPage(page);//����ȷ�ϵ�ǰҳ
	        List<Object> list_page =new ArrayList<>();
	        //����ǰҳ��ֵ�����µ�list_page�����У�list������ȫ�������ۺϣ���i�������еļ������ݸ�list_page
	        for (int i = paging.getPage()*paging.getPagesize(); i <(paging.getPage()+1)*paging.getPagesize()&&i<courses.size(); i++) {
	            list_page.add(courses.get(i));
	        }
	        //��paging�������������������У��Ա����ҳ�����
	        request.setAttribute("paging", paging);
	        request.setAttribute("list", list_page);
	        rd = sc.getRequestDispatcher("/student/MySelectedCou.jsp");
			rd.forward(request, response);
		}
	}

}
