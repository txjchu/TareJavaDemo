<%@page pageEncoding="utf-8"%>
<!-- taglib指令用来引入标签库(.tld文件，一组标签)；
	uri是标签库的名称，prefix是标签名的前缀。 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>JSTL+EL</title>
	</head>
	<body>
		<h1>JSTL</h1>
		<!-- if -->
		<p>
			<c:if test="${user.sex=='Male'}">男</c:if>
			<c:if test="${user.sex=='Female'}">女</c:if>
		</p>
		<p>
			<!-- 通过var声明的变量r，就是表达式返回的值 -->
			<c:if test="${user.sex=='Male'}" var="r">男</c:if>
			<c:if test="${!r}">女</c:if>
			
		</p>
		<hr/>
		
		<h1>EL</h1>
		<!-- 使用EL获取bean属性值 -->
		<!-- EL取值的过程： -->
		<!-- 1.范围对象.getAttribute("user") -->
		<!-- 2.user.getCourse().getName() -->
		<!-- EL取值的范围依次是： -->
		<!-- page/request/session/application -->
		<!-- 常用的是request/session -->
		<p>账号：${user.userName }</p>
		<p>密码：${user["password"] }</p>
		<p>兴趣：${user.loves[0] }</p>
		<p>课程：${user.course.name }</p>
		<!-- 强制EL从request对象中取值 -->
		<p>性别：${requestScope.user.sex }</p>
		<!-- 运算 -->
		<!-- 1.算数运算+-*/% -->
		<p>课时：${user.course.days+1 }</p>
		<!-- 2.逻辑运算(与或非) -->
		<p>${user.userName=="Cang"&&user.password=="123" }</p>
		<!-- 3.关系运算(大于小于等于...) -->
		<p>${user.course.days>100 }</p>
		<!-- 4.判空 -->
		<p>${empty user }</p>
		<!-- 获取请求参数 -->
		<p>ID：${param.id }</p>
	</body>
</html>











