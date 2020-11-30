<%@ page import="demo.day09.Course" %>
<%@ page import="demo.day09.User" %>
<%@ page import="java.util.Arrays" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/17
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>练习 EL 表达式</title>
</head>
<body>
    <%--访问 Bean 属性 --%>
    <%-- 创建 Bean --%>
    <%
        Course course = new Course();
        course.setCourseId(1);
        course.setCourseName("Servlet");
        User u1 = new User();
        u1.setName("Luffy");
        u1.setAge(17);
        u1.setCourse(course);
        u1.setInterests(new String[]{"Sleeping", "Eating", "Shopping"});
        request.setAttribute("user", u1);
    %>

    <%--1. Java 编码方式访问--%>
    1. Java 编码方式访问<hr/>
    <%
        User u = (User) request.getAttribute("user");
        out.println("姓名："+ u.getName() +"<br>");
        out.println("年龄："+ u.getAge() +"<br>");
        out.println("课程："+ u.getCourse().getCourseName() +"<br>");
        out.println("兴趣："+ Arrays.toString(u.getInterests()) +"<br>");
    %>
    <br><br><br>
    2. EL 表达式 方式一<hr/>
    <%--常用类型--%>
    姓名：${user.name}<br>
    年龄：${user.age}<br>
    <%--引用类型--%>
    课程：${user.course.courseName}<br>
    兴趣：${user.interests[1]}<br><br><br>

    3.EL 表达式 方式二<hr/>
    姓名：${user["name"]}<br>
    <%
        request.setAttribute("userAge", "age");
    %>
    年龄：${user[userAge]}<br> <%-- 动态获取某个内部对象域所绑定的指定属性 --%>

    兴趣：${user.interests[0]}<br><br><br>

    4. 访问范围<hr/>
    用户姓名：${requestScope.user.name}


</body>
</html>
