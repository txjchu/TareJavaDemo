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
		// �ж�����·��
		// /netctoss/cost/xxx.do
		String uri = req.getRequestURI();
		System.out.println("����URI:" + uri);
		// /cost/xxx.do
		// req.getContextPath()����Ŀ������
		uri = uri.replace(
			req.getContextPath(), "");
		System.out.println("��ȡ���URI:" + uri);
		System.out.println(
			"������:" + req.getContextPath());
		if(uri.equals("/cost/find.do")) {
			//�ʷѲ�ѯ
			findCost(req, res);
		} else if (uri.equals("/cost/toAdd.do")) {
			//���ʷ�����ҳ
			toAddCost(req, res);
		} else if (uri.equals("/cost/add.do")) {
			//��������
			addCost(req, res);
		}
	}

	//���������ʷ�
	protected void addCost(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//��ȡ�������
		String name = req.getParameter("name");
		String costType = 
			req.getParameter("costType");
		String baseDuration = 
			req.getParameter("baseDuration");
		String baseCost = 
			req.getParameter("baseCost");
		String unitCost = 
			req.getParameter("unitCost");
		String descr = 
			req.getParameter("descr");
		//�����ʷѶ���
		Cost c = new Cost();
		c.setName(name);
		if(baseDuration != null
			&& !baseDuration.equals("")) {
			c.setBaseDuration(
				new Integer(baseDuration));
		}
		if(baseCost != null
			&& !baseCost.equals("")) {
			c.setBaseCost(
				new Double(baseCost));
		}
		if(unitCost != null
			&& !unitCost.equals("")) {
			c.setUnitCost(
				new Double(unitCost));
		}
		c.setDescr(descr);
		c.setCostType(costType);
		//��������
		ICostDao dao = new CostDaoImpl();
		dao.save(c);
		//�ض��򵽲�ѯ�ʷ�
		// /netctoss/cost/add.do
		// /netctoss/cost/find.do
		res.sendRedirect("find.do");
	}
	
	//���ʷ�����ҳ
	protected void toAddCost(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		// ��ǰ����(Servlet)�ķ���·��
		// /netctoss/cost/toAdd.do
		// jsp�ļ��Ĵ��·����ͨ����·�������ҵ�
		// jsp�������޷����ʣ���Ϊ�ܵ�WEB-INF�ı�����
		// ͨ��ת���Ϳ��Է������ˡ�
		// /netctoss/WEB-INF/cost/add_cost.jsp
		String url = "../WEB-INF/cost/add_cost.jsp";
		req.getRequestDispatcher(url)
			.forward(req, res);
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








