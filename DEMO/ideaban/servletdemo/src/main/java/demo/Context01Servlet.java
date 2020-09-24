package demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 练习 ServletContext 的使用
 * 通过 ServletContext 获取当前 webapp 中所有 servlet 共有的数据。
 * 设定一个 count 上下文参数，用来对所有请求计数。
 * @author: Peter
 * @date: 2020/9/21 0:49
 */
public class Context01Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();

        // 获取全局上下文对象 ServletContext
        ServletContext servletContext = getServletContext();
        Object count = servletContext.getAttribute("count");
        if(count == null){ // 若所有的 servlet 中都还没有初始化 count
//            servletContext.setAttribute("count", 1);
            servletContext.setAttribute("count", servletContext.getInitParameter("count")); // 则用上下文对象从 web.xml 中读取设置的初始化参数
        } else {
            servletContext.setAttribute("count", Integer.parseInt(count.toString())+ 1);
        }
        out.print("总浏览量为："+ servletContext.getAttribute("count"));
    }
}
