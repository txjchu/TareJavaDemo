<%@page pageEncoding="utf-8" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>登录页面</title>
		<style type="text/css">
            .s1{
                cursor:pointer;
            }
        </style>
	</head>
	<body>
		<p>当前页面的session中的name为：<%=session.getAttribute("userName") %></p>
		<form action="login.do" method="post">
			<p>账号：
				<input type="text" name="userName" value="${userName }"/><!-- userName使用EL标签动态获取某个内置对象的userName的属性，如page.userName。并动态的将获取到的数据赋值给input的value属性显示出来。 -->
			</p>
			<p>
				密码：
				<input type="password" name="pwd"/>
			</p>
			<p>
				验证码：
				<input type="text" name="vcode" >
				<img class="s1" title="点击更换" src="code.do" onclick="this.src='code.do?'+Math.random();"><!-- 假装不同的浏览器请求 -->
			</p>
			<p>
				记住我：<input type="checkbox" name="remember" value="yes" ${userName!=null?"checked":"" }/>
			</p>
			<p>
				<input type="submit" value="登录" />
			</p>
			<p><%= (String)request.getAttribute("msg") %></p><!-- null为什么获取不到msg对应的value呢？必须在一个请求中，request被设置attribute后没有被销毁重新生成。 -->
		</form>
		
	</body>
</html>