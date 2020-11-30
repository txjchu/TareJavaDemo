<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/17
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>使用 EL 表达式运算</title>
</head>
<body>
    <%-- 使用 EL 表达式进行运算 --%>
    <%-- 1.算数运算 --%>
    加：${1+2}<br>
    加：${"123"+"456"} <%-- 加号只能进行加法运算，不能进行连接 --%><br>
    加：${123+"456"}<br><hr/>

    <%-- 2.关系运算 --%>
    ${123 == 123}<br>
    ${"123" == "123"}<br>
    ${"123" eq "123"}<br>
    <% pageContext.setAttribute("str", "abc"); %>
    ${"abc" eq str}<br><hr/>

    <%-- 3.empty运算 --%>
    <%
        request.setAttribute("str1", "");
        List list = new ArrayList<>();
        request.setAttribute("list1", list);
        request.setAttribute("obj", null);

    %>
    空字符串：${empty str1}<br>
    找不到绑定对象：${empty xxx}<br>
    集合内容为空：${empty list1}<br>
    null 的结果：${empty obj}<br>

</body>
</html>
