<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

    <head>
        <title>ServletDemo Index</title>
        <meta http-equiv="content-type" content="text/html;charset=utf-8">
        <%-- 注意：page 标签中定义 pageEncoding="utf-8" 的级别比 meta 高   --%>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
    </head>
    <body>
        <h2>Hello World!</h2>

        username : <%= request.getAttribute("username")%></br>
        password : <%= request.getAttribute("password")%></br>
        <%= request.getAttribute("date")%>
    </body>
</html>
