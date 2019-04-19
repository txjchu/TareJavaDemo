<%@page pageEncoding="utf-8"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>达内－NetCTOSS</title>
        <!-- 当前页面路径：/netctoss/login/toLogin.do -->
        <!-- 图片路径：/netctoss/images/logo.png -->
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" /> 
    </head>
    <body class="index">
        <div class="login_box">
        <form action="login.do" method="post">
            <table>
                <tr>
                    <td class="login_info">账号：</td>
                    <td colspan="2"><input name="adminCode" value="adminCode" type="text" class="width150" /></td>
                    <td class="login_error_info"><span class="required">30长度的字母、数字和下划线</span></td>
                </tr>
                <tr>
                    <td class="login_info">密码：</td>
                    <td colspan="2"><input name="password" value="password" type="password" class="width150" /></td>
                    <td><span class="required">30长度的字母、数字和下划线</span></td>
                </tr>
                <tr>
                    <td class="login_info">验证码：</td>
                    <td class="width70"><input name="" type="text" class="width70" /></td>
                    <!-- 给验证码图片src地址增加一个随机数，可以让浏览器准确判断图片地址更换。 -->
                    <td><img src="create.do" alt="验证码"  onclick="this.src='createImage.do?n='+Math.random();" title="点击更换" /></td>  
                    <td><span class="required"></span></td>              
                </tr>            
                <tr>
                    <td></td>
                    <td class="login_button" colspan="2">
                        <a href="javascript:document.forms[0].submit();"  ><img  src="../images/login_btn.png" /></a>
                    </td>    
                    <!-- login.jsp 被2个请求所复用：
                    	 1.打开登录页toLogin.do
                    	 2.验证失败时login.do
                    	   	此处显示的error的值，在请求1中是Null,因此不会显示出来，
                    	 	而在请求2中发现有错误时会显示出具体的错误信息。(提示密码错误) -->
                    <td><span class="required">${error }</span></td>                
                </tr>
            </table>
        </form>
        </div>
    </body>
</html>
