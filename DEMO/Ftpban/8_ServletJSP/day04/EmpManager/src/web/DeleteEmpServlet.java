package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;

public class DeleteEmpServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//1.获取请求参数
		String id = req.getParameter("id");
		//2.将此员工删除
		EmpDao dao = new EmpDao();
		dao.delete(new Integer(id));
		//3.跳转至员工列表页面，由于查询员工
		//和删除员工是独立的组件，彼此不依赖，
		//所以使用重定向实现本次跳转。
		res.sendRedirect("findEmp");
	}
	
}






