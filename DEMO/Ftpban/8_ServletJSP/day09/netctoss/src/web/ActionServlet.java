package web;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.ImageUtil;
import dao.AdminDaoImpl;
import dao.CostDaoImpl;
import dao.IAdminDao;
import dao.ICostDao;
import entity.Admin;
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
		} else if (uri.equals("/cost/toUpdate.do")) {
			//���޸�ҳ
			toUpdateCost(req, res);
		} else if (uri.equals("/cost/update.do")) {
			//�޸ı���
			updateCost(req, res);
		} else if (uri.equals("/login/toLogin.do")) {
			//�򿪵�¼ҳ
			toLogin(req, res);
		} else if (uri.equals("/login/toIndex.do")) {
			//����ҳ
			toIndex(req, res);
		} else if (uri.equals("/login/login.do")) {
			//��¼��֤
			login(req, res);
		} else if(uri.equals("/login/createImage.do")) {
			//������֤��ͼƬ
			createImage(req, res);
		} else if (uri.equals("/login/logout.do")) {
			//�˳�
			logout(req, res);
		}else {
			//û��������󣬸�����ʾ
			throw new RuntimeException("û�����·��");
		}
	}
	
	//�˳�
	protected void logout(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//�˳�ʱҪע��session���ͷ���Դ��
		//����session�е��������ڴ��ж��30���ӡ�
		HttpSession session =  req.getSession();
		session.invalidate();
		//�ض��򵽵�¼ҳ
		// /netctoss/login/toLogin.do
		// /netctoss/login/logout.do
		res.sendRedirect("toLogin.do");
	}
	
	//������֤��ͼƬ
	protected void createImage(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//1.������֤��ͼƬ
		Object[] objs = ImageUtil.createImage();
		//2.��ȡ��֤�룬����session
		String code = (String) objs[0];
		HttpSession session = req.getSession();
		session.setAttribute("code", code);
		//3.��ȡͼƬ������������
		BufferedImage image = 
			(BufferedImage) objs[1];
		res.setContentType("image/png");
		OutputStream os = res.getOutputStream();
		ImageIO.write(image, "png", os);
		os.close();
	}
	
	//��¼��֤
	protected void login(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//���ձ�������
		String adminCode = 
			req.getParameter("adminCode");
		String pwd = 
			req.getParameter("password");
		//У����֤��
		String imageCode = 
			req.getParameter("imageCode");
		HttpSession session = req.getSession();
		String code = (String) 
			session.getAttribute("code");
		if(imageCode == null
			|| imageCode.equals("")
			|| !imageCode.equalsIgnoreCase(code)) {
			//��֤�����
			req.setAttribute("error", "��֤�����");
			req.setAttribute("adminCode", adminCode);
			req.setAttribute("password", pwd);
			//��֤�����ת���ص�¼ҳ����������ʾ
			String url = 
				"../WEB-INF/login/login.jsp";
			req.getRequestDispatcher(
				url).forward(req, res);
			return;
		}
		//������֤
		IAdminDao dao = new AdminDaoImpl();
		//�����˺Ų�ѯ����Ա
		Admin admin = dao.findByCode(adminCode);
		//�ж�
		if(admin == null) {
			//�˺Ų����ڣ�ת������¼ҳ
			req.setAttribute("error", "�˺Ų�����");
			//���˺����룬��������Ĭ��ֵ
			req.setAttribute("adminCode", adminCode);
			req.setAttribute("password", pwd);
			// /netctoss/login/login.do
			// /netctoss/WEB-INF/login/login.jsp
			String url = 
				"../WEB-INF/login/login.jsp";
			req.getRequestDispatcher(
				url).forward(req, res);
		} else if(!admin.getPassword().equals(pwd)) {
			//�������ת������¼ҳ
			req.setAttribute("error", "�������");
			//���˺����룬��������Ĭ��ֵ
			req.setAttribute("adminCode", adminCode);
			req.setAttribute("password", pwd);
			// /netctoss/login/login.do
			// /netctoss/WEB-INF/login/login.jsp
			String url = 
				"../WEB-INF/login/login.jsp";
			req.getRequestDispatcher(
				url).forward(req, res);
		} else {
			//��¼�ɹ�ʱ�����˺Ŵ���session��
			//���ں�������¼���ʹ�á�
			session.setAttribute(
				"adminCode", adminCode);
			
			//�˺����붼�ԣ���¼�ɹ����ض�����ҳ
			// /netctoss/login/login.do
			// /netctoss/login/toIndex.do
			res.sendRedirect("toIndex.do");
		}
	}
	
	//�򿪵�¼ҳ
	protected void toLogin(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		// /netctoss/WEB-INF/login/login.jsp
		// /netctoss/login/toLogin.do
		String url = "../WEB-INF/login/login.jsp";
		req.getRequestDispatcher(url)
			.forward(req, res);
	}
	
	//����ҳ
	protected void toIndex(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		// /netctoss/WEB-INF/login/index.jsp
		// /netctoss/login/toIndex.do
		String url = 
			"../WEB-INF/login/index.jsp";
		req.getRequestDispatcher(url)
			.forward(req, res);
	}	
	
	//�޸ı���
	protected void updateCost(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//��ȡ�������
		String costId = req.getParameter("costId");
		String name = req.getParameter("name");
		String baseDuration = 
			req.getParameter("baseDuration");
		String baseCost = 
			req.getParameter("baseCost");
		String unitCost = 
			req.getParameter("unitCost");
		String descr = req.getParameter("descr");
		String costType= 
			req.getParameter("costType");
		//��װ��Щ����
		Cost c = new Cost();
		c.setCostId(new Integer(costId));
		c.setName(name);
		if(baseDuration != null
			&& !baseDuration.equals("")) {
			c.setBaseDuration(
				new Integer(baseDuration));
		}
		if(baseCost != null
			&& !baseCost.equals("")) {
			c.setBaseCost(new Double(baseCost));
		}
		if(unitCost != null
			&& !unitCost.equals("")) {
			c.setUnitCost(new Double(unitCost));
		}
		c.setDescr(descr);
		c.setCostType(costType);
		//�޸�����
		ICostDao dao = new CostDaoImpl();
		dao.update(c);
		//�ض���ز�ѯ
		// /netctoss/cost/update.do
		// /netctoss/cost/find.do
		res.sendRedirect("find.do");
	}
	
	//���޸�ҳ
	protected void toUpdateCost(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//��ѯҪ�޸ĵ�����
		String id = req.getParameter("id");
		ICostDao dao = new CostDaoImpl();
		Cost cost = 
			dao.findById(new Integer(id));
		//ת�����޸�ҳ��
		req.setAttribute("cost", cost);
		// /netctoss/WEB-INF/cost/update_cost.jsp
		// /netctoss/cost/toUpdate.do
		String url = 
			"../WEB-INF/cost/update_cost.jsp";
		req.getRequestDispatcher(url)
			.forward(req, res);
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








