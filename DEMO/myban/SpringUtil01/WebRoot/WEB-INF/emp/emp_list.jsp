<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>员工信息列表</title>
		<meta content="text/html; charset=utf-8">
	</head>
	<body>
		<div>
			<fieldset>	<!-- 区域领域块 -->
				<legend>员工信息列表</legend>	<!-- 图例标头 -->
				<table width="60%" border="1px" cellpadding="2" cellspacing="0">
					<thead>
						<tr>
							<th>EMPNO</th>
							<th>ENAME</th>
							<th>JOB</th>
							<th>MGR</th>
							<th>HIREDATE</th>
							<th>SAL</th>
							<th>COMM</th>
							<th>DEPTNO</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${emps}" var="emp">
							<tr>
								<td>${emp.empno }</td>
								<td>${emp.ename }</td>
								<td>${emp.job }</td>
								<td>${emp.mgr }</td>
								<td>${emp.hiredate }</td>
								<td>${emp.sal }</td>
								<td>${emp.comm }</td>
								<td>${emp.deptno }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</fieldset>
		</div>
	</body>
</html>