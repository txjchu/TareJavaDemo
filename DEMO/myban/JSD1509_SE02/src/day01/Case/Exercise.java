package day01.Case;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

/**
 * �κ�ϰ��
 * @author Administrator
 *
 */
public class Exercise {
	
	@Test //ϰ��1 	��ȡĿ¼����Ŀ¼�е��ļ�
	public void testListFile() throws FileNotFoundException{
		File dir = new File(".");
		Collection<File> files = FileUtils.listFiles(dir, new String[]{"txt"}, true);
		System.out.println(files.size());
		int count = 0;
		for(File f : files){
			System.out.println("jar" + (count ++ ) +":"+ f);
		}
	}
	
	@Test //ϰ��4		�����ļ���������ȡд��
	public void testCopyFile() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "r");
		RandomAccessFile raf_copy = new RandomAccessFile("raf_copy.dat", "rw");
		int len = -1;
		byte[] buf = new byte[1024];//��ȡ���ֽ�����
		while((len = raf.read(buf)) != -1){//û�ж�ȡ���ļ�ĩβ
			raf_copy.write(buf, 0, len);//����ȡ����bufд��raf_copy�ļ���	ע��д����ָ�봦���ļ�ĩβ
		}
		System.out.println("�����ļ�raf��ϣ�"+ raf_copy.length());
		raf_copy.seek(0);//��ָ�����
		int i = 1;
		while((len = raf_copy.read(buf)) != -1){
			System.out.println("��"+ (i ++) +"�ζ�ȡ...");
			System.out.println(new String(Arrays.copyOf(buf, len)) +",");
													//��buf������ЧԪ��ת��Ϊ�ַ����������
		}
		raf.close(); raf_copy.close();//�ر�
		Random ran = new Random();
		int a = ran.nextInt(4);
		System.out.println(a);
		
	}
	
	@Test//ϰ��5 		����ָ���ƶ��ķ���
	public void testPointSkip() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "r");
		System.out.println(raf.length());
		raf.skipBytes(3);//����3���ֽ�
		long a = raf.getFilePointer();//��ȡ��ǰָ���±�
		System.out.println(a);
	}
	
	@Test //��2 -- 100֮�������
	public void test(){
		int count = 0;//������������
		for(int i = 2; i <= 100; i++){//����1 - 100������
			boolean flag = true;//����Ϊ����
			for(int j = 2; j < i; j ++){//��������	//���ܵ���i
				if(i % j == 0){//����������
					flag = false;//������
					break;
				}				
			}
			if(flag){
				count ++;//����������1
				if((count % 10) == 0) {//�����������������������ж�
					System.out.print(i + "\n");
				}else{
					System.out.print(i +" ");					
				}				
			}
		}
		System.out.println("\n����"+ count + "������");
	}
}








