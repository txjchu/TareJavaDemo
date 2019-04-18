<%@page pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>JSTL+EL</title>
	</head>
	<body>
		<h1>EL</h1>
		<!-- 使用EL获取bean属性值 -->
		<p>账号：${user.userName }</p>
		<p>密码：${user["password"] }</p>
		<!-- user.getLoves()[0] -->
		<p>兴趣：${user.loves[0] }</p>
		<!-- user.getCourse().getName() -->
		<p>课程：${user.course.name }</p>
	</body>
</html>











