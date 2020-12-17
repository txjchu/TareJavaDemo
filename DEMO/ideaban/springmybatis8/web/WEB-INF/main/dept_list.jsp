<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/17
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>部门列表页</title>
</head>
<body>
    <table border="1">
        <caption>部门列表</caption>
        <tr>
            <td>编号</td>
            <td>名称</td>
            <td>地址</td>
        </tr>
        <c:forEach items="${depts}" var="dept">
            <tr>
                <td>${dept.deptno}</td>
                <td>${dept.dname}</td>
                <td>${dept.loc}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
