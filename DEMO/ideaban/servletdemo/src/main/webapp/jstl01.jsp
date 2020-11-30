<%@ page import="demo.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/18
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>练习 jstl 01</title>

    <style>
        .s1{
            color: #0a97ff;
        }
        .s2{
            color: #125eff;
        }
    </style>
</head>
<body>
    <%
        Employee employee = new Employee();
        employee.setName("Luffy");
        employee.setAge(17);
        employee.setGender("m");
        request.setAttribute("employee", employee);
    %>
    if 标签：<hr/>
    员工姓名：${employee.name}<br>
    员工年龄：${employee.age}<br>
    员工性别：<c:if test="${employee.gender == 'm'}" var="temp" scope="request">男</c:if> <%--其中 var=temp 表示临时变量，记录test的结果 --%>
            <c:if test="${!temp}">女</c:if>
    <br><br><br>


    choose 标签：<hr/>
    使用choose标签输出Employee对象的性别属性值。通过子标签when进行判断后输出性别属性对应的中文说明。<br><br>
    员工性别：
    <c:choose>
        <c:when test="${employee.gender == 'm'}">男</c:when>
        <c:otherwise>女</c:otherwise>
    </c:choose>
    <br><br><br><br><br>

    <%
        Employee emp1 = new Employee();
        emp1.setName("Zoro");
        emp1.setAge(17);
        emp1.setGender("m");
        request.setAttribute("emp1", emp1);
        Employee emp2 = new Employee();
        emp2.setName("Luna");
        emp2.setAge(15);
        emp2.setGender("f");
        request.setAttribute("emp2", emp2);

        List<Employee> emps = new ArrayList<Employee>();
        emps.add(emp1);
        emps.add(emp2);
        request.setAttribute("emps", emps);

    %>
    forEach 标签1：<hr/>
    <c:forEach var="emp" items="${emps}" varStatus="s">
        姓名：${emp.name} &nbsp; &nbsp;
        性别：${emp.gender}<br>
    </c:forEach>
    <br><br>

    forEach 标签2：<hr/>
    <%--输出varStatus中的index和count的值。index代表对象在集合中的下标，count代表访问过的对象的个数。--%>
    <c:forEach var="emp" items="${emps}" varStatus="s">
        <%--添加样式，使得对象值交错变色--%>
        <p class="s${s.index%2+1}">
            姓名：${emp.name} &nbsp; &nbsp;
            性别：${emp.gender} &nbsp; &nbsp;
            count：${s.count} &nbsp; &nbsp;
            index：${s.index}
        </p>
    </c:forEach>
    <br><br>



</body>
</html>
