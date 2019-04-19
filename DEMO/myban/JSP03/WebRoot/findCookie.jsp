    <%@ page contentType="text/html;charset=UTF-8"
     pageEncoding="UTF-8"%>
     <%@ page import="java.net.*"%>
     <h1>findCookie.jsp</h1>
    <%
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                String name = c.getName();
                String value = URLDecoder.encode(c.getValue(),"utf-8");
                out.println("<h3>Name:" + 
                name + "  Value:" + value
                        + "</h3>");
                out.println("<h3>Name:" + 
                        name + "  Value:" + value
                                + "</h3>");
            }
        } else {
            out.print("没有Cookie");
        }
    %>