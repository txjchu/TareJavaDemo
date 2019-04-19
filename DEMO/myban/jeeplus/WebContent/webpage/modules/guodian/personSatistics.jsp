<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>人员信息统计管理</title>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<meta name="decorator" content="ani"/>
	<%@ include file="/webpage/include/bootstraptable.jsp"%>
	<link href="${ctxStatic}/plugin/bootstrapTree/bootstrap-treeview.css" rel="stylesheet" type="text/css"/>
	<script src="${ctxStatic}/plugin/bootstrapTree/bootstrap-treeview.js" type="text/javascript"></script>
	<%@include file="personList.js" %>
</head>
<body>
<script>
    $.getJSON("${ctx}/projectlist/projectlist/treeData",function(data){
        $('#tree').treeview({
            data: data,
            levels: 1,
            showCheckbox:true,
            onNodeChecked:function(event, node) {
                console.log(event);
                console.log(node);
                var text = "<button>"+node.name+"</button>.";
                $("#hasSelectProject").append(text);
            },
            onNodeUnchecked:function(event, node) {
                console.log(event);
                console.log(node);
                var text = "<button>"+node.name+"</button>.";
                $("#hasSelectProject").append(text);
            },
        });
    });
</script>
	<div class="wrapper wrapper-content">
	<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">人员信息统计</h3>
	</div>
	<div class="panel-body">
		<sys:message content="${message}"/>
		<div class="row">
			<div class="col-md-5 posAbsolute" style="position: relative">
				<h3>1.勾选要统计的项目</h3>
				<ul id="tree" style="width:520px; overflow:scroll;">
				</ul>
				<div class="hasSelect">
					<h3 class="title">已经选择了的项目:</h3>
					<div class="project" id="hasSelectProject">
					</div>
				</div>
			</div>
			<div class="col-md-5 kinds" >
				<h3 class="title">2.请选择要统计图类型</h3>
				<div class="row">
					<div class="col-md-3 kind" data-charType="pie">
						<div class="col-md-12" >
							<i class="iconfont icon-bingzhuangtu"></i>
							<h5>饼状图</h5>
						</div>
					</div>
					<div class="col-md-3 kind" data-charType="line">

						<div class="col-md-12">
							<i class="iconfont icon-62"></i> <i class="iconfont icon-zhexiantu"></i>
							<h5>柱状图/折线图</h5>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>