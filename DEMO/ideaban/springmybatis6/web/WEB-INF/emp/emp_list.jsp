<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/13
  Time: 1:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>员工列表页</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>工资</td>
            <td>入职时间</td>
            <td>操作</td>
        </tr>
        <c:forEach var="emp" items="${emps}">
            <tr>
                <td>${emp.empno}</td>
                <td>${emp.ename}</td>
                <td>${emp.sal}</td>
                <td>${emp.hiredate }</td>
                <td><a href="toUpdate.do?empno=${emp.empno}">修改</a></td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>

