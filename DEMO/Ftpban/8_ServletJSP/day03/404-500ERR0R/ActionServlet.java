package web;
/**
 * 该Servlet要处理所有的请求。
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class ActionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//由于该Servlet要处理所有请求，因此必须判断出请求的来源，不同的来源其业务有本质的区别。
		//请求的来源看规范(事先约定)。
		String uri = req.getRequestURI();
		if(uri.contains("findEmp")){
			//查询员工
			findEmp(req,res);
		}else if(uri.contains("saveEmp")){
			//新增员工
			
		}else if(uri.contains("deleteEmp")){
			//删除员工
			
		}
	}
	//在处理请求的方法中查询员工
	//----@Override----有这个标记会报错
	protected void findEmp(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//1.直接查询全部的员工
		EmpDao dao = new EmpDao();
		List<Emp> list = dao.findAll();
		//2.响应：输出HTML(包含全部员工)
		res.setContentType("text/html;charset=utf-8");		//----设置，字体转换
		PrintWriter w = res.getWriter();
			//----分为2部分，一部分静态，一部分动态。
			//2.1输出静态部分的HTML：包括版本声明，根元素，head,body,table,标题行
			w.println("<!doctype html>");
			w.println("<html>");
			w.println("	<head>");
			w.println("		<meta charset='utf-8'/>");
			w.println("		<title>查询出的员工列表</title>");
			w.println("		");
			w.println("	</head>");
			w.println("	<body>");
			
			//新增记录功能的按钮的超链接----【当前页面上的按钮的连接路径】
			//当前页面路径：/EmpManager/findEmp
			//目标页面路径：/EmpManager/add_emp.html(放在WebRoot下)
			w.println("		<a href='add_emp.html'>新增+</a>");
			
			w.println("		<table width='40%' border='1px' cellspacing='0'>");//----cellspacing格式的空格是0，消除table和td之间的空隙
			w.println("			<tr>");	//----行
			w.println("				<th>编号</th>");//----表头用th，自带格式：加粗，黑体，居中
			w.println("				<th>姓名</th>");
			w.println("				<th>薪资</th>");
			w.println("				<th>年龄</th>");
			w.println("				<th></th>");
			w.println("			</tr>");
			
			//2.2输出动态部分的HTML：包括数据行(有多少员工就有多少数据行)
			for(Emp e :list){		//----新循环
				w.println("			<tr>");	//----行
				w.println("				<td>"+e.getId()+"</td>");//----行中列td----需要动态拼接内容
				w.println("				<td>"+e.getName()+"</td>");
				w.println("				<td>"+e.getSalary()+"</td>");
				w.println("				<td>"+e.getAge()+"</td>");
				w.println("<td><a href='deleteEmp?id="+e.getId()+"'>删除按钮</a></td>");
				w.println("			</tr>");
			}
		
		//用完PrintWriter之后要关闭，在关闭之前写输出，输出
			w.println("		</table>");
			w.println("	</body>");
			w.println("</html>");
			w.close();		
	}
	
}
