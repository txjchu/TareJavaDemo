<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/18
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@taglib uri="http://java.sun.com/jstl/core" %>--%> <%--注意不要混淆了另一个标签库--%>
<html>
<head>
    <title>jstl04</title>

    <style>
        .s1{
            color: #8ac1db;
        }
        .s2{
            color: #0063a0;
        }
    </style>
</head>
<body>
    forEach 标签的使用：<hr/>
    嵌套 choose 标签
    <c:forEach var="emp" items="${emps}" varStatus="s">
        <p class="s${s.index%2+1}">
            员工姓名：${emp.name} &nbsp;&nbsp;
            员工性别：
            <c:choose>
                <c:when test="${emp.gender == 'm'}">男</c:when>
                <c:otherwise>女</c:otherwise>
            </c:choose>
        </p>
    </c:forEach>

</body>
</html>
