<%-- 声明jsp文件的编码--%>
<%@page pageEncoding="utf-8"%>

<%--JSP声明:函数，变量等(语法) --%>
<%!
	//计算n的平方-----在页面的开头声明
	public int pf(int n){
		return n*n;
}
%>

<!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>JSP的使用</title>
	</head>
	<body>
		<h1>下面时间来自于date.jsp</h1>
		<%--引入另外JSP页面----date.jsp用【include】指令用来引入JSP，相当于把JSP内容复制到此处。 --%>
		<%@include file="date.jsp" %>
		
		<h2>1.JSP中可以写静态的HTML</h2>
		<h2>2.JSP中可以写Java代码</h2>
		<%--JSP脚本，里面可以写JAVA代码，循环判断都可以 --%>
		<%
			for(int i=0;i<10;i++){
		%>
			<%--JSP表达式 --%>
			<p><%=pf(i) %></p>	
			
		<%--可以将JAVA代码标签分割，中间可以加入JSP编码 --%>
		<%		
			}
		%>
	</body>
</html>