package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �ļ�����������Ĺ�����
 * @author Administrator
 *
 */
public class FileUtil {
	
	public static boolean copy(File src, File dest){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			byte[] bts = new byte[1024];
			int len = -1;
			while((len = bis.read(bts)) != -1){//����������ȡһ�����ݷ���ֵΪ-1����ʾ��ȡ���ļ�ĩβ�ˡ�
				bos.write(bts, 0, len);//������������ͨ�������д����
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(bis != null){
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bos != null){
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
