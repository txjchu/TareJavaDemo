package a01;

import java.util.Arrays;
import java.util.Random;

/**
 * �Լ���˼·��˫ɫ��	33����  ȡ  6������16����  ȡ  1������δ�����ɫ��
 * 1.
 * @author Administrator
 *
 */
public class day06_doubleBallsDome {
	public static void main(String[] args) {
		//33����ȡ6������
		String[] redBalls = {"00","01","02","03","04","05","06","07","08",
				"09","10","11","12","13","14","15","16","17","18","19",
				"20","21","22","23","24","25","26","27","28","29",
				"30","31","32"};
		String[] blueBalls = {"00","01","02","03","04","05","06","07","08",
				"09","10","11","12","13","14","15",};
//		System.out.println(Arrays.toString(redBalls));
//		System.out.println(Arrays.toString(rb));
		String[] balls = new String[7];//7��˫ɫ������
		
		//���ɺ���
		int[] rb = generateArray(6,33);//����6����ɫ����±�
		for(int i = 0; i < 6; i ++){
			balls[i] = redBalls[rb[i]]; //�����ɵ�6����ɫ���±�����6�����򣬷���˫ɫ��ǰ6λ��
		}
		System.out.println("˫ɫ����6������ĺ����ǣ�"+ Arrays.toString(balls));
		//��������
		int[] bb = generateArray(1,16);
		balls[6] = blueBalls[bb[0]];
		System.out.println("˫ɫ��7�������ǣ�"+ Arrays.toString(balls));
	}
	//���ȡ�򷽷�(���������)
	public static int[] generateArray(int length,int max){
		int[] arr = new int[length];//�������飬����Ϊlength(����6����1)
		Random ran = new Random();
		for(int i = 0; i < arr.length; i++){
			arr[i] = ran.nextInt(max);//ȡ����Χ��0<=x<max(max����ΪredBalls�ĳ���)
			for(int j = 0; j < i; j++){
				if(arr[j] == arr[i]){
					i -- ;//ȥ���ظ����ɵ����֣���arr[i]��������
					continue;
				}
			}
		}
		return arr;
	}
	
}
