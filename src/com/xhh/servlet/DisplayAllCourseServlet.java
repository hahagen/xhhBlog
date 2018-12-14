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
import com.xhh.dao.CouDao;
import com.xhh.utils.Paging;


@WebServlet("/DisplayAllCourseServlet")
public class DisplayAllCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayAllCourseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		ServletContext sc = this.getServletContext();
		
		try {
			List<Object> courses = CouDao.getAllCourse();
			 int page=0;
		        //�õ��������ĵ�ǰҳ
		        String str_page= request.getParameter("page");
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//ҳ�浱ǰҳ
       
        
        rd = sc.getRequestDispatcher("/student/SelectCou.jsp");
		rd.forward(request, response);
	}

}
