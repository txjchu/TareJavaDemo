package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ����һ�ΰ���
 * @author Administrator
 *
 */
public class HiServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");//��֪�������ʲô���͵��ļ�
		res.setCharacterEncoding("utf-8");//��֪���������ʲô���͵��ַ���
		//1.��ȡ�����
		PrintWriter pw = res.getWriter();//����Ӧ�����л�ȡ�����
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = sdf.format(date);
		//2.������������Ϣ
		pw.println("<input type='text' value = 'Hi,'>" +
					"<p>now:"+ now +"</p>");
		pw.close();
	}
	
}
