package demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author: Peter
 * @date: 2020/9/16 12:24
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置输出类型
        resp.setContentType("text/html; charset=utf-8");
        //2.获取 writer
        PrintWriter printWriter = resp.getWriter();
        //3.设置输出内容
        printWriter.print("<h1>Hello, Servlet</h1>");
        printWriter.print("<a href='login?username=中文&password=xxx'>Login</a>");
        // 4.关闭 writer
        printWriter.close();
    }
}
