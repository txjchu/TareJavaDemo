<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>城市信息列表</title>
    </head>
	<body>
		<table border='1' cellpadding='0' cellspacing='0' width='60%'>
			<caption>城市信息列表</caption>
			<thead>
				<tr>
					<td>ID</td>
					<td>城市</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="city" items="${listCity}">
					<tr>
						<td>${city.id }</td>
						<td>${city.name }</td>
					</tr>
				</c:forEach>
			</tbody>	

		</table>	
	</body>
</html>    