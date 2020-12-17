<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/11
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>NETCTOSS</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/styles/global_color.css" />
    <script language="javascript" type="text/javascript">
        var timer;
        //启动跳转的定时器
        function startTimes() {
            timer = window.setInterval(showSecondes,1000);
        }

        var i = 5;
        function showSecondes() {
            if (i > 0) {
                i--;
                document.getElementById("secondes").innerHTML = i;
            }
            else {
                window.clearInterval(timer);
                <%--location.href = "<%=request.getContextPath()%>/login/toLogin.do";--%>
                location.href = "<%=request.getContextPath()%>/index.do";
            }
        }

        //取消跳转
        function resetTimer() {
            if (timer != null && timer != undefined) {
                window.clearInterval(timer);
                location.href = "<%=request.getContextPath() %>/index.do";
                // history.back();
            }
        }
        /*startTimes(); *//*笔记 在js中定义的方法，如果需要调用，可以直接如此调用。直接在 body 标签上使用 onload="" 来调用该方法*/
    </script>
</head>
<body class="error_page" onload="startTimes();">
    <h1 id="error">
        遇到错误，&nbsp;<span id="secondes">5</span>&nbsp;秒后将自动跳转，立即跳转请点击&nbsp;
        <a  href="javascript:;" onclick="resetTimer();">返回</a>
    </h1>
</body>
</html>
