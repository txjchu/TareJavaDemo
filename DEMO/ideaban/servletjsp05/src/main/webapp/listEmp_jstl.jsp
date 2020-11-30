<%@ page import="demo.dao.EmployeeDAO" %>
<%@ page import="demo.entity.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/24
  Time: 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>EmpList</title>
        <style type="text/css">
            .row1{ background-color: #E4E4F1}
            .row2{ background-color: #FAFAF5
            }
        </style>
    </head>
    <body>
        <table border="1" cellpadding="0" cellspacing="0" width="500px">
            <caption>员工表</caption>
            <tr>
                <td>编号</td>
                <td>姓名</td>
                <td>薪水</td>
                <td>年龄</td>
                <td>操作</td>
            </tr>
            <c:forEach var="emp" items="${emps}" varStatus="s" >

                <tr class="row${s.index % 2 + 1}">
                    <td>${emp.id}</td>
                    <td>${emp.name}</td>
                    <td>${emp.salary}</td>
                    <td>${emp.age}</td>
                    <td>
                        <a href="load.do?id=${emp.id}">修改</a>
                        <a href="delete.do?id=${emp.id}" onclick="return confirm('是否确认删除${emp.name}')">删除</a>
                    </td>
                </tr>

            </c:forEach>
        </table>
        <%--    <a href='addEmp.jsp'>增加新员工</a>--%>
        <%--    或者--%>
        <br>
        <input type="button" class="" value="增加员工" onclick="location='addEmp.jsp'"/>

        <br><br><br><br>jstl版
    </body>
</html>
