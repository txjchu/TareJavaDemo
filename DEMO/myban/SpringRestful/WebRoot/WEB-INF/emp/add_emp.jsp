<%@page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
	<head>
		<meta content="text/html; charset=utf-8">
		<title>添加员工信息页面</title>
		<script type="text/javascript" src="scripts/jquery-1.11.1.js"></script>
		<script type="text/javascript" src="scripts/jquery.min.js"></script>
		<script type="text/javascript" src="scripts/prototype-1.6.0.3.js"></script>
	</head>
	<body>
		<form action="addEmp.do" method="post">
			<table width="40%" border="1" cellpadding="2" cellspacing="0" align="center">
				<tr>
					<td>姓名</td>
					<td><input type="text" name="ename"/></td>
				</tr>
				<tr>
					<td>岗位：</td>
					<td><input type="text" name="job"></td>
				</tr>
				<tr>
					<td>工资：</td>
					<td><input type="text" name="sal"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="保存"/></td>					
				</tr>
			</table>
		</form>	
	</body>
</html>		