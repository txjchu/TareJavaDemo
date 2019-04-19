<%@page pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
		<title>NetCTOSS-ERROR</title>
		<link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css"/>
		<link type="text/css" rel="stylesheet" media="all" href="../../styles/global_color.css"/>
		<script type="text/javascript" language="javascript">
			var timer;
			function startTimes(){//启动跳转的定时器
				timer = window.setInterval(showSecondes,1000);
			}
			var i = 5;
			function showSecondes(){//显示定时器
				if(i > 0){
					i--;
					document.getElementById("secondes").innerHTML = i;
				} else {
					window.clearInterval(timer);
					//location.href="login.html";
					history.back();
				}
			}
			function resetTimer(){//取消跳转
				if(timer != null && timer != undefined){
					window.clearInterval(timer);
					//location.href = "login.html";
					history.back();//取消计时器，并跳转回上一个页面（从历史记录中找到）
				}
			}
		</script>
	</head>
	<body class="error_page" onload="startTimes();">
		<h1 id="error">
			遇到错误，&nbsp;<span id="secondes">5</span>&nbsp;秒后将自动跳转，立即跳转请点击&nbsp;
			<a href="javascript:resetTimer();">返回</a>
		</h1>
	</body>
</html>











