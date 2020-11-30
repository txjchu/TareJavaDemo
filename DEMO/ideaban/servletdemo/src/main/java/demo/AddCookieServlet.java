package demo;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 练习 cookie 的添加与获取
 * @author: Peter
 * @date: 2020/11/12 15:01
 */
public class AddCookieServlet extends HelloServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();

        // 创建 cookie
        Cookie c1 = new Cookie("uname", "Kitty");
        Cookie c2 = new Cookie("city", "Beijing");
        // 添加 cookie 到 response
        resp.addCookie(c1);
        resp.addCookie(c2);
        out.close();

    }
}
