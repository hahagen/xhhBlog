<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.xhh.beans.Student"%>
<%@ page import="com.xhh.beans.Course"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,hight=device-hight,minimum-scale=1.0,maximum-scale=1.0,ser-scalable=none"/>
<title>课程管理</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	position: relative;
	 background-image: url(student/images/xh.jpg); 
	background-position: center; /*background-repeat: no-repeat;*/
	width: 100%;
	height: 100%;
	background-size: 100% 100%;
}
.one{
	 color:#FFF; 
}
.two{
	 color:#FFF; 
}
</style>
</head>
<body id="body" onLoad="init()">
	<script type="text/javascript" src="student/js/ThreeCanvas.js"></script>
	<script type="text/javascript" src="student/js/Snow.js"></script>

	<script type="text/javascript">
		var SCREEN_WIDTH = window.innerWidth;//
		var SCREEN_HEIGHT = window.innerHeight-331;
		var container;
		var particle;//粒子

		var camera;
		var scene;
		var renderer;

		var starSnow = 1;

		var particles = [];

		var particleImage = new Image();
		//THREE.ImageUtils.loadTexture( "img/ParticleSmoke.png" );
		particleImage.src = 'student/images/ParticleSmoke.png';

		function init() {
			//alert("message3");
			container = document.createElement('div');//container：画布实例;
			document.body.appendChild(container);

			camera = new THREE.PerspectiveCamera(60, SCREEN_WIDTH
					/ SCREEN_HEIGHT, 1, 10000);
			camera.position.z = 1000;
			//camera.position.y = 50;

			scene = new THREE.Scene();
			scene.add(camera);

			renderer = new THREE.CanvasRenderer();
			renderer.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
			var material = new THREE.ParticleBasicMaterial({
				map : new THREE.Texture(particleImage)
			});
			//alert("message2");
			for (var i = 0; i < 500; i++) {
				//alert("message");
				particle = new Particle3D(material);
				particle.position.x = Math.random() * 2000 - 1000;

				particle.position.z = Math.random() * 2000 - 1000;
				particle.position.y = Math.random() * 2000 - 1000;
				//particle.position.y = Math.random() * (1600-particle.position.z)-1000;
				particle.scale.x = particle.scale.y = 1;
				scene.add(particle);

				particles.push(particle);
			}

			container.appendChild(renderer.domElement);

			//document.addEventListener( 'mousemove', onDocumentMouseMove, false );
			document
					.addEventListener('touchstart', onDocumentTouchStart, false);
			document.addEventListener('touchmove', onDocumentTouchMove, false);
			document.addEventListener('touchend', onDocumentTouchEnd, false);

			setInterval(loop, 1000 / 60);

		}

		var touchStartX;
		var touchFlag = 0;//储存当前是否滑动的状态;
		var touchSensitive = 80;//检测滑动的灵敏度;
		//var touchStartY;
		//var touchEndX;
		//var touchEndY;
		function onDocumentTouchStart(event) {

			if (event.touches.length == 1) {

				event.preventDefault();//取消默认关联动作;
				touchStartX = 0;
				touchStartX = event.touches[0].pageX;
				//touchStartY = event.touches[ 0 ].pageY ;
			}
		}

		function onDocumentTouchMove(event) {

			if (event.touches.length == 1) {
				event.preventDefault();
				var direction = event.touches[0].pageX - touchStartX;
				if (Math.abs(direction) > touchSensitive) {
					if (direction > 0) {
						touchFlag = 1;
					} else if (direction < 0) {
						touchFlag = -1;
					}
					;
					//changeAndBack(touchFlag);
				}
			}
		}

		function onDocumentTouchEnd(event) {
			// if ( event.touches.length == 0 ) {
			// 	event.preventDefault();
			// 	touchEndX = event.touches[ 0 ].pageX ;
			// 	touchEndY = event.touches[ 0 ].pageY ;

			// }这里存在问题
			var direction = event.changedTouches[0].pageX - touchStartX;

			changeAndBack(touchFlag);
		}

		function changeAndBack(touchFlag) {
			var speedX = 25 * touchFlag;
			touchFlag = 0;
			for (var i = 0; i < particles.length; i++) {
				particles[i].velocity = new THREE.Vector3(speedX, -10, 0);
			}
			var timeOut = setTimeout(";", 800);
			clearTimeout(timeOut);

			var clearI = setInterval(function() {
				if (touchFlag) {
					clearInterval(clearI);
					return;
				}
				;
				speedX *= 0.8;

				if (Math.abs(speedX) <= 1.5) {
					speedX = 0;
					clearInterval(clearI);
				}
				;

				for (var i = 0; i < particles.length; i++) {
					particles[i].velocity = new THREE.Vector3(speedX, -10, 0);
				}
			}, 100);

		}

		function loop() {
			for (var i = 0; i < particles.length; i++) {
				var particle = particles[i];
				particle.updatePhysics();

				with (particle.position) {
					if ((y < -1000) && starSnow) {
						y += 2000;
					}

					if (x > 1000)
						x -= 2000;
					else if (x < -1000)
						x += 2000;
					if (z > 1000)
						z -= 2000;
					else if (z < -1000)
						z += 2000;
				}
			}

			camera.lookAt(scene.position);

			renderer.render(scene, camera);
		}
	</script>
	<div class="one">
		<details> <%
 	HttpSession sessions = request.getSession();
 	Object stus = session.getAttribute("stuId");
 	String stus1 = (String) stus;
 %> <summary>课程管理</summary>
		<ul>
			<li><a href="#" class="two">我的选课</a></li>
			<li><a href="/selectcou/FindSelectedServlet?stuId=<%=stus1%>" class="two">已选课程</a></li>

		</ul>
		</details>
	
	<center>
		<div>
			<ul>
				<form action="/selectcou/FindCourseServlet" menthod="post">
					课程名称：<input type="text" name="CouName">
					</li> 任课教师：<input type="text" name="Teacher">
					</li> <input type="submit" value="查询"> <input type="reset"
						value="取消">
				</form>
			</ul>
		</div>
		<table border="5">
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
					Object obj = request.getAttribute("list");//why??
					ArrayList<Course> courses = (ArrayList<Course>) obj;
					if (courses.size() > 0) {
						for (int i = 0; i < courses.size(); i++) {
							Course course = courses.get(i);
				%>
				<tr>
					<td width="90px"><%=i + 1%></td>
					<td width="90px"><%=course.getCouId()%></td>
					<td width="120px"><%=course.getCouName()%></td>
					<td width="120px"><%=course.getTeacher()%></td>
					<td width="180px"><%=course.getCouExp()%></td>
					<td width="90px"><%=course.getCredit()%></td>
					<td width="90px"><a
						href="/selectcou/SelectCouServlet?stuId=<%=stus1%>&couId=<%=course.getCouId()%>"
						class="tablelink" style="color:#FF9;">选课</a></td>
				</tr>
				<%
					}
					} else {
				%>
				<tr>
					<td colspan="6">没有课程信息，请联系管理员！</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</center>
	</div>
</body>
</html>