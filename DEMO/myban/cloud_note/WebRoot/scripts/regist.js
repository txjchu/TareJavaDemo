$(function(){
	$("#regist_button").click(function(){
	//清除原有提示信息
	$("#warning_1 span").html("");	
	$("#warning_2 span").html("");
	$("#warning_3 span").html("");
	$("#warning_4 span").html("");
	$("#warning_1").hide();
	$("#warning_2").hide();
	$("#warning_3").hide();
	$("#warning_4").hide();
		//获取请求提交的参数
		var username = $("#regist_username").val().trim();
		var password = $("#regist_password").val().trim();
		var nickname = $("#nickname").val().trim();
		var repassword = $("#final_password").val().trim();
		//检查参数格式
		var ok=true;
		if(username==""){
			ok=false;
			//选中元素中的元素两种方法：(1)
			$("#warning_1 span").html("用户名为空");
			//(2)
			//$("#warning_1").find("span").html("用户名为空");
			$("#warning_1").show();
			
		}
		if(nickname==""){
			ok=false;
			$("#warning_4 span").html("昵称为空");
			$("#warning_4").show();
		}
		if(password==""){
			ok=false;
			$("#warning_2 span").html("密码为空");
			$("#warning_2").show();
		}else{
			if(password.length<6){
				ok=false;
				$("#warning_2 span").html("密码长度小于6位");
				$("#warning_2").show();
			}
		}
		if(repassword!=password){
			ok=false;
			$("#warning_3 span").html("与密码不一致");
			$("#warning_3").show();
		}
		//通过检测。发送ajax请求
		if(ok){
			//----下行未测试通过
			//alert("通过检测发送ajax请求");
			$.ajax({
				url:"http://localhost:9080/cloud_note/user/regist.do",
				type:"post",
				data:{"username":username,
						"nickname":nickname,
						"password":password},
				dataType:"json",
				success:function(result){
					if(result.status==0){//注册成功，跳转到登录页面
						alert(result.msg);
						$("#back").click();	//触发利用返回按钮的单击function()方法--click()无参是调用，有参是设置
					}else if(result.status==1){//用户名重复
						$("#warning_1 span").html(result.msg);
						$("#warning_1").show();
						}	
					},
					error:function(result){
						
					}
				});
			}
		});
	});

