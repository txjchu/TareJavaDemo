package demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 练习路径的写法
 * day05 CASE 03
 * @author: Peter
 * @date: 2020/9/24 21:14
 */
public class SomeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();

        System.out.println("SomeServlet's service is running....");
        System.out.println("req.getRequestURI():"+ req.getRequestURI());    // req.getRequestURI():/servletjsp05/some
        System.out.println("req.getContextPath():"+ req.getContextPath());// req.getContextPath()：/servletjsp05
        System.out.println(req.getParameter("name"));

        // 转发到 biz1/a1.jsp
        req.getRequestDispatcher("/biz1/a1.jsp").forward(req, resp);
    }
}
