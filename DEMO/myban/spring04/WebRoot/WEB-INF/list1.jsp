<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head></head>
	<body style="font-size:30px;" >
		<c:forEach items="${students}" var="s">
		${s.name},${s.age}<br/>
		</c:forEach>
	</body>
	<h1>hello1</h1>
</html>