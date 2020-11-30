<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/16
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>评论</title>
</head>
<body>
    <form action="comment" method="post">
        <fieldset>
            <legend>评论</legend>
            请输入评论：<textarea name="comment" style="vertical-align: middle; width: 150px; height: 55px"></textarea><br>
            <input type="submit" value="发表评论"/>
        </fieldset>
    </form>
</body>
</html>
