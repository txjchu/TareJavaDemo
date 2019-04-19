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
 * 1.��Servlet�䵱������Controller�������������Ŀ����������
 * 2.��Ҫ��Ӧ�����ݣ�ת������Ӧ��JSP����
 * @author Administrator
 *
 */
public class ActionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//ͳһ���ñ���----һ�θ㶨
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		//�ж�����·��----����·��������֪����ǰ��ʲô���󣬽�����ô����		
		String uri = req.getRequestURI();
		System.out.println("����������uri:"+uri);
		//req.getContextPath()����Ŀ�Ĳ�������Ҳ����/netctoss
		uri=uri.replace(req.getContextPath(), "");
		System.out.println("���ǽ�ȡ���uri:"+uri);
		System.out.println("��������"+req.getContextPath());
		if(uri.equals("/cost/find.do")){
			//�ʷѲ�ѯ
			findcost(req,res);
		}else if(uri.equals("/cost/toAdd.do")){
			//��������	���ʹ��ʷ�����ҳ��
			toAddCost(req,res);
		}else if(uri.equals("/cost/add.do")){
			//��������
			addCost(req,res);
			
		}else if(uri.equals("/cost/toUpdate.do")){
			//���޸�ҳ��
			toUpdateCost(req,res);
		}else if(uri.equals("/cost/updateCost.do")){
			//�޸ı���
			updateCost(req,res);
		}else if(uri.equals("/login/toLogin.do")){
			//�򿪵�¼ҳ��
			toLogin(req,res);
		}else if(uri.equals("/login/toIndex.do")){
			//����ҳ
			toIndex(req,res);
		}else if(uri.equals("/login/login.do")){
			//��¼��֤
			login(req,res);
		}else if(uri.equals("/login/createImage.do")){
			//������֤ͼƬ
			createImage(req,res);
		}else{
			//û�����ҳ�棬������ʾ��(����404)
			throw new RuntimeException("û�����·������Tomcat������ת�����·��");
		}
	}
	
	/**
	 * ��¼��֤ 1.�˺��Ƿ���� 2.�����Ƿ���ȷ
	 * @param req
	 * @param res
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void login(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		//��������������������(�˺ź�����)
		String adminCode = req.getParameter("adminCode");
		String pwd = req.getParameter("password");
		
		//У����֤��----��У����֤�룬��У���˺�����
		String imageCode = req.getParameter("imageCode");
		HttpSession session = req.getSession();
		String code = (String)session.getAttribute("name");
		if(imageCode == null || imageCode.equals("") || !imageCode.equalsIgnoreCase(code)){//----����.equalsIgnoreCase(code)��֤����Դ�Сд�ķ�����
			//��֤����󣬸�����ʾ
			req.setAttribute("error", adminCode);
			req.setAttribute("adminCode",adminCode);
			req.setAttribute("password",pwd);
			//��֤�����ת���ص�¼ҳ����������ʾ
			String url = "../WEB-INF/login/login.jsp";
			req.getRequestDispatcher(url).forward(req, res);
			return;//----ת����֮�����Ҫ���أ�����������뻹�������
			
		}
		
		//������֤
		//1.�����˺Ų�ѯ����Ա
		IAdminDao dao = new AdminDaoImpl();
		Admin admin = dao.findByCode(adminCode);	
			//�ж�
		if(admin == null){//����
			//�˺Ų����ڣ�ת���ص�¼ҳ�档
			req.setAttribute("error","�˺Ŵ���");
			// ��ǰ��/netctoss/login/login.do
			// Ŀ�꣺/netctoss/WEB-INF/login/login.jsp
			String url = "../WEB-INF/login/login.jsp";
			req.getRequestDispatcher(url).forward(req, res);
		}else if(!admin.getPassword().equals(pwd)){		//----����˺���ȷ������֤�û���������롣
			//�������ת���ص�¼ҳ�档
			req.setAttribute("error","�������");
			//���˺����룬��������Ĭ��ֵ
			req.setAttribute("adminCode", adminCode);
			req.setAttribute("password", pwd);//----
			// ��ǰ��/netctoss/login/login.do
			// Ŀ�꣺/netctoss/WEB-INF/login/login.jsp
			String url = "../WEB-INF/login/login.jsp";
			req.getRequestDispatcher(url).forward(req, res);
			
			
		}else{
			//��¼�ɹ�ʱ�����˺Ŵ���session����ں�������¼���ʹ�á�----������תǰ��������ת����
			session.setAttribute("adminCode", adminCode);
			
			//�˺����붼��ȷ�����¼�ɹ����ض�����ҳ��
			// ��ǰ��/netctoss/login/login.do
			// Ŀ�꣺/netctoss/login/toindex.do
			res.sendRedirect("toindex.do");
		}
		
	}
	
	//�˳��ķ���
	private void logout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//�˳�ʱҪע��session���ͷ���Դ������session�е��������ڴ��ж��30���ӡ�
		HttpSession session = req.getSession();
		session.invalidate();
		//ɾ��session����Ҫ�ض��򵽵�¼ҳ��
		//Ŀ�꣺/netctoss/login/toLogin.do
		//��ǰ��/netctoss/login/logout.do
		res.sendRedirect("");
	}
	//������֤��ͼƬ
	private void createImage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1.������֤��ͼƬ
		Object[] objs = ImageUtil.createImage();	//----������֤�봴���ľ�̬����
		//2.��ȡ��֤�룬����session
		String code = (String) objs[0];
		HttpSession session = req.getSession();
		session.setAttribute("code", code);
		//3.��ȡͼƬ������������
		BufferedImage image = (BufferedImage) objs[1];
		res.setContentType("image/png");//----���������
		OutputStream os = res.getOutputStream();//-----���ͼƬ����ʽ��png
		ImageIO.write(image, "png", os);
		os.close();
	}	
	//ȥ��¼ҳ��ķ���
	private void toLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//ֱ��ת��----/netctoss/WEB-INF/login/login.jsp
		// 	   ----/netctoss/login//toLogin.do
		String url = "../WEB-INF/login/login.jsp";
		//��
		req.getRequestDispatcher(url).forward(req, res);
	}
	//ȥ��ҳ�ķ���
	private void toIndex(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//ֱ��ת��
		// /netctoss/WEB-INF/login/index.jsp
		// /netctoss/login/toIndex.do
		String url ="../WEB-INF/login/index.jsp";
		req.getRequestDispatcher(url).forward(req, res);
	}

	private void updateCost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//��ȡ�������
		String costID = req.getParameter("costID");
		String name = req.getParameter("name");
		String baseDuration = req.getParameter("baseDuration");
		String baseCost = req.getParameter("baseCost");
		String unitCost = req.getParameter("unitCost");
		String descr = req.getParameter("descr");
		String costType = req.getParameter("costType");
		//��װ��Щ����----������Cost���󣬷�װ����
		Cost c = new Cost();
		c.setCostID(new Integer(costID));
		c.setName(name);
		if(baseDuration !=null && !baseDuration.equals("")){			
			c.setBaseDuration(new Integer(baseDuration));
		}
		if(baseCost !=null && !baseCost.equals("")){
			c.setBaseCost(new Double(baseCost));
		}
		if(unitCost !=null && !baseCost.equals("")){
		c.setUnitCost(new Double(unitCost));
		}
		c.setDescr(descr);
		c.setCostType(costType);
		//�޸�����
		ICostDao dao = new CostDaoImpl();
		dao.update(c);
		//���¶��򷵻ز�ѯ
		//��ǰ��/netctoss/cost/update.do
		//Ŀ�꣺/netctoss/cost/find.do		
		res.sendRedirect("find.do");
	}
	// ���޸�ҳ�淽��
	private void toUpdateCost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//��ѯҪ�޸ĵ�����
		String id = req.getParameter("id");
		ICostDao dao = new CostDaoImpl();
		//ͨ��id��findById�Ķ����ҳ�����
		Cost cost = dao.findById(new Integer(id));
		//ת�����޸�ҳ�棬----�Ȱ����ݴ���ȥ
		req.setAttribute("cost", cost);
		//��ת��/netctoss/WEB-INF/cost/update_cost.jsp
		//��ǰ��/netctoss/cost/toUpdate.do
		String url = "../WEB-INF/cost/update_cost.jsp";
		req.getRequestDispatcher(url).forward(req, res);
	}

	//���������ʷѷ���
	protected void addCost(HttpServletRequest req, HttpServletResponse res)
						throws ServletException, IOException {
		//��ȡ�������----���ȣ����ύ���ݹ�������Ҫ����(�������������ˣ�)
		String name = req.getParameter("name");
		String costType = req.getParameter("costType");
		String baseDuration = req.getParameter("baseDuration");
		String baseCost = req.getParameter("baseCost");
		String unitCost = req.getParameter("unitCost");
		String descr = req.getParameter("descr");
		//�����ʷѶ���
		Cost c = new Cost();
		c.setName(name);
		
		//���...������null���Ҳ�Ϊ���ַ���������
		if(baseDuration !=null && !baseDuration.equals("")){			
			c.setBaseDuration(new Integer(baseDuration));
		}
		if(baseCost !=null && !baseCost.equals("")){
			c.setBaseCost(new Double(baseCost));			
		}
		if(unitCost !=null && !unitCost.equals("")){			
			c.setUnitCost(new Double(unitCost));
		}
		c.setDescr(descr);
		c.setCostType(costType);
		//��������
		ICostDao dao = new CostDaoImpl();
		dao.save(c);
		//�ض��򵽲�ѯ�ʷ�
		//��ǰ��/netctoss/cost/add.do
		//Ŀ��:/netctoss/cost/find.do
		res.sendRedirect("find.do");
		
	}
	
	protected void toAddCost(HttpServletRequest req, HttpServletResponse res)
						throws ServletException, IOException {

		//��ǰ����(Servlet)�ķ���·����	/netctoss/cost/toAdd.do
		//jsp�ļ��Ĵ��·����/netctoss/WEB-INF/cost/add_cost.jsp
				//ͨ����·�������ҵ�jsp�������޷����ʣ���Ϊ�ܵ�WEB-INF�ı���������ͨ����ת�����Ϳ��Է������ˡ�
		String url = "../WEB-INF/cost/add_cost.jsp";
		req.getRequestDispatcher(url).forward(req,res);
		
		
		//����url����ȡת������ת��������һ���࣬����.forward
//		req.getRequestDispatcher(url).forward(req, res);
				
	}
	
	protected void findcost(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
		//1.��ѯȫ���ʷ�
		ICostDao dao = new CostDaoImpl();
		List<Cost> list = dao.findAll();
		//2.������ת����jsp����jsp������ʾ��Щ���ݡ�
		//2.1��JSP������----����1���������ƣ�����2�����ݵ�ֵ
		req.setAttribute("costs", list);
		//2.2 ������ת����jsp-----һ�����ȴ����ݺ�ת����
		//Ŀ�꣺/netctoss/WEB-INF/cost/cost_list.jsp----����Ŀ�����WebRoot==��Ŀ���ļ�����ȡ��WebRoot��
		//��ǰ��/netctoss/cost/find.do
		
		String url = "../WEB-INF/cost/cost_list.jsp";//���·��
		//����url����ȡת������ת��������һ���࣬����.forward
		req.getRequestDispatcher(url).forward(req, res);
		
	}
	
}
