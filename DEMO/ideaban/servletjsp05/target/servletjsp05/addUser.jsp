<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/24
  Time: 1:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>AddUser</title>

</head>
<body style="font-size:24px">
    <form action="addUser.action" method="post">
        <fieldset>
            <legend>用户管理</legend>
            用户名:<input name="username"/><br>
            密码:<input name="pwd"/><br>
            姓名:<input name="name"/><br>
            性别:<input name="gender"/><Br>
            <input type="submit" value="增加"/>
        </fieldset>
    </form>

</body>
</html>
