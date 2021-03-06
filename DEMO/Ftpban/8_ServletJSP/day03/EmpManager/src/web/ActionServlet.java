package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

/**
 *	该Servlet要处理所有的请求。
 */
public class ActionServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//由于该Servlet要处理所有请求，因此
		//必须判断出请求的来源，不同的来源其
		//业务有本质的区别。请求的来源看规范。
		// /EmpManager/xxx.do
		String uri = req.getRequestURI();
		if(uri.contains("findEmp")) {
			//查询员工
			findEmp(req, res);
		} else if (uri.contains("saveEmp")) {
			//新增员工
		} else if (uri.contains("deleteEmp")) {
			//删除员工
		}
	}

	protected void findEmp(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
			//1.查询全部的员工
			EmpDao dao = new EmpDao();
			List<Emp> list = dao.findAll();
			//2.响应：输出HTML(包含全部员工)
			res.setContentType(
				"text/html;charset=utf-8");
			PrintWriter w = res.getWriter();
			//2.1输出静态部分的HTML，
			//包括：版本/根元素/head/body/table/标题行
			w.println("<!doctype html>");
			w.println("<html>");
			w.println("	<head>");
			w.println("		<meta charset='utf-8'/>");
			w.println("		<title>员工列表</title>");
			w.println("	</head>");
			w.println("	<body>");
			
			//新增功能
			//目标页面:/EmpManager/add_emp.html
			//当前页面:/EmpManager/findEmp
			w.println("		<a href='add_emp.html'>新增</a>");
			
			w.println("		<table width='40%' border='1px' cellspacing='0'>");
			w.println("			<tr>");
			w.println("				<th>编号</th>");
			w.println("				<th>姓名</th>");
			w.println("				<th>薪资</th>");
			w.println("				<th>年龄</th>");
			w.println("				<th></th>");
			w.println("			</tr>");
			
			//2.2输出动态部分的HTML，
			//包括：数据行，有多少个员工就有多少数据行
			for(Emp e : list) {
				w.println("			<tr>");
				w.println("				<td>"+e.getId()+"</td>");
				w.println("				<td>"+e.getName()+"</td>");
				w.println("				<td>"+e.getSalary()+"</td>");
				w.println("				<td>"+e.getAge()+"</td>");
				w.println("				<td><a href='deleteEmp?id="+e.getId()+"'>删除</a></td>");
				w.println("			</tr>");			
			}
			
			w.println("		</table>");
			w.println("	</body>");
			w.println("</html>");
			w.close();
		}	
	
}








