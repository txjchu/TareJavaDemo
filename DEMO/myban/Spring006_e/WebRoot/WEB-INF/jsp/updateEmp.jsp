<%@page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML >
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta content="text/html; charset=utf-8">
		<title>修改员工信息页面</title>
	</head>
	<body>
		<form:form action="../emp/update.do" method="post" commandName="emp">
			<form:hidden path="empno"/>
			姓名：<form:input path="ename"/><br/>
			职位：<form:select path="job">
					<form:option value="SALESMAN" label="SALESMAN"></form:option>
					<form:option value="MANAGER" label="MANAGER"></form:option>
					<form:option value="CLERK" label="CLERK"></form:option>
					<form:option value="PRESIDENT" label="PRESIDENT"></form:option>
					<form:option value="ANALYST" label="ANALYST"></form:option>
				 </form:select><br/>
			管理者：<form:input path="mgr"/><br/>
			入职时间：<form:input path="hiredate"/><br/>
			工资：<form:input path="sal"/><br/>
			奖金：<form:input path="comm"/><br/>
			所在部门：<form:select path="deptno" items="${deptMap}"/><br/>
			<input type="submit" value="修改"/>	 
		</form:form>
	</body>
</html>
















