<%-- 声明jsp文件的编码 --%>
<%@page pageEncoding="utf-8"%>
<%-- JSP声明 --%>
<%!
	//计算n的平方
	public int pf(int n) {
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
		<%-- include指令用来引入一个JSP，
			相当于把这个JSP的内容复制到此处。 --%>
		<%@include file="date.jsp"%>
		
		<h2>1.JSP中可以写静态的HTML</h2>
		<h2>2.JSP中可以写Java代码</h2>
		<%-- JSP脚本 --%>
		<%
			for(int i=0;i<10;i++) {
		%>
				<%-- JSP表达式 --%>
				<p><%=pf(i) %></p>
		<%-- JSP脚本 --%>
		<%
			}
		%>
	</body>
</html>







