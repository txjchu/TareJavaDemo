<%@ page contentType="text/html;charset=UTF-8" %>
<script>
$(document).ready(function() {
	$('#personTable').bootstrapTable({
		 
		  //请求方法
               method: 'get',
               //类型json
               dataType: "json",
               //显示刷新按钮
               showRefresh: true,
               //显示切换手机试图按钮
               showToggle: true,
               //显示 内容列下拉框
    	       showColumns: true,
    	       //显示到处按钮
    	       showExport: true,
    	       //显示切换分页按钮
    	       showPaginationSwitch: true,
    	       //显示详情按钮
    	       detailView: true,
    	       	//显示详细内容函数
	           detailFormatter: "detailFormatter",
    	       //最低显示2行
    	       minimumCountColumns: 2,
               //是否显示行间隔色
               striped: true,
               //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）     
               cache: false,    
               //是否显示分页（*）  
               pagination: true,   
                //排序方式 
               sortOrder: "asc",  
               //初始化加载第一页，默认第一页
               pageNumber:1,   
               //每页的记录行数（*）   
               pageSize: 10,  
               //可供选择的每页的行数（*）    
               pageList: [10, 25, 50, 100],
               //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据  
               url: "${ctx}/person/person/dataZtyc",
               //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
               //queryParamsType:'',   
               ////查询参数,每次调用是会带上这个参数，可自定义                         
               queryParams : function(params) {
               	var searchParam = $("#searchForm").serializeJSON();
               	searchParam.pageNo = params.limit === undefined? "1" :params.offset/params.limit+1;
               	searchParam.pageSize = params.limit === undefined? -1 : params.limit;
               	searchParam.orderBy = params.sort === undefined? "" : params.sort+ " "+  params.order;
                   return searchParam;
               },
               //分页方式：client客户端分页，server服务端分页（*）
               sidePagination: "server",
               contextMenuTrigger:"right",//pc端 按右键弹出菜单
               contextMenuTriggerMobile:"press",//手机端 弹出菜单，click：单击， press：长按。
               contextMenu: '#context-menu',
               onContextMenuItem: function(row, $el){
                   if($el.data("item") == "edit"){
                   	window.location = "${ctx}/person/person/form?id=" + row.id;
                   } else if($el.data("item") == "delete"){
                        jp.confirm('确认要删除该人员信息记录吗？', function(){
                       	jp.loading();
                       	jp.get("${ctx}/person/person/delete?id="+row.id, function(data){
                   	  		if(data.success){
                   	  			$('#personTable').bootstrapTable('refresh');
                   	  			jp.success(data.msg);
                   	  		}else{
                   	  			jp.error(data.msg);
                   	  		}
                   	  	})
                   	   
                   	});
                      
                   } 
               },
              
               onClickRow: function(row, $el){
               },
               columns: [{
		        checkbox: true
		       
		    }
			,{
		        field: 'userName',
		        title: '姓名',
		        sortable: true
		        ,formatter:function(value, row , index){
		        	return "<a href='${ctx}/person/person/form?id="+row.id+"'>"+value+"</a>";
		         }
		       
		    }
			,{
		       		 field: 'cellNumber',
					 title: '手机号',
		        	 sortable: true
		       
		    },{
                       field: 'deviceId',
                       title: '设备号',
                       sortable: true
			},{
                       field: 'title',
                       title: '所属项目',
                       sortable: true
            }
			,{
		        field: 'company',
		        title: '所属单位',
		        sortable: true
		       
		    },{
                       field: 'devicedata.status',
                       title: '异常状态',
                       sortable: true,
                       formatter:function(value, row , index){
                           if(value==-3){
                               return "姿态和运动量异常";
                           }else if(value==-1){
                               return "运动量异常";

                           }else if(value==-2){
                               return " 姿态异常";
                           }else if(value==1){
                               return "姿态和运动量正常";
                           }else  if(value==0){
                               return "无定位、姿态和运动量异常";
                           }
                       }
              },{
                       field: 'devicedata.type',
                       title: '异常时间',
                       sortable: true

                   },{

                       title: '历史异常详情',
                       sortable: true
                       ,formatter:function(value, row , index){
                           return "<a href='${ctx}/person/person/ztycList?id="+row.id+"'>详情</a>";
                       }

                   }
		     ]
		
		});
		
		  
	  if(navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)){//如果是移动端

		  $('#personTable').bootstrapTable("toggleView");

		}
	  $('#personTable').on('check.bs.table uncheck.bs.table load-success.bs.table ' +
                'check-all.bs.table uncheck-all.bs.table', function () {
            $('#remove').prop('disabled', ! $('#personTable').bootstrapTable('getSelections').length);
            $('#edit').prop('disabled', $('#personTable').bootstrapTable('getSelections').length!=1);
      });
		  
		$("#btnImport").click(function(){
			jp.open({
			    type: 1, 
			    area: [500, 300],
			    title:"导入数据",
			    content:$("#importBox").html() ,
			    btn: ['下载模板','确定', '关闭'],
				    btn1: function(index, layero){
					  window.location='${ctx}/person/person/import/template';
				  },
			    btn2: function(index, layero){
				        var inputForm =top.$("#importForm");
				        var top_iframe = top.getActiveTab().attr("name");//获取当前active的tab的iframe 
				        inputForm.attr("target",top_iframe);//表单提交成功后，从服务器返回的url在当前tab中展示
				        inputForm.onsubmit = function(){
				        	jp.loading('  正在导入，请稍等...');
				        }
				        inputForm.submit();
					    jp.close(index);
				  },
				 
				  btn3: function(index){ 
					  jp.close(index);
	    	       }
			}); 
		});
		    
	  $("#search").click("click", function() {// 绑定查询按扭
		  $('#personTable').bootstrapTable('refresh');
		});
	 
	 $("#reset").click("click", function() {// 绑定查询按扭
		  $("#searchForm  input").val("");
		  $("#searchForm  select").val("");
		   $("#searchForm  .select-item").html("");
		  $('#personTable').bootstrapTable('refresh');
		});
		
		
	});
		
  function getIdSelections() {
        return $.map($("#personTable").bootstrapTable('getSelections'), function (row) {
            return row.id
        });
    }
function getIdSelectionsName() {
    return $.map($("#personTable").bootstrapTable('getSelections'), function (row) {
        return row.username
    });
}
  
  function deleteAll(){

		jp.confirm('确认要删除该人员信息记录吗？', function(){
			jp.loading();  	
			jp.get("${ctx}/person/person/deleteAll?ids=" + getIdSelections(), function(data){
         	  		if(data.success){
         	  			$('#personTable').bootstrapTable('refresh');
         	  			jp.success(data.msg);
         	  		}else{
         	  			jp.error(data.msg);
         	  		}
         	  	})
          	   
		})
  }
  function edit(){
	  window.location = "${ctx}/person/person/form?id=" + getIdSelections();
  }

  
		   
  function detailFormatter(index, row) {
	  var htmltpl =  $("#personChildrenTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
	  var html = Mustache.render(htmltpl, {
			idx:row.id
		});
	  $.get("${ctx}/person/person/detail?id="+row.id, function(person){
    	var personChild1RowIdx = 0, personChild1Tpl = $("#personChild1Tpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
		var data1 =  person.badrecordList;
		for (var i=0; i<data1.length; i++){
			addRow('#personChild-'+row.id+'-1-List', personChild1RowIdx, personChild1Tpl, data1[i]);
			personChild1RowIdx = personChild1RowIdx + 1;
		}
				
    	var personChild2RowIdx = 0, personChild2Tpl = $("#personChild2Tpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
		var data2 =  person.personjobList;
		for (var i=0; i<data2.length; i++){
			addRow('#personChild-'+row.id+'-2-List', personChild2RowIdx, personChild2Tpl, data2[i]);
			personChild2RowIdx = personChild2RowIdx + 1;
		}
				
      	  			
      })
     
        return html;
    }
  
	function addRow(list, idx, tpl, row){
		$(list).append(Mustache.render(tpl, {
			idx: idx, delBtn: true, row: row
		}));
	}
			
</script>
<script type="text/template" id="personChildrenTpl">
	<div class="tabs-container">
		<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#tab-{{idx}}-1" aria-expanded="true">人员不良纪录</a></li>
				<li><a data-toggle="tab" href="#tab-{{idx}}-2" aria-expanded="true">人员工作记录</a></li>
		</ul>
		<div class="tab-content">
				 <div id="tab-{{idx}}-1" class="tab-pane fade in active">
						<table class="ani table">
						<thead>
							<tr>
								<th>开始时间</th>
								<th>结束时间</th>
								<th>内容</th>
    							<th>备注信息</th>
							</tr>
						</thead>
						<tbody id="personChild-{{idx}}-1-List">
						</tbody>
					</table>
				</div>
				<div id="tab-{{idx}}-2" class="tab-pane fade">
					<table class="ani table">
						<thead>
							<tr>
								<th>开始时间</th>
								<th>结束时间</th>
								<th>工作内容</th>
							</tr>
						</thead>
						<tbody id="personChild-{{idx}}-2-List">
						</tbody>
					</table>
				</div>
		</div>//-->
	</script>
	<script type="text/template" id="personChild1Tpl">
				<tr>
					<td>
						{{row.startTime}}
					</td>
					<td>
						{{row.overTime}}
					</td>
					<td>
						{{row.centent}}
					</td>
					<td>
						{{row.remarks}}
					</td>
				</tr>
	</script>
	<script type="text/template" id="personChild2Tpl">
				<tr>
					<td>
						{{row.starttime}}
					</td>
					<td>
						{{row.overtime}}
					</td>
					<td>
						{{row.jobcontent}}
					</td>
				</tr>
	</script>
