<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/18
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>import 标签</title>
</head>
<body>

    import 标签：import标记将另一个页面嵌入到当前页面中。<br>
    This is jstl09.jsp <hr/>

    <div style="border: solid 1px #0063a0">
        <c:import url="jstl10.jsp"/>
    </div>
    This is jstl09.jsp.....
</body>
</html>
