<%@page pageEncoding="utf-8"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 格式化标签库，包括格式化日期 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>达内－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            //排序按钮的点击事件
            function sort(btnObj) {
                if (btnObj.className == "sort_desc")
                    btnObj.className = "sort_asc";
                else
                    btnObj.className = "sort_desc";
            }

            //启用
            function startFee() {
                var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
                document.getElementById("operate_result_info").style.display = "block";
            }
            //删除
            function deleteFee() {
                var r = window.confirm("确定要删除此资费吗？");
                document.getElementById("operate_result_info").style.display = "block";
            }
        </script>        
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../images/logo.png" alt="logo" class="left"/>
			<%@include file="../logout.jsp" %>         
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">                        
			<%@include file="../login/menu.jsp" %>          
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
                <!--排序-->
                <div class="search_add">
                    <div>
                        <!--<input type="button" value="月租" class="sort_asc" onclick="sort(this);" />-->
                        <input type="button" value="基费" class="sort_asc" onclick="sort(this);" />
                        <input type="button" value="时长" class="sort_asc" onclick="sort(this);" />
                    </div>
                    		<!-- //当前方法(Servlet)的访问路径：	/netctoss/cost/toAdd.do -->
							<!-- //jsp文件的存放路径：/netctoss/WEB-INF/cost/add_cost.jsp -->
                    <input type="button" value="增加" class="btn_add" onclick="location.href='toAdd.do';" />
                </div> 
                <!--启用操作的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                   		 删除成功！
                </div>    
                <!--数据区域：用表格展示数据-->     
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
                        
                        <!-- 
                        	//通过request获取Servlet转发过来的数据
                        	//request是隐含对象，可以直接使用
                        	List<Cost> list =(List<Cost>)request.getAttribute("costs");//---需要转型
                        	//获取到cost 后需要循环，有几个cost，循环几次
                        	for(Cost c:list){	//----for循环里面输出tr
                         -->
                         
                        <!-- 用EL表达式来做 -->
                        <c:forEach items="${costs}" var="c">                   
                        <tr>
                            <td>${c.costID}</td>
                            <td><a href="fee_detail.html">${c.name}</a></td>
                            <td>${c.baseDuration}</td>
                            <td>${c.baseCost}</td>
                            <td>${c.unitCost}</td>
                            <td><fmt:formatDate value="${c.creatime}" pattern="yyyy-MM--dd"/></td>
                            <td><fmt:formatDate value="${c.creatime}" pattern="yyyy-MM--dd"/></td>
                            
                            <%--三目运算解决开始暂停状态显示 --%>
                            <td>${c.status==0?"开通":"暂停"}</td>
                            <td>                                
                                <input type="button" value="启用" class="btn_start" onclick="startFee();" />
                                <!-- /netctoss/cost/find.do    /netctoss -->
                                <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdate.do?id=${c.costID}';" />
                                <input type="button" value="删除" class="btn_delete" onclick="deleteFee();" />
                            </td>
                        </tr>
                       	</c:forEach> 

                    </table>
                    <p>业务说明：<br />
                    1、创建资费时，状态为暂停，记载创建时间；<br />
                    2、暂停状态下，可修改，可删除；<br />
                    3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br />
                    4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
                    </p>
                </div>
                <!--分页-->
                <div id="pages">
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <p>版权所有(C)加拿大达内IT培训集团公司 </p>
        </div>
    </body>
</html>
