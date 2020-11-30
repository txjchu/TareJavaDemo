<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/12
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>findCookie</title>
</head>
<body>
    <%

        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie c : cookies){
                String name = c.getName();
                String value = c.getValue();
                out.println("<h4>Name:"+ name +", Value:"+ value +"</h4>");
            }
        } else {
            out.println("没有 cookie 信息！");
        }
    %>
</body>
</html>
