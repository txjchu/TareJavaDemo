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
 * 上传文件的Servlet
 * @author Administrator
 *
 */
public class FileUploadServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//step1:创建一个DiskFileItemFactory对象	--磁盘文件项目工厂类
		//该对象为解析器提供解析时的缺省的配置。
		DiskFileItemFactory dfif = new DiskFileItemFactory(); 
		//step2:创建解析器	会使用dfif的一些配置来解析IO流
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		//step3:使用解析器来解析
		//解析器会调用req.getInputStream获取输入流，并将分析的结果封装到FileItem对象里。
		//一个FileItem对象封装了一个表单域中的所有数据。
		try {
			List<FileItem> items = sfu.parseRequest(req);
			//只需要遍历items集合就可以访问表单中的每一个表单域中的数据。
			for(int i = 0; i < items.size(); i++){
				FileItem curr = items.get(i);
				if(curr.isFormField()){
					//普通表单域	field域	
					String fieldname = curr.getFieldName();
					System.out.println("该表单域的名字："+ fieldname);
					String username = curr.getString();
					System.out.println("获取的表单域中的username:"+ username);
				} else {
					//上传文件域	将上传过来的文件保存到服务器端物理地址上'.\ webapps \ JSP05\ upload'
					ServletContext context = getServletContext();//获取上下文 
					String path = context.getRealPath("upload");//获取upload文件的真实物理路径
					System.out.println("path:"+ path);//path:D:\Workspaces\apache-tomcat-6.0.29\webapps\JSP05\ upload
					//保存的文件名为用户发送的文件名
					String filename = curr.getName();//获取用户上传的文件的文件名
					File file = new File(path +"\\"+ filename);//若文件名有中文，则乱码.必须在service方法开始将req的解码设置为utf-8才能避免乱码。
					try {
						curr.write(file);
					} catch (Exception e) {
						System.out.println("输入流异常");
						e.printStackTrace();
					}
					
					
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
	}
	
}












