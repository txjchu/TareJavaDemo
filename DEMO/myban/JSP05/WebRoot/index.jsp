<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
  <head>

    <meta content="UTF-8">
    <title>带计算在线人数功能的首页</title>

  </head>
  
  <body style="font-size:30px; font-style:italic;">
    This is my JSP page. <br>
            在线人数：<%= application.getAttribute("count") %>
	<a href="logOut.jsp">退出</a>
  </body>
</html>
