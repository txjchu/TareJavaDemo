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
			saveEmp(req, res);
		} else if (uri.contains("deleteEmp")) {
			//删除员工
			deleteEmp(req, res);
		}
	}

	protected void deleteEmp(
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
		res.sendRedirect("findEmp.do");
	}	
	
	protected void saveEmp(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//1.接收传入的数据
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String salary = req.getParameter("salary");
		String age = req.getParameter("age");
		//2.构造员工对象
		Emp emp = new Emp();
		emp.setName(name);
		emp.setSalary(new Double(salary));
		emp.setAge(new Integer(age));
		//3.保存员工
		EmpDao dao = new EmpDao();
		dao.save(emp);
		//4.响应：跳转至员工列表页面(重定向)
		//当前：/EmpManager/addEmp
		//目标：/EmpManager/findEmp
		/*
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		w.println("<h1>新增成功</h1>");
		w.close();
		*/
		res.sendRedirect("findEmp.do");
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
				w.println("				<td><a href='deleteEmp.do?id="+e.getId()+"'>删除</a></td>");
				w.println("			</tr>");			
			}
			
			w.println("		</table>");
			w.println("	</body>");
			w.println("</html>");
			w.close();
		}	
	
}








