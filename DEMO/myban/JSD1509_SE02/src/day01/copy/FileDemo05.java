package day01.copy;

import java.io.File;

/**
 * ����һ���༶Ŀ¼
 * @author Administrator
 *
 */
public class FileDemo05 {
	public static void main(String[] args) {
		/*
		 * �ڵ�ǰ��Ŀ��Ŀ¼�´���Ŀ¼��a/b/c/d/e/f
		 */
		File dir = new File("a"+ File.separator +
							 "b"+ File.separator +
							 "c"+ File.separator +
							 "d"+ File.separator +
							 "e"+ File.separator +
							 "f");
		if(!dir.exists()){
			/*
			 * mkdir()�ڴ���Ŀ¼ʱ����һ��ǰ����������Ҫ������Ŀ¼���ڵĸ�Ŀ¼������ڣ����򴴽����ɹ���
			 * mkdirs()�ڿ��Դ�����ǰĿ¼��ͬʱ�������в����ڵĸ�Ŀ¼һͬ����������
			 */
			dir.mkdirs();
			System.out.println("����Ŀ¼dir��ϣ�");
		}
	}
}
















