package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CostDaoImpl;
import dao.ICostDao;
import entity.Cost;

/**
 * 1.��Servlet�䵱������Controller����������
 *   ����Ŀ����������
 * 2.��Ҫ��Ӧ�����ݣ�ת������Ӧ��JSP����
 */
public class ActionServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//ͳһ���ñ���
		req.setCharacterEncoding("utf-8");
		res.setContentType(
			"text/html;charset=utf-8");
		//�ж�����·��
		String uri = req.getRequestURI();
		if(uri.contains("/cost/find")) {
			//�ʷѲ�ѯ
			findCost(req, res);
		}
	}

	//��ѯ�ʷ�
	protected void findCost(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//1.��ѯȫ���ʷ�
		ICostDao dao = new CostDaoImpl();
		List<Cost> list = dao.findAll();
		//2.������ת����jsp����jsp������ʾ��Щ����
		//2.1��jsp������
		//����1��������������2�����ݵ�ֵ��
		req.setAttribute("costs", list);
		//2.2������ת����jsp
		//Ŀ��:/netctoss/WEB-INF/cost/cost_list.jsp
		//��ǰ:/netctoss/cost/find.do
		String url = 
			"../WEB-INF/cost/cost_list.jsp";
		req.getRequestDispatcher(url)
			.forward(req, res);
	}
	
}








