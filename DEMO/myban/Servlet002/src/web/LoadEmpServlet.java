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
 * �����޸�Ա����Ϣ��htmlҳ�棬����Ҫ�޸ĵ���ϢԤ�����ı�����
 * @author Administrator
 *
 */
public class LoadEmpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(req.getParameter("id"));//��ȡ�����������Ϣͷ�еļ�ֵ����Ϣ
		PrintWriter out = res.getWriter();
//		System.out.println(id);
		
		//2.�������ӣ��������ݿ⣬����Id��ѯ����Ϣ������
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
			//3.����Ϣ����������������ҳ��
			while(rs.next()){
				String name = rs.getString("name");
				double salary = rs.getDouble("salary");
				int age = rs.getInt("age");
				out.println("<form action='modify' method='post'>");//���ύ��ʽΪpost�������������modify
                out.println("���:" + id + "<br>");
                out.println("<input type='hidden' name='id' value='"+id+"'/><br>");
                out.println("����:<input name='name' value='"+name+"'/><br>");
                out.println("нˮ:<input name='salary' value='"+salary+"'/><br>");
                out.println("����:<input name='age' value='"+age+"'/><br>");
                out.println("<input type='submit' value='�޸�'/>");//�����ύ��ť
                out.println("</form>");
			}
			out.println("</body></html>");
			out.close();
		} catch (SQLException e) {
			out.print("<h1>�޸�ʧ�ܣ�</h1>");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("�ر�����ʧ�ܣ�");
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
}
