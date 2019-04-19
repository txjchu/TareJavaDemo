<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head></head>
<body>
    <h1>模拟修改客户</h1>
    <s:form action="#" method="post">
		<s:textfield name="customer.name" label="姓名"></s:textfield>
		<s:password name="customer.password" label="密码" showPassword="true"></s:password>
	    <s:checkbox name="customer.marry" label="婚否" labelposition="left"/>
    	<s:textarea name="customer.desc" label="简介" cols="30" rols="5" title="123"></s:textarea>
    	<s:radio name="customer.sex" list="#{'M':'男','F':'女'}" label="性别"/>		<!-- 单选框的两种初始化方式 -->
		<s:radio name="customer.home" list="cities" listKey="code" listValue="name" label="家乡"/>
		<!--
		<s:radio name="customer.home" list="cities" listKey="code" listValue="name" label="性别"/> 
		-->  	
		<!-- 
		 -->
		<s:checkboxlist name="customer.travelCities" list="cities" listKey="code" listValue="name" label="旅游过的城市"></s:checkboxlist>
		<s:checkboxlist name="customer.travelCities" list="#{'beijing':'北京','shanghai':'上海','guangzhou':'广州','shenzhen':'深圳','hangzhou':'杭州','wuhan':'武汉','nanjing':'南京','xianggang':'香港'}" label="旅游城市"></s:checkboxlist>
		<s:select name="customer.home" list="#{'beijing':'北京','shanghai':'上海','guangzhou':'广州','shenzhen':'深圳','hangzhou':'杭州','wuhan':'武汉','nanjing':'南京','xianggang':'香港'}" label="家乡" headerkey="" headerValue="请选择"/>
		<s:select name="customer.home" list="cities" listKey="code" listValue="name" label="家乡" headerValue="请选择"></s:select>
		<s:submit value="提交"></s:submit>
    </s:form>
</body>
</html>