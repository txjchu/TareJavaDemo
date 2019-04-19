package action;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import util.FileUtil;

/**
 * 文件上传Action
 * @author Administrator
 *
 */
public class UploadAction {
	
	//接收拦截器注入的临时文件
	private File some;
	//接收拦截器注入的文件名
	private String someFileName;
	
	public String execute(){
		System.out.println(some == null);
		if(some == null){//若临时文件为空
			return "error";
		}
		//将上传过来的文件放在upload文件下	--[相对路径]
		String path = "WEB-INF/upload/"+ someFileName;
		System.out.println("someFileName"+ someFileName);//someFileNameMVC.jpg
		//根据相对路径计算绝对路径
		path = ServletActionContext.getServletContext().getRealPath(path);
									/*
									 * path:D:\Workspaces\apache-tomcat-6.0.29\webapps\Struts2_01\WEB-INF\ upload\MVC.jpg
									 */
		System.out.println("path:"+ path);
		FileUtil.copy(some, new File(path));
		return "success";

	}
	
	
	public File getSome() {
		return some;
	}
	public void setSome(File some) {
		this.some = some;
	}
	public String getSomeFileName() {
		return someFileName;
	}
	public void setSomeFileName(String someFileName) {
		this.someFileName = someFileName;
	}
	
}
