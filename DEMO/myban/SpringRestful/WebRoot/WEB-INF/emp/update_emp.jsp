<%@page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML >
<html>
	<head>
		<meta content="text/html; charset=utf-8">
		<title>修改员工信息页面</title>
		<script type="text/javascript" src="../../scripts/jquery.min.js"></script>
		
		<script type="text/javascript" src="../../scripts/jquery-1.4.3.js"></script>
		<script type="text/javascript" src="../../scripts/prototype-1.6.0.3.js"></script>
		<script type="text/javascript" src="../../scripts/json.js"></script>
		<script type="text/javascript">
			function save(){
				jQuery.ajax({
					type:"PUT",
					url:"../updateEmp",
					data:JSON.stringify(jQuery("#myform").serializObject),//使用jQ的选择器选中表单，然后调用自定义的函数将表单数据转变为JSON字符串。
					dataType:"json",
					contentType:"application/json",
					success:function(data){
						location.href = "../emp/findEmp";
					},
					error:f1()
				});
			}
			function f1(){
				var obj = $(jQuery("#myform"));
				var str = obj.serializeArray();
				alert(str);				
			}
		</script>
	</head>
	<body>
		<form action="../updateEmp" method="post" id="myform" >	<!-- 不使用ajax发送请求，直接使用表单的submit提交。 -->	<!-- onclick="f1();" -->
			<table width="40%" border="1" cellpadding="2" cellspacing="0" align="center">
				<tr>			
					<td>编号：</td>
					<td><input type="text" name="empno" value="${emp.empno}" readonly="readonly"/></td>
				</tr>		
				<tr>
					<td>姓名：</td>
					<td><input type="text" name="ename" value="${emp.ename}"/></td>
				</tr>
				<tr>
					<td>岗位：</td>
					<td><input type="text" name="job" value="${emp.job}"/></td>
				</tr>		
				<tr>
					<td>工资：</td>
					<td><input type="text" name="sal" value="${emp.sal}"/></td>
				</tr>				
				<tr>										<!-- 此处将submit提交方式改为按钮提交，绑定ajax请求。 -->
					<td colspan="2" align="center"><input type="submit" align="middle" value="修改"/></td>
					<!-- 
					<td colspan="2" align="center"><input type="button" align="middle" value="修改" onclick="save();"/></td>
					 -->
				</tr>
			</table>
		</form>
	</body>
</html>	