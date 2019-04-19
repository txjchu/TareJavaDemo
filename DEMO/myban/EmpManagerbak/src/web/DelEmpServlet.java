package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;

public class DelEmpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

@Override
protected void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
	        req.setCharacterEncoding("utf-8");
	       String id=req.getParameter("id");
	        EmpDao.delete(new Integer(id));
	        //由于删除员工和查询员工是两个独立的组件，所以使用重定向实现本次跳转
	        res.sendRedirect("findemp");
}
}
