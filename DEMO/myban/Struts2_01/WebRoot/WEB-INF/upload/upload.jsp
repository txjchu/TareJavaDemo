<%@page pageEncoding="utf-8"%>
<html>
	<head>上传文件拦截器练习</head>
<body>
    <form action="upload" method="post" enctype="multipart/form-data">
        <input type="file" name="some" />
        <input type="submit" value="提交" />
    </form>
</body>
</html>