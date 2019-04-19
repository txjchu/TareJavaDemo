package day02;

public class HomeWorkTest03 {
	public static void main(String[] args) {
		
		String str = "someapp/manager/emplist.action";
		
		//找到最后一个"/"的位置
		int index = str.lastIndexOf("/");
		
		//从最后一个"/"之后的第一个字符开始截取到末尾
		String sub = str.substring(index+1);
		System.out.println(sub);
	}
}
