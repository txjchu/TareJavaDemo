package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

/**
 *	��ServletҪ�������е�����
 */
public class ActionServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//���ڸ�ServletҪ���������������
		//�����жϳ��������Դ����ͬ����Դ��
		//ҵ���б��ʵ������������Դ���淶��
		// /EmpManager/xxx.do
		String uri = req.getRequestURI();
		if(uri.contains("findEmp")) {
			//��ѯԱ��
			findEmp(req, res);
		} else if (uri.contains("saveEmp")) {
			//����Ա��
			saveEmp(req, res);
		} else if (uri.contains("deleteEmp")) {
			//ɾ��Ա��
			deleteEmp(req, res);
		}
	}

	protected void deleteEmp(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//1.��ȡ�������
		String id = req.getParameter("id");
		//2.����Ա��ɾ��
		EmpDao dao = new EmpDao();
		dao.delete(new Integer(id));
		//3.��ת��Ա���б�ҳ�棬���ڲ�ѯԱ��
		//��ɾ��Ա���Ƕ�����������˴˲�������
		//����ʹ���ض���ʵ�ֱ�����ת��
		res.sendRedirect("findEmp.do");
	}	
	
	protected void saveEmp(
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
	
	protected void findEmp(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
			//1.��ѯȫ����Ա��
			EmpDao dao = new EmpDao();
			List<Emp> list = dao.findAll();
			//2.��Ӧ�����HTML(����ȫ��Ա��)
			res.setContentType(
				"text/html;charset=utf-8");
			PrintWriter w = res.getWriter();
			//2.1�����̬���ֵ�HTML��
			//�������汾/��Ԫ��/head/body/table/������
			w.println("<!doctype html>");
			w.println("<html>");
			w.println("	<head>");
			w.println("		<meta charset='utf-8'/>");
			w.println("		<title>Ա���б�</title>");
			w.println("	</head>");
			w.println("	<body>");
			
			//��������
			//Ŀ��ҳ��:/EmpManager/add_emp.html
			//��ǰҳ��:/EmpManager/findEmp
			w.println("		<a href='add_emp.html'>����</a>");
			
			w.println("		<table width='40%' border='1px' cellspacing='0'>");
			w.println("			<tr>");
			w.println("				<th>���</th>");
			w.println("				<th>����</th>");
			w.println("				<th>н��</th>");
			w.println("				<th>����</th>");
			w.println("				<th></th>");
			w.println("			</tr>");
			
			//2.2�����̬���ֵ�HTML��
			//�����������У��ж��ٸ�Ա�����ж���������
			for(Emp e : list) {
				w.println("			<tr>");
				w.println("				<td>"+e.getId()+"</td>");
				w.println("				<td>"+e.getName()+"</td>");
				w.println("				<td>"+e.getSalary()+"</td>");
				w.println("				<td>"+e.getAge()+"</td>");
				w.println("				<td><a href='deleteEmp.do?id="+e.getId()+"'>ɾ��</a></td>");
				w.println("			</tr>");			
			}
			
			w.println("		</table>");
			w.println("	</body>");
			w.println("</html>");
			w.close();
		}	
	
}








