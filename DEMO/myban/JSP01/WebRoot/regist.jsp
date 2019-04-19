    <%@ page contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <html>
        <head>
            <title>注册</title>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" type="text/css" href="css/style.css" />
        </head>
        <body>
            <div id="wrap">
                <div id="top_content">
                        <div id="header">
                            <div id="rightheader">
                                <p>
                                    2009/11/20
                                    <br />
                                </p>
                            </div>
                            <div id="topheader">
                                <h1 id="title">
                                    <a href="#">main</a>
                                </h1>
                            </div>
                            <div id="navigation">
                            </div>
                        </div>
                    <div id="content">
                        <p id="whereami">
                        </p>
                        <h1>
                            注册
                        </h1>
                        <form action="regist.do" method="post">
                            <table cellpadding="0" cellspacing="0" border="0"
                                class="form_table">
                                <tr>
                                    <td valign="middle" align="right">
                                        用户名:
                                    </td>
                                    <td valign="middle" align="left">
                                        <input type="text" class="inputgri" name="username" value="${param.username}"/>
                                        <%--
                                        <%
                                            String errorMsg = (String)request.getAttribute("regis_err");
                                        %>
                                         --%>
                                        <span style="color:red;">
                                        <%--
                                        <%=errorMsg==null?"":errorMsg%>
                                         --%>
                                         <c:if test="${regis_err==null}" var="msg" scope="request"></c:if>
                                         <c:if test="${!msg}">${regis_err}</c:if>
                                        </span>
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="middle" align="right">
                                        真实姓名:
                                    </td>
                                    <td valign="middle" align="left">
                                        <input type="text" class="inputgri" name="name" value="${param.name}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="middle" align="right">
                                        密码:
                                    </td>
                                    <td valign="middle" align="left">
                                        <input type="password" class="inputgri" name="pwd" value="${param.pwd}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="middle" align="right">
                                        性别:
                                    </td>
                                    <td valign="middle" align="left" ><!-- 此处不应该使用value="${param.sex}"，应尝试js代码function -->
                                        男
                                        <input type="radio" class="inputgri" name="sex" value="m" checked="checked"/>
                                        女
                                        <input type="radio" class="inputgri" name="sex" value="f"/>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td valign="middle" align="right">
                                        验证码:
                                    </td>
                                    <td valign="middle" align="left">
                                        <input type="text" class="inputgri" name="vcode" /><!-- 用户输入的验证码 -->
                                        <img id="num" src="code.do" title="点击更换"/>
                                        <a href="javascript:;" onclick="document.getElementById('num').src = 'code.do?'+(new Date()).getTime()">换一张</a>
                                    </td>
                                </tr>
                            </table>
                            <p>
                                <input type="submit" class="button"  value="Submit &raquo;" onclick="return confirm('是否确认注册-${param.username}-的信息？');"/>
                                <%--想要动态获取表单中文本框中的信息，需要使用${param.xxx}，但是此处因为在转发之前填出确认框，此时，还没有生成转发的请求对象，没有给请求对象setParameter()，因此，
                                	${param.username}还是获取不到请求对象，也就获取不到请求对象中的参数了。	onclick="return confirm('是否确认注册-${param.username}-的信息？');" --%>
                            </p>
                        </form>
                    </div>
                </div>
                <div id="footer">
                    <div id="footer_bg">
                    ABC@126.com
                    </div>
                </div>
            </div>
        </body>
    </html>