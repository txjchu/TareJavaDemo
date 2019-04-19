package web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * �ϴ��ļ���Servlet
 * @author Administrator
 *
 */
public class FileUploadServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//step1:����һ��DiskFileItemFactory����	--�����ļ���Ŀ������
		//�ö���Ϊ�������ṩ����ʱ��ȱʡ�����á�
		DiskFileItemFactory dfif = new DiskFileItemFactory(); 
		//step2:����������	��ʹ��dfif��һЩ����������IO��
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		//step3:ʹ�ý�����������
		//�����������req.getInputStream��ȡ�����������������Ľ����װ��FileItem�����
		//һ��FileItem�����װ��һ�������е��������ݡ�
		try {
			List<FileItem> items = sfu.parseRequest(req);
			//ֻ��Ҫ����items���ϾͿ��Է��ʱ��е�ÿһ�������е����ݡ�
			for(int i = 0; i < items.size(); i++){
				FileItem curr = items.get(i);
				if(curr.isFormField()){
					//��ͨ����	field��	
					String fieldname = curr.getFieldName();
					System.out.println("�ñ�������֣�"+ fieldname);
					String username = curr.getString();
					System.out.println("��ȡ�ı����е�username:"+ username);
				} else {
					//�ϴ��ļ���	���ϴ��������ļ����浽�������������ַ��'.\ webapps \ JSP05\ upload'
					ServletContext context = getServletContext();//��ȡ������ 
					String path = context.getRealPath("upload");//��ȡupload�ļ�����ʵ����·��
					System.out.println("path:"+ path);//path:D:\Workspaces\apache-tomcat-6.0.29\webapps\JSP05\ upload
					//������ļ���Ϊ�û����͵��ļ���
					String filename = curr.getName();//��ȡ�û��ϴ����ļ����ļ���
					File file = new File(path +"\\"+ filename);//���ļ��������ģ�������.������service������ʼ��req�Ľ�������Ϊutf-8���ܱ������롣
					try {
						curr.write(file);
					} catch (Exception e) {
						System.out.println("�������쳣");
						e.printStackTrace();
					}
					
					
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
	}
	
}












