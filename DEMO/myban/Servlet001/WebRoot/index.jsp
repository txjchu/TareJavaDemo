
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta content="utf-8">
		<title>这是一个计算在线人数的首页countIndex</title>
	</head>
	<body style="font-size:30px; font-style:italic;">
		在线人数：
		<%--
		 --%>
		<%= application.getAttribute("count") %>
		<a href="logout.jsp">进入</a>
	</body>
</html>