package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 查询员工表的服务器类
 * @author Administrator
 *
 */
public class ListEmpServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {	
		res.setContentType("text/html;charset=utf-8");//编码
		req.setCharacterEncoding("utf-8");//解码
		PrintWriter out = res.getWriter();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//1.创建连接
			Class.class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "chris", "123456");
			ps = conn.prepareStatement("select * from t_emp order by id");
			rs = ps.executeQuery();
			//2.输出表格之前的标记
			out.println("<HTML>");
			out.println("<HEAD><title>员工信息列表</title></HEAD>");
			out.println("<BODY>");
			out.println("<table border='1' cellpadding='0' cellspacing='0' width='60%'>");
			out.println("<caption>员工信息列表</caption>");
			out.println("<tr><td>ID</td><td>姓名</td><td>薪水</td><td>年龄</td><td>操作</td></tr>");
			//3.遍历结果集，以表格形式输出数据
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double salary = rs.getDouble("salary");
				int age = rs.getInt("age");
				out.println("<tr><td>"+
						id+"</td><td>"+
						name+"</td><td>"+
						salary+"</td><td>"+
						age+"</td>"+		//链接a采用get方式提交请求，将数据id通过附加在链接之后提交给服务器。服务器通过req获取
						"<td><a href='delete?id="+ id +"' onclick=\"return confirm('是否确认删除"+name+"');\">删除</a>"+
						" <a href='load?id="+ id +"'>修改</a></td>"+
						"</tr>");
			}
			out.print("</table>");
			out.print("<a href='addEmp.html'>增加员工信息</a>");
			out.println("</BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("驱动类加载异常！");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("创建连接异常！");
			e.printStackTrace();
		} finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
}
