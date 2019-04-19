<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
    <script src="${ctxStatic}/plugin/echarts3/echarts.js"></script>
    <script src="${ctxStatic}/plugin/jquery/jquery-2.1.1.min.js"></script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div >
    <div id="Aclass" style="float:left; width:100%;height:100%;" ></div>
</div>
<script type="text/javascript">

    // 基于准备好的dom，初始化echarts实例
    var myChartA = echarts.init(document.getElementById('Aclass'));
    // 指定图表的配置项和数据
         optionA = {
             title: {
             text: '考勤记录',
             left: 'center',
             },
             color: ['#3398DB'],
             tooltip : {
             trigger: 'axis',
             axisPointer : {            // 坐标轴指示器，坐标轴触发有效
             type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
             }
             },
             grid: {
             left: '3%',
             right: '4%',
             bottom: '3%',
             containLabel: true
             },
             xAxis : [
             {
             type : 'category',
             data:(function(){
             var res = [];
             <c:forEach items="${attendanceList}" var="list">
             res.push('<fmt:formatDate value="${list.date}" pattern="MM/dd"/>');
             </c:forEach>
             return res;
             })(),
             axisTick: {
             alignWithLabel: true
             }
             }
             ],
             yAxis : [
             {
             type : 'value'
             }
             ],
             series : [
             {
             name:'直接访问',
             type:'bar',
             barWidth: '60%',
                 markLine : { data : [ { name: '标准工时', yAxis: 10 //数值你自定义
                 }]},
             data:(function(){
             var res = [];
             <c:forEach items="${attendanceList}" var="list">
             res.push({value:${list.onlineTime},name:'${list.date}'});
             </c:forEach>
             return res;
             })(),
             }
             ]
             };
    myChartA.setOption(optionA);

</script>
</body>
</html>
