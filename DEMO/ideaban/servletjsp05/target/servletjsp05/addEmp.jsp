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
    <title>AddEmp</title>

</head>
<body style="font-size:24px">
    <form action="add.do" method="post">
        <fieldset>
            <legend>员工管理</legend>
            姓名:<input name="name"/><br>
            薪水:<input name="salary"/><br>
            年龄:<input name="age"/><Br>
            <input type="submit" value="增加"/>
        </fieldset>
    </form>

</body>
</html>
