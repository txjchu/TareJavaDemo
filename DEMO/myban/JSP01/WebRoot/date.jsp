<%--
	page指令主要的3个用途：
	1.设置页面本身的编码；
	2.设置contentType()；
	3.可以导入类(包import)
 --%>
<%@page pageEncoding="utf-8"
	contentType="text/html;"
	import="java.util.*,java.text.*"%>
<div style="border:1px solid red ; width:350px;padding:25px;font-size:20px;">
	<%--通过JSP脚本运算出时间 --%>	
	<%--JSP脚本：创建系统时间 --%>
	<%
		//创建系统时间
		Date date = new Date();
		//对时间格式化
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
		//获取格式化后的当前时间
		String now = fmt.format(date);
	%>
	<%--通过JSP表达式输出这个时间 --%>
	<%=now %>
</div>
