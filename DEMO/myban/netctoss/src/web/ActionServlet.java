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
 * 1.此Servlet充当控制器Controller，用来处理该项目的所有请求。
 * 2.需要响应的数据，转发给对应的JSP处理。
 * @author Administrator
 *
 */
public class ActionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//统一设置编码----一次搞定
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		//判断请求路径----根据路径，可以知道当前是什么请求，进而怎么处理。		
		String uri = req.getRequestURI();
		System.out.println("这是完整的uri:"+uri);
		//req.getContextPath()是项目的部署名，也就是/netctoss
		uri=uri.replace(req.getContextPath(), "");
		System.out.println("这是截取后的uri:"+uri);
		System.out.println("部署名："+req.getContextPath());
		if(uri.equals("/cost/find.do")){
			//资费查询
			findcost(req,res);
		}else if(uri.equals("/cost/toAdd.do")){
			//如果是这个	，就打开资费增加页面
			toAddCost(req,res);
		}else if(uri.equals("/cost/add.do")){
			//新增保存
			addCost(req,res);
			
		}else if(uri.equals("/cost/toUpdate.do")){
			//打开修改页面
			toUpdateCost(req,res);
		}else if(uri.equals("/cost/updateCost.do")){
			//修改保存
			updateCost(req,res);
		}else if(uri.equals("/login/toLogin.do")){
			//打开登录页面
			toLogin(req,res);
		}else if(uri.equals("/login/toIndex.do")){
			//打开首页
			toIndex(req,res);
		}else if(uri.equals("/login/login.do")){
			//登录验证
			login(req,res);
		}else if(uri.equals("/login/createImage.do")){
			//创建验证图片
			createImage(req,res);
		}else{
			//没有这个页面，给予提示，(返回404)
			throw new RuntimeException("没有这个路径。给Tomcat，它会转发这个路径");
		}
	}
	
	/**
	 * 登录验证 1.账号是否存在 2.密码是否正确
	 * @param req
	 * @param res
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void login(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		//接收请求表单传入参数数据(账号和密码)
		String adminCode = req.getParameter("adminCode");
		String pwd = req.getParameter("password");
		
		//校验验证码----先校验验证码，后校验账号密码
		String imageCode = req.getParameter("imageCode");
		HttpSession session = req.getSession();
		String code = (String)session.getAttribute("name");
		if(imageCode == null || imageCode.equals("") || !imageCode.equalsIgnoreCase(code)){//----【】.equalsIgnoreCase(code)验证码忽略大小写的方法。
			//验证码错误，给个提示
			req.setAttribute("error", adminCode);
			req.setAttribute("adminCode",adminCode);
			req.setAttribute("password",pwd);
			//验证码错误，转发回登录页，并给予提示
			String url = "../WEB-INF/login/login.jsp";
			req.getRequestDispatcher(url).forward(req, res);
			return;//----转发完之后必须要返回，否则后续代码还会继续。
			
		}
		
		//进行验证
		//1.根据账号查询管理员
		IAdminDao dao = new AdminDaoImpl();
		Admin admin = dao.findByCode(adminCode);	
			//判断
		if(admin == null){//【】
			//账号不存在，转发回登录页面。
			req.setAttribute("error","账号错误！");
			// 当前：/netctoss/login/login.do
			// 目标：/netctoss/WEB-INF/login/login.jsp
			String url = "../WEB-INF/login/login.jsp";
			req.getRequestDispatcher(url).forward(req, res);
		}else if(!admin.getPassword().equals(pwd)){		//----如果账号正确，则验证用户输入的密码。
			//密码错误，转发回登录页面。
			req.setAttribute("error","密码错误！");
			//传账号密码，便于设置默认值
			req.setAttribute("adminCode", adminCode);
			req.setAttribute("password", pwd);//----
			// 当前：/netctoss/login/login.do
			// 目标：/netctoss/WEB-INF/login/login.jsp
			String url = "../WEB-INF/login/login.jsp";
			req.getRequestDispatcher(url).forward(req, res);
			
			
		}else{
			//登录成功时，将账号存入session里，便于后续做登录检查使用。----放在跳转前，避免跳转出错
			session.setAttribute("adminCode", adminCode);
			
			//账号密码都正确，则登录成功，重定向到首页。
			// 当前：/netctoss/login/login.do
			// 目标：/netctoss/login/toindex.do
			res.sendRedirect("toindex.do");
		}
		
	}
	
	//退出的方法
	private void logout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//退出时要注销session，释放资源。避免session中的数据在内存中多存30分钟。
		HttpSession session = req.getSession();
		session.invalidate();
		//删除session后需要重定向到登录页面
		//目标：/netctoss/login/toLogin.do
		//当前：/netctoss/login/logout.do
		res.sendRedirect("");
	}
	//创建验证码图片
	private void createImage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1.创建验证码图片
		Object[] objs = ImageUtil.createImage();	//----调用验证码创建的静态方法
		//2.获取验证码，存入session
		String code = (String) objs[0];
		HttpSession session = req.getSession();
		session.setAttribute("code", code);
		//3.获取图片，输出给浏览器
		BufferedImage image = (BufferedImage) objs[1];
		res.setContentType("image/png");//----调用这个流
		OutputStream os = res.getOutputStream();//-----输出图片，格式是png
		ImageIO.write(image, "png", os);
		os.close();
	}	
	//去登录页面的方法
	private void toLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//直接转发----/netctoss/WEB-INF/login/login.jsp
		// 	   ----/netctoss/login//toLogin.do
		String url = "../WEB-INF/login/login.jsp";
		//将
		req.getRequestDispatcher(url).forward(req, res);
	}
	//去主页的方法
	private void toIndex(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//直接转发
		// /netctoss/WEB-INF/login/index.jsp
		// /netctoss/login/toIndex.do
		String url ="../WEB-INF/login/index.jsp";
		req.getRequestDispatcher(url).forward(req, res);
	}

	private void updateCost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//获取请求参数
		String costID = req.getParameter("costID");
		String name = req.getParameter("name");
		String baseDuration = req.getParameter("baseDuration");
		String baseCost = req.getParameter("baseCost");
		String unitCost = req.getParameter("unitCost");
		String descr = req.getParameter("descr");
		String costType = req.getParameter("costType");
		//封装这些数据----创建个Cost对象，封装它们
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
		//修改它们
		ICostDao dao = new CostDaoImpl();
		dao.update(c);
		//重新定向返回查询
		//当前：/netctoss/cost/update.do
		//目标：/netctoss/cost/find.do		
		res.sendRedirect("find.do");
	}
	// 打开修改页面方法
	private void toUpdateCost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//查询要修改的数据
		String id = req.getParameter("id");
		ICostDao dao = new CostDaoImpl();
		//通过id把findById的对象找出来。
		Cost cost = dao.findById(new Integer(id));
		//转发到修改页面，----先把数据传过去
		req.setAttribute("cost", cost);
		//跳转到/netctoss/WEB-INF/cost/update_cost.jsp
		//当前：/netctoss/cost/toUpdate.do
		String url = "../WEB-INF/cost/update_cost.jsp";
		req.getRequestDispatcher(url).forward(req, res);
	}

	//新增保存资费方法
	protected void addCost(HttpServletRequest req, HttpServletResponse res)
						throws ServletException, IOException {
		//获取请求参数----首先，表单提交数据过来，先要接收(不用声明编码了，)
		String name = req.getParameter("name");
		String costType = req.getParameter("costType");
		String baseDuration = req.getParameter("baseDuration");
		String baseCost = req.getParameter("baseCost");
		String unitCost = req.getParameter("unitCost");
		String descr = req.getParameter("descr");
		//构造资费对象
		Cost c = new Cost();
		c.setName(name);
		
		//如果...不等与null并且不为空字符串，【】
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
		//保存数据
		ICostDao dao = new CostDaoImpl();
		dao.save(c);
		//重定向到查询资费
		//当前：/netctoss/cost/add.do
		//目标:/netctoss/cost/find.do
		res.sendRedirect("find.do");
		
	}
	
	protected void toAddCost(HttpServletRequest req, HttpServletResponse res)
						throws ServletException, IOException {

		//当前方法(Servlet)的访问路径：	/netctoss/cost/toAdd.do
		//jsp文件的存放路径：/netctoss/WEB-INF/cost/add_cost.jsp
				//通过改路径可以找到jsp，但是无法访问，因为受到WEB-INF的保护。但是通过【转发】就可以访问它了。
		String url = "../WEB-INF/cost/add_cost.jsp";
		req.getRequestDispatcher(url).forward(req,res);
		
		
		//传入url，获取转发器，转发器就是一格类，调用.forward
//		req.getRequestDispatcher(url).forward(req, res);
				
	}
	
	protected void findcost(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
		//1.查询全部资费
		ICostDao dao = new CostDaoImpl();
		List<Cost> list = dao.findAll();
		//2.将数据转发给jsp，由jsp负责显示这些数据。
		//2.1给JSP传数据----参数1是数据名称，参数2是数据的值
		req.setAttribute("costs", list);
		//2.2 将请求转发到jsp-----一定是先传数据后转发。
		//目标：/netctoss/WEB-INF/cost/cost_list.jsp----当项目部署后，WebRoot==项目名文件，并取消WebRoot层
		//当前：/netctoss/cost/find.do
		
		String url = "../WEB-INF/cost/cost_list.jsp";//相对路径
		//传入url，获取转发器，转发器就是一格类，调用.forward
		req.getRequestDispatcher(url).forward(req, res);
		
	}
	
}
