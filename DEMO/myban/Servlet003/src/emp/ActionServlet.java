package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Employee;

/**
 * 服务器类
 * @author Administrator
 *
 */
public class ActionServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		
		//获取请求的资源路径
		String uri = req.getRequestURI();
		System.out.println(uri);
		//截取资源路径中间除去应用名以外的部分
		String action = uri.substring(uri.lastIndexOf("/")+ 1, uri.lastIndexOf("."));
		System.out.println(action);
		//判断获取到的路径，开始分发任务
		if(action.equals("list")){//查询所有记录
			try {
				EmpDao dao = new EmpDao();
				List<Employee> emps = dao.findAll();
				out.println("<table border='1' cellpadding='0' cellspacing='0' width='60%'>");
				out.println("<caption>员工信息列表</caption>");
				out.println("<tr><td>编号</td><td>姓名</td><td>薪水</td><td>年龄</td><td>操作</td></tr>");
				for (Employee emp : emps) {
					out.println("<tr>");
					out.println("<td>" + emp.getId() + "</td>");
					out.println("<td>" + emp.getName() + "</td>");
					out.println("<td>" + emp.getSalary() + "</td>");
					out.println("<td>" + emp.getAge() + "</td>");
					out.println("<td><a href='#'>删除</a>");
					out.println("<a href='#'>修改</a></td>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.println("<a href='addEmp.html'>增加新员工</a>");
			} catch (Exception e) {
				e.printStackTrace();
				out.println("系统繁忙请稍后再试！");
			}
		} else if(action.equals("add")){//添加员工
			String name = req.getParameter("name");
			double salary = Double.parseDouble(req.getParameter("salary"));
			int age = Integer.parseInt(req.getParameter("age"));
			Employee emp = new Employee();
			emp.setName(name);
			emp.setSalary(salary);
			emp.setAge(age);
			EmpDao dao = new EmpDao();
			try {
				dao.save(emp);
				res.sendRedirect("list.do");
			} catch (SQLException e) {
				e.printStackTrace();
				out.print("添加失败！");
			}
		} else if(action.equals("")){//删除员工
			
		}
		
		
	}
	
}














