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
 * ��������
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
		
		//��ȡ�������Դ·��
		String uri = req.getRequestURI();
		System.out.println(uri);
		//��ȡ��Դ·���м��ȥӦ��������Ĳ���
		String action = uri.substring(uri.lastIndexOf("/")+ 1, uri.lastIndexOf("."));
		System.out.println(action);
		//�жϻ�ȡ����·������ʼ�ַ�����
		if(action.equals("list")){//��ѯ���м�¼
			try {
				EmpDao dao = new EmpDao();
				List<Employee> emps = dao.findAll();
				out.println("<table border='1' cellpadding='0' cellspacing='0' width='60%'>");
				out.println("<caption>Ա����Ϣ�б�</caption>");
				out.println("<tr><td>���</td><td>����</td><td>нˮ</td><td>����</td><td>����</td></tr>");
				for (Employee emp : emps) {
					out.println("<tr>");
					out.println("<td>" + emp.getId() + "</td>");
					out.println("<td>" + emp.getName() + "</td>");
					out.println("<td>" + emp.getSalary() + "</td>");
					out.println("<td>" + emp.getAge() + "</td>");
					out.println("<td><a href='#'>ɾ��</a>");
					out.println("<a href='#'>�޸�</a></td>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.println("<a href='addEmp.html'>������Ա��</a>");
			} catch (Exception e) {
				e.printStackTrace();
				out.println("ϵͳ��æ���Ժ����ԣ�");
			}
		} else if(action.equals("add")){//���Ա��
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
				out.print("���ʧ�ܣ�");
			}
		} else if(action.equals("")){//ɾ��Ա��
			
		}
		
		
	}
	
}














