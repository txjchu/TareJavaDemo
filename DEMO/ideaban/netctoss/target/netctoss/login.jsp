<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/30
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link type="text/css" rel="stylesheet" media="all" href="styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="styles/global_color.css" />
    <style>
        span.required {
            color: #fff700;
            /* border: 1px solid red; */
        }
    </style>
</head>
<body class="index">
    <div class="login_box">
        <form name="login" action="login.do" method="post">
            <table>
                <tr>
                    <td class="login_info">账号：</td>
                    <td colspan="2"><input name="adminCode" type="text" class="width150" /></td>
                    <td class="login_error_info">
    <%--                    <span class="required">30长度的字母、数字和下划线</span>--%>
                    </td>
                </tr>
                <tr>
                    <td class="login_info">密码：</td>
                    <td colspan="2"><input name="password" type="password" class="width150" /></td>
                    <td>
    <%--                    <span class="required">30长度的字母、数字和下划线</span>--%>
                    </td>
                </tr>
                <tr>
                    <td class="login_info">验证码：</td>
                    <td class="width70"><input name="vcode" type="text" class="width70" /></td>
                    <td><img src="code" alt="验证码" title="点击更换" class="s1" onclick="this.src='code?'+Math.random()"/></td>
                    <td>
                        <span class="required">${vcode_err == null ? "" : vcode_err}</span>
                    </td>
                </tr>


                <tr>
                    <td class="login_info">
                        <input type="checkbox" name="saveCookie" value="yes" checked />
                    </td>
                    <td colspan="2">
                        自动登录
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td class="login_button" colspan="2">
                        <%--笔记--%>
                        <a href="javascript:document.login.submit();"><img src="images/login_btn.png" /></a>
                    </td>
                    <td>
                        <span class="required">${login_err == null ? "" : login_err}</span>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
