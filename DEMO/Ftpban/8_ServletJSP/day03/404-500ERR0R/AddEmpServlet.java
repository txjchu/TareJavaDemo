package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;

import entity.Emp;

public class AddEmpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		//1.接收传入的数据
		req.setCharacterEncoding("utf-8");//----
		String name = req.getParameter("name");
		String salary = req.getParameter("salary");
		String age = req.getParameter("age");
		//2.构造员工对象，便于保存
		Emp emp = new Emp();
		emp.setName(name);
		emp.setSalary(new Double(salary));
		emp.setAge(new Integer(age));
		//3.保存员工对象的数据
		EmpDao dao = new EmpDao();
		dao.save(emp);
		//4.响应给客户端(有待改进)---改进：不是输出信息，而是跳转至员工列表页面。【重定向】
		//目标路径：/EmpManager/addEmp
		//当前路径：/EmpManager/findEmp
//		res.setContentType("text/html;charset=utf-8");
//		PrintWriter w = res.getWriter();
//		w.println("<h1>新增成功</h1>");
//		w.close();
		
		//【重定向】：2个独立的组件(Servlet)之间跳转，采用重定向。
		//		  1一次重定向中包含2次请求。
		//使用时机：1.新增保存后，重定向到查询；
		//		2.删除保存后，重定向到查询；
		//		3.修改保存后，重定向到查询。
		 res.sendRedirect("findEmp");
	}
}	
