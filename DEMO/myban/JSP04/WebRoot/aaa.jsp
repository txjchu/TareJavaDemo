<%@page pageEncoding="utf-8" %>
<!doctype html>
<html>
	<head>
		<meta content="utf-8">
		<title>这是测试web.xml配置的页面</title>
	</head>
	<body>
		<h1>这是测试web.xml配置的页面</h1>
		<h2>这个地址怎么访问呢？</h2>
		<h3>重要：servlet标签中servlet-name必须和servlet-mapping标签中对应的名称一样</h3>
		<h5>地址：http://localhost:9080/JSP04/aaa.jsp</h5>
		<p>如果是class文件，则地址应该包含包名，如：web/aaa</p>
		<form action="check.dd">
			<p>
				验证码：
				<input type="text" name="vcode" />
				
				<img src="code1.dd" class="s1" title="点击获取图片" onclick="this.src='code1.dd?'+ Math.random();"/>
			</p>
			<input type="submit" value="确定">
			<p><%= (String)request.getAttribute("msg")%></p>
			
		</form>
		
	</body>
</html>