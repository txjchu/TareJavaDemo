<%@page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
	<head>
		<meta content="text/html; charset=utf-8">
		<title>员工信息列表页面</title>
	</head>
	<body>
		<table border="1">
			<thead>
				<tr>
					<td>编号</td>
					<td>姓名</td>
					<td>工资</td>
					<td>入职时间</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${emps}" var="emp">
					<tr>
						<td>${emp.empno }</td>
						<td>${emp.ename }</td>
						<td>${emp.sal }</td>
						<td>${emp.hiredate }</td>
						<td><a href="../emp/toUpdate.do?empno=${emp.empno}">修改</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>