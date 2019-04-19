package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 删除功能服务类
 * @author Administrator
 *
 */
public class DeleteEmpServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(req.getParameter("id"));
		Connection conn = null;
		PreparedStatement ps = null;
//		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "chris", "123456");
			String sql = "delete from t_emp where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int flag = ps.executeUpdate();
			if(flag > 0){
				System.out.println("删除成功!");
				res.sendRedirect("/Servlet002/list");
			} else {
				System.out.println("删除数据失败！");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动异常！");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("操作数据库异常！");
			e.printStackTrace();
		} finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("关闭连接异常！");
					e.printStackTrace();
				}
			}
		}
	}
	
}
