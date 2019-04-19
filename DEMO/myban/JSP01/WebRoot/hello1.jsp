<%@page pageEncoding="utf-8" %>
<% 
	for(int i = 0; i < 10; i++){
		out.println("Hello JSP<br>");
	}
%>
<hr/>
<%-- 访问地址应该是：http://localhost:9080/JSP01/hello1.jsp --%>
<!-- 使用<%= "Hello JSP111"%>方式输出 --><%--该方式注释不会输出<h1>不会输出</h1> --%>
<%
	for(int i=0; i< 10; i ++){
%>
	<%="No." +(i+ 1)+" Hello JSP" %><br/>

<% 
	}
%>	