    <%@ page contentType="text/html;charset=UTF-8" 
        pageEncoding="UTF-8"%>
    <%
        Cookie c1 = new Cookie("uname","Kitty");
        //设置路径为应用的根路径
        c1.setPath("/JSP03");
        response.addCookie(c1);
    %>
    <h1>
    	addCookie.jsp
    </h1>