<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/24
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>a2.jsp</title>
</head>
<body>
    a2.jsp content<br>
    相对路径的写法：<a href="../biz1/a1.jsp">a1.jsp</a>  <%--当从 servlet 中使用转发到该 jsp 时，此处的路径会出错(多向上一级)--%>
    绝对路径的写法：<a href="/servletjsp05/biz1/a1.jsp">a1.jsp</a>
    变量路径的写法：<a href="<%=request.getContextPath()%>/biz1/a1.jsp">a1.jsp</a>  <%--绝对路径--%>
</body>
</html>
