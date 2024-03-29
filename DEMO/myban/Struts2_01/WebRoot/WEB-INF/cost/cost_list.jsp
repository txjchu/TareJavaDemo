<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
		<title>NetCTOSS_cost_list</title>
		<link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css"/>
		<link type="text/css" rel="stylesheet" media="all" href="../../styles/global_color.css"/>
		<script type="text/javascript" language="javascript">
			//排序按钮的点击事件
			function sort(btnObj){
				if(btnObj.className == "sort_desc"){
					btnObj.className = "sort_asc";//升序排列
				} else {
					btnObj.className = "sort_desc";//降序
				}
			}
			//启用	
			function startFee(){
				var r = window.confirm("确定要启用此资费吗？资费启用后将不能删除和修改。");
				document.getElementById("operate_result_info").style.display = "block";
			}
			//删除
			function deleteFee(id){
				var r = window.confirm("确定要删除此资费吗？");
				//document.getElementById("operate_result_info").style.display = "block";//设定其为隐藏---不能生效。。
				window.location.href = "deletecost.action?id="+ id;
			}
		</script>	
	</head>
	<body>
		<!-- Logo区域开始 -->
		<div id="header">
			<img src="../../images/logo.png" alt="logo" class="left" />
			<a href="#">[退出]</a>
		</div>
		<!-- Logo区域结束 -->
		<!-- 导航区开始 -->
		<div id="navi">
			<ul id="menu">
				<li><a href="../index.html" class="index_off"></a></li>
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
		<!-- 导航区域结束 -->
		<!-- 主要区域开始 -->
		<div id="main">
			<form action="" method="">
				<!-- 排序 -->
				<div class="search_add">
					<div>
						<!-- <input type="button" value="月租" class="sort_asc" onclick="sort(this);"/> -->
						<input type="button" value="基费" class="sort_asc" onclick="sort(this);"/>
						<input type="button" value="时长" class="sort_asc" onclick="sort(this);"/>
					</div>
					<input type="button" value="增加" class="btn_add" onclick="location.href='toaddcost.action';"/>	<!-- 增加资费类型的功能 -->
				</div>
				<!-- 启用操作时操作提示 -->
				<div id="operate_result_info" class="operate_success">
					<img src="../../images/close.png" onclick="this.parentNode.style.display='none';"  />
					删除成功！
				</div>
				<!-- 数据区域:用表格展示数据 -->
				<div id="data">
					<table id="datalist">
						<tr>
							<th>资费ID</th>
							<th class="width100">资费名称</th>
							<th>基本时长</th>
							<th>基本费用</th>
							<th>单位费用</th>
							<th>创建时间</th>
							<th>开通时间</th>
							<th class="width50">状态</th>
							<th class="width200"></th>
						</tr>
						<tr>
							<td>2</td>
							<td><a href="fee_detail.html">包 40 小时</a></td>
							<td>40 小时</td>
							<td>40.50 元</td>
							<td>3.00 元/小时</td>
							<td>2013/01/21 00:00:00</td>
							<td>2013/01/23 00:00:00</td>
							<td>开通</td>
							<td>
								<input type="button" value="启用" class="btn_start" onclick="startFee();" />
								<input type="button" value="修改" class="btn_modify" onclick="location.href='fee_modi.html';" />
								<input type="button" value="删除" class="btn_delete" onclick="deleteFee();" />
							</td>
						</tr>
						
						<!-- 使用OGNL遍历ValueStack中的集合数据 -->
						<s:iterator value="costs">
							<tr>
								<td><s:property value="id"/></td>
								<td><a href="fee_detail.html"><s:property value="name"/></a></td>
								<td><s:property value="baseDuration"/></td>
								<td><s:property value="baseCost"/></td>
								<td><s:property value="unitCost"/></td>
								<td><s:property value="createTime"/></td>
								<td><s:property value="startTime"/></td>
								<td>
									<s:if test="status==0">开通</s:if>
									<s:else>暂停</s:else>
								</td>
								<td><input type="button" value="启用" class="btn_start" onclick="startFee();"/>			<!-- 拼接形式是否可以？ -->
									<input type="button" value="修改" class="btn_modify" onclick="location.href='toupdatecost?id='+ <s:property value="id"/>;"/>
									<input type="button" value="删除" class="btn_delete" onclick="deleteFee(<s:property value="id"/>);"/>
								</td>
							</tr>
						</s:iterator>
						
						
					</table>
					<p>业务说明：<br/>
						1.创建资费时，状态为暂停，记载创建时间；<br/>
						2.暂停状态下，可修改，可删除；<br/>
						3.开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br/>
						4.业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）。
					</p>
				</div>
				<!-- 分页 -->
				<div id="pages">
					<a href="#"> 上一页</a>
					<a href="#" class="current_page">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
					<a href="#">5</a>
					<a href="#">下一页</a>
				</div>
			</form>
		</div>		
		<!-- 主要区域结束 -->
		<div id="footer">
			<p>[源自天山的自来水，我们不生产水，我们只是大自然的搬运工。]</p>
			<p>版权所有(c) 美国迪斯尼动漫集团公司</p>
		</div>			
	</body>
</html>



















