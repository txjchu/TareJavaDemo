package entity;
/**
 * �������һ������ĳ�������е�Ԫ�ص������
 * @author Administrator
 *
 */
public class testRandom {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = (int) (Math.random() * 100);
		while(check(n)){
			n = (int) (Math.random() * 100);
			continue;
		}
		System.out.println(n);
	}
	public static boolean check(int n){
		int[] arr = {43, 12, 66, 87, 23};
		boolean flag = false;//���
		for(int i = 0; i < arr.length; i ++){
			if(n == arr[i]){
				flag = true;//���n���������е�����Ԫ�أ��򽫱�Ǹ�Ϊtrue
				break;
			}
		}
		return flag;
	}
}
