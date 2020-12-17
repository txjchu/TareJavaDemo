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
    <title>员工列表页</title>
</head>
<body>
    <h1>员工列表</h1>
    <table border="1">
        <caption>员工列表</caption>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>工资</td>
            <td>奖金</td>
            <td>入职时间</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${emps}" var="emp">
            <tr>
                <td>${emp.empno}</td>
                <td>${emp.ename}</td>
                <td>${emp.sal}</td>
                <td>${emp.comm}</td>
                <td>${emp.hiredate}</td>
                <td><a href="toUpdate.do?id=${emp.empno}">操作</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
