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
		
		//1.���մ��������
		req.setCharacterEncoding("utf-8");//----
		String name = req.getParameter("name");
		String salary = req.getParameter("salary");
		String age = req.getParameter("age");
		//2.����Ա�����󣬱��ڱ���
		Emp emp = new Emp();
		emp.setName(name);
		emp.setSalary(new Double(salary));
		emp.setAge(new Integer(age));
		//3.����Ա�����������
		EmpDao dao = new EmpDao();
		dao.save(emp);
		//4.��Ӧ���ͻ���(�д��Ľ�)---�Ľ������������Ϣ��������ת��Ա���б�ҳ�档���ض���
		//Ŀ��·����/EmpManager/addEmp
		//��ǰ·����/EmpManager/findEmp
//		res.setContentType("text/html;charset=utf-8");
//		PrintWriter w = res.getWriter();
//		w.println("<h1>�����ɹ�</h1>");
//		w.close();
		
		//���ض��򡿣�2�����������(Servlet)֮����ת�������ض���
		//		  1һ���ض����а���2������
		//ʹ��ʱ����1.����������ض��򵽲�ѯ��
		//		2.ɾ��������ض��򵽲�ѯ��
		//		3.�޸ı�����ض��򵽲�ѯ��
		 res.sendRedirect("findEmp");
	}
}	
