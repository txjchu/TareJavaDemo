package day01.copy;

import java.io.File;

/**
 * ɾ���κθ�����File��������ʾ���ļ���Ŀ¼��������ɾ�����������Ŀ¼��
 * @author Administrator
 *
 */
public class FileDemo09 {
	public static void main(String[] args) {
		File dir = new File("a");
		deleteFile(dir);
		System.out.println(dir.exists());
	}
	/**
	 * ��������File��������ʾ���ļ���Ŀ¼ɾ����
	 * �ݹ�
	 * @param File f
	 */
	public static void deleteFile(File f){
		if(f.isDirectory()){//��f��Ŀ¼
			//�Ƚ���������ɾ��
			File[] subs = f.listFiles();//��ȡ�����ļ�����
			for(File sub : subs){//ʹ����ѭ���������������������ļ�����
				deleteFile(sub);//�˴���ݹ����deleteFile(f)������ֱ�������Ŀ¼���ļ�ʱ����if�������Ϊ�٣�
								//ִ��if������Ĵ��롣
			}
		}
		f.delete();
	}
}	















