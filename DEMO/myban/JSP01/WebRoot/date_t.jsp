
<%@page pageEncoding="utf-8"
		contentType="text/html;"
		import="java.util.*,java.text.*"%>
<div style="border:1px solid red; width:350px; padding:25px; font-size:20px;">
	<% Date date = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
		String now = fmt.format(date);
	%>
	时间来自于date_t.jsp页面<br>
	<%= now %>
</div>