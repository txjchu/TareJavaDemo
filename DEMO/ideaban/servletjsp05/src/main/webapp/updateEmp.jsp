<%@ page import="demo.entity.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/24
  Time: 1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>修改员工记录</title>
</head>
<body>
    <p id="whereami">
    </p>
    <h1>
        更新员工
    </h1>
    <%
        Employee emp = (Employee) request.getAttribute("emp");
    %>
    <form action="update.do?id=<%=emp.getId()%>" method="post">
        <table ellpadding="0" cellspacing="0" border="0" class="form_table">
            <tr>
                <td valign="middle" align="right">
                    编号:
                </td>
                <td valign="middle" align="left">
                    <%=emp.getId()%>
                </td>
            </tr>
            <tr>
                <td valign="middle" align="right">
                    姓名:
                </td>
                <td valign="middle" align="left">
                    <input type="text" class="inputgri" name="name" value="<%=emp.getName()%>"/>
                </td>
            </tr>
            <tr>
                <td valign="middle" align="right">
                    薪水:
                </td>
                <td valign="middle" align="left">
                    <input type="text" class="inputgri" name="salary" value="<%=emp.getSalary()%>"/>
                </td>
            </tr>
            <tr>
                <td valign="middle" align="right">
                    年龄:
                </td>
                <td valign="middle" align="left">
                    <input type="text" class="inputgri" name="age" value="<%=emp.getAge()%>"/>
                </td>
            </tr>
        </table>
        <p>
            <input type="submit" class="button" value="修改" />
        </p>
    </form>
</body>
</html>
