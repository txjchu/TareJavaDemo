package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;

import emp.entity.Emp;
/**
 * 查询员工
 */
public class FindEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//在处理请求的方法中查询员工
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("1");
			res.setContentType("text/html;charset=utf-8");
			PrintWriter w= res.getWriter();
			List<Emp> emps=new ArrayList<Emp>();
			try {
				emps=EmpDao.findAll();
				//响应：输出HTML（包含全部员工）
				//1.输出静态部分的HTML(包含 版本/根元素/head/body/table/标题行）
				w.println("<!doctype html>");
				w.println("<html>");
				w.println("	<head>");
				w.println("  		<meta charset='utf-8'/>");
				w.println("  		<title>员工列表</title>");
				w.println("	</head>");
				w.println("	<body>");
				//目标：/EmpManager/add_emp.html
				 //当前：/EmpManager/findemp
				w.println("   <a href='add_emp.html'>新增</a>");//新增功能
				w.println("       <table width='40%' border='1px' cellspacing='0'>");	
				w.println("				<tr >");
				w.println("      					<td>ID</td>");	
				w.println("      					<td>名字</td>");	
				w.println("      					<td>工资</td>");	
				w.println("      					<td>年龄</td>");	
				w.println(" 				</tr>");	
				//2.输出动态的HTML包括：数据行，有多少个员工就有多少个数据行
				for(Emp emp :emps){
					w.println("				<tr >");
					w.println("      					<td>"+emp.getId()+"</td>");	
					w.println("      					<td>"+emp.getName()+"</td>");	
					w.println("      					<td>"+emp.getSalary()+"</td>");	
					w.println("      					<td>"+emp.getAge()+"</td>");	
					w.println("                       <td><a href='delemp?id="+emp.getId()+"'>删除</a></td>");
					w.println(" 				</tr>");	
				}
				w.println("       </table>");
				w.println("	</body>");
				w.println("</html>");
			} catch (Exception e) {	
				e.printStackTrace();
			}
			w.close();
	}
	
	
}
