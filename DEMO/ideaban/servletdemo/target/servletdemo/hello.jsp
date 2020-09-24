<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/23
  Time: 0:44
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page pageEncoding="UTF-8" %>
<%@page import="" %>
<html>
    <head>
        <title>hello JSP</title>
    </head>
    <body style="font-size:24px">
        <%--  使用 out.println("Hello JSP<br>"); 方式输出       --%>
        <%
            for(int i = 0; i < 10; i++){
                out.println("Hello JSP<br>");
            }
        %>
        <hr>
        <%--使用<%="Hello JSP"%> 方式输出 --%>
        <%
            for(int i = 0; i < 10; i ++){
        %>
                <%="Hello JSP" %> <br>
        <%
            }
        %>



    </body>
</html>
