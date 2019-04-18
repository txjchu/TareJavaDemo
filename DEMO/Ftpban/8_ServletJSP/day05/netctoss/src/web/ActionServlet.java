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
		//判断请求路径
		String uri = req.getRequestURI();
		if(uri.contains("/cost/find")) {
			//资费查询
			findCost(req, res);
		}
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








