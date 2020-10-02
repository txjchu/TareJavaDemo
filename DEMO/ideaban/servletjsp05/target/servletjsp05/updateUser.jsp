<%@ page import="demo.entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/24
  Time: 1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>修改用户记录</title>
</head>
<body>
    <p id="whereami">
    </p>
    <h1>
        更新用户
    </h1>
    <%
        User user = (User) request.getAttribute("user");
    %>
    <form action="updateUser.action?id=<%=user.getId()%>" method="post">
        <table ellpadding="0" cellspacing="0" border="0" class="form_table">
            <tr>
                <td valign="middle" align="right">
                    编号:
                </td>
                <td valign="middle" align="left">
                    <%=user.getId()%>
                </td>
            </tr>
            <tr>
                <td valign="middle" align="right">
                    姓名:
                </td>
                <td valign="middle" align="left">
                    <input type="text" class="inputgri" name="name" value="<%=user.getName()%>"/>
                </td>
            </tr>
            <tr>
                <td valign="middle" align="right">
                    用户名:
                </td>
                <td valign="middle" align="left">
                    <input type="text" class="inputgri" name="username" value="<%=user.getUserName()%>"/>
                </td>
            </tr>
            <tr>
                <td valign="middle" align="right">
                    密码:
                </td>
                <td valign="middle" align="left">
                    <input type="text" class="inputgri" name="pwd" value="<%=user.getPwd()%>"/>
                </td>
            </tr>
            <tr>
                <td valign="middle" align="right">
                    性别:
                </td>
                <td valign="middle" align="left">
                    <input type="text" class="inputgri" name="gender" value="<%=user.getGender()%>"/>
                </td>
            </tr>
        </table>
        <p>
            <input type="submit" class="button" value="修改" />
        </p>
    </form>
</body>
</html>
