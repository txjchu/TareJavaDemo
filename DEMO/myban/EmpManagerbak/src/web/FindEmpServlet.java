package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;

import emp.entity.Emp;
/**
 * ��ѯԱ��
 */
public class FindEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//�ڴ�������ķ����в�ѯԱ��
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("1");
			res.setContentType("text/html;charset=utf-8");
			PrintWriter w= res.getWriter();
			List<Emp> emps=new ArrayList<Emp>();
			try {
				emps=EmpDao.findAll();
				//��Ӧ�����HTML������ȫ��Ա����
				//1.�����̬���ֵ�HTML(���� �汾/��Ԫ��/head/body/table/�����У�
				w.println("<!doctype html>");
				w.println("<html>");
				w.println("	<head>");
				w.println("  		<meta charset='utf-8'/>");
				w.println("  		<title>Ա���б�</title>");
				w.println("	</head>");
				w.println("	<body>");
				//Ŀ�꣺/EmpManager/add_emp.html
				 //��ǰ��/EmpManager/findemp
				w.println("   <a href='add_emp.html'>����</a>");//��������
				w.println("       <table width='40%' border='1px' cellspacing='0'>");	
				w.println("				<tr >");
				w.println("      					<td>ID</td>");	
				w.println("      					<td>����</td>");	
				w.println("      					<td>����</td>");	
				w.println("      					<td>����</td>");	
				w.println(" 				</tr>");	
				//2.�����̬��HTML�����������У��ж��ٸ�Ա�����ж��ٸ�������
				for(Emp emp :emps){
					w.println("				<tr >");
					w.println("      					<td>"+emp.getId()+"</td>");	
					w.println("      					<td>"+emp.getName()+"</td>");	
					w.println("      					<td>"+emp.getSalary()+"</td>");	
					w.println("      					<td>"+emp.getAge()+"</td>");	
					w.println("                       <td><a href='delemp?id="+emp.getId()+"'>ɾ��</a></td>");
					w.println(" 				</tr>");	
				}
				w.println("       </table>");
				w.println("	</body>");
				w.println("</html>");
			} catch (Exception e) {	
				e.printStackTrace();
			}
			w.close();
	}
	
	
}
