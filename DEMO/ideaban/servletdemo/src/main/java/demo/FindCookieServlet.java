package demo;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 练习获取 Cookie
 * @author: Peter
 * @date: 2020/11/12 17:14
 */
public class FindCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        Cookie[] cookies = req.getCookies();// 通过 request 对象获取到 cookie 数组
        if (cookies != null) {
            for(Cookie c : cookies){// 遍历
                String name = c.getName();
                String value = c.getValue();
                out.println("<h3>name:"+ name +" value:"+ value +"</h3>");
            }
        } else {
            out.println("没有 Cookie 信息！");
        }
        out.close();
    }
}
