package demo;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 练习设置 cookie 的有效时长
 * @author: Peter
 * @date: 2020/11/12 18:18
 */
public class PersistentCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        Cookie c1 = new Cookie("uname", "Kitty");
        c1.setMaxAge(800);
        resp.addCookie(c1);
        Cookie c2 = new Cookie("city", "Beijing");
        resp.addCookie(c2);
        out.close();
    }
}
