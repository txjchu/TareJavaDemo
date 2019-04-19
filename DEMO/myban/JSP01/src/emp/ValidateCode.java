package emp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * ��֤��ͼƬ�������뷢��
 * @author Administrator
 *
 */
public class ValidateCode extends HttpServlet {

	/**
	 * ���л��࣬��Ҫ���һ���汾�ţ�������֤���л������Ƿ�����ͬһ�汾�½���ת��ġ�
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
//		PrintWriter out = res.getWriter();------getWriter()��getOutputStream()�������⣬����һ�����Ͳ��ܵ�����һ���ˡ�
		
		String uri = req.getRequestURI();//��ȡ������Դ·��  uri:/JSP04/login/code1
//		StringBuffer url = req.getRequestURL();//��ȡ���Ǿ��Ե�ַ  url:http://localhost:9080/JSP04/login/code1
//		System.out.println("uri:"+ uri +"\n"+ "url:"+ url);
		String action = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		System.out.println("�����xmlת������ȥ���أ�ValidateCode�е�action:"+ action);
		String code ;//������������ͼƬ��session�е�value
		
		if(action.equals("code")){//������������ȡ��֤ͼ������֤ͼƬ��ʾ��ҳ����
//			res.sendRedirect("aaa.jsp");//�����ض�����Ϊ������֤�����������Ҫת������֤ҳ��
//			req.getRequestDispatcher("aaa.jsp").forward(req, res);
			
			validate(req, res);//����������֤ͼƬ����

		} else if(action.equals("check")){//����л�ͼƬ��������֤ͼƬ
			/*
			 * ��֤����֤���Ƿ�������ȷ����ȷ-->ccc.jsp������ȷ-->ת���ص�ǰҳ�棬��������ʾ��
			 */
			//���ύ������֤��֤���Ƿ�������ȷ����ȷ-->�ض���ccc.jsp������ȷ--ת���ص�ǰҳ�棬����ʾ��ʾ
			HttpSession session = req.getSession();
			code = (String) session.getAttribute("code");
			String vcode = req.getParameter("vcode");
			System.out.println("code:"+ code +";vcode:"+ vcode);
			if(vcode.toUpperCase().equals(code)){//����֤��������ȷ
//				toCCC(req, res);
			} else {
				req.setAttribute("msg", "��֤���������");
				System.out.println("�˴���req����msg"+ req.getAttribute("msg"));
				req.getRequestDispatcher("test.dd").forward(req, res);//ת���ص�ǰ
			}			
		} else if(action.equals("ccc")){
			res.sendRedirect("main/ccc.jsp");
		}
		
		
	}

	
	//��ȡ��֤ͼƬ�ķ���
	protected void validate(HttpServletRequest req, HttpServletResponse res) throws IOException{
		Random r = new Random(); 
		//1.�����������
		BufferedImage image = new BufferedImage(100,30, BufferedImage.TYPE_INT_RGB);
		//2.�������ʶ���
		Graphics g = image.getGraphics();
		//3.�趨������ɫ
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		//4.���ƾ��α���
		g.fillRect(0, 0, 100, 30);
		//5.�����Զ���ķ�����ȡ����Ϊ5���ַ����������ɵ���֤�����5���ַ�
		String number = getNumber(4);
//		System.out.println("�Զ��巽�����ɵ�����ַ���:"+ number);
		
		HttpSession session = req.getSession();//����֤���ַ�������session��
		
		session.setAttribute("code", number);//���Զ����ɵ���֤�����session�У��Ա�������֤�û������Ƿ���ȷ��
		
		g.setColor(new Color(0, 0, 0));//�����ַ�����ɫ
		g.setFont(new Font(null,Font.BOLD,24));//�������壬�ֺ�
		g.drawString(number, 5, 25);//�����ַ�����������������xy������
		//6.����������
		for(int i = 0; i < 8; i ++){
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));
		}
		//7.ѹ��ͼƬ�����
		res.setContentType("image/jpeg");
		OutputStream os = res.getOutputStream();//�ֽ������
//		System.out.println("������֤�뷽��");
		ImageIO.write(image, "jpeg", os);
		os.close();
		
		
	}
	//��ȡָ�����ȵ�����ַ���
	protected String getNumber(int size){
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String number = "";
		Random r = new Random();
		for(int i = 0; i < size; i ++){
			number += str.charAt(r.nextInt(str.length()));//�������һ���±꣬��ȡ���±����ڵ��ַ���ƴ��
		}
		return number;
	}
	
}
