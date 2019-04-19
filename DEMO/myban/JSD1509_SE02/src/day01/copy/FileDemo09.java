package day01.copy;

import java.io.File;

/**
 * 删除任何给定的File对象所表示的文件或目录。包含：删除含有子项的目录。
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
	 * 将给定的File对象所表示的文件或目录删除。
	 * 递归
	 * @param File f
	 */
	public static void deleteFile(File f){
		if(f.isDirectory()){//若f是目录
			//先将所有子项删除
			File[] subs = f.listFiles();//获取子项文件数组
			for(File sub : subs){//使用新循环（迭代器）遍历子项文件数组
				deleteFile(sub);//此处会递归调用deleteFile(f)方法，直到到达非目录的文件时，即if条件语句为假，
								//执行if语句后面的代码。
			}
		}
		f.delete();
	}
}	















