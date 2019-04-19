<%@page pageEncoding="utf-8" %>
<!doctype html>
	<!-- 将首页用session判断-是否登录判断保护起来， -->
	<%--
	 --%> 
	<%
		if(session.getAttribute("userName") == null){
			response.sendRedirect("/JSP04/login/toLogin.do");//没有登录则拒绝访问
			
		}
	%>
	 
<html>
	<head>
		<meta charset="utf-8"/>
		<title>首页</title>
	</head>
	<body>
		<!-- EL的取值范围：page/request/session/application ,下面语句会从session里取值-->
		<h1>欢迎您，${userName }。</h1><!-- EL取值 -->
		<h2>此时的session中的userName:<%=session.getAttribute("userName") %></h2><!-- jsp表达式取值 -->
		<h2>这里是首页！</h2>
		<a href="logout.do">登出</a>
	</body>
</html>