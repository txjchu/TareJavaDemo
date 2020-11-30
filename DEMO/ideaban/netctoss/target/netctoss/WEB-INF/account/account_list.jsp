<%@ page import="entity.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/26
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>账务账号列表</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            //删除
            function deleteAccount(id){
                var r = window.confirm("确定要删除此账务账号吗？\r\n删除后将不能恢复，且会删除其下属的所有业务账号。");
                window.location.href = "delete.do?id="+id;
                document.getElementById("operate_result_info").style.display = "block";
            }
            //开通或暂停
            function setState(){
                var r = window.confirm("确定要开通此账务账号吗？");
                document.getElementById("operate_result_info").style.display = "block";
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
            <%@include file="../login/menu.jsp"%>
        </div>
        <!--导航区域结束-->

        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
                <!--查询-->
                <div class="search_add">
                    <div>
                        身份证：
                        <input type="text" value="不验证" class="text_search" />
                    </div>
                    <div>
                        姓名：
                        <input type="text" class="width70 text_search" value="不验证" />
                    </div>
                    <div>
                        登录名：
                        <input type="text" value="不验证" class="text_search" />
                    </div>
                    <div>
                        状态：
                        <select class="select_search">
                            <option>
                                全部
                            </option>
                            <option>
                                开通
                            </option>
                            <option>
                                暂停
                            </option>
                            <option>
                                删除
                            </option>
                        </select>
                    </div>
                    <div>
                        <input type="button" value="搜索" class="btn_search" />
                    </div>
                    <input type="button" value="增加" class="btn_add"
                           onclick="location.href='toAdd.do';" />
                </div>
                <!--删除等的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png"
                         onclick="this.parentNode.style.display='none';" />
                    删除成功，且已删除其下属的业务账号！
                </div>
                <!--数据区域：用表格展示数据-->
                <div id="data">
                    <table id="datalist">

                        <tr>
                            <th colspan="6">
                                NETCTOSS系统被访问过<%=application.getAttribute("count")%>次
                            </th>
                        </tr>

                        <tr>
                            <th>
                                账号ID
                            </th>
                            <th>
                                姓名
                            </th>
                            <th class="width150">
                                身份证
                            </th>
                            <th>
                                登录名
                            </th>
                            <th>
                                状态
                            </th>
                            <th class="width200"></th>
                        </tr>
                        <c:forEach var="account" items="${accounts}" varStatus="i">
                            <tr>
                                <td>${account.accountId}</td>
                                <td><a href="detail.do?id=${account.accountId}">${account.realName}</a></td>
                                <td>${account.idcardNo}</td>
                                <td>${account.loginName}</td>
                                <td>${account.status==0?"开通":"暂停"}</td>
                                <td class="td_modi">
                                    <input type="button" value="暂停" class="btn_pause" onclick="setState();" />
                                    <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdate.do?id='+${account.accountId};" />
                                    <input type="button" value="删除" class="btn_delete" onclick="deleteAccount(${account.accountId});" />
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

                <!--分页-->
                <div id="pages">
                    <a href="#">首页</a>
                    <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                    <a href="#">末页</a>
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
