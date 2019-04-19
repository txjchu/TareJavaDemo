<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
    
    <div>
		<fieldset>
			<legend>练习Struts2的传参</legend>
			<form action="demo/hello.action" method="post">
				<!-- 基本属性注入 -->
				请输入你的姓名：<input type="text" name="name" ><br/><br/>
				<!-- 域模型注入 -->
				账号：<input type="text" name="user.username"><br/>
				密码：<input type="password" name="user.password"/><br/>

				<input type="submit" value="提交"/>
			</form>
			
		</fieldset>
	</div>
  </body>
</html>
