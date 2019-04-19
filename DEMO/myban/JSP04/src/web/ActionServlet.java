package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ActionServlet extends HttpServlet {
	//�򿪵�¼ҳ�棺/JSP03/login/toLogin.do
	//��¼��/JSP03/login/login.do	
	//����ҳ��/JSP03/main/toIndex.do
	//��¼ҳ��/WEB-INF/login.jsp
	//��ҳ��/WEB-INF/index.jsp
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession(); 
		
		String uri = req.getRequestURI();
//		System.out.println("uri:"+ uri);//��ǰuri
//		System.out.println("�����ContextPath:"+ req.getContextPath());//�����������·��
		uri = uri.replace(req.getContextPath(),"");//----��ȡ��ǰ����ļ�uri
		if(uri.equals("/login/toLogin.do")){
			//�򿪵�¼ҳ
			toLogin(req,res);
		}else if(uri.equals("/login/login.do")){
			//��¼
			login(req,res);
		}else if(uri.equals("/main/toIndex.do")){
			//����ҳ
			toIndex(req,res);
		} else if(uri.equals("/main/logout.do")){
			session.invalidate();//ʹ��Ч�����session�е�����
			res.sendRedirect("/JSP04/login/toLogin.do");//�ض�����¼ҳ��
		} else if (uri.equals("/login/code.do")){
			//��ȡ��֤��ͼƬ
			validate(req, res);
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
		String str = getNumber(5);
		HttpSession session = req.getSession();//��ȡ��ǰsession����
		session.setAttribute("code", str);//����֤���ַ�������session��
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));//�����ַ�������ɫ
		g.setFont(new Font(null, Font.BOLD, 24));//���������ֺ�
		g.drawString(str, 5, 25);//�����ַ�����������������xy������
		//6.����������
		for(int i = 0; i < 8; i ++){
            g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255),r.nextInt(255)));
            g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));
		}
		//7.ѹ��ͼƬ�����
		res.setContentType("image/jpeg");
		OutputStream os = res.getOutputStream();//�ֽ������
		ImageIO.write(image, "jpeg", os);
		os.close();
	}
	//��ȡ�������ָ�����ȵ��ַ�������
	protected String getNumber(int size){
		String str ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String number = "";
		Random r = new Random();
		for(int i = 0; i < size; i++){
			number += str.charAt(r.nextInt(str.length()));//�������һ���±꣬Ȼ���ȡ�ַ����и��±�������ַ���������ƴ��
		}
		return number;
	}
	
	//תȥ��¼ҳ��
	protected void toLogin(HttpServletRequest req, HttpServletResponse res)
									throws ServletException, IOException {
		req.getRequestDispatcher("../WEB-INF/login.jsp").forward(req, res);
	}
	//��¼ҳ��
	protected void login(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		//��ȡ������
		String userName = req.getParameter("userName");
		String pwd = req.getParameter("pwd");
		String rmb = req.getParameter("remember");
		String vcode = req.getParameter("vcode").toUpperCase();//��ȡ��֤���������������ַ���
		HttpSession session = req.getSession();//��ȡ��ǰsession����
		String code = (String) session.getAttribute("code");//��session��ȡ��vcode��value
		//��֤��У���˺ţ����룬��֤��
		if(userName.equals("zhang") && pwd.equals("123456") && vcode.equals(code)){
			//��ס��
			//�����ѡ�˸�ѡ�򣬾��Ǽ�ס�ң�----��yes��rmbλ�ã�����д�����ָ���쳣��
			if("yes".equals(rmb)){
				/*
				 * ��ҳ���sessionֻ����ѡ����submit�ύ���yes�󣬲Ż��session��������userName.
				 * ������ҳ��֤ʱ���ܻ�ȡ������xml��������session�ı���ʱ��Ϊ1���ӡ���
				 */
				//��ȡsession,��session��Tomcat����request֮ǰ���Զ������ˡ�
				//sessionֻ�ڴ�һ������ʱ����һ�Ρ�
				session = req.getSession();
				//��session�д����ݡ�
				session.setAttribute("userName",userName);
			}
			
			//��ǰ��/JSP03/login/login.do
			//Ŀ�꣺/JSP03/main/toindex.do
			//����ȷ���ض�����ҳ
			//�˴�ʹ����дurl����ֹ������ر�cookie����sessionID׷�ӵ�url======�˴�û����дurl
			String url = res.encodeRedirectURL("../main/toIndex.do");
//			System.out.println("login()��������д���url:"+ url);
			res.sendRedirect(url);//�ض���
		} else {//���˺Ż����벻��ȷ
			//response�в����������ԺͲ�����
			//��Ϣ
			req.setAttribute("msg", "�û��������벻��ȷ��");
			/*
			 * ��¼ҳ����ô��ȡ�˺���������ķ��������
			 * ʹ��ת���ص�¼ҳ�档
			 * ��Ϊ�ض��������������2������ת����ͬһ��������ˣ��˴���������������������ԣ�������������ض���
			 * �������������٣����´������µ����������ˣ�ҳ���еĻ�ȡ��������е����ԵĴ���ֻ�ܻ�ȡ��Null��
			 * 
			 */
//			System.out.println("toLogin()���������õ�req�еļ�ֵ��"+ req.getAttribute("msg"));
			//�ض������»ص���¼ҳ��
//			res.sendRedirect("/JSP04/login/toLogin.do");
			req.getRequestDispatcher("/login/toLogin.do").forward(req, res);
			
		}
		
		
	}
	//����ҳ
	protected void toIndex(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		HttpSession session = req.getSession();
		//��Session�ж�ȡ���ݡ�
		String userName = (String)session.getAttribute("userName");
		System.out.println("toIndex()��������Ĵ�ʱ��session�л�ȡ����ϢuserName��"+ userName);
		
		//ת��
		String url = res.encodeRedirectURL("../WEB-INF/index.jsp");
		req.getRequestDispatcher(url).forward(req, res);
	}
	
	
}
