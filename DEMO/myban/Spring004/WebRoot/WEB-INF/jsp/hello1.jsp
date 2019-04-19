<%@page pageEncoding="utf-8"%>
<html>
	<head>
		<title>练习MVC中数据传输</title>
	</head>
	<body>
		<h1>hello, SpringMVC.</h1>
		
		<h4>使用ModelAndView,ModelMap传递出参数</h4>
		<h1>是否成功：${success }</h1>
		<h1>提示信息：${message }</h1>
		
		<h4>使用@ModelAttribute注解向JSP页面传值</h4>
		<h1>年龄:${age }</h1>
		<h1>账号:${userName }</h1>
		<h1>密码:${password }</h1>
		
		<h4>test7:使用session传出数据</h4>
		<h4>test8:使用String</h4>
		<h1>工资:${salary }</h1>
		<h1>对象:${user.userName }</h1>
	</body>
</html>