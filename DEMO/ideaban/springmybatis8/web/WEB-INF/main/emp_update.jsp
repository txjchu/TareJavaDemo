<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/17
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>修改员工记录</title>
</head>
<body>
    <form:form action="update.do" method="post" modelAttribute="emp"> <%--commandName 弃用，会报异常 JasperException, 改用 modelAttribute--%>
        <form:hidden path="empno" />
        姓名：<form:input path="ename"/><br>
        职位：<form:select path="job">
                <form:option value="SALESMAN" label="SALESMAN"/>
                <form:option value="MANAGER" label="MANAGER"/>
                <form:option value="CLERK" label="CLERK"/>
                <form:option value="PRESIDENT" label="PRESIDENT"/>
                <form:option value="ANALYST" label="ANALYST"/>
             </form:select><br>
        管理者：<form:input path="mgr"/><br>
        工资：<form:input path="sal"/><br>
        奖金：<form:input path="comm"/><br>
        入职时间：<form:input path="hiredate"/><br>
        所在部门：<form:select path="deptno" items="${depts}" itemLabel="dname" itemValue="deptno"/><br>
        <input type="submit" value="修改">
    </form:form>
</body>
</html>
