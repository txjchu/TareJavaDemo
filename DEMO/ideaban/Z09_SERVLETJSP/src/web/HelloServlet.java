package web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: Peter
 * @date: 2020/9/13 1:03
 */
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1.设置输出类型
        response.setContentType("text/html");
        //2. 获取 writer
        PrintWriter printWriter = response.getWriter();
        // 3. 输出内容片断
        printWriter.println("<h1>Hello, Servlet</h1>");
        //4. 关闭 writer
        printWriter.close();


    }
}
