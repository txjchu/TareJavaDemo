package day01;
/** 
 * 练习第三题 
 * 截取给定字符串最后一个“/”之后的字符，获取新字符串。
 */
public class exercise03 {
	public static void main(String[] args) {
		String str = "someapp/manager/emplist.action";
		int endSite = str.lastIndexOf("/");
		String newStr = str.substring(endSite + 1);
		System.out.println(newStr);
		
		/**
		 * 练习题第五题
		 * 检测回文
		 */
		str = "able was i ere i saw elba";
		for(int i = 0; i < str.length() / 2; i ++){
			if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
				System.out.println(str + "不是回文！");
				return;
			}
		}
		System.out.println(str +"是回文！");
	}
}
