package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 创建修改员工信息的html页面，并将要修改的信息预放在文本框中
 * @author Administrator
 *
 */
public class LoadEmpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(req.getParameter("id"));//获取请求对象中消息头中的键值对信息
		PrintWriter out = res.getWriter();
//		System.out.println(id);
		
		//2.创建连接，访问数据库，根据Id查询出信息并返回
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "chris", "123456");
			String sql = "select * from t_emp where id = "+ id;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			out.println("<html><head></head><body style='font-size:30px'>");
			//3.将信息输出浏览器，创建新页面
			while(rs.next()){
				String name = rs.getString("name");
				double salary = rs.getDouble("salary");
				int age = rs.getInt("age");
				out.println("<form action='modify' method='post'>");//表单提交方式为post，请求的连接是modify
                out.println("编号:" + id + "<br>");
                out.println("<input type='hidden' name='id' value='"+id+"'/><br>");
                out.println("姓名:<input name='name' value='"+name+"'/><br>");
                out.println("薪水:<input name='salary' value='"+salary+"'/><br>");
                out.println("年龄:<input name='age' value='"+age+"'/><br>");
                out.println("<input type='submit' value='修改'/>");//创建提交按钮
                out.println("</form>");
			}
			out.println("</body></html>");
			out.close();
		} catch (SQLException e) {
			out.print("<h1>修改失败！</h1>");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("关闭连接失败！");
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
}
