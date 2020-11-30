<%@ page import="demo.entity.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/18
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>修改员工记录</title>
    </head>
    <body>
        <p id="whereami">
        </p>
        <h1>
            更新员工
        </h1>

        <form action="update.do?id=${emp.id}" method="post">
            <table ellpadding="0" cellspacing="0" border="0" class="form_table">
                <tr>
                    <td valign="middle" align="right">
                        编号:
                    </td>
                    <td valign="middle" align="left">
                        ${emp.id}
                    </td>
                </tr>
                <tr>
                    <td valign="middle" align="right">
                        姓名:
                    </td>
                    <td valign="middle" align="left">
                        <input type="text" class="inputgri" name="name" value="${emp.name}"/>
                    </td>
                </tr>
                <tr>
                    <td valign="middle" align="right">
                        薪水:
                    </td>
                    <td valign="middle" align="left">
                        <input type="text" class="inputgri" name="salary" value="${emp.salary}"/>
                    </td>
                </tr>
                <tr>
                    <td valign="middle" align="right">
                        年龄:
                    </td>
                    <td valign="middle" align="left">
                        <input type="text" class="inputgri" name="age" value="${emp.age}"/>
                    </td>
                </tr>
            </table>
            <p>
                <input type="submit" class="button" value="修改" />
            </p>
        </form>
    </body>
</html>

