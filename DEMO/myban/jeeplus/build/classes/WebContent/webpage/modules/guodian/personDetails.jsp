<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>人员信息管理</title>
	<meta name="decorator" content="ani"/>
	<script type="text/javascript">

	/*	$(document).ready(function() {*/
			/*$("#inputForm").validate({
                rules: {
                    userName: {remote: "${ctx}/person/person/checkExistsByName?oldUserName=" + encodeURIComponent('${person.userName}')},
                    cellNumber: {remote: "${ctx}/person/person/checkExistsByCellNumber?oldCellNumber=" + encodeURIComponent('${person.cellNumber}')},
                    idCard: {remote: "${ctx}/person/person/checkExistsByIdCard?oldIdCard=" + encodeURIComponent('${person.idCard}')}
                },
                messages: {
                    userName: {remote: "姓名已存在"},
                    cellNumber: {remote: "电话已存在"},
                    idCard: {remote: "身份证已存在"}
                },
				submitHandler: function(form){
					jp.loading();
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});*/

	     /*   $('#hidedate').datetimepicker({
				 format: "YYYY-MM-DD HH:mm:ss"
		    });

            $('#admissionTrainTime').datetimepicker({
                format: "YYYY-MM-DD HH:mm:ss"
            });
		});*/
		
		function addRow(list, idx, tpl, row){
			$(list).append(Mustache.render(tpl, {
				idx: idx, delBtn: true, row: row
			}));
			$(list+idx).find("select").each(function(){
				$(this).val($(this).attr("data-value"));
			});
			$(list+idx).find("input[type='checkbox'], input[type='radio']").each(function(){
				var ss = $(this).attr("data-value").split(',');
				for (var i=0; i<ss.length; i++){
					if($(this).val() == ss[i]){
						$(this).attr("checked","checked");
					}
				}
			});
			$(list+idx).find(".form_datetime").each(function(){
				 $(this).datetimepicker({
					 format: "YYYY-MM-DD HH:mm:ss"
			    });
			});
		}
	/*	function delRow(obj, prefix){
			var id = $(prefix+"_id");
			var delFlag = $(prefix+"_delFlag");
			if (id.val() == ""){
				$(obj).parent().parent().remove();
			}else if(delFlag.val() == "0"){
				delFlag.val("1");
				$(obj).html("&divide;").attr("title", "撤销删除");
				$(obj).parent().parent().addClass("error");
			}else if(delFlag.val() == "1"){
				delFlag.val("0");
				$(obj).html("&times;").attr("title", "删除");
				$(obj).parent().parent().removeClass("error");
			}
		}*/
	</script>
</head>
<body>
<div class="wrapper wrapper-content">				
<div class="row">
	<div class="col-md-12">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title"> 
				<a class="panelButton" href="${ctx}/person/person"><i class="ti-angle-left"></i> 返回</a>
			</h3>
		</div>
		<div class="panel-body">
		<form:form id="inputForm" modelAttribute="person" action="${ctx}/person/person/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
				<div class="form-group col-md-4">
					<label class="col-sm-4 control-label">照片：</label>
					<div class="col-sm-5">
						<img class="col-sm-5 control-label"  src="${person.photo}" >
					</div>
				</div>

				<div class="form-group col-md-4" >
					<label class="col-sm-4 control-label" >姓名：</label>
					<div class="col-sm-5">
						<label class="col-sm-4 control-label" style="text-align: left;">${person.userName}</label>
					</div>

					<div class=" col-md-12"></div>


					<label class="col-sm-4 control-label" style="margin-top: 21px">年龄：</label>
					<div class="col-sm-5">

						<label class="col-sm-4 control-label"  style="text-align: left;margin-top: 21px">${person.userAge}岁</label>

					</div>
				</div>


			<div class=" col-md-12"></div>
				<div class="form-group col-md-4">
					<label class="col-sm-4 control-label">手机号：</label>
					<div class="col-sm-5">
						<label class="col-sm-4 control-label"  style="text-align: left">${person.cellNumber}</label>
					</div>
				</div>

				<div class="form-group col-md-4">
					<label class="col-sm-4 control-label">性别：</label>
					<div class="col-sm-5">
								<label class="col-sm-4 control-label"  style="text-align: left">${person.userSex}</label>

					</div>
				</div>

			<div class=" col-md-12"></div>
				<div class="form-group col-md-4">
					<label class="col-sm-4 control-label">民族：</label>
					<div class="col-sm-5">

						<c:forEach items="${fns:getDictList('nation')}" var="national">

							<c:if test="${person.national==national.value}">

								<label class="col-sm-4 control-label"  style="text-align: left">${national.label}</label>
							</c:if>

						</c:forEach>

					</div>
				</div>

				<div class="form-group col-md-4">
					<label class="col-sm-4 control-label">学历：</label>
					<div class="col-sm-5">

						<c:forEach items="${fns:getDictList('education')}" var="education">

							<c:if test="${person.eduCation==education.value}">

								<label class="col-sm-10 control-label"  style="text-align: left">${education.label}</label>
							</c:if>

						</c:forEach>

					</div>
				</div>
			<div class=" col-md-12"></div>
				<div class="form-group col-md-4">
					<label class="col-sm-4 control-label">身份证号：</label>
					<div class="col-sm-5">
						<label class="col-sm-4 control-label"  style="text-align: left">${person.idCard}</label>
					</div>
				</div>

				<div class="form-group col-md-4">
					<label class="col-sm-4 control-label">血型：</label>
					<div class="col-sm-5">
						<label class="col-sm-4 control-label"  style="text-align: left">${person.blood}</label>

					</div>
				</div>
			<div class=" col-md-12"></div>
				<div class="form-group col-md-4">
					<label class="col-sm-4 control-label">住址：</label>
					<div class="col-sm-5">
						<label class="col-sm-4 control-label"  style="text-align: left">${person.address}</label>
					</div>
				</div>

				<div class="form-group col-md-4">
				<label class="col-sm-4 control-label">身体状况：</label>
					<div class="col-sm-5">
						<label class="col-sm-4 control-label"  style="text-align: left">${person.body}</label>

					</div>
				</div>
			<div class="col-md-12"></div>
			<div class="tabs-container col-md-12">
            <ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">人员不良纪录：</a>
                </li>
				<li class=""><a data-toggle="tab" href="#tab-2" aria-expanded="false">人员工作记录：</a>
                </li>
            </ul>
            <div class="tab-content">
				<div id="tab-1" class="tab-pane fade in  active">
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th class="hide"></th>
						<th>开始时间</th>
						<th>结束时间</th>
						<th>内容</th>
					</tr>
				</thead>
				<tbody id="badrecordList">
				</tbody>
			</table>
			<script type="text/template" id="badrecordTpl">//<!--
				<tr id="badrecordList{{idx}}">
					<td class="hide">
						<input id="badrecordList{{idx}}_id" name="badrecordList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
						<input id="badrecordList{{idx}}_delFlag" name="badrecordList[{{idx}}].delFlag" type="hidden" value="0"/>
					</td>

					<td style="vertical-align: inherit">
						<div class='input-group form_datetime' id="badrecordList{{idx}}_startTime">
		                   <%-- <input type='text'  name="badrecordList[{{idx}}].startTime" class="form-control "  value="{{row.startTime}}"/>--%>
		                   <span >{{row.startTime}}</span>
		                    <%--<span class="input-group-addon">

		                       < <span class="glyphicon glyphicon-calendar"></span>
		                    </span>--%>
		                </div>
					</td>

					<td style="vertical-align: inherit">
						<div class='input-group form_datetime' id="badrecordList{{idx}}_overTime">
						<span >{{row.overTime}}</span>
		                   <%-- <input type='text'  name="badrecordList[{{idx}}].overTime" class="form-control "  value="{{row.overTime}}"/>
		                    <span class="input-group-addon">
		                        <span class="glyphicon glyphicon-calendar"></span>
		                    </span>--%>
		                </div>
		           </td>

					<td>
						<span >{{row.centent}}</span>
						<%--<textarea id="badrecordList{{idx}}_centent" name="badrecordList[{{idx}}].centent" rows="4"    class="form-control ">{{row.centent}}</textarea>--%>
					</td>

					<%--<td class="text-center" width="10">
						{{#delBtn}}<span class="close" onclick="delRow(this, '#badrecordList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
					</td>--%>
				</tr>//-->
			</script>
			<script type="text/javascript">
				var badrecordRowIdx = 0, badrecordTpl = $("#badrecordTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
				$(document).ready(function() {
					var data = ${fns:toJson(person.badrecordList)};
					for (var i=0; i<data.length; i++){
						addRow('#badrecordList', badrecordRowIdx, badrecordTpl, data[i]);
						badrecordRowIdx = badrecordRowIdx + 1;
					}
				});
			</script>
			</div>
				<div id="tab-2" class="tab-pane fade">
		<%--	<a class="btn btn-white btn-sm" onclick="addRow('#personjobList', personjobRowIdx, personjobTpl);personjobRowIdx = personjobRowIdx + 1;" title="新增"><i class="fa fa-plus"></i> 新增</a>--%>
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th class="hide"></th>
						<th>开始时间</th>
						<th>结束时间</th>
						<th>工作内容</th>
						<%--<th width="10">&nbsp;</th>--%>
					</tr>
				</thead>
				<tbody id="personjobList">
				</tbody>
			</table>
			<script type="text/template" id="personjobTpl">//<!--
				<tr id="personjobList{{idx}}">
					<td class="hide">
						<input id="personjobList{{idx}}_id" name="personjobList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
						<input id="personjobList{{idx}}_delFlag" name="personjobList[{{idx}}].delFlag" type="hidden" value="0"/>
					</td>

					<td style="vertical-align: inherit">
						<div class='input-group form_datetime' id="personjobList{{idx}}_starttime">
						<span >{{row.starttime}}</span>
		                    <%--<input type='text'  name="personjobList[{{idx}}].starttime" class="form-control "  value="{{row.starttime}}"/>
		                    <span class="input-group-addon">
		                        <span class="glyphicon glyphicon-calendar"></span>
		                    </span>--%>
		                </div>
					</td>


					<td style="vertical-align: inherit">
						<div class='input-group form_datetime' id="personjobList{{idx}}_overtime">
						<span >{{row.overtime}}</span>
		                   <%-- <input type='text'  name="personjobList[{{idx}}].overtime" class="form-control "  value="{{row.overtime}}"/>
		                    <span class="input-group-addon">
		                        <span class="glyphicon glyphicon-calendar"></span>
		                    </span>--%>
		                </div>
					</td>


					<td>
					<span >{{row.jobcontent}}</span>
						<%--<textarea id="personjobList{{idx}}_jobcontent" name="personjobList[{{idx}}].jobcontent" rows="4"    class="form-control ">{{row.jobcontent}}</textarea>--%>
					</td>

					<%--<td class="text-center" width="10">
						{{#delBtn}}<span class="close" onclick="delRow(this, '#personjobList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
					</td>--%>
				</tr>//-->
			</script>
			<script type="text/javascript">
				var personjobRowIdx = 0, personjobTpl = $("#personjobTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
				$(document).ready(function() {
					var data = ${fns:toJson(person.personjobList)};
					for (var i=0; i<data.length; i++){
						addRow('#personjobList', personjobRowIdx, personjobTpl, data[i]);
						personjobRowIdx = personjobRowIdx + 1;
					}
				});
			</script>
			</div>
		</div>
		</div>
		<%--<c:if test="${fns:hasPermission('person:person:edit') || isAdd}">
				<div class="col-lg-3"></div>
		        <div class="col-lg-6">
		             <div class="form-group text-center">
		                 <div>
		                     <button class="btn btn-primary btn-block btn-lg btn-parsley" data-loading-text="正在提交...">提 交</button>
		                 </div>
		             </div>
		        </div>
		</c:if>--%>
		</form:form>
		</div>				
	</div>
	</div>
</div>
</div>
</body>
</html>