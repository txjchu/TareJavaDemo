<%@page pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>NetCTOSS_update</title>
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global_color.css" />
        <script type="text/javascript" src="../../js/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="../../js/myjs.js"></script>
        <script language="javascript" type="text/javascript">
     		//检查用户名
        	function check_name(){
        		var cost_name = $("#cost_name").val();
        		var cost_id = $("#cost_cost_id").val();
        		//console.log(cost_name +",空");
        		//alert(cost_name +",空");
        		//校验资费名是否为空
        		if(cost_name == ""){
        			$("#name_msg").text("资费名不能为空！").addClass("error_msg");
        			return;//直接返回
        		}
        		//异步请求检查资费名是否为空
        		$.post(
        			"checkcostname2",
        			{"name":cost_name, "cost_id":cost_id},//json字符串形式发送cost_name中的资费名
        			function(data){
        				//回调函数的参数就是返回info属性
        				var info = data;
        				//根据返回值设置提示信息
        				if(info.success){
        					//验证通过，设置提示信息并移出错误样式
        					$("#name_msg").text(info.message).removeClass("error_msg");
        				}else{
        					//验证失败，设置提示信息并添加错误样式
        					$("#name_msg").text(info.message).addClass("error_msg");
        				}
        			}
        		);
        	}
            //保存结果的提示
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
            }
            //切换资费类型
            function feeTypeChange(type) {
                var inputArray = document.getElementById("main").getElementsByTagName("input");
                if (type == 1) {
                    inputArray[5].readonly = true;
                    inputArray[5].value = "";
                    inputArray[5].className += " readonly";
                    inputArray[6].readonly = false;
                    inputArray[6].className = "width100";
                    inputArray[7].readonly = true;
                    inputArray[7].className += " readonly";
                    inputArray[7].value = "";
                }
                else if (type == 2) {
                    inputArray[5].readonly = false;
                    inputArray[5].className = "width100";
                    inputArray[6].readonly = false;
                    inputArray[6].className = "width100";
                    inputArray[7].readonly = false;
                    inputArray[7].className = "width100";
                }
                else if (type == 3) {
                    inputArray[5].readonly = true;
                    inputArray[5].value = "";
                    inputArray[5].className += " readonly";
                    inputArray[6].readonly = true;
                    inputArray[6].value = "";
                    inputArray[6].className += " readonly";
                    inputArray[7].readonly = false;
                    inputArray[7].className = "width100";
                }
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../../images/logo.png" alt="logo" class="left"/>
            <input type="button" value="退出" class="btn_add" onclick="exitFee();"/>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
            <ul id="menu">
                <li><a href="../index/toindex" class="index_off"></a></li>
                <li><a href="../role/role_list.html" class="role_off"></a></li>
                <li><a href="../admin/admin_list.html" class="admin_off"></a></li>
                <li><a href="../fee/fee_list.html" class="fee_on"></a></li>
                <li><a href="../account/account_list.html" class="account_off"></a></li>
                <li><a href="../service/service_list.html" class="service_off"></a></li>
                <li><a href="../bill/bill_list.html" class="bill_off"></a></li>
                <li><a href="../report/report_list.html" class="report_off"></a></li>
                <li><a href="../user/user_info.html" class="information_off"></a></li>
                <li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>
            </ul>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <div id="save_result_info" class="save_success">保存成功！</div>
            <form action="updatecost.action" method="post" class="main_form">
                <div class="text_info clearfix"><span>资费ID：</span></div>
                <div class="input_info">
                	<s:textfield name="cost.cost_id" cssClass="readonly" readonly="true"/>
                </div>
                <div class="text_info clearfix"><span>资费名称：</span></div>
                <div class="input_info">
                    <s:textfield name="cost.name" cssClass="width300" onblur="check_name();" id="cost_name"/>
                    <span class="required">*</span>
                    <div class="validate_msg_short" id="name_msg">50长度的字母、数字、汉字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info fee_type"> 
                    <s:radio name="cost.cost_type" list="#{'1':'包月','2':'套餐','3':'计时'}" onclick="feeTypeChage(this.value)"/>
                </div>
                <div class="text_info clearfix"><span>基本时长：</span></div>
                <div class="input_info">
                    <s:textfield name="cost.base_duration" cssClass="width100"/>
                    <span class="info">小时</span>
                    <span class="required">*</span>
                    <div class="validate_msg_long">1-600之间的整数</div>
                </div>
                <div class="text_info clearfix"><span>基本费用：</span></div>
                <div class="input_info">
                    <s:textfield name="cost.base_cost" cssClass="width100"/>
                    <span class="info">元</span>
                    <span class="required">*</span>
                    <div class="validate_msg_long">0-99999.99之间的数值</div>
                </div>
                <div class="text_info clearfix"><span>单位费用：</span></div>
                <div class="input_info">
                    <s:textfield name="cost.unit_cost" cssClass="width100"/>
                    <span class="info">元/小时</span>
                    <span class="required">*</span>
                    <div class="validate_msg_long">0-99999.99之间的数值</div>
                </div>   
                <div class="text_info clearfix"><span>资费说明：</span></div>
                <div class="input_info_high">
                    <s:textarea name="cost.descr" cssClass="width300height70"/>
                    <div class="validate_msg_short">100长度的字母、数字、汉字和下划线的组合</div>
                </div>                    
                <div class="button_info clearfix">
                    <input type="submit" value="保存" class="btn_save"  onclick="showResult();" />
                    <input type="button" value="取消" class="btn_save" onclick="location.href='findcost.action'"/>
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自天山的自来水，我们不生产水，我们只是大自然的搬运工。]</p>
			<p>版权所有(c) 美国迪斯尼动漫集团公司</p>
        </div>
    </body>
</html>