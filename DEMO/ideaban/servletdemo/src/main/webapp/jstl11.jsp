<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/18
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>redirect 标签 (重定向)</title>
</head>
<body>
    redirect 标签：重定向到指定 url。<hr/>
    <c:set var="num" scope="session" value="${1+3}"></c:set>
    <c:redirect url="jstl12.jsp"/>
</body>
</html>
