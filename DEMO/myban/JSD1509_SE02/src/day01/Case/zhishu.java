package day01.Case;
/**
 * ���2-100֮�������
 * @author Administrator
 *
 */
public class zhishu {
	public static void main(String[] args) {
		int count = 0;
		for(int i = 1; i <= 100; i ++){
			for(int j = 2; j <= i; j++){
				if(i == j){
					count ++;
					System.out.print(i +" ");
					if(count % 10 == 0){
						System.out.println();
					}
				}
				if(i % j == 0){
					break;
				}
			}
		}
		System.out.println("������"+ count);
	}
}
