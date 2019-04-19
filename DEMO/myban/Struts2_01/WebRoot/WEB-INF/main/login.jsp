<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
		<title>NetCTOSS</title>
		<link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css"/>
		<link type="text/css" rel="stylesheet" media="all" href="../../styles/global_color.css"/>
		<script type="text/javascript" language="javascript">
			//刷新验证码图片
			function change(image){
				//改变img的src属性即可，由于该url没有变化，因此需要追加动态参数伪装成新的url.
				image.src = "createImage?date=" +new Date().getTime();
			}
		</script>
	</head>
	<body class="index">
		<div class="login_box">
			<form action="login.action" method="post">
				<table>
					<tr>
						<td class="login_info">账号:</td>
						<td colspan="2"><input name="adminCode" type="text" class="width150" value="<s:property value="adminCode"/>"/></td>
						<td class="login_error_info"><span class="required">30长度的字母、数字和下划线</span></td>
					</tr>
					<tr>
						<td class="login_info">密码：</td>
						<td colspan="2"><input name="password" value="<s:property value="password"/>" type="password" class="width150"/></td> <!-- colspan跨行 -->
						<td><span class="required">30长度的字母、数字和下划线</span></td> <!-- required 需要，要求 -->
					</tr>
					<tr>
						<td class="login_info">验证码:</td>
						<td class="width70"><input name="verifyCode" type="text" class="width70"/></td>
						<td><img src="createImage" alt="验证码" title="点击更换" onclick="change(this);"/></td>
						<td><span class="required"></span></td>
					</tr>
						<td></td>
						<td class="login_button" colspan="2">
							<a href="javascript:document.forms[0].submit();"><img src="../../images/login_btn.png"/></a>
						</td>
						<td><span class="required"><s:property value="errormsg"/></span></td>
				</table>
			</form>
		</div>		
	</body>
</html>





















