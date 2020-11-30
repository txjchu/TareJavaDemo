package demo.day09;

import demo.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 练习 jstl 标签
 *
 * 在 servlet 中给 request 对象绑定数据，然后在 jsp 中使用 jstl 的标签获取数据并输出。
 * @author: Peter
 * @date: 2020/11/18 0:49
 */
public class ActionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String uri = req.getRequestURI();
        String uriSub = uri.substring(uri.lastIndexOf("/")+ 1, uri.lastIndexOf("."));// 截取有效请求字符串
        System.out.println(this.getClass().getName() +": uri:"+ uri);
        System.out.println(this.getClass().getName() +": uriSub:"+ uriSub);
        if("list".equals(uriSub)){
            List<Employee> emps = new ArrayList<Employee>();
            Employee e1 = new Employee();
            e1.setName("Luffy");
            e1.setGender("m");
            emps.add(e1);
            Employee e2 = new Employee();
            e2.setName("Zoro");
            e2.setGender("m");
            emps.add(e2);
            Employee e3 = new Employee();
            e3.setName("Luna");
            e3.setGender("f");
            emps.add(e3);

            // 绑定集合到 request 对象
            req.setAttribute("emps", emps);
            // 转发到 jsp 注意需要返回一层，因为请求中加了 /day09/,但是 jstl04.jsp 却是直接在项目下，而非 day09 目录下
            req.getRequestDispatcher("../jstl04.jsp").forward(req, resp);
        } else {

        }
    }
}
