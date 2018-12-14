<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style type="text/css">
body{
	font-size:20px;
	font-family:"宋体";
	  position: relative;
	background-image: url(http://localhost:8088/selectcou/student/images/lg3.png);
	/* background-position: center; /*background-repeat: no-repeat;*/ */
	 width: 100%; 
	height: 100%;
	background-size:  100%; 
}

body,form,input,p{
	padding:0;
	margin:0;
	border:0;
}
form{
	width:450px;
	height:200px;
	padding-top:20px;
	margin:50p auto;
	background:#f5f8fd;
	border-radius:20px;
	border:3px solid #4accb;
}
p{
	margin-top:15px;
	text-align:center;
}
p span{
	width:90px;
	height:20px;
	display:inline-block;
	text-align:right;
}

.num,.pass{
	width:152px;
	height:18px;
	border:1px solid #38a1bf;
	paddig:2px 2px 2px 22px;
	 
}
.num{
	color:#999;
}
.btn01,.btn02{
	width:70px;
	height:35px;
	border-radius:3px;
	border:1px solid #6b5d50;
	margin-left:30px;
}
.btn01{
	background:#3F3;
}
.btn02{
	background:#9F9;
}
.radio{
	margin-left:30px;
}
.pic{
	width:70px;
	height:35px;
}
</style>
</head>
<body>
	
	<center>
	<h3>登录</h3>
	<form action="/selectcou/LoginServlet" method="post">
		<p>
		<span>学&nbsp;&nbsp;号</span>
		<input type="text" name="stuId" class="num">
		</p>
		<p>
		<span>密&nbsp;&nbsp;码</span>
		<input type="password" name="stuPwd" class="num">
		</p>
		<br>
		<input type="submit" value="登录" class="btn01">
		<!-- <a href="/selectcou/student/Register.jsp" ><img alt="" src="images/zhuce.jpg"></a> -->
		<input onclick="javascript:location.href='student/Register.jsp' " type="button" value="注册" class="btn01" style="background:#9E3">
		
	</form>
	</center>

</body>
</html>