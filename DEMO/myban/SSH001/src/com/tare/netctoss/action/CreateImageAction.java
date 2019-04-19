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
 * 处理获取验证图片的请求的Action
 * 继承BaseAction后，可以将生成的验证码及图片放入session中，以备登录Action中验证用户输入的验证码是否正确。
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")
public class CreateImageAction extends BaseAction{

	/*
	 * 用于配合StreamResult传输二进制数据，向页面输出验证码图片。
	 */
	private InputStream imageStream;

	public String execute(){
		
		
		Map<String, BufferedImage> map = ImageUtil.createImage();//1.通过图片工具类获取生成的验证码加图片，Map形式的数据。
		String imageCode = map.keySet().iterator().next();//2.获取验证码
		session.put("imageCode", imageCode);//3.将验证码字符串放入session中。
		System.out.println("进入生成验证码Action..."+ imageCode);
		BufferedImage image = map.get(imageCode);//4.获取验证码图片
		try {
			imageStream = ImageUtil.getInputStream(image);//5.使用工具类的方法用这个图片创建一个输入流，配合StreamResult输出。
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
