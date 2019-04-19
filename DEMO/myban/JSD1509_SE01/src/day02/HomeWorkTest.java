package day02;
//回文作业  	作业5
public class HomeWorkTest {
	public static void main(String[] args) {
		String str="上海自来水来自海上";
		StringBuilder builder = new StringBuilder(str);
		builder.reverse();//翻转字符串
		String str1=builder.toString();
		
		if(str.equals(str1)){
			System.out.println("是回文");
		}else{
			System.out.println("不是回文");
		}
	}
}
