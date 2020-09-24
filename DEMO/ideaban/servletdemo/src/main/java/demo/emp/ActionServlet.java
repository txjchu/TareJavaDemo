package demo.emp;

import demo.dao.EmployeeDAO;
import demo.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 整合 Servlet
 * @author: Peter
 * @date: 2020/9/20 0:48
 */
public class ActionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();

        // 获取请求路径
        String uri = req.getRequestURI();
        // 获取请求路径中除应用名之外的部分    此处主要获取最后一个分隔符之后的路径
        String action = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));// 截取最后一个/与.之间的字符串，含头不含尾

        // 根据请求路径分别执行不同的动作
        if("list".equals(action)){ // 添加记录
            EmployeeDAO dao = new EmployeeDAO();
            List<Employee> emps = dao.findAll();
            out.println("<table border='1' cellpadding='0' cellspacing='0' width='60%'>");
            out.println("<caption>员工信息列表</caption>");
            out.println("<tr><td>编号</td><td>姓名</td><td>薪水</td><td>年龄</td><td>操作</td></tr>");

            for(Employee emp : emps){
                out.println("<tr>");
                out.println("<td>" + emp.getId() + "</td>");
                out.println("<td>" + emp.getName() + "</td>");
                out.println("<td>" + emp.getSalary() + "</td>");
                out.println("<td>" + emp.getAge() + "</td>");
                out.println("<td><a href='delete.do?id="+ emp.getId() +"' " +"onclick=\"return confirm('是否确定删除"+ emp.getName() +"');\">删除</a>");
                out.println("<a href='load.do?id="+ emp.getId() +"'>修改</a></td></td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<a href='addEmp.html'>增加新员工</a>");
        } else if("add".equals(action)){ // 新加记录
            String name = req.getParameter("name");
            double salary = Double.parseDouble(req.getParameter("salary"));
            int age = Integer.parseInt(req.getParameter("age"));
            Employee emp = new Employee();
            emp.setName(name);
            emp.setSalary(salary);
            emp.setAge(age);
            EmployeeDAO dao = new EmployeeDAO();
            dao.save(emp);
            resp.sendRedirect("list.do");
        } else if("load".equals(action)){// 如果是需要修改某条记录，则通过请求中的 id 获取到该记录数据后展示在页面，然后在页面修改后再次发出提交修改结果请求
            int id = Integer.parseInt(req.getParameter("id"));
            EmployeeDAO dao = new EmployeeDAO();
            Employee emp = dao.findById(id);
            out.println("<html><head></head><body style='font-size:30px'>");
            out.print("<form action='modify.do' method='post'>");
            out.print("编号："+ emp.getId() +"<br>");
            out.print("<input type='hidden' name='id' value='"+ emp.getId() +"'/><br>");
            out.print("姓名：<input name='name' value='"+ emp.getName() +"'/><br>");
            out.print("薪水：<input name='salary' value='"+ emp.getSalary() +"'/><br>");
            out.print("年龄：<input name='age' value='"+ emp.getAge() +"'/><br>");
            out.print("<input type='submit' value='修改'/>");
            out.print("</form>");
            out.print("</body></html>");

        } else if("modify".equals(action)){ // 修改记录
            EmployeeDAO dao = new EmployeeDAO();
            Employee emp = new Employee();
            emp.setName(req.getParameter("name"));
            emp.setSalary(Double.parseDouble(req.getParameter("salary")));
            emp.setAge(Integer.parseInt(req.getParameter("age")));
            emp.setId(Integer.parseInt(req.getParameter("id")));
            dao.modify(emp);
            resp.sendRedirect("list.do");
        } else if("delete".equals(action)){ // 删除记录
            int id = Integer.parseInt(req.getParameter("id"));
            EmployeeDAO dao = new EmployeeDAO();
            dao.delete(id);
            resp.sendRedirect("list.do");
        }

    }
}
