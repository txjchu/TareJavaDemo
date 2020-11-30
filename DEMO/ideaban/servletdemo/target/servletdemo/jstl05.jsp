<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/18
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>URL标签</title>
</head>
<body>
    URL标签：使用URL标签生成的地址，在禁用Cookie的情况下，系统会自动在链接上添加JSESSIONID，以保证能够访问session对象。<hr/>

    <%
        session.setAttribute("uname", "Luffy");

    %>
    <a href="<c:url value="jstl06.jsp"/>">访问 jstl06.jsp </a>
</body>
</html>
