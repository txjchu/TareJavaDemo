package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 修改数据表的服务器类
 * @author Administrator
 *
 */
public class ModifyEmpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		Connection conn = null;
		PreparedStatement ps = null;
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		double salary = Double.parseDouble(req.getParameter("salary"));
		int age = Integer.parseInt(req.getParameter("age"));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "chris", "123456");
			String sql = "update t_emp set name = ?, salary = ?,age = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDouble(2, salary);
			ps.setInt(3, age);
			ps.setInt(4, id);
			int flag = ps.executeUpdate();
			if(flag > 0){
				res.sendRedirect("/Servlet002/list");//若修改成功，则返回list页面
			} else {
				out.print("<h1>修改信息失败！</h1>");
			}
			out.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
