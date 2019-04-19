<%@ page contentType="text/html; charset=UTF-8" 
         pageEncoding="UTF-8"%>
<%@ page import="dao.*,entity.*,util.*,java.util.*"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>员工信息</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
    </head>
    <body>
        <div id="wrap">
            <div id="top_content">
                <div id="header">
                    <div id="rightheader">
                        <p>2009/11/20<br /></p>
                    </div>
                    <div id="topheader">
                        <h1 id="title"><a href="#">main</a></h1>
                    </div>
                    <div id="navigation"></div>
                </div>
                <div id="content">
                    <p id="whereami"></p>
                    <h1>员工信息列表</h1>
                    <table class="table">
                        <tr class="table_header">
                            <td>编号</td>
                            <td>姓名</td>
                            <td>薪水</td>
                            <td>年龄</td>
                            <td>操作</td>
                        </tr>
                        <%-- 删除小脚本代码块使用JSTL标签来实现
                        <%
                            EmployeeDao dao = new EmployeeDao();
							List<Employee> emps = (List<Employee>)request.getAttribute("emps"); 
                            for (int i = 0; i < emps.size(); i++) {
                               Employee emp = emps.get(i);
                        %>
                         --%>
					<c:forEach var="emp" items="${emps}" varStatus="s">
                        <tr class="row${s.index % 2 + 1}"><!-- class为row1或row2隔行区分 -->
                            <td>${emp.id}</td>
                            <td>${emp.name}</td>
                            <td>${emp.salary}</td>
                            <td>${emp.age}</td>
                            <td><a href="delete.do?id=${emp.id}" onclick="return confirm('是否确认删除${emp.name}的信息？');">删除</a>&nbsp;<a href="load.do?id=${emp.id}">更新</a></td>
                        </tr>
					</c:forEach>                        
                        <%--
                            }
                        --%>
                        
                    </table>
                    <p>
                        <input type="button" class="button" value="Add Employee" onclick="location='addEmp.jsp'"/>
                    </p>
                </div>
            </div>
            <div id="footer">
                <div id="footer_bg">ABC@126.com</div>
            </div>
        </div>
    </body>
</html>