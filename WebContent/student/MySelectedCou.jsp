<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.xhh.beans.Student"  %>
<%@ page import="com.xhh.beans.Course" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已选课程</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	position: relative;
	  background-image: url(student/images/s5.png); 
	background-position: center; /*background-repeat: no-repeat;*/
	width: 100%;
	/* height:100% */;
	/* background-size: 100% 100%; */
}
.one{
	/*  color:#FFF; */
	  margin:50px auto;
}
.two{
	/*  color:#FFF;  */
}
</style>
</head>
<body>
	<%
	HttpSession sessions=request.getSession();
	Object stus = session.getAttribute("stuId");
	String stus1 = (String)stus;
   %> 
   <!-- <div>
 		<ul>
			<form action="/selectcou/FindCourseServlet.jsp" menthod="post">
				课程名称：<input type="text" name="CouName"> </li>
 				任课教师：<input type="text" name="Teacher"></li>
 				<input type="submit" value="查询">
 				<input type="reset" value="取消">
				</form>
		</ul>
 	</div> -->
 	<center>
 	<table border="5" class="one">
    	<thead>
	    	<tr>
		        <th>序号</th>
		        <th>课程编号</th>
		        <th>课程名称</th>
		        <th>授课教师</th>
		        <th>课程描述</th>
		        <th>学分</th>
		        <th>操作</th>
	        </tr>
        </thead>
         <tbody>
        	<%
        		Object obj = request.getAttribute("list");
        		ArrayList<Course> courses = (ArrayList<Course>)obj;
        		if(courses.size()>0){
	        		for(int i=0;i<courses.size();i++){
	        			Course course = courses.get(i);
        	%>
	        <tr>
	        	<td width="90px"><%=i + 1%></td>
					<td width="90px"><%=course.getCouId()%></td>
					<td width="120px"><%=course.getCouName()%></td>
					<td width="120px"><%=course.getTeacher()%></td>
					<td width="180px"><%=course.getCouExp()%></td>
					<td width="90px"><%=course.getCredit()%></td>
		        <td><a href="/selectcou/DelCouServlet?stuId=<%=stus1 %>&couId=<%=course.getCouId() %>" class="tablelink">删除</a></td>
	        </tr> 
	        <%
        			}
        		}else{
	        %>
	        <tr>
		        <td colspan="6">没有课程信息！</td>
	        </tr>
	        <%
        		}
	        %>
        </tbody>
    </table>
    <a href="/selectcou/DisplayAllCourseServlet"><img alt="" src="student/images/list.jpg"></a>
    </center>
 
</body>
</html>