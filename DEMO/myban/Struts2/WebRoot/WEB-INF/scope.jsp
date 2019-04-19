<%@page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<title></title>
	</head>
	<body>
		request:${msg } ${requestScope.msg }<br/>
		session:${sessionScope.msg }<br/>
		application:${applicationScope.msg }		
		
	</body>
</html>