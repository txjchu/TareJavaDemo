<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/13
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login</title>
    <style>
        .s1{
            cursor: pointer;
        }
    </style>
</head>
<body>
    <%

    %>
    <form action="login.action" method="post">
        用户名：<input type="" name="uname"/><Br><br>
        密  码：<input type="password" name="pwd"/><br><br>
        验证码：<input type="" name="vcode" /> <img src="code" onclick="this.src='code?'+Math.random();" class="s1" title="点击更换"/><br><br>
        <p><%=session.getAttribute("msg") %></p>
        <input type="submit" value="登录"/>


    </form>
</body>
</html>
