<%@page pageEncoding="utf-8" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>登录页面</title>
	</head>
	<body>
		<form action="Login.do" method="post">
			<p>
				账号：
				<input type="text" name="userName" value="${cookie.userName.value }"/>
			</p>
			<p>
				密码：
				<input type="password" name="pwd"/>
			</p>
			<p>
				记住我：<input type="checkbox" name="remember" value="yes" ${cookie.userName!=null ?"checked":"" }/>
			</p>
			<p>
				<input type="submit" value="登录" />
			</p>
		</form>
	</body>
</html>