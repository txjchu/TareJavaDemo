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
    <%
        // 请求url list.do, 通过 servlet 转发到 listEmp.jsp，转发前查询数据库后将获取到的数据绑定到 request.setAttribute("", obj) 上
        List<Employee> emps = (List<Employee>) request.getAttribute("emps");
        for(int i = 0; i < emps.size(); i ++){
            Employee emp = emps.get(i);
    %>
        <tr class="row<%= i % 2 + 1%>">
            <td><%= emp.getId() %></td>
            <td><%= emp.getName() %></td>
            <td><%= emp.getSalary() %></td>
            <td><%= emp.getAge() %></td>
            <td>
                <a href="load.do?id=<%=emp.getId() %>">修改</a>
                <a href="delete.do?id=<%=emp.getId() %>" onclick="return confirm('是否确认删除<%=emp.getName()%>')">删除</a>
            </td>
        </tr>
    <%
        }
    %>
    </table>
<%--    <a href='addEmp.jsp'>增加新员工</a>--%>
<%--    或者--%>
    <br>
    <input type="button" class="" value="增加员工" onclick="location='addEmp.jsp'"/>
</body>
</html>
