<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>

		<P>
			<c:forEach items="${stu}" var="u" >
				${u.name },${u.age }<br>
			</c:forEach>
		</P>
		<p>hello</p>
</h1>