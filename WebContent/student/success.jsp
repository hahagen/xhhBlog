<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,hight=device-hight,minimum-scale=1.0,maximum-scale=1.0,ser-scalable=none"/>
<title>选课成功</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	position: relative; 
	/* background:#f5f8fd; */
	width: 100%;
	height:50%;
	background-size:100% ; 
}
.one{
  margin:50px auto;
}
.btn01,.btn02{
	width:100px;
	height:45px;
	border-radius:3px;
	border:1px solid #6b5d50;
	margin-left:30px;
}
.btn01{
	background:#3F3;
}
</style>
</head>
<body >
<%
 	HttpSession sessions = request.getSession();
 	Object stus = session.getAttribute("stuId");
 	String stus1 = (String) stus;
 %>
<center>
	<img alt=" nidian" src="student/images/selected.gif" ><br>
	<input onclick="javascript:location.href='/selectcou/DisplayAllCourseServlet' " type="button" value="课程列表" class="btn01">
	<input onclick="javascript:location.href='/selectcou/FindSelectedServlet?stuId=<%=stus1%>' " type="button" value="已选课程" class="btn01" style="background:#9E3">
</center>
</body>
</html>