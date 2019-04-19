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
 * 添加员工的服务器类
 * @author Administrator
 *
 */
public class AddEmpServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");//设置响应对象的编码方式和浏览器的解码方式
		req.setCharacterEncoding("utf-8");//设置请求对象的解码方式-post有效
		//获取输出流
		PrintWriter pw = res.getWriter();
		//获取表单提交的数据
		String name = req.getParameter("name");
		double sal = Double.parseDouble(req.getParameter("salary"));
//		double sal = Double.valueOf(req.getParameter("salary"));
		int age = Integer.parseInt(req.getParameter("age"));
//		int age = Integer.valueOf(req.getParameter("age"));

/*	案例05		
		//输出
		pw.println("<h1>员工信息</h1>");
		pw.println("<h1>姓名："+ name +"</h1>");
		pw.println("<h1>工资："+ sal +"</h1>");
		pw.println("<h1>年龄："+ age +"</h1>");
		
		pw.close();
*/		
		
		//案例06		连接数据库，将数据插入到表中，返回结果
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.class.forName("oracle.jdbc.driver.OracleDriver");//加载驱动
//			oracle.jdbc.driver.OracleDriver				jdbc:oracle:thin:@localhost:1521:xe
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "chris", "123456");//创建连接
			String sql = "insert into t_emp values(emp_id_seq.nextval,?,?,?)";//sql语句
			ps = conn.prepareStatement(sql);//将sql语句放入语句对象
			ps.setString(1, name);
			ps.setDouble(2, sal);
			ps.setInt(3, age);
			int flag = ps.executeUpdate();
			if(flag > 0){

				res.sendRedirect("/Servlet002/list");
			} else {
				pw.print("系统繁忙，请稍后再试");
			}
			
			pw.close();
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动异常！");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库操作异常!");
			e.printStackTrace();
		} finally {
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					System.out.println("语句对象关闭异常");
					e.printStackTrace();
				} finally {
					if(conn != null){
						try {
							conn.close();
						} catch (SQLException e) {
							System.out.println("连接关闭异常");
							e.printStackTrace();
						}
					}
				}
			}
		}
 
			
	}
}
