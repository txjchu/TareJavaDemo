package action;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import util.FileUtil;

/**
 * �ļ��ϴ�Action
 * @author Administrator
 *
 */
public class UploadAction {
	
	//����������ע�����ʱ�ļ�
	private File some;
	//����������ע����ļ���
	private String someFileName;
	
	public String execute(){
		System.out.println(some == null);
		if(some == null){//����ʱ�ļ�Ϊ��
			return "error";
		}
		//���ϴ��������ļ�����upload�ļ���	--[���·��]
		String path = "WEB-INF/upload/"+ someFileName;
		System.out.println("someFileName"+ someFileName);//someFileNameMVC.jpg
		//�������·���������·��
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
