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
		//1.���մ��������
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String salary = req.getParameter("salary");
		String age = req.getParameter("age");
		//2.����Ա������
		Emp emp = new Emp();
		emp.setName(name);
		emp.setSalary(new Double(salary));
		emp.setAge(new Integer(age));
		//3.����Ա��
		EmpDao dao = new EmpDao();
		dao.save(emp);
		//4.��Ӧ����ת��Ա���б�ҳ��(�ض���)
		//��ǰ��/EmpManager/addEmp
		//Ŀ�꣺/EmpManager/findEmp
		/*
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		w.println("<h1>�����ɹ�</h1>");
		w.close();
		*/
		res.sendRedirect("findEmp.do");
	}
	
}










