package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * ͨ������session������ͻ�������
 * @author Administrator
 *
 */
public class CountServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		//��ȡsession����
		HttpSession session = req.getSession();
		//���sessionId
		System.out.println(session.getId());
		//��ȡ�󶨼��������²��ж��Ƿ��ȡ��
		Integer count = (Integer) session.getAttribute("count");
		if(count == null){//��һ�η���
			count = 1;
		} else {//���ǵ�һ�η���
			count ++;
		}
		session.setAttribute("count", count);//��session��count
		//�����Ϣ
		out.println("���ǵ�"+ count +"�η��ʡ�");
		out.close();
		
			
		
		
		
		
		
		
		
		
	}
	
}
