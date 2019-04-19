package com.tare.netctoss.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.tare.netctoss.entity.ImageUtil;

/**
 * �����ȡ��֤ͼƬ�������Action
 * �̳�BaseAction�󣬿��Խ����ɵ���֤�뼰ͼƬ����session�У��Ա���¼Action����֤�û��������֤���Ƿ���ȷ��
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")
public class CreateImageAction extends BaseAction{

	/*
	 * �������StreamResult������������ݣ���ҳ�������֤��ͼƬ��
	 */
	private InputStream imageStream;

	public String execute(){
		
		
		Map<String, BufferedImage> map = ImageUtil.createImage();//1.ͨ��ͼƬ�������ȡ���ɵ���֤���ͼƬ��Map��ʽ�����ݡ�
		String imageCode = map.keySet().iterator().next();//2.��ȡ��֤��
		session.put("imageCode", imageCode);//3.����֤���ַ�������session�С�
		System.out.println("����������֤��Action..."+ imageCode);
		BufferedImage image = map.get(imageCode);//4.��ȡ��֤��ͼƬ
		try {
			imageStream = ImageUtil.getInputStream(image);//5.ʹ�ù�����ķ��������ͼƬ����һ�������������StreamResult�����
			return "success";
		} catch (IOException e) {			
			e.printStackTrace();
			return "error";
		}
	}
	
	public InputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}
}
