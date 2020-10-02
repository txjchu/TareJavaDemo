<%@ page import="demo.dao.UserDAO" %>
<%@ page import="demo.entity.User" %>
<%@ page import="java.util.List" %>
<%--
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
        <caption>用户表</caption>
        <tr>
            <td>id</td>
            <td>username</td>
            <td>pwd</td>
            <td>name</td>
            <td>gender</td>
            <td>操作</td>
        </tr>
    <%
        // 请求url listUser.do, 通过 servlet 转发到 listUser.jsp，转发前查询数据库后将获取到的数据绑定到 request.setAttribute("", obj) 上
        List<User> users = (List<User>) request.getAttribute("users");
        if(users != null){

        } else {
            UserDAO dao = new UserDAO();
            users = dao.findAll();
        }
        for(int i = 0; i < users.size(); i ++){
            User user = users.get(i);
    %>
        <tr class="row<%= i % 2 + 1%>">
            <td><%= user.getId() %></td>
            <td><%= user.getUserName() %></td>
            <td><%= user.getPwd() %></td>
            <td><%= user.getName() %></td>
            <td><%= user.getGender() %></td>
            <td>
                <a href="loadUser.action?id=<%=user.getId() %>">修改</a>
                <a href="deleteUser.action?id=<%=user.getId() %>" onclick="return confirm('是否确认删除<%=user.getName()%>')">删除</a>
            </td>
        </tr>
    <%
        }
    %>
    </table>
<%--    <a href='addUser.jsp'>增加新员工</a>--%>
<%--    或者--%>
    <br>
    <input type="button" class="" value="增加用户" onclick="location='addUser.jsp'"/>
</body>
</html>
