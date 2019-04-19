<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>姿态异常管理</title>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<meta name="decorator" content="ani"/>
	<%@ include file="/webpage/include/bootstraptable.jsp"%>
	<%@include file="/webpage/include/treeview.jsp" %>
	<script type="text/javascript">
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
            url: "${ctx}/devicedata/devicedata/ztycHistory?id="+$('#person').text(),
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
                    field: 'person.userName',
                    title: '姓名',
                    sortable: true

                }
                ,{
                    field: 'person.deviceId',
                    title: '设备号',
                    sortable: true
                },{
                    field: 'status',
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
                    field: 'type',
                    title: '异常时间',
                    sortable: true

                }
            ]

        });

		})

   </script>

		</head>
<body>
	<div class="wrapper wrapper-content">
	<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">历史姿态异常列表</h3>
	</div>
	<div class="panel-body">
		<sys:message content="${message}"/>
		<div id="toolbar">
			<a class="accordion-toggle btn btn-default" href="${ctx}/person/person/listZtyc"><i class="ti-angle-left"></i> 返回</a>
		</div>
	<!-- 表格 -->
	<table id="personTable"   data-toolbar="#toolbar"></table>
		<span hidden id="person">${per.id}</span>

	</div>
	</div>
	</div>
</body>
</html>