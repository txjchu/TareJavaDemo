package web;
/**
 * ��ServletҪ�������е�����
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class ActionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//���ڸ�ServletҪ��������������˱����жϳ��������Դ����ͬ����Դ��ҵ���б��ʵ�����
		//�������Դ���淶(����Լ��)��
		String uri = req.getRequestURI();
		if(uri.contains("findEmp")){
			//��ѯԱ��
			findEmp(req,res);
		}else if(uri.contains("saveEmp")){
			//����Ա��
			
		}else if(uri.contains("deleteEmp")){
			//ɾ��Ա��
			
		}
	}
	//�ڴ�������ķ����в�ѯԱ��
	//----@Override----�������ǻᱨ��
	protected void findEmp(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//1.ֱ�Ӳ�ѯȫ����Ա��
		EmpDao dao = new EmpDao();
		List<Emp> list = dao.findAll();
		//2.��Ӧ�����HTML(����ȫ��Ա��)
		res.setContentType("text/html;charset=utf-8");		//----���ã�����ת��
		PrintWriter w = res.getWriter();
			//----��Ϊ2���֣�һ���־�̬��һ���ֶ�̬��
			//2.1�����̬���ֵ�HTML�������汾��������Ԫ�أ�head,body,table,������
			w.println("<!doctype html>");
			w.println("<html>");
			w.println("	<head>");
			w.println("		<meta charset='utf-8'/>");
			w.println("		<title>��ѯ����Ա���б�</title>");
			w.println("		");
			w.println("	</head>");
			w.println("	<body>");
			
			//������¼���ܵİ�ť�ĳ�����----����ǰҳ���ϵİ�ť������·����
			//��ǰҳ��·����/EmpManager/findEmp
			//Ŀ��ҳ��·����/EmpManager/add_emp.html(����WebRoot��)
			w.println("		<a href='add_emp.html'>����+</a>");
			
			w.println("		<table width='40%' border='1px' cellspacing='0'>");//----cellspacing��ʽ�Ŀո���0������table��td֮��Ŀ�϶
			w.println("			<tr>");	//----��
			w.println("				<th>���</th>");//----��ͷ��th���Դ���ʽ���Ӵ֣����壬����
			w.println("				<th>����</th>");
			w.println("				<th>н��</th>");
			w.println("				<th>����</th>");
			w.println("				<th></th>");
			w.println("			</tr>");
			
			//2.2�����̬���ֵ�HTML������������(�ж���Ա�����ж���������)
			for(Emp e :list){		//----��ѭ��
				w.println("			<tr>");	//----��
				w.println("				<td>"+e.getId()+"</td>");//----������td----��Ҫ��̬ƴ������
				w.println("				<td>"+e.getName()+"</td>");
				w.println("				<td>"+e.getSalary()+"</td>");
				w.println("				<td>"+e.getAge()+"</td>");
				w.println("<td><a href='deleteEmp?id="+e.getId()+"'>ɾ����ť</a></td>");
				w.println("			</tr>");
			}
		
		//����PrintWriter֮��Ҫ�رգ��ڹر�֮ǰд��������
			w.println("		</table>");
			w.println("	</body>");
			w.println("</html>");
			w.close();		
	}
	
}
