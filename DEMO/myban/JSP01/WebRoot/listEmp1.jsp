<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.*, entity.*,java.util.*, util.*" %>
<html>
	<head>
		<title>员工信息查询_jsp练习</title>
	</head>
	<body style="font-size:24px">
		<table border="1" cellpadding="0" cellspacing="0">
			<caption>员工信息</caption>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>薪水</td>
				<td>年龄</td>
			</tr>
			<%
				EmployeeDao dao = new EmployeeDao();
				List<Employee> emps = dao.findAll();
				
				for(int i = 0; i < emps.size(); i++){
					Employee emp = emps.get(i);
			%>
			<tr>
				<td><%= emp.getId() %></td>
				<td><%=emp.getName() %></td>
				<td><%=emp.getSalary() %></td>
				<td><%=emp.getAge() %></td>
			</tr>
			<%		
				}
			%>
		</table>
	</body>
</html>


















