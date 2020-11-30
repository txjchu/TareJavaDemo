package demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 练习通过 session 控制登录后才能访问某些资源
 *
 * [设置session的有效时间](https://blog.csdn.net/qq_40087415/article/details/78972362)
 * 编程式 > web.xml 声明式 > tomcat:conf->web.xml设置。
 * session
 * @author: Peter
 * @date: 2020/11/13 0:16
 */
public class ActionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String uri = req.getRequestURI();
        System.out.println("当前uri"+ uri); //当前uri/helloservlet/login.action
        String action = uri.substring(uri.lastIndexOf("/")+ 1, uri.lastIndexOf("."));// 截取有效 uri
        HttpSession session = req.getSession();// 获取 session
        System.out.println("获取到的session ID 为："+ session.getId());
        // 判断动作是否为登录 login
        if("login".equals(action)){
            String name = req.getParameter("uname");// 通过请求获取到 form 传递过来的数据
            String pwd = req.getParameter("pwd");
            String number = req.getParameter("vcode");
            System.out.println(action +","+ name +","+ pwd +","+ number);

            // 添加验证码验证
            String code = session.getAttribute("code").toString();

            if(number.equals(code) && "111".equals(name) && "123".equals(pwd)){// 验证用户名和密码
                session.setAttribute("uname", name);// 验证成功，则将 name 绑定到 session 中
//                System.out.println(name);

                // 编程式设置 session 的时效, 单位 秒
                session.setMaxInactiveInterval(10);

//                resp.sendRedirect("../WEB-INF/index.jsp");// 且跳转到 index 页面 转发，放在 WEB-INF 下的 jsp 页面访问路径
                /**
                 * 注意路径的写法
                 */
//                req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);// 只能用转发的方式访问 WEB-INF 下的 jsp,不能用重定向直接请求。

                /*
                 * 禁用 cookie 后，需要使用 url 重写，即改变原来的访问地址，在url 后使用参数的方式携带上 sessionID
                 * 此处因为使用了转发而不是重定向，因此在浏览器上看不出请求 uri 的变化。
                 */
                req.getRequestDispatcher(resp.encodeRedirectURL("/WEB-INF/index.jsp")).forward(req, resp);
            } else { // 若验证不成功，则重定向回 login.jsp 登录页面
                session.setAttribute("msg", "用户名或密码错误！");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else if("logout".equals(action)){// 如果点击登出，则删除 session 信息
            session.invalidate();// session 无效化
            resp.sendRedirect("login.jsp");
        }
        out.close();
    }
}
