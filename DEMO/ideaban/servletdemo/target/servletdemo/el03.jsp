<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/17
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>使用 EL 表达式获取请求中的参数</title>
</head>
<body>
    <%-- 当请求 uri 上绑定有参数数据，则可以使用 EL 表达式中的如下方式获取 --%>
    <%-- 使用param访问Name-Value中的Value，使用paramValues访问Name-Values中的多值。 --%>

    <%-- 请求uri: http://localhost:8080/helloservlet/el03.jsp?name=Luffy&interest=Sleeping&interest=Eating --%>

    <%-- 获取请求参数 --%>
    姓名：${param.name}<br>
    兴趣：${paramValues.interest[0]}<br>
    兴趣：${paramValues.interest[1]}<br>
    测试：${paramValues.interest}<br> <%-- 直接显示的是字符串数组.toString()：[Ljava.lang.String;@2c49ef3f --%>
</body>
</html>
