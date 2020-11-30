<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/12
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>addCookie</title>
</head>
<body>
    <%--    只有访问的当前路径与Cookie路径一致或是其子目录时，浏览器才会发送Cookie。需要修改Cookie路径时使用setPath()方法。--%>
    <%
        Cookie c1 = new Cookie("uname", "Kitty");
        /*设置 cookie 的路径，只有在cookie 的路径内或路径下的访问请求才能获取到 cookie */
        c1.setPath("/helloservlet");
        response.addCookie(c1);
    %>
</body>
</html>
