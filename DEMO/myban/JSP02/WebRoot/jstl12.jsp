<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>jstl12</head>
	<body>
		session中的num为：${sessionScope.num }<br>
		直接被重定向到了jstl12界面。
		<br>
		<br/>
		session中的num为：${sessionScope.num }<br>
		session中的uname为：${sessionScope.uname }
		
	</body>
</html>