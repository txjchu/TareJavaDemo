<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/29
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>账务账号详情</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />

    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../images/logo.png" alt="logo" class="left"/>
            <a href="../logout.do">[退出]</a>
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
            <%@include file="../login/menu.jsp"%>
        </div>
        <!--导航区域结束-->

        <!--主要区域开始-->
        <div id="main">
            <form action="" method="" class="main_form">
                <!--必填项-->
                <div class="text_info clearfix"><span>账务账号ID：</span></div>
                <div class="input_info"><input type="text" value="${account.accountId}" readonly class="readonly" /></div>
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info"><input type="text" value="${account.realName}" readonly class="readonly" /></div>
                <div class="text_info clearfix"><span>身份证：</span></div>
                <div class="input_info">
                    <input type="text" value="${account.idcardNo}" readonly class="readonly" />
                </div>
                <div class="text_info clearfix"><span>登录账号：</span></div>
                <div class="input_info">
                    <input type="text" value="${account.loginName}" readonly class="readonly" />
                </div>
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input type="text" class="width200 readonly" readonly value="${account.telephone}" />
                </div>
                <div class="text_info clearfix"><span>推荐人账务账号ID：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${account.recommenderId != null || !''.equals(account.recommenderId) ? account.recommenderId : ''}"  /></div>
                <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${recommenderIdcardNo}" /></div>
                <div class="text_info clearfix"><span>状态：</span></div>
                <div class="input_info">
                    <select class="readonly" disabled>
                        <c:choose>
                            <c:when test="${account.status == 0}"><option>开通</option></c:when>
                            <c:when test="${account.status == 1}"><option>暂停</option></c:when>
                            <c:otherwise><option>删除</option></c:otherwise>
                        </c:choose>
                    </select>
                </div>
                <c:choose>
                    <c:when test="${account.status == 0}">
                        <div class="text_info clearfix"><span>开通时间：</span></div>
                        <div class="input_info"><input type="text" readonly class="readonly" value="${account.createDate}" /></div>
                    </c:when>
                    <c:when test="${account.status == 1}">
                        <div class="text_info clearfix"><span>暂停时间：</span></div>
                        <div class="input_info"><input type="text" readonly class="readonly" value="${account.pauseDate}" /></div>
                    </c:when>
                    <c:otherwise>
                        <div class="text_info clearfix"><span>关闭时间：</span></div>
                        <div class="input_info"><input type="text" readonly class="readonly" value="${account.closeDate}" /></div>
                    </c:otherwise>

                </c:choose>


                <div class="text_info clearfix"><span>上次登录时间：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${account.lastLoginTime}" /></div>
                <div class="text_info clearfix"><span>上次登录IP：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${account.lastLoginIp}" /></div>
                <!--可选项数据-->
                <div class="text_info clearfix"><span>生日：</span></div>
                <div class="input_info">
                    <input type="text" readonly class="readonly" value="${account.birthdate}" />
                </div>
                <div class="text_info clearfix"><span>Email：</span></div>
                <div class="input_info">
                    <input type="text" class="width350 readonly" readonly value="${account.email}" />
                </div>
                <div class="text_info clearfix"><span>职业：</span></div>
                <div class="input_info">
                    <select class="readonly"  disabled>
                        <option>${account.occupation != null && !"".equals(account.occupation) ? account.occupation : "无信息"}</option>
                    </select>
                </div>
                <div class="text_info clearfix"><span>性别：</span></div>
                <div class="input_info fee_type">
                    <input type="radio" name="gender" value="f" ${account.gender=='f'? "checked":"" } id="female" disabled />
                    <label for="female">女</label>
                    <input type="radio" name="gender" value="m" ${account.gender=='m'? "checked":"" } id="male" disabled />
                    <label for="male">男</label>
                </div>
                <div class="text_info clearfix"><span>通信地址：</span></div>
                <div class="input_info"><input type="text" class="width350 readonly" readonly value="${account.mailaddress}" /></div>
                <div class="text_info clearfix"><span>邮编：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value="${account.zipcode}" /></div>
                <div class="text_info clearfix"><span>QQ：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value="${account.qq}" /></div>
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="button" value="返回" class="btn_save" onclick="location.href='list.do';" />
                </div>
            </form>
        </div>

        <!--主要区域结束-->

        <div id="footer">
            <p>[最真实的企业环境，最适用的实战项目]</p>
            <p>版权所有(C) </p>
        </div>
    </body>
</html>
