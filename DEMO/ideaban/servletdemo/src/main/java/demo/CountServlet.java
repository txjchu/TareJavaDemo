package demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 练习通过 session 计数统计用户访问次数
 * @author: Peter
 * @date: 2020/11/12 23:37
 */
public class CountServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();// 获取 session
        String sessionId = session.getId();//获取 session id
        Integer count = (Integer) session.getAttribute("count");// 获取绑定的计数器
        if(count == null){
            count = 1;// 第一次访问
        } else {
            count ++; // 不是第一次访问,则访问次数加1
        }
        session.setAttribute("count", count); // 在 session 中绑定计时器
        out.println("这是"+ sessionId +"第"+ count +"次访问。");
        out.close();

        /*
        sessionID跟随一次会话，存储在客户端浏览器的内存中一个叫JSESSIONID的Cookie里面。
        第一次创建后，只要不关闭浏览器，那么每一次的请求sessionID都会被自动发送到服务器端。
        重启浏览器后，sessionID会被销毁，重新创建新的数值。
         */
    }
}
