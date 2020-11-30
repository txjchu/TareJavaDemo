<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/15
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码练习</title>
    <style>
        <%--  鼠标移入变为手形状 --%>
        .s1{
            cursor: pointer;
        }
    </style>
</head>
<body>
    验证码：<input name="vcode"/>
    <%--  src为请求资源uri，   --%>
    <img src="code" onclick="this.src='code?'+Math.random();" class="s1" title="点击更换">
</body>
</html>
