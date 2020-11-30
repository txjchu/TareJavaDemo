<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/26
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>资费详情</title>
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
                <div class="text_info clearfix"><span>资费ID：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value="${cost.costId}" /></div>
                <div class="text_info clearfix"><span>资费名称：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value="${cost.name}"/></div>
                <div class="text_info clearfix"><span>资费状态：</span></div>
                <div class="input_info">
                    <select class="readonly" disabled>
                        <c:choose>
                            <c:when test="${cost.status == 0}"><option>开通</option></c:when>
                            <c:when test="${cost.status == 1}"><option>暂停</option></c:when>
                            <c:otherwise><option>删除</option></c:otherwise>
                        </c:choose>

                    </select>
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info fee_type">
                    <%--单选框的 checked, 判断获取到的 costType 的值，若符合条件，则修改为被选中状态--%>
                    <!-- 使用EL获取资费类型，然后通过三元运算判断该类型的值。
                          如果是1就在包月的radio上输出checked;
                          如果是2就在套餐的radio上输出checked;
                          如果是3就在计时的radio上输出checked; -->
                    <input type="radio" name="costType" value="1" ${cost.costType==1? "checked":"" } id="monthly" onclick="" />
                    <label for="monthly">包月</label>
                    <input type="radio" name="costType" value="2" ${cost.costType==2? "checked":"" } id="package" onclick="" />
                    <label for="package">套餐</label>
                    <input type="radio" name="costType" value="3" ${cost.costType==3? "checked":"" } id="timeBased" onclick="" />
                    <label for="timeBased">计时</label>
                </div>
                <div class="text_info clearfix"><span>基本时长：</span></div>
                <div class="input_info">
                    <input type="text" class="readonly" readonly value="${cost.baseDuration}"  />
                    <span>小时</span>
                </div>
                <div class="text_info clearfix"><span>基本费用：</span></div>
                <div class="input_info">
                    <input type="text"  class="readonly" readonly value="${cost.baseCost}" />
                    <span>元</span>
                </div>
                <div class="text_info clearfix"><span>单位费用：</span></div>
                <div class="input_info">
                    <input type="text"  class="readonly" readonly value="${cost.unitCost}" />
                    <span>元/小时</span>
                </div>
                <div class="text_info clearfix"><span>创建时间：</span></div>
                <div class="input_info"><input type="text"  class="readonly" readonly value="<fmt:formatDate value="${cost.creatime}" pattern="yyyy-MM-dd hh:mm:ss"/>" /></div>
                <div class="text_info clearfix"><span>启动时间：</span></div>
                <div class="input_info"><input type="text"  class="readonly" readonly value="<fmt:formatDate value="${cost.startime}" pattern="yyyy-MM-dd hh:mm:ss"/>" /></div>
                <div class="text_info clearfix"><span>资费说明：</span></div>
                <div class="input_info_high">
                    <textarea class="width300 height70 readonly" readonly>${cost.descr}</textarea>
                </div>
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
