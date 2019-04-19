package web;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;

import emp.entity.Emp;

public class AddEmpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
				req.setCharacterEncoding("utf-8");
	
					Emp emp=new Emp();
					emp.setName(req.getParameter("name"));
					emp.setSalary(Double.valueOf(req.getParameter("salary")));
					emp.setAge(Integer.valueOf(req.getParameter("age")));
					//3.保存员工
					EmpDao.save(emp);
					/*
					 * 跳转到员工列表页面
					 * 当前：/EmpManager/add_Emp
					 *目标：/EmpManager/findemp
					 */
					res.sendRedirect("findemp");
					//4.给客户端反应。
					/*res.setContentType("text/html;charset=utf-8");					
					PrintWriter w= res.getWriter();					
					w.println("<h1>新建成功</h1>");
					w.close();
				*/
					
					
					
					
	}

}
