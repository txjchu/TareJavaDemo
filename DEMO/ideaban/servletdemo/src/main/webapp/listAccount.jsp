<%@ page import="demo.dao.AccountDAO" %>
<%@ page import="demo.entity.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/23
  Time: 1:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>ListAccount</title>
</head>
<body>

    <table border="1" cellpadding="0" cellspacing="0" width="500px">
        <caption>账号表</caption>
        <tr>
            <td>ID</td>
            <td>登录名</td>
            <td>状态</td>
            <td>姓名</td>
            <td>身份证</td>
            <td>手机号</td>
            <td>操作</td>
        </tr>

    <%
        AccountDAO dao = new AccountDAO();
        List<Account> accounts = dao.findAll();
        for(int i = 0; i < accounts.size(); i ++){
            Account account = accounts.get(i);
            String strStatus = "";
            if("1".equals(account.getStatus())){
                strStatus = "暂停";
            } else if ("2".equals(account.getStatus())){
                strStatus = "删除";
            } else {
                strStatus = "开通";
            }
    %>
        <tr>
            <td><%= account.getAccountId()%></td>
            <td><%= account.getLoginName()%></td>
            <td><%= strStatus%></td>
            <td><%= account.getRealName()%></td>
            <td><%= account.getIdcardNo()%></td>
            <td><%= account.getTelephone()%></td>
            <td class="td_modi">
                <input type="button" value="修改" onclick="location.href='load.do?accountId=<%=account.getAccountId()%>'"/>
                <input type="button" value="删除" onclick="location.href='delete.do?accountId=<%=account.getAccountId()%>'"/>
            </td>
        </tr>
    <%
        }
    %>
    </table>
</body>
</html>
