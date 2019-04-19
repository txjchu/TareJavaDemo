<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" p ="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<
  
    <base href="<%=basePath%>">
    
    <title>My JSP 'book_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table>
    	<tr>
    		<td>笔记本名</td>
    		<td>创建事件</td>
    		<td>所属用户</td>
    	</tr>
    	<!-- 循环forEach -->
    	<c:forEach items="${result.data}" var="book">
    		<tr>
    			<td>${book.cn_notebook_name}</td>
    			<td>${book.cn_notebook_createtime}</td>
    			<td>${book.cn_user_name}</td>
    			
    		</tr>
    	</c:forEach>
    </table>
  </body>
</html>
