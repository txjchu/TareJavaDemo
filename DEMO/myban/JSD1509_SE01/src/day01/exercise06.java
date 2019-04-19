package day01;
/**
 * 作业第六题
 * 创建StringBuilder
 * 打印出Unicode所有的汉字（U4E00 - U9FA5），50个字换一行。
 * @author Administrator
 *
 */
public class exercise06 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for(char c = '\u4E00', i = 1; c <= '\u9FA5'; i ++, c ++){
			sb = sb.append(c);//利用append(str)方法添加
			
			//*****利用数组长度计算50的倍数，会出现第一行50个字符，其他行都是49个字符的情况？？？
			//*****原因："\n"也是一个字符，当sb的字符长度等于50时，添加了一个字符"\n"换行，因此实际上第一行有51个字符。
			//*****其他行有49个汉字+一个换行符。sb.length()中包含了每一个"\n"字符。
//			if(sb.length()  % 50 == 0){//被50整除，则表示有x个50，每50个做一件事
//				sb.append("\n");//每50个汉字后添加一个换行符
//			}
			if(i % 50 == 0){
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
