package netctoss.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.sun.image.codec.jpeg.ImageFormatException;

import netctoss.util.ImageUtil;

/**
 * ����ͼƬ��Action������
 * @author Administrator
 *
 */

public class CreateImageAction extends BaseAction{//ʵ��BaseAction����Լ̳����е�����session
	//������StreamResult�����������ϣ����������е�ͼƬ���
	private InputStream imageStream;

	public String execute(){
		Map<String, BufferedImage> map = ImageUtil.createImage();//ʹ�ù������ȡ��������ɵ���֤�����֤��ͼƬ
		String code = map.keySet().iterator().next();//��Map�е�keyתΪset���ϣ�Ȼ����ü��ϵĵ�������������ȡ�������ĵ�һ��Ԫ�أ������ɵ���֤�롣
		session.put("imageCode", code);//����֤�����session�У��Ա��¼��֤action�е�����֤�û��������֤���Ƿ���ȷ��
		BufferedImage imageCode = map.get(code);
		try {
			imageStream = ImageUtil.getInputStream(imageCode);//ͨ��code��ȡ��map�ж�Ӧ��aule������֤��ͼƬ
			System.out.println("������֤�뷽��...���ɵ���֤��Ϊ:"+ code);
		} catch (IOException e) {
			e.printStackTrace();
			return "error";//��������֤���쳣������뵽�쳣ҳ�档
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
