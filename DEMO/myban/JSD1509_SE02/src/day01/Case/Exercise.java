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
 * 课后习题
 * @author Administrator
 *
 */
public class Exercise {
	
	@Test //习题1 	获取目录及子目录中的文件
	public void testListFile() throws FileNotFoundException{
		File dir = new File(".");
		Collection<File> files = FileUtils.listFiles(dir, new String[]{"txt"}, true);
		System.out.println(files.size());
		int count = 0;
		for(File f : files){
			System.out.println("jar" + (count ++ ) +":"+ f);
		}
	}
	
	@Test //习题4		测试文件的批量读取写入
	public void testCopyFile() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "r");
		RandomAccessFile raf_copy = new RandomAccessFile("raf_copy.dat", "rw");
		int len = -1;
		byte[] buf = new byte[1024];//读取的字节数组
		while((len = raf.read(buf)) != -1){//没有读取到文件末尾
			raf_copy.write(buf, 0, len);//将读取到的buf写入raf_copy文件中	注：写入完指针处于文件末尾
		}
		System.out.println("复制文件raf完毕！"+ raf_copy.length());
		raf_copy.seek(0);//将指针归零
		int i = 1;
		while((len = raf_copy.read(buf)) != -1){
			System.out.println("第"+ (i ++) +"次读取...");
			System.out.println(new String(Arrays.copyOf(buf, len)) +",");
													//将buf数组有效元素转化为字符串并输出。
		}
		raf.close(); raf_copy.close();//关闭
		Random ran = new Random();
		int a = ran.nextInt(4);
		System.out.println(a);
		
	}
	
	@Test//习题5 		测试指针移动的方法
	public void testPointSkip() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "r");
		System.out.println(raf.length());
		raf.skipBytes(3);//跳过3个字节
		long a = raf.getFilePointer();//获取当前指针下标
		System.out.println(a);
	}
	
	@Test //求2 -- 100之间的质数
	public void test(){
		int count = 0;//用于质数计数
		for(int i = 2; i <= 100; i++){//生成1 - 100的数字
			boolean flag = true;//假设为质数
			for(int j = 2; j < i; j ++){//生成因数	//不能等于i
				if(i % j == 0){//非质数条件
					flag = false;//非质数
					break;
				}				
			}
			if(flag){
				count ++;//质数个数加1
				if((count % 10) == 0) {//换行条件，根据质数个数判断
					System.out.print(i + "\n");
				}else{
					System.out.print(i +" ");					
				}				
			}
		}
		System.out.println("\n共有"+ count + "个质数");
	}
}








