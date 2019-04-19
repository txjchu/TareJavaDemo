<%@page pageEncoding="utf-8" import="entity.*,dao.*,java.util.List"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>JSP员工列表</title>
	</head>
	<body>
		<table border="1px" width="40%" cellspacing="0">
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>薪资</th>
				<th>年龄</th>
			</tr>
			<%
				EmpDao dao = new EmpDao();
				List<Emp> list = dao.findAll();
				//循环输出每一行员工
				for(Emp e:list){
			%>
			<tr>
				<td><%=e.getId() %></td>
				<td><%=e.getName() %></td>
				<td><%=e.getSalary() %></td>
				<td><%=e.getAge() %></td>
			</tr>	
			<%		
				}
			%>
		</table>
	</body>
</html>