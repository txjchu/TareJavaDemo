<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/3
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>

<%--
    jsp页面中的EL表达式不被解析org.apache.jasper.JasperException: Unable to convert string [${item.createtime}]
    https://m.imooc.com/qadetail/277572
    web.xml的版本是不是2.3, 如果是2.3,在jsp页面开头添加<%@ page isELIgnored="false"%>
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 格式化相关的标签库 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>NetCTOSS - CostList</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />

    <script language="javascript" type="text/javascript">
        //排序按钮的点击事件
        function sort(btnObj) {
            if (btnObj.className == "sort_desc")
                btnObj.className = "sort_asc";
            else
                btnObj.className = "sort_desc";
        }

        // 参考：[js中的 location.href 用法](https://www.cnblogs.com/shuilangyizu/p/6604646.html)


        //启用
        function startFee(id, status) {
            var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
            window.location.href = "startCost.do?id="+id+"&status="+status;
            document.getElementById("operate_result_info1").style.display = "block";
        }
        //删除
        function deleteFee(id) {
            var r = window.confirm("确定要删除此资费吗？");
            window.location.href = "delete.do?id="+id;
            document.getElementById("operate_result_info").style.display = "block";

        }


        // 添加热键 T 返回顶部
        window.onkeydown = function (evt) {
            evt = (evt) ? evt : ((window.event) ? window.event : "");
            if (evt) { // 按下 T 键后返回页面顶部
                if (evt.keyCode == 84) {
                    document.body.scrollIntoView();
                }
            }
        }

    </script>
    <style>
        #operate_result_info1
        {
            width: 400px;
            line-height: 70px;
            padding-left: 40px;
            font-size: 16px;
            display: none;
            position: absolute;
            z-index: 100;
            top: 90px;
            left: 30%;
        }
        #operate_result_info1 img
        {
            float: right;
            margin-right: 10px;
            margin-top: 10px;
            cursor: pointer;
        }
    </style>
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
        <%@include file="../main/menu.jsp"%>
    </div>
    <!--导航区域结束-->
    <!--主要区域开始-->
    <div id="main">
        <form action="" method="">
            <!--排序-->
            <div class="search_add">
                <div>
                    <!--<input type="button" value="月租" class="sort_asc" onclick="sort(this);" />-->
                    <input type="button" value="基费" class="sort_asc" onclick="sort(this);" />
                    <input type="button" value="时长" class="sort_asc" onclick="sort(this);" />
                </div>
                <!-- /netctoss/cost/find.do -->
                <!-- /netctoss/cost/toAdd.do -->
                <input type="button" value="增加" class="btn_add" onclick="location.href='toAdd.do';" />
            </div>
            <!--启用操作的操作提示-->
            <div id="operate_result_info1" class="operate_success">
                <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                启动成功！
            </div>
            <!-- 删除操作的操作结果提示 -->
            <div id="operate_result_info" class="operate_success">
                <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                删除成功！
            </div>
            <!--数据区域：用表格展示数据-->
            <div id="data">
                <table id="datalist">

                    <tr>
                        <th colspan="9">
                            NETCTOSS系统被访问过<%=application.getAttribute("count")%>次
                        </th>
                    </tr>

                    <tr>
                        <th>资费ID</th>
                        <th class="width100">资费名称</th>
                        <th>基本时长</th>
                        <th>基本费用</th>
                        <th>单位费用</th>
                        <th>创建时间</th>
                        <th>开通时间</th>
                        <th class="width50">状态</th>
                        <th class="width200"></th>
                    </tr>
                    <c:forEach items="${costs}" var="c">
                        <tr>
                            <td>${c.costId}</td>
                            <td><a href="toDetail.do?id=${c.costId}">${c.name}</a></td>
                            <td>${c.baseDuration}</td>
                            <td>${c.baseCost}</td>
                            <td>${c.unitCost}</td>
                            <td><fmt:formatDate value="${c.creatime}" pattern="yyyy-MM-dd"/></td>
                            <td>${c.startime}</td>
                            <td>
                                    ${c.status==0?"开通":"暂停"}
                            </td>
                            <td>
                                <input type="button" value="启用" class="btn_start" onclick="startFee(${c.costId},${c.status});" />
                                <!-- /netctoss/cost/find.do -->
                                <!-- /netctoss/cost/toUpdate.do -->
                                <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdate.do?id=${c.costId}';" />
                                <input type="button" value="删除" class="btn_delete" onclick="deleteFee(${c.costId});" />
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <p>业务说明：<br />
                    1、创建资费时，状态为暂停，记载创建时间；<br />
                    2、暂停状态下，可修改，可删除；<br />
                    3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br />
                    4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
                </p>
            </div>
            <!--分页-->
            <div id="pages">
                <a href="#">上一页</a>
                <a href="#" class="current_page">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
                <a href="#">4</a>
                <a href="#">5</a>
                <a href="#">下一页</a>
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
