package entity;
/**
 * 如何生成一个不是某个数组中的元素的随机数
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
		boolean flag = false;//标记
		for(int i = 0; i < arr.length; i ++){
			if(n == arr[i]){
				flag = true;//如果n等于数组中的任意元素，则将标记改为true
				break;
			}
		}
		return flag;
	}
}
