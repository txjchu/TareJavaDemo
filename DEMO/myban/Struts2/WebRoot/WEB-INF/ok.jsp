<%@page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<title></title>
	</head>
	<body>
		<h1>恭喜你，成功登录系统</h1>
		<h2>登录成功，欢迎访问系统</h2>
		当前用户<% ${success.getAttribute()}%>
	</body>
</html>