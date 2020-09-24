<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/16
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddEmp</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
</head>
<body style="font-size:24px">
    <form action="add" method="post">
        <fieldset>
            <legend>添加员工</legend>
            姓名：<input name="name"/><br>
            薪水：<input name="salary"/><br>
            年龄：<input name="age"/><br>
            <input type="submit" value="添加"/>
        </fieldset>
    </form>
</body>
</html>
