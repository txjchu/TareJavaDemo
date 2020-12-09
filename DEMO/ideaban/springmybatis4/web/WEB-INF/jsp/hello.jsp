<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/8
  Time: 1:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>数据展示页面</title>
    <meta charset="UTF-8" >
</head>
<body>
    <h1>Hello, SpringMVC</h1>

    <br><br><hr/>

    <h2>1. test4 使用 ModelAndView 传输数据 </h2><br>
    new ModelAndView(视图名.jsp, map)<br>
    获取时：\${success} ,不需要 map.key
    <h3>操作：${success}</h3>
    <h3>消息：${message}</h3>

    <h2>2. test5 使用 ModelMap 传输数据</h2>
    <h3>操作：${success}</h3>
    <h3>消息：${message}</h3>

    <h2>3. test6 使用 @ModelAttribute 注解传送数据</h2>
    @ModelAttribute("xxx") 注解中参数名必须与接收时一致。
    <h3>年龄：${age}</h3>
    <h3>userName: ${uname}</h3>

    <h2>4. test7 使用 session 传输数据</h2>
    注意：index.jsp 中表单提交修改为 demo/test7.do
    <h3>user.userName: ${user.userName}</h3>
    <h3>user.password: ${user.password}</h3>
    <h3>salary: ${salary}</h3>

    <h2>5. test8 返回 String 练习</h2>
    <h3>user.userName: ${user.userName}</h3>
    <h3>user.password: ${user.password}</h3>

</body>
</html>
