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
 * ��ѯԱ����ķ�������
 * @author Administrator
 *
 */
public class ListEmpServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {	
		res.setContentType("text/html;charset=utf-8");//����
		req.setCharacterEncoding("utf-8");//����
		PrintWriter out = res.getWriter();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//1.��������
			Class.class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "chris", "123456");
			ps = conn.prepareStatement("select * from t_emp order by id");
			rs = ps.executeQuery();
			//2.������֮ǰ�ı��
			out.println("<HTML>");
			out.println("<HEAD><title>Ա����Ϣ�б�</title></HEAD>");
			out.println("<BODY>");
			out.println("<table border='1' cellpadding='0' cellspacing='0' width='60%'>");
			out.println("<caption>Ա����Ϣ�б�</caption>");
			out.println("<tr><td>ID</td><td>����</td><td>нˮ</td><td>����</td><td>����</td></tr>");
			//3.������������Ա����ʽ�������
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double salary = rs.getDouble("salary");
				int age = rs.getInt("age");
				out.println("<tr><td>"+
						id+"</td><td>"+
						name+"</td><td>"+
						salary+"</td><td>"+
						age+"</td>"+		//����a����get��ʽ�ύ���󣬽�����idͨ������������֮���ύ����������������ͨ��req��ȡ
						"<td><a href='delete?id="+ id +"' onclick=\"return confirm('�Ƿ�ȷ��ɾ��"+name+"');\">ɾ��</a>"+
						" <a href='load?id="+ id +"'>�޸�</a></td>"+
						"</tr>");
			}
			out.print("</table>");
			out.print("<a href='addEmp.html'>����Ա����Ϣ</a>");
			out.println("</BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("����������쳣��");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���������쳣��");
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
