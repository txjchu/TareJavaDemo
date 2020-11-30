<%--
  练习通过 session 控制登录后才能访问该页面
  web-inf目录只能在sevlet（或bai者spring的control，struts的action，本质都是dusevlet）中访问。
  也就是只能通过zhijava后台访问，这里web-inf下的内容是不对外开dao放的/安全的，不能通过url直接访问。
  以避免非法人员通过url自己操作一些比较私密的文件信息。

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/13
  Time: 0:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <script type="text/javascript">
        <%--   计时器     --%>
        var timer;
        var count = 0;
        timer = setInterval(function () { // 1秒加1
            count ++;
            document.getElementById("clock").innerHTML = count; // 将计数器每秒都赋给 clock ，实现刷新效果。
        }, 1000);
        window.onload = timer;// 页面加载完成后执行该方法.
        // window.onload = function (){
        //     alert("a");
        // }
    </script>
</head>
<body>
    <%--  session 验证  --%>
    <%
        Object uname = session.getAttribute("uname");// session 是 JSP 中的内置对象，类型为 HttpSession ，获取 session 中绑定的数据
        if(uname == null){ // 获取不到 session 中的数据，则说明未登录成功，将其转发返回登录页面
            response.sendRedirect("login.jsp"); // 为什么用转发，而不是用重定向？

            return;
        }
    %>
    <h3>首页</h3>
    欢迎你 <%= uname.toString() %><br><br> <p>计时：<span id="clock"></span></p>
    <a href="logout.action">登出</a>
</body>
</html>
