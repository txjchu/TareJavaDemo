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
		}
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








