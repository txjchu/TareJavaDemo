package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;

public class DeleteEmpServlet extends HttpServlet {

	@Override
	protected void service(
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
		res.sendRedirect("findEmp");
	}
	
}






