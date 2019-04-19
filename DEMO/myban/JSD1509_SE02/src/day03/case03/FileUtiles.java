package day03.case03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * 案例3：
 * 自定义的文件工具类
 * 1.尝试复制文件
 * 2.对第一步的代码进行捕获异常处理
 * try-catch-finally
 * @author Administrator
 *
 */
public class FileUtiles {

	@Test//案例3	测试try-catch-final
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
			System.out.println("复制完毕！");
		} catch (FileNotFoundException e) {
			System.out.println("文件未找到！");
			e.printStackTrace();
		}catch(IOException e){
			System.out.println("读取复制错误");
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
	
	@Test//案例5	测试自定义异常CopyException
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
			System.out.println("文件复制完毕");
		} catch (FileNotFoundException e) {
			throw new CopyException("文件未找到", e);
		} catch(IOException e){
			throw new CopyException("读写异常", e);
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
