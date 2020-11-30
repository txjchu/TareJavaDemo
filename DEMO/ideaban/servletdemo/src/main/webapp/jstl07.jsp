<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/18
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>set remove 标签</title>
</head>
<body>
    set 标签：向某个区域添加键值对数据<br><br>
    remove 标签：移除某个区域中的键值对数据<br><br>
    <hr/>

    <c:set var="num" scope="session" value="${1+2}"></c:set>
    set之后：num = ${sessionScope.num}<br>
    <c:remove var="num" scope="session"></c:remove>
    remove 之后： num = ${sessionScope.num}
</body>
</html>
