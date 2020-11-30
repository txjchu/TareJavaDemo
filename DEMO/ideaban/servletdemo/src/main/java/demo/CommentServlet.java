package demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 练习过滤器的使用 day08
 * @author: Peter
 * @date: 2020/11/16 17:16
 */
public class CommentServlet extends HttpServlet {

    /**
     * request对象中的req.getAttribute和req.getParameter两个方法的区别
     * https://blog.csdn.net/qq_40301026/article/details/90740229
     * getParameter()方法
     *      该方法是用于客户端传递过来的参数，它的返回值类型永远是是字符串类型这个赋值动作是有客户端完成的。
     *      （返回值是字符串，没有setParameter方法）
     * getAttribute()方法
     *       该方法是专用在请求传到服务器端后，在去使用其进行存取一些附加数据。它的返回类型永远是Object.
     *
     *
     * https://www.cnblogs.com/joke0406/p/6476002.html
     * 从更深的层次考虑，request.getParameter()方法传递的数据，会从Web客户端传到Web服务器端，代表HTTP请求数据。request.getParameter()方法返回String类型的数据。
     * request.setAttribute()和getAttribute()方法传递的数据只会存在于Web容器内部，在具有转发关系的Web组件之间共享。这两个方法能够设置Object类型的共享数据。
     * request.getParameter()取得是通过容器的实现来取得通过类似post，get等方式传入的数据，，  request.setAttribute()和getAttribute()只是在web容器内部流转，仅仅是请求处理阶段，这个的确是正解.
     * getAttribute是返回对象,getParameter返回字符串
     * request.getAttribute()方法返回request范围内存在的对象，而request.getParameter()方法是获取http提交过来的数据。
     */



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        // 获取评论内容
        String str = req.getParameter("comment");

//        String str = (String) req.getAttribute("comment"); // 不会报错，但是获取的是null。

        // 显示评论内容
        out.println("<h3>评论内容："+ str +"</h3>");
        out.close();
    }
}
