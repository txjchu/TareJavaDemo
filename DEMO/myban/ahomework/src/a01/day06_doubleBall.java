package a01;

import java.util.Arrays;
import java.util.Random;
/**
 * ˫ɫ�򣬲�ʹ�÷���
 * @author Administrator
 *
 */
public class day06_doubleBall {
	public static void main(String[] args) {

		String[] pool = { "01", "02", "03", "04", "05", "06","07","08",// �����
				"09", "10", "11", "12", "13", "14", "15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
				"29", "30", "31", "32", "33" };
		boolean[] used = new boolean[pool.length];// �ж����Ƿ�ʹ�ù����У��ù����Ĭ��ֵfalseΪtrue
		String[] balls = { null, null, null, null, null, null };// ȡ���Ĳ����
		Random ran = new Random();
		int i = 0;
//		while (true) {
//			int n = ran.nextInt(pool.length);
//			if (used[n]) {
//				continue;
//			}
//			balls[i++] = pool[n];
//			used[n] = true;
//			if (i == balls.length) {
//				break;
//			}
//		}
//===============================================
//�Լ���˼·
		 for(int j = 0; j < 6; j++){
//			 do{
			 i = ran.nextInt(pool.length);
		 	 if(used[i] == true){//�ڸ�balls[j]��Ԫ�ظ�ֵǰ���ж�pool[i]�Ƿ�ʹ�ù�
		 		 j--;			 //���ʹ�ù�����j-1,��������balls[j]
		 		 continue;
		 	 }
			 balls[j] = pool[i];
			 used[i] = true;
//			 }while(used[i] == true);	//���while����Ϊ�棬��ִ��do����
		 }
//===============================================
		Arrays.sort(balls);	//====��6��������String[] balls������Arrays.sort()���������������null�������򱨴�
		System.out.println(Arrays.toString(balls));
	}
}
