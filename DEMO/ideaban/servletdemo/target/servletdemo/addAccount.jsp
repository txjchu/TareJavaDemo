<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/18
  Time: 5:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>addAccount</title>
        <meta http-equiv="content-type" content="text/html;charset=utf-8">
    </head>
    <body style="font-size:24px">
        <form action="addAccount" method="post">
            <fieldset>
                <legend>添加帐务帐号</legend>
                姓名：<input name="realName"/><br>
                身份证：<input name="idcardNo"/><br>
                登录名：<input name="loginName"/><br>
                手机号：<input name="telephone"/><br>
                <input type="submit" value="添加"/>
            </fieldset>
        </form>
    </body>
</html>
