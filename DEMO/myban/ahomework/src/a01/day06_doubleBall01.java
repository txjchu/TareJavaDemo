package a01;

import java.util.Arrays;
import java.util.Random;

/**
 * 1.pool ={01,02,03,...33}
 * 2.used ={ f, f, t,.....}
 * 3.balls={null,null,null,null,null,null}
 * 4.int i = 0 ���ж��Ƿ�ȡ��6����ʱʹ�ã�
 * 1) ���������n,n�ķ�Χ0<=n<33,
 * 2) ���n��Ӧ�����ʹ�ñ��used[n]
 * 3) ���ʹ�ù�����used[n]��ֵΪtrue,����1��
 * 4) ���û��ʹ�ù�����ȡ����pool[n]������balls[i++]��
 * 		balls[i++] = pool[n]
 *    ����pool[n]��Ӧ�ı��used[n]��Ϊtrue����ʾʹ�ù�
 * 5) ���balls�����������������˾ͽ�����
 * 		balls�� = i==balls.length 
 * 6) ���û���ͷ���1��
 * @author Administrator
 *
 */
public class day06_doubleBall01 {
	public static void main(String[] args) {
		//���ݽṹ
		String[] pool = {"01","02","03","04","05","06","07","08","09","10","11","12","13",
				"14","15","16","17","18","19","20","21","22",
				"23","24","25","26","27","28","29","30","31","32","33"};
		boolean[] used = new boolean[pool.length];
		String[] balls = new String[6];
		int i = 0;
		//�㷨
		while(true){//��һ���㷨:do...while(i =! balls.length)
			Random ran = new Random();
			int n = ran.nextInt(pool.length);
			if(used[n]){
				continue;
			}
			balls[i++] = pool[n];
			used[n] = true; 
			if(i == balls.length){
				break;
			}
		}
//		��������򷽷���
//		for(int j = 0; j <= balls.length; j++){  
//			if(balls[j] > balls[j+1]){		====�ַ������ܱȽϴ�С��
//				String str = balls[j];
//				balls[j] = balls[j+1];
//				balls[j+1] = str;
//			}
//		}
		Arrays.sort(balls);
		System.out.println(Arrays.toString(balls));
	}	
}
	
