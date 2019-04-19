<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<html>
	<head>
		<title>上传文件页面练习</title>
	</head>
	<body style="font-size:30px; font-style:italic;">
		<form action="fileupload" method="post" enctype="multipart/form-data"><!-- 上传文件必须将enctype属性设置为此，才能上传文件 -->
			<fieldset>
				<legend>上传文件</legend>
				用户名：<input name="username" /><br/>
				照片：<input type="file" name="file1"/>
				<input type="submit" value="确定">
			</fieldset>		
		
		</form>
	</body>
</html>