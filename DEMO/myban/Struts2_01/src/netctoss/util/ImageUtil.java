package netctoss.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 生成验证图片的类
 * @author Administrator
 *
 */
public class ImageUtil {
	
	private static final char[] chars = { '0', '1', '2', '3', '4', '5', '6',
        '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };
	private static final int SIZE = 4;		//字符个数
	private static final int LINES = 5;		//干扰线条
	private static final int WIDTH = 80;	//图片的宽
	private static final int HEIGHT = 40;	//图片的高
	private static final int FONT_SIZE = 30;//字号
	
	/**
	 * 生成验证码图片，封装与Map中。其中Map的key是验证码，Map的value是验证码图片。
	 */
	public static Map<String, BufferedImage> createImage(){
		StringBuffer sb = new StringBuffer();
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics graphic = image.getGraphics();//获取画笔
		graphic.setColor(Color.LIGHT_GRAY);
		graphic.fillRect(0, 0, WIDTH, HEIGHT);
		Random ran = new Random();
		//画随机字符
		for(int i = 1; i <= SIZE; i++){
			int r = ran.nextInt(chars.length);
			graphic.setColor(getRandomColor());
			graphic.setFont(new Font(null, Font.BOLD + Font.ITALIC, FONT_SIZE));
			graphic.drawString(chars[r] +"", (i - 1)* WIDTH /SIZE, HEIGHT / 2);
			sb.append(chars[r]);//将字符保存，存入Session
		}
		//画干扰线
		for(int i = 1; i <= LINES; i++){
			graphic.setColor(getRandomColor());
			graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
		}
		//将生成的字符串，图片放入Map中，返回。
		Map<String, BufferedImage> map = new HashMap<String, BufferedImage>();
		map.put(sb.toString(), image);
		return map;
	}
	
	
	//获取一个可以将要输出的图片转为输入流对象的静态方法
	public static InputStream getInputStream(BufferedImage image) throws ImageFormatException, IOException{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();//字节数组输出流
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);//JPEG图片格式的编码对象
		encoder.encode(image);
		byte[] imageBts = bos.toByteArray();
		InputStream in = new ByteArrayInputStream(imageBts);
		return in;
	}
	
	
	//随机生成颜色对象的静态方法
	private static Color getRandomColor(){
		Random ran = new Random();
		Color color = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
		return color;
	}
}













