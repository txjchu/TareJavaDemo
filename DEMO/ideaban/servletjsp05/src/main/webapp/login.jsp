<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/28
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>login</title>

    <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
    <div id="wrap">
        <div id="top_content">
            <div id="header">
                <div id="rightheader">
                    <p>
                        2009/11/20 <br />
                    </p>
                </div>
                <div id="topheader">
                    <h1 id="title">
                        <a href="#">main</a>
                    </h1>
                </div>
                <div id="navigation"></div>
            </div>
            <div id="content">
                <p id="whereami"></p>
                <h1>login</h1>
                <form action="login.do" method="post">
                    <table cellpadding="0" cellspacing="0" border="0"
                           class="form_table">
                        <tr>
                            <td valign="middle" align="right">用户名:</td>
                            <td valign="middle" align="left">
                                <input type="text"    class="inputgri" name="username" />
                                <%
                                    String errorMsg = (String)request.getAttribute("login_err");
                                %><span style="color:red;"><%=errorMsg==null?"":errorMsg%></span>
                            </td>
                        </tr>
                        <tr>
                            <td valign="middle" align="right">密码:</td>
                            <td valign="middle" align="left"><input type="password"
                                                                    class="inputgri" name="pwd" />
                            </td>
                        </tr>
                    </table>
                    <p>
                        <input type="submit" class="button" value="Submit &raquo;" />
                    </p>
                </form>
            </div>
        </div>
        <div id="footer">
            <div id="footer_bg">ABC@126.com</div>
        </div>
    </div>
</body>
</html>
