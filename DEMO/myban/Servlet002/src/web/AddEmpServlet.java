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
 * ���Ա���ķ�������
 * @author Administrator
 *
 */
public class AddEmpServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");//������Ӧ����ı��뷽ʽ��������Ľ��뷽ʽ
		req.setCharacterEncoding("utf-8");//�����������Ľ��뷽ʽ-post��Ч
		//��ȡ�����
		PrintWriter pw = res.getWriter();
		//��ȡ���ύ������
		String name = req.getParameter("name");
		double sal = Double.parseDouble(req.getParameter("salary"));
//		double sal = Double.valueOf(req.getParameter("salary"));
		int age = Integer.parseInt(req.getParameter("age"));
//		int age = Integer.valueOf(req.getParameter("age"));

/*	����05		
		//���
		pw.println("<h1>Ա����Ϣ</h1>");
		pw.println("<h1>������"+ name +"</h1>");
		pw.println("<h1>���ʣ�"+ sal +"</h1>");
		pw.println("<h1>���䣺"+ age +"</h1>");
		
		pw.close();
*/		
		
		//����06		�������ݿ⣬�����ݲ��뵽���У����ؽ��
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.class.forName("oracle.jdbc.driver.OracleDriver");//��������
//			oracle.jdbc.driver.OracleDriver				jdbc:oracle:thin:@localhost:1521:xe
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "chris", "123456");//��������
			String sql = "insert into t_emp values(emp_id_seq.nextval,?,?,?)";//sql���
			ps = conn.prepareStatement(sql);//��sql������������
			ps.setString(1, name);
			ps.setDouble(2, sal);
			ps.setInt(3, age);
			int flag = ps.executeUpdate();
			if(flag > 0){

				res.sendRedirect("/Servlet002/list");
			} else {
				pw.print("ϵͳ��æ�����Ժ�����");
			}
			
			pw.close();
		} catch (ClassNotFoundException e) {
			System.out.println("���������쳣��");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���ݿ�����쳣!");
			e.printStackTrace();
		} finally {
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					System.out.println("������ر��쳣");
					e.printStackTrace();
				} finally {
					if(conn != null){
						try {
							conn.close();
						} catch (SQLException e) {
							System.out.println("���ӹر��쳣");
							e.printStackTrace();
						}
					}
				}
			}
		}
 
			
	}
}
