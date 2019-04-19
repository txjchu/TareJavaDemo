package a01;
/**
 * 输出1~9乘法运算口诀
 * @author Administrator
 *
 */
public class day05_c01_19 {
	public static void main(String[] args) {
		for(int i = 1; i < 10; i++){
			for(int j = 1; j <= i; j++){
				System.out.print(j +"*"+ i +"="+ i*j +"\t");
			}
			System.out.println();
		}
	}
}
