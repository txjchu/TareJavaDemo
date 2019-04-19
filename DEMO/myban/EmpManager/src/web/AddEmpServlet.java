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
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//1.接收传入的数据
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String salary = req.getParameter("salary");
		String age = req.getParameter("age");
		//2.构造员工对象
		Emp emp = new Emp();
		emp.setName(name);
		emp.setSalary(new Double(salary));
		emp.setAge(new Integer(age));
		//3.保存员工
		EmpDao dao = new EmpDao();
		dao.save(emp);
		//4.响应：跳转至员工列表页面(重定向)
		//当前：/EmpManager/addEmp
		//目标：/EmpManager/findEmp
		/*
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		w.println("<h1>新增成功</h1>");
		w.close();
		*/
		res.sendRedirect("findEmp.do");
	}
	
}










