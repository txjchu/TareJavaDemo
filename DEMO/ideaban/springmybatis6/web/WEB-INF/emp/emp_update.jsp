<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/13
  Time: 1:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>修改员工记录</title>
    <%--笔记 Spring 框架的 form 标签的使用--%>
</head>
<body>
    
    <%--@elvariable id="emp" type="com.pc.entity.Emp"--%>
    <%--modelAttribute 与 commandName 都可以在视图与控制器直接传递对象，但是 commandName 已弃用--%>
    <form:form action="update.do" method="post" modelAttribute="emp">
            <form:hidden path="empno"/>
            姓名：<form:input path="ename"/><br>
            职位：<form:select path="job">
                    <form:option value="SALESMAN" label="SALESMAN"/>
                    <form:option value="MANAGER" label="MANAGER"/>
                    <form:option value="CLERK" label="CLERK"/>
                    <form:option value="PRESIDENT" label="PRESIDENT"/>
                    <form:option value="ANALYST" label="ANALYST"/>
                 </form:select><br>
            管理者：<form:input path="mgr"/><br>
            入职时间：<form:input path="hiredate" data-format="yyyy-MM-dd"/><br>
            工资：<form:input path="sal"/><br>
            奖金：<form:input path="comm"/><br>
            所在部门：<form:select path="deptno" items="${deptMap}"/><br>
            <input type="submit" value="修改">
    </form:form>
        <%--<form action="update.do" method="post">
            编号：<input type="text" readonly value="${emp.empno}" name="empno"><br>
            姓名：<input type="text" value="${emp.ename}" name="ename"><br>
            职位：<select name="job">
                    <c:choose>
                        <c:when test="${emp.job != null && !''.equals(emp.job)}">
                            <option value="${emp.job}">${emp.job}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="">请选择</option>
                        </c:otherwise>
                    </c:choose>
                    <option value="SALESMAN">SALESMAN</option>
                    <option value="MANAGER">MANAGER</option>
                    <option value="CLERK">CLERK</option>
                    <option value="PRESIDENT">PRESIDENT</option>
                    <option value="ANALYST">ANALYST</option>
                 </select><br>
            管理者：<input name="mgr" value="${emp.mgr}"><br>
            &lt;%&ndash;入职时间：<input name="hiredate" value="${emp.hiredate}"><br>&ndash;%&gt;
            工资：<input name="sal" value="${emp.sal}"><br>
            奖金：<input name="comm" value="${emp.comm}"><br>
            所在部门：<select name="deptno">
                        <c:choose>
                            <c:when test="${emp.deptno == 10}">
                                <option value="10">${deptMap.get("10")}</option>
                            </c:when>
                            <c:when test="${emp.deptno == 20}">
                                <option value="20">${deptMap.get("20")}</option>
                            </c:when>
                            <c:when test="${emp.deptno == 30}">
                                <option value="30">${deptMap.get("30")}</option>
                            </c:when>
                            <c:when test="${emp.deptno == 40}">
                                <option value="40">${deptMap.get("40")}</option>
                            </c:when>
                            <c:otherwise><option value="">请选择</option></c:otherwise>
                        </c:choose>
                        <option value="10">${deptMap.get("10")}</option>
                        <option value="20">${deptMap.get("20")}</option>
                        <option value="30">${deptMap.get("30")}</option>
                        <option value="40">${deptMap.get("40")}</option>
                    </select>
            <br>
            <input type="submit" value="修改">
        </form>--%>

</body>
</html>
