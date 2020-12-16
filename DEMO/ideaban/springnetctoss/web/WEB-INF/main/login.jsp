<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/10
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>登录页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
    <style>
        span.required
        {
            color: #ffeb00;
            /* border:1px solid red; */
        }
    </style>
</head>
<body class="index">
    <div class="login_box">

        <form method="post" action="checkLogin.do">
            <table>
                <tr>
                    <td class="login_info">账号：</td>
                    <td colspan="2" ><input name="adminCode" class="width150" type="text" value="${adminCode}"></td>
                    <td class="login_error_info"><span class="required">30长度的字母、数字或下划线组合</span></td>
                </tr>
                <tr>
                    <td class="login_info">密码：</td>
                    <td colspan="2"><input name="password" value="${password}" type="password" class="width150"></td>
                    <td class="login_error_info"><span class="required">30长度的字母、数字或下划线组合</span></td>
                </tr>
                <tr>
                    <td class="login_info">验证码：</td>
                    <td class="width70"><input class="width70" type="text" name=""></td>
                    <td><img src="../images/valicode.jpg" class="" alt="验证码" title="点击更换"/></td>
                    <td><span class="required"></span></td>
                </tr>
                <tr>
                    <td></td>
                    <td class="login_button" colspan="2">
                        <a href="javascript:document.forms[0].submit();"><img src="../images/login_btn.png"></a><%--笔记：注意forms[0]的 s--%>
                    </td>
                    <td><span class="required">${message}</span></td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>
