<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%--自定义标签 --%>
<%@ taglib uri="/lhh/abc/Tags" prefix="s"%>
<%@ taglib uri="/mytag/HelloTag" prefix="h" %>
<html>
	<head>
		<title>jstl05</title>
	</head>
	<body>
	<%--无法编译
		<% ${session.setAttribute("uname", "lili")}; %>
	 --%>
	<!-- url标签		禁用cookie后，会自动添加JSESSIONID到链接上，以保证session的访问。 --> 
		<% session.setAttribute("uname", "Luffy");%>
		URL标签<hr/>
		<a href="<c:url value='/jstl06.jsp'/>">访问jstl06</a>
	<hr>	
	
	<!-- set和remove标签 -->
	SET标签和remove标签：<br>
	<c:set var="num" scope="session" value="${1+1}"></c:set>
	set之后：num=${sessionScope.num }<br/>
	<c:set var="num" scope="session" ></c:set>		<!-- 将session中的属性num移除 -->
	remove之后：num=${sessionScope.num }		
	<hr/>
	
	<!-- catch标签，捕获异常 -->
	catch标签：<br>
	<c:catch var="msg">
		<%
			Integer.parseInt("123a");
		%>
	</c:catch>
	${msg }
	<hr>
	
	<!-- import标签 将另一个页面嵌入到当前页面 -->
	<dir style="border:solid 1px red">
		<c:import url="/jstl10.jsp"></c:import>
	</dir>
	这里是jstl05页面<hr>
	
	<!-- redirect标签	直接重定向去新页面 -->
	<div >
		<!-- 保存在session中的键值对数据，可以在重定向的情况中在不同页面传输数据，填补了request的不足。  -->
		<c:set var="num" scope="session" value="${11+11}"></c:set>
		<a href='jstl10.jsp'>
			jstl10页面
		</a>
		<%--
		<c:redirect url="jstl12.jsp">redisect标签</c:redirect>
		 --%>
	</div>	
	<hr>
	
	<!-- out标签		内置对象JSPWriter输出方法 -->
	<div>
		<c:out value="${2+2}"></c:out>	----等价于:${2+2 }<br>
		输出变量：num:<c:out value="${num}" default="123"></c:out><br>
				msg:<c:out value="${msg}" default="没有msg"></c:out><br/>
		<div>
			<table style="border: 1px solid blue;">
				<thead>
					<tr>
						<td>ID</td>
						<td>姓名</td>
						<td>年龄</td>
						<td>成绩</td>
						<td>排名</td>					
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>zhang</td>
						<td>13</td>
						<td>33</td>
						<td>1</td>					
					</tr>
					<tr>
						<td>2</td>
						<td>wang</td>
						<td>12</td>
						<td>22</td>
						<td>2</td>
					<%--
					 --%>						
					</tr>
				</tbody>
			</table>
		</div>		
		转义字符：&lt;table&gt;
		<c:out value="</table>" escapeXml="true"></c:out>	<!-- 注意escapeXml忽略Xml代码 -->
		<table style="border: 1px solid #ccc;">
			<thead>
				<tr><td>1</td><td>2</td><td>3</td></tr>
			</thead>
		</table> 	
	</div>
	
	<!-- 自定义标签的使用 -->
	<!-- 自定义s标签的使用，s标签作用是输出当前系统时间 -->
	<div>
		北京时间：<s:sysdate format="yyyy年MM月dd日 E HH点mm分ss秒"/>
	</div>
	<div>
	调用自定义标签HelloTag:<br/>	
	<h:sayHello count="2" info="HelloWorld!我是自定义标签"/>
		
	</div>
	</body>
</html>    