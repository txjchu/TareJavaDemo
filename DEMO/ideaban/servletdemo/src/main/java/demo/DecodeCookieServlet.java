package demo;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * 练习 cookie 中的中文编解码。（保存、解码）
 * cookie的值只能是ASCII字符，中文需要转换成ASCII码形式，使用URLEncoder.encode（）方法和URLDecoder.decode（）方法实现。
 * @author: Peter
 * @date: 2020/11/12 18:59
 */
public class DecodeCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie c : cookies){
                String name = c.getName();
                String value = c.getValue();
                out.println("<h3>Name:"+ name +"; Value:"+ URLDecoder.decode(value, "UTF-8") +"</H3>");
            }
        } else {
            out.println("没有 cookie 信息！");
        }
        out.close();
    }
}
