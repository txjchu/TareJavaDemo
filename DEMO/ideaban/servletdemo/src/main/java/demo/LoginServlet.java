package demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author: Peter
 * @date: 2020/9/16 14:52
 */
public class LoginServlet  extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");// 设置输出类型及编码格式
        req.setCharacterEncoding("utf-8");

        // 通过 URL 拼接 "?username=xxx&password=xxx" 为 request 对象增加 parameter .
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 解决 get 请求中的中文乱码。注意：JSP页面中 page 标签中定义 pageEncoding="utf-8" 的级别比 meta 高
//        username = new String(username.getBytes("iso-8859-1"),"utf-8");  // 注意 NullPointerException
//        password = new String(password.getBytes("iso-8859-1"), "utf-8");
//        System.out.println("username:"+ username +", password:"+ password +".");
        // 将获取到的数据绑定到 request 对象中
        req.setAttribute("username", username);
        req.setAttribute("password", password);
        // 获取转发器并转发到 jsp 页面，因为转发是在同一个请求过程中，因此 request 与 response 对象为同一个，拥有同样的数据。

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = simpleDateFormat.format(new Date());
        req.setAttribute("date", strDate);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }
}
