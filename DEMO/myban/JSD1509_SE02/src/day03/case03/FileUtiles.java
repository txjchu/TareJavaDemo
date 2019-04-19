package day03.case03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * ����3��
 * �Զ�����ļ�������
 * 1.���Ը����ļ�
 * 2.�Ե�һ���Ĵ�����в����쳣����
 * try-catch-finally
 * @author Administrator
 *
 */
public class FileUtiles {

	@Test//����3	����try-catch-final
	public void testCopy() throws IOException{
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("fos.dat");
			fos = new FileOutputStream("fos_copy04.dat");
			int len = -1;
			while ((len = fis.read()) != -1) {
				fos.write(len);
			}
			System.out.println("������ϣ�");
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�δ�ҵ���");
			e.printStackTrace();
		}catch(IOException e){
			System.out.println("��ȡ���ƴ���");
			e.printStackTrace();
		}finally{
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				
			}
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	@Test//����5	�����Զ����쳣CopyException
	public void testCopyException() throws CopyException{
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("fos1.dat");
			fos = new FileOutputStream("fos_copy05.dat");
			int len = -1;
			while ((len = fis.read()) != -1) {
				fos.write(len);
			}
			System.out.println("�ļ��������");
		} catch (FileNotFoundException e) {
			throw new CopyException("�ļ�δ�ҵ�", e);
		} catch(IOException e){
			throw new CopyException("��д�쳣", e);
		} finally{
			if(fis != null){
				try {
					fis.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}				
			}
			if(fos != null){
				try {
					fos.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}							
			}
		}
	}
}
