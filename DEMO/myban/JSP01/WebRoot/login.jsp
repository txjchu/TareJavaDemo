    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="/lhh/abc/Tags" prefix="s"%>
    <html>
    <head>
    <title>login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    </head>
    <body>
        <div id="wrap">
            <div id="top_content">
                <div id="header">
                    <div id="rightheader">
                        <p>
                            <s:sysdate format="yyyy-MM-dd E HH-mm-ss"/> <br />
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
                                <input type="text"    class="inputgri" name="name" value="${param.name }"/>
                                <%--
                                    <%
                                    	String errorMsg = (String)request.getAttribute("login_err");
                                    %>
                                 --%>
                                    <span style="color:red;">
                                    <%--
                                    <%=errorMsg==null?"":errorMsg%>
                                     --%>
		                                   <c:if test="${login_err==null}" var="msg" scope="request"></c:if>
		                                   <c:if test="${!msg}">${login_err}</c:if>
                                    </span>
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
                            <input type="submit" class="button" value="Submit &raquo;" /><!-- &raquo;双大于号 -->
                            <a href="toRegist.do">注册账号</a>
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