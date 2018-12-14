<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<style type="text/css">
body{
	font-size:20px;
	font-family:"宋体";
	position: relative;
	background-image: url(images/snow.jpg);
}
}
body,form,input,p{
	padding:0;
	margin:0;
	border:0;
}
form{
	width:500px;
	height:300px;
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
	background:#3bb7ea;
}
.btn02{
	background:#fb8c16;
}
.radio{
	margin-left:30px;
}
.c{
	color:#FFF;
}
</style>

</head>
<body>

	<center>
	<h1 class="c">注册</h1>
	<form action="/selectcou/RegServlet" method="post">
			<p>
				<span>学&nbsp;&nbsp;号</span> <input type="text" name="stuId"
					class="num">
			</p>
			<p>
				<span>姓&nbsp;&nbsp;名</span> <input type="text" name="stuName" class="num">
			</p>
			<p>
		<span> 性&nbsp;&nbsp;别</span>
		<input type="radio" name="stuSex"  value="M" class="radio">男
		<input type="radio" name="stuSex" value="F" class="radio">女
		</p>
		<p>
		<span>密&nbsp;&nbsp;码</span>
		<input type="password" name="stuPwd" class="pass">
		</p>
		<p>
		<span>所在学院</span>
		<input type="text" name="stuInstitute" class="num">
		</p>
		<p>
		<input type="submit" value="确定" class="btn01">
		<input type="reset" value="重置" class="btn02">
		</p>
	</form>
</center>
</body>
</html>