package a01;
/**
 * ���1~9�˷�����ھ�
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
