<%@page pageEncoding="utf-8"%>
<ul id="menu">
	<li><a href="<%=request.getContextPath() %>/login/toIndex.do" class='index_${module==0?"on":"off" }'></a></li>
	<li><a href="role/role_list.html" class="role_off"></a></li>
	<li><a href="admin/admin_list.html" class="admin_off"></a></li>
	<li><a href="<%=request.getContextPath() %>/cost/find.do" class='fee_${module==3?"on":"off" }'></a></li>
	<li><a href="account/account_list.html" class="account_off"></a></li>
	<li><a href="service/service_list.html" class="service_off"></a></li>
	<li><a href="bill/bill_list.html" class="bill_off"></a></li>
	<li><a href="report/report_list.html" class="report_off"></a></li>
	<li><a href="user/user_info.html" class="information_off"></a></li>
	<li><a href="user/user_modi_pwd.html" class="password_off"></a></li>
</ul>