package demo.servlet;

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
public class EmpActionServlet extends HttpServlet {

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

        EmployeeDAO dao = new EmployeeDAO();

        // 根据请求路径分别执行不同的动作
        if("list".equals(action)){ // 添加记录
            List<Employee> emps = dao.findAll();
            req.setAttribute("emps", emps); // 绑定数据
            req.getRequestDispatcher("listEmp.jsp").forward(req, resp);// 转发到 listEmp.jsp ，并绑定请求对象与相应对象

        } else if("add".equals(action)){ // 新加记录
            String name = req.getParameter("name");
            double salary = Double.parseDouble(req.getParameter("salary"));
            int age = Integer.parseInt(req.getParameter("age"));
            Employee emp = new Employee();
            emp.setName(name);
            emp.setSalary(salary);
            emp.setAge(age);
            dao.save(emp);
            resp.sendRedirect("list.do");
        } else if("load".equals(action)){// 如果是需要修改某条记录，则通过请求中的 id 获取到该记录数据后展示在页面，然后在页面修改后再次发出提交修改结果请求
            int id = Integer.parseInt(req.getParameter("id"));
            Employee emp = dao.findById(id);

            req.setAttribute("emp", emp);
            req.getRequestDispatcher("updateEmp.jsp").forward(req, resp);

        } else if("update".equals(action)){ // 修改记录
            Employee emp = new Employee();
            emp.setName(req.getParameter("name"));
            emp.setSalary(Double.parseDouble(req.getParameter("salary")));
            emp.setAge(Integer.parseInt(req.getParameter("age")));
            emp.setId(Integer.parseInt(req.getParameter("id")));
            dao.modify(emp);
            resp.sendRedirect("list.do");
        } else if("delete".equals(action)){ // 删除记录
            int id = Integer.parseInt(req.getParameter("id"));
            dao.delete(id);
            resp.sendRedirect("list.do");
        } else if("error".equals(action)){
            // 声明式处理异常
            System.out.println("声明式异常！");
            req.setAttribute("err_msg", "声明式异常处理方式: err_msg");
            throw new ServletException(new Exception());
        } else if ("err".equals(action)){
            // 编程式处理异常
            req.setAttribute("err_msg", "系统出错，请重试！(编程式处理异常)");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }

    }
}
