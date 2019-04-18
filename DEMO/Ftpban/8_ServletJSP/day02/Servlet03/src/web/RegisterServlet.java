package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//����post�����ڻ�ȡ����ǰ�����ñ���
		//Ϊutf-8�����ɽ���������⡣
		req.setCharacterEncoding("utf-8");
		//ͨ��request���Ի�ȡ���������
		//���ۻ�ȡ����ֵ�����Ƕ��ֵ����ͨ��name��
		//���صĲ���������String/String[]��
		String code = req.getParameter("code");
		//����get����������Ĳ�������������iso8859-1
		//��ԭ��byte������utf-8��byte����ΪString��
//		code = new String(
//			code.getBytes("iso8859-1"), "utf-8");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		String[] loves = 
			req.getParameterValues("love");
		//�������
		System.out.println(code);
		System.out.println(pwd);
		System.out.println(sex);
		if(loves != null) {
			for(String love : loves) {
				System.out.println(love);
			}
		}
		
		//������Ӧ
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		w.println("<h1>ע��ɹ�.</h1>");
		w.close();
	}

	
	
	
	
	
}
