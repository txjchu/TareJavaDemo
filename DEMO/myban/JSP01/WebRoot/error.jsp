    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <html>
        <head>    
            <title>错误提醒</title>
        </head>
        <body style="font-size:24px">
        <%--
        <%=request.getAttribute("err_msg")==null
           ?"":request.getAttribute("err_msg")%><Br>
         --%>
         <c:if test="${err_msg==null}" var="msg" scope="request"></c:if>
         <c:if test="${!msg}" >${err_msg}</c:if>
        
        	系统异常    <a href="list.do">返回</a>
        </body>
    </html>