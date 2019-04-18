package homework01;
/**
 * 作业5
 * 使用StringBuilder实现
 * @author Administrator
 *
 */
public class Test05 {
	public static void main(String[] args) {
		String str = "上海自来水来自海上";
		StringBuilder builder
			= new StringBuilder(str);
		
		builder.reverse();
		String str1 = builder.toString();
		
		if(str.equals(str1)){
			System.out.println("是回文");
		}else{
			System.out.println("不是回文");
		}
	}
}







