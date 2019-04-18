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
 * 1.此Servlet充当控制器Controller，用来处理
 *   该项目的所有请求。
 * 2.需要响应的数据，转发给对应的JSP处理。
 */
public class ActionServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//统一设置编码
		req.setCharacterEncoding("utf-8");
		res.setContentType(
			"text/html;charset=utf-8");
		// 判断请求路径
		// /netctoss/cost/xxx.do
		String uri = req.getRequestURI();
		System.out.println("完整URI:" + uri);
		// /cost/xxx.do
		// req.getContextPath()是项目部署名
		uri = uri.replace(
			req.getContextPath(), "");
		System.out.println("截取后的URI:" + uri);
		System.out.println(
			"部署名:" + req.getContextPath());
		if(uri.equals("/cost/find.do")) {
			//资费查询
			findCost(req, res);
		} else if (uri.equals("/cost/toAdd.do")) {
			//打开资费增加页
			toAddCost(req, res);
		} else if (uri.equals("/cost/add.do")) {
			//新增保存
			addCost(req, res);
		} else if (uri.equals("/cost/toUpdate.do")) {
			//打开修改页
			toUpdateCost(req, res);
		} else if (uri.equals("/cost/update.do")) {
			//修改保存
			updateCost(req, res);
		} else if (uri.equals("/login/toLogin.do")) {
			//打开登录页
			toLogin(req, res);
		} else if (uri.equals("/login/toIndex.do")) {
			//打开首页
			toIndex(req, res);
		} else if (uri.equals("/login/login.do")) {
			//登录验证
			login(req, res);
		} else if(uri.equals("/login/createImage.do")) {
			//创建验证码图片
			createImage(req, res);
		} else if (uri.equals("/login/logout.do")) {
			//退出
			logout(req, res);
		}else {
			//没有这个请求，给予提示
			throw new RuntimeException("没有这个路径");
		}
	}
	
	//退出
	protected void logout(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//退出时要注销session，释放资源。
		//避免session中的数据在内存中多存30分钟。
		HttpSession session =  req.getSession();
		session.invalidate();
		//重定向到登录页
		// /netctoss/login/toLogin.do
		// /netctoss/login/logout.do
		res.sendRedirect("toLogin.do");
	}
	
	//创建验证码图片
	protected void createImage(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//1.创建验证码图片
		Object[] objs = ImageUtil.createImage();
		//2.获取验证码，存入session
		String code = (String) objs[0];
		HttpSession session = req.getSession();
		session.setAttribute("code", code);
		//3.获取图片，输出给浏览器
		BufferedImage image = 
			(BufferedImage) objs[1];
		res.setContentType("image/png");
		OutputStream os = res.getOutputStream();
		ImageIO.write(image, "png", os);
		os.close();
	}
	
	//登录验证
	protected void login(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//接收表单的数据
		String adminCode = 
			req.getParameter("adminCode");
		String pwd = 
			req.getParameter("password");
		//校验验证码
		String imageCode = 
			req.getParameter("imageCode");
		HttpSession session = req.getSession();
		String code = (String) 
			session.getAttribute("code");
		if(imageCode == null
			|| imageCode.equals("")
			|| !imageCode.equalsIgnoreCase(code)) {
			//验证码错误
			req.setAttribute("error", "验证码错误");
			req.setAttribute("adminCode", adminCode);
			req.setAttribute("password", pwd);
			//验证码错误，转发回登录页，并给予提示
			String url = 
				"../WEB-INF/login/login.jsp";
			req.getRequestDispatcher(
				url).forward(req, res);
			return;
		}
		//进行验证
		IAdminDao dao = new AdminDaoImpl();
		//根据账号查询管理员
		Admin admin = dao.findByCode(adminCode);
		//判断
		if(admin == null) {
			//账号不存在，转发到登录页
			req.setAttribute("error", "账号不存在");
			//传账号密码，便于设置默认值
			req.setAttribute("adminCode", adminCode);
			req.setAttribute("password", pwd);
			// /netctoss/login/login.do
			// /netctoss/WEB-INF/login/login.jsp
			String url = 
				"../WEB-INF/login/login.jsp";
			req.getRequestDispatcher(
				url).forward(req, res);
		} else if(!admin.getPassword().equals(pwd)) {
			//密码错误，转发到登录页
			req.setAttribute("error", "密码错误");
			//传账号密码，便于设置默认值
			req.setAttribute("adminCode", adminCode);
			req.setAttribute("password", pwd);
			// /netctoss/login/login.do
			// /netctoss/WEB-INF/login/login.jsp
			String url = 
				"../WEB-INF/login/login.jsp";
			req.getRequestDispatcher(
				url).forward(req, res);
		} else {
			//登录成功时，将账号存入session。
			//便于后续做登录检查使用。
			session.setAttribute(
				"adminCode", adminCode);
			
			//账号密码都对，登录成功，重定向到首页
			// /netctoss/login/login.do
			// /netctoss/login/toIndex.do
			res.sendRedirect("toIndex.do");
		}
	}
	
	//打开登录页
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
	
	//打开首页
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
	
	//修改保存
	protected void updateCost(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//获取请求参数
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
		//封装这些数据
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
		//修改它们
		ICostDao dao = new CostDaoImpl();
		dao.update(c);
		//重定向回查询
		// /netctoss/cost/update.do
		// /netctoss/cost/find.do
		res.sendRedirect("find.do");
	}
	
	//打开修改页
	protected void toUpdateCost(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//查询要修改的数据
		String id = req.getParameter("id");
		ICostDao dao = new CostDaoImpl();
		Cost cost = 
			dao.findById(new Integer(id));
		//转发到修改页面
		req.setAttribute("cost", cost);
		// /netctoss/WEB-INF/cost/update_cost.jsp
		// /netctoss/cost/toUpdate.do
		String url = 
			"../WEB-INF/cost/update_cost.jsp";
		req.getRequestDispatcher(url)
			.forward(req, res);
	}
	
	//新增保存资费
	protected void addCost(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//获取请求参数
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
		//构造资费对象
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
		//保存数据
		ICostDao dao = new CostDaoImpl();
		dao.save(c);
		//重定向到查询资费
		// /netctoss/cost/add.do
		// /netctoss/cost/find.do
		res.sendRedirect("find.do");
	}
	
	//打开资费增加页
	protected void toAddCost(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		// 当前方法(Servlet)的访问路径
		// /netctoss/cost/toAdd.do
		// jsp文件的存放路径，通过该路径可以找到
		// jsp，但是无法访问，因为受到WEB-INF的保护。
		// 通过转发就可以访问它了。
		// /netctoss/WEB-INF/cost/add_cost.jsp
		String url = "../WEB-INF/cost/add_cost.jsp";
		req.getRequestDispatcher(url)
			.forward(req, res);
	}
	
	//查询资费
	protected void findCost(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//1.查询全部资费
		ICostDao dao = new CostDaoImpl();
		List<Cost> list = dao.findAll();
		//2.将数据转发给jsp，由jsp负责显示这些数据
		//2.1给jsp传数据
		//参数1是数据名，参数2是数据的值。
		req.setAttribute("costs", list);
		//2.2将请求转发到jsp
		//目标:/netctoss/WEB-INF/cost/cost_list.jsp
		//当前:/netctoss/cost/find.do
		String url = 
			"../WEB-INF/cost/cost_list.jsp";
		req.getRequestDispatcher(url)
			.forward(req, res);
	}
	
}








