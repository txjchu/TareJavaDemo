<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/7
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>城市列表</title>
</head>
<body>
    <table border='1' cellpadding='0' cellspacing='0' width='60%'>
        <caption>城市信息列表</caption>
        <tr>
            <td>ID</td>
            <td>城市</td>
        </tr>
        <c:forEach items="${cities}" var="city">
            <tr>
                <td>${city.id}</td>
                <td>${city.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
