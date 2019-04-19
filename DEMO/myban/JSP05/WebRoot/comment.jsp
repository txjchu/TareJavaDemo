<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>评论</title>
</head>
<body>
	<form action="comment" method="post"><!-- action会新建一个请求 -->
		<fieldset>
			<legend>评论</legend>
			请输入评论：<textarea name="comment" style="vertical-align:middle; 
												width:140px;height:55px" value=${comment }></textarea><Br>
			<input type="submit" value="发表评论" />
			<%--
			 --%>
			<span><%= requset.getAttribute("illegal") %><% request.getAttribute("length") %></span>
		</fieldset>
	</form>
</body>
</html>