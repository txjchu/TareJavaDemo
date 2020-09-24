<%@ page import="demo.dao.EmployeeDAO" %>
<%@ page import="demo.entity.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/23
  Time: 1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .row1{ background-color: #E4E4F1}
        .row2{ background-color: #FAFAF5
        }
    </style>
</head>
<body>
    <table border="1" cellpadding="0" cellspacing="0" width="500px">
        <caption>员工信息表</caption>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>薪水</td>
            <td>年龄</td>
        </tr>
        <%
            EmployeeDAO dao = new EmployeeDAO();
            List<Employee> emps = dao.findAll();
            for(int i = 0; i < emps.size(); i ++){
                Employee emp = emps.get(i);
        %>
        <tr class="row<%= i % 2 + 1%>">
            <td><%=emp.getId() %></td>
            <td><%=emp.getName() %></td>
            <td><%=emp.getSalary() %></td>
            <td><%=emp.getAge() %></td>
        </tr>
        <%
            }
        %>

    </table>
</body>
</html>
