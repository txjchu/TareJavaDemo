<%@page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<title></title>
	</head>
	<body>
		${msg }
		<form action="login" method="post">
			用户名：<input type="text" name="username"/>
			密码：<input type="password" name="password"/>
			<input type="submit" value="登录"/>
		</form>
	</body>
</html>