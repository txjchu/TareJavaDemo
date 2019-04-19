package netctoss.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.sun.image.codec.jpeg.ImageFormatException;

import netctoss.util.ImageUtil;

/**
 * 生成图片的Action控制器
 * @author Administrator
 *
 */

public class CreateImageAction extends BaseAction{//实现BaseAction后可以继承其中的属性session
	//用来给StreamResult的输出流做配合，将输入流中的图片输出
	private InputStream imageStream;

	public String execute(){
		Map<String, BufferedImage> map = ImageUtil.createImage();//使用工具类获取到随机生成的验证码和验证码图片
		String code = map.keySet().iterator().next();//将Map中的key转为set集合，然后调用集合的迭代器方法，获取到迭代的第一个元素，即生成的验证码。
		session.put("imageCode", code);//将验证码放入session中，以便登录验证action中调用验证用户输入的验证码是否正确。
		BufferedImage imageCode = map.get(code);
		try {
			imageStream = ImageUtil.getInputStream(imageCode);//通过code获取到map中对应的aule，即验证码图片
			System.out.println("进入验证码方法...生成的验证码为:"+ code);
		} catch (IOException e) {
			e.printStackTrace();
			return "error";//若生成验证码异常，则进入到异常页面。
		}
		
		return "success";
	}
	
	public InputStream getImageStream() {
		return imageStream;
	}

	public void setInputStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}
}
