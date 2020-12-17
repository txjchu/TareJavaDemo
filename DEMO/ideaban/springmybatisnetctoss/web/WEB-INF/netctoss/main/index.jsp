<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/10
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>NetCTOSS</title>
    <%--注意 css 的请求路径，当请求为 index.do 时，则会因为缺少应用名路径而造成url路径错误，因此此处需要使用 jsp 方式获取应用路径后拼接为全路径--%>
    <%-- "../styles/global.ss"--%>
    <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/styles/global_color.css" />
</head>
<body class="index">
<!--导航区域开始-->
<div id="index_navi">
    <ul id="menu">
        <li><a href="index.do" class="index_on"></a></li>
        <li><a href="role/role_list.html" class="role_off"></a></li>
        <li><a href="admin/admin_list.html" class="admin_off"></a></li>
        <li><a href="../cost/list.do" class="fee_off"></a></li>
        <li><a href="account/list.do" class="account_off"></a></li>
        <li><a href="service/service_list.html" class="service_off"></a></li>
        <li><a href="bill/bill_list.html" class="bill_off"></a></li>
        <li><a href="report/report_list.html" class="report_off"></a></li>
        <li><a href="user/user_info.html" class="information_off"></a></li>
        <li><a href="user/user_modi_pwd.html" class="password_off"></a></li>
    </ul>
</div>
</body>
</html>

