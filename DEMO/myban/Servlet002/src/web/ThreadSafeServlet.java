package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * day03����7 	�����̰߳�ȫ
 * @author Administrator
 *
 */
public class ThreadSafeServlet extends HttpServlet{
	//���ø�˽�����ԣ������̰߳�ȫ
	private int count = 0;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset= utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		//����ͬ�������½��̱߳���ȴ�֮ǰ�������̼߳�֮ǰ�����󷵻���Ӧ���˳���ͬ��������ܱ���������֤һ���߳������е�˽�����Եİ�ȫ������ͬʱ���޸ġ�
		synchronized (this) {
			count++;
			try {
				Thread.sleep(6000);//ģ�������ӳ٣������ڴ�ʱˢ�¶��ҳ�棬���Ͷ�����������޸�count��ֵ
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			out.println(Thread.currentThread().getName() + ":" + count);
		}
		
	}
	
}
