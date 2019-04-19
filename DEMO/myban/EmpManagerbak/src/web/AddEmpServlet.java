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
					//3.����Ա��
					EmpDao.save(emp);
					/*
					 * ��ת��Ա���б�ҳ��
					 * ��ǰ��/EmpManager/add_Emp
					 *Ŀ�꣺/EmpManager/findemp
					 */
					res.sendRedirect("findemp");
					//4.���ͻ��˷�Ӧ��
					/*res.setContentType("text/html;charset=utf-8");					
					PrintWriter w= res.getWriter();					
					w.println("<h1>�½��ɹ�</h1>");
					w.close();
				*/
					
					
					
					
	}

}
