package day01.copy;

import java.io.File;

/**
 * 删除一个现有文件
 * @author Administrator
 *
 */
public class FileDemo03 {
	public static void main(String[] args) {
		/*
		 * 将项目根目录下的文件test.txt删除
		 */
		File file = new File("test.txt");
		if(file.exists()){
			file.delete();
			//删除file表示的文件或目录
			System.out.println("删除完毕！");
		}
		System.out.println(file.exists());
	}
}


















