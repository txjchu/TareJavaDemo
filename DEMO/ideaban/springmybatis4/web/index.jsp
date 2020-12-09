<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/7
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>通过表单提交数据页面</title>
  </head>
  <body>
      <h1>测试表单</h1>
      <form action="demo/test11.do" method="post">
          账号：<input type="text" name="userName"/><br><br/>
          密码：<input name="password" type="password"> <br><br>
          <input type="submit" value="提交">
      </form>
  </body>
</html>
