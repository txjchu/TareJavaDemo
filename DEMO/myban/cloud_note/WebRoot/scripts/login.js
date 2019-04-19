//
$(function(){  //<!-- 登录处理 -->
	$("#login").click(function(){
		//alert("用户名为空");
		//清除原有提示信息
		$("#count_span").html("");
		$("#password_span").html("");
		//获取请求提交数据
		var name = $("#count").val().trim();
		var password = $("#password").val().trim();
		//检测数据格式
		var ok = true;//表单是否通过检测
		if(name==""){
			ok = false;
			$("#count_span").html("用户名为空");
		}
		if(password==""){
			ok = false;
			$("#password_span").html("密码为空");
		}
		
		//通过检测，发送ajax请求
		if(ok){
			//发送ajax
			$.ajax({url:path+"/user/login.do",
					type:"post",
					data:{"username":name,"password":password},
					dataType:"json",
					success:function(result){
						//成功处理	
						if(result.status==0){	   //登录成功
							//将返回的用户ID写入Cookie
							var userId = result.data;//由UserServiceImpl将用户ID放入data中
							addCookie("userId",userId,2);//写入，2小时失效
							//location跳转到edit.html主界面					
							window.location.href="edit.html";
						}else if(result.status==1){//账号错误
							//
							$("#count_span").html(result.msg);
						}else if(result.status==2){//密码错误
							$("#password_span").html(result.msg);
						}
					},
					error:function(){
						//异常处理
						alert("登录异常");
					}
			});
		}
	});
});











