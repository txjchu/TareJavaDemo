package demo;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * 练习 cookie 中的中文传递。（保存、解码）
 * cookie的值只能是ASCII字符，中文需要转换成ASCII码形式，使用URLEncoder.encode（）方法和URLDecoder.decode（）方法实现
 * @author: Peter
 * @date: 2020/11/12 18:54
 */
public class EncodeCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        Cookie c1 = new Cookie("uname", "Kitty");
        Cookie c2 = new Cookie("city", URLEncoder.encode("北京","UTF-8"));
        resp.addCookie(c1);
        resp.addCookie(c2);
        out.close();
    }
}
