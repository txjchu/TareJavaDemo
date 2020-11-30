<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/24
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>错误提醒</title>
</head>
<body style="font-size: 24px">
    <%--<%=request.getAttribute("err_msg")== null ? "" : request.getAttribute("err_msg") %>--%>
    <c:if test="${err_msg == null}" var="msg" scope="request"></c:if>
    <c:if test="${!msg}">${err_msg}</c:if>
    <br>
    系统异常    <a href="list.do">返回</a>


</body>
</html>
