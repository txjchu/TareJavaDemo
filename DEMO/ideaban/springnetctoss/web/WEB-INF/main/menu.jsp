<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/11
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul id="menu">
    <li><a href="<%=request.getContextPath() %>/index.do" class="index_off"></a></li>
    <li><a href="role/role_list.html" class="role_off"></a></li>
    <li><a href="admin/admin_list.html" class="admin_off"></a></li>
    <%--    <li><a href="<%=request.getContextPath() %>/cost/list.do" class="fee_off"></a></li>--%>
    <li><a href="<%=request.getContextPath() %>/cost/list.do" class="<%=request.getRequestURI().indexOf("cost") != -1 ? "fee_on" : "fee_off"%>"></a></li>
    <li><a href="<%=request.getContextPath() %>/account/list.do" class="<%=request.getRequestURI().indexOf("account") != -1 ? "account_on" : "account_off"%>"></a></li>
    <li><a href="service/service_list.html" class="service_off"></a></li>
    <li><a href="bill/bill_list.html" class="bill_off"></a></li>
    <li><a href="report/report_list.html" class="report_off"></a></li>
    <li><a href="user/user_info.html" class="information_off"></a></li>
    <li><a href="user/user_modi_pwd.html" class="password_off"></a></li>
</ul>
