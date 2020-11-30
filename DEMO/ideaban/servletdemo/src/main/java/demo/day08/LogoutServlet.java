package demo.day08;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 处理登出请求的 Servlet
 * @author: Peter
 * @date: 2020/11/16 22:53
 */
public class LogoutServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        /*
         * 因为监听器是通过监听 session 的创建与销毁来计算 count，因此登出的请求应该是在此处进行 session 的注销，
         * 这样就能实现登出人数-1的效果。
         */
        HttpSession session = req.getSession();
        session.invalidate();// session 无效化
    }
}
