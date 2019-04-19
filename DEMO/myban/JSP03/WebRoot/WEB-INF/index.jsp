<%@page pageEncoding="utf-8" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>首页</title>
	</head>
	<body>
		<!-- 在登录时将用户名记住(cookie)，在首页可以 从cookie中取到它并替换为XXX-->
		<!-- 1.可以写jsp脚本，通过request获取所有的cookie，将其值写入到此处。
			 2.可以通过EL表达式获取cookie中的值。语法：cookie.key.value -->
		<h1>欢迎您，${cookie.userName.value }。</h1>
		<h2>${cookie.city.value }</h2>
	</body>
</html>