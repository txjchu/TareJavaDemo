package day02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * java.io.FileOutputSteam
 * 低级流，用于将数据写出到文件中。
 * 
 * 继承自java.io.OutputStream
 * 
 * 低级流特点：
 * 负责读写数据的流，数据的来源（in），去向（out）是明确的。
 * 
 * @author Administrator
 *
 */
public class FOSDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * FileOutputStream(String path)
		 * FileOutputStream(File file)
		 * 以上两种构造方法从创建出来的文件字节输出流，是覆盖写操作，
		 * 意思是，当使用流向文件中写出数据前，会先将该文件中原来的内容删除。
		 * 然后再把通过该流写出的数据写入该文件中。
		 */
		FileOutputStream fos
			= new FileOutputStream("fos.txt");
		
		String str="我的滑板鞋,时尚时尚最时尚";
		
		byte[] data=str.getBytes("GBK");
		fos.write(data);
		
		//流使用完毕后要关闭
		fos.close();
		
	}
}
