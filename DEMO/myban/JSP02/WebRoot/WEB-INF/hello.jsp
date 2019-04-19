<%@page pageEncoding="utf-8" %>
<!-- taglib指令用来引入标签库(.tld文件，一组标签)，引入文件中的一组标签；
	uri是标签库的名称，prefix是标签名的前缀。 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/lhh/abc/tags" prefix="s"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>JSTL+EL</title>
	</head>
	<body>
		<!-- 自定义标签 -->
		<s:sysdate format="yyyy-MM-dd"/>	
	
		<h1>JSTL</h1>
		<!-- if判断标签 -->
		<!-- 判断用户性别，输出男或女 -->
		<c:if test="${user.sex=='Male'}">男</c:if>
		<c:if test="${user.sex=='Female'}">女</c:if>
		
		<!-- 通过var声明的变量r，就是表达式返回的值 -->
		<c:if test="${user.sex=='Male'}" var="r">男</c:if>
		<c:if test="${!r}">女</c:if>			<!-- 当前一行没有设置var="r"时，r为null，!null为true? -->
		
		<!-- choose -->
		
		<!-- forEach遍历集合(数组)两种方式 -->
		<!-- 1.遍历集合 -->
		<!-- items属性用来指定要遍历的【集合】，该数据可以通过EL表达式获取。 
			 var属性用来声明每次循环对应的数据段名称。 
			 varStatus属性用来声明一个变量，该变量可以获取循环相关的参数。(index是下标，count是(index+1)循环的次数)-->
		<P>
		<%--
		 --%>
			<c:forEach items="${users}" var="u" varStatus="s">
				${u.userName },${s.index },${s.count }<br>
			</c:forEach>
		</P>
		<!-- 2.按数字循环 -->
		<%--
		 --%>
		<p>
			<c:forEach begin="${begin}" end="${end}" var="i">
				<%--  
				 --%>
				${i}<br/>
				${users[i]}<%--	输出的是集合中的每个对象的地址
								entity.User@116aa4b 1
								entity.User@1063b1a 
								 --%>
				
			</c:forEach>
		</p>
		
		<hr/>	<!-- 输出一条黑线，分割线 -->
	
		<h1>EL</h1>
		<!-- 使用EL获取bean属性值 -->
		
		<!-- EL取值的过程 -->
		<!-- 1.范围对象.request.getAttribute("user") -->
		<!-- 2.user.getCourse().getName() -->
		<!-- EL取值的范围依次是：page/request/session/application -->
		<!-- 常用的范围对象有request/session等四个 -->
		
		<p>账号：${user.userName} </p>
		<p>密码：${user["password"]} </p>
		<!-- user.getlove -->
		<p>兴趣：${user.loves[0] }</p>
		<!-- user.getCourse().getName() -->
		<p>课程：${user.course.name }</p>
		
		<!-- 强制EL从request对象中取值 -->
		<p>性别：${requestScope.user.sex }</p>
		
		<!-- EL的用法2：运算 -->
		<!-- 1.算数运算+-*/% -->
		<p>课时：${user.course.days+1 }</p>
		<!-- 2.逻辑运算：$$与||或!非 -->
		<p>${user.userName=="cang"&&user.password=="123" }</p>
		<!-- 3.关系运算：><=(大于小于等于) -->
		<P>${user.course.days>100 }</P>
		<!-- 4.判断对象是否为空，判空 -->
		<P>${empty user }</P>
		<!-- EL  获取请求参数 -->
		<p>ID:${parm.id }</p>
		
	</body>
</html>