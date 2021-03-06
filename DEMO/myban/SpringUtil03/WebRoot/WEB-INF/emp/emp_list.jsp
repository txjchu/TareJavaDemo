<%@page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
	<head>
		<meta content="text/html; charset=utf-8">
		<title>员工信息列表页面</title>
		<script type="text/javascript" src="scripts/jquery-1.11.1.js"></script>
		<script type="text/javascript" src="scripts/jquery.min.js"></script>
		<script type="text/javascript" src="scripts/prototype-1.6.0.3.js"></script>
		<script type="text/javascript">
			function delete_emp(empno){
				var r = window.confirm("确认要删除此条记录吗？")
				if(r){
					location.href = "../emp/deleteEmp.do?empno="+ empno;
				}
			}	
		</script>
	</head>
	<body>
		<table border="1">
			<thead>
				<tr>
					<td>编号</td>
					<td>姓名</td>
					<td>岗位</td>
					<td>工资</td>
					<td>奖金</td>
					<td>经理</td>
					<td>部门编号</td>
					<td>入职时间</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${emps}" var="emp">
					<tr>
						<td>${emp.empno }</td>
						<td>${emp.ename }</td>
						<td>${emp.job }</td>
						<td>${emp.sal }</td>
						<td>${emp.comm }</td>
						<td>${emp.mgr }</td>
						<td>${emp.deptno }</td>
						<td>${emp.hiredate }</td>
						<td>
							<a href="../emp/toUpdateEmp.do?empno=${emp.empno}">修改</a>
							<a href="javascript:" onclick="delete_emp(${emp.empno});">删除</a><!-- ../emp/deleteEmp.do?empno=${emp.empno} -->
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>