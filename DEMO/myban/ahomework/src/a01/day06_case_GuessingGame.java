package a01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * ����ĸ��Ϸ
 * 1.������ݽṹ
 * 1) �����ֵĴ��������Լ�����÷֣���int count
 * 2) ���ɵ���ĸ���飺char[] chs
 * 3) �û��������ĸ���飺char[] input
 * 4) 2������ԱȺ�Ľ������֪�û�ÿһ�β²��Ľ����1����ʾ��ĸ��˳�򶼶ԣ�1����ʾ��ĸ��˳�򲻶ԣ���
 * 		int[] result = new int[2]
 * 2.��Ƴ���ṹ
 * 1) �����û����������ķ���������������ظ�����input��???
 * 2) ������ĸ����ķ���������������ظ�����chs��generate();
 * 3) ��input��chs��������Աȵķ���������������ظ�����result��check();
 * @author Administrator
 *
 */
public class day06_case_GuessingGame {
	public static void main(String[] args) {
		int count = 0;//�²�Ĵ���
		char[] input = null;//�û����������
		char[] chs = null;//���ɵ�����
		int[] result = new int[2];//ÿ�β²��Ľ��
		//3.���������
		chs = generate();//1)�ȵ���generate()�������ɴ���ĸ��
		System.out.println(Arrays.toString(chs));//����
		System.out.println("GuessingGame==>��ӭ���Բ���ĸ��Ϸ��");
		System.out.println("GuessingGame==>��Ϸ��ʼ�������������µ�5����ĸ���У�������exit���˳���");
		Scanner scan = new Scanner(System.in);
		while(true){
			String inputStr = scan.next().trim().toUpperCase();//�����û������5����ĸ
			if("EXIT".equals(inputStr)){//�ж��û��Ƿ�Ҫ�˳�
				System.out.println("GuessingGame==>лл��ĳ��ԣ��ټ���");
				break;
			}
			input = inputStr.toCharArray();//���ַ���ת��Ϊ�ַ�������
			result = check(input,chs);//����check()�����Ա�2����ĸ����
			if(result[0] == input.length){//ȫ���¶Ե����
				int score = 100 * input.length - 10 * count;//�÷ֵļ���
				System.out.println("GuessingGame==>��ϲ��ȫ�¶��ˣ���ĵ÷��ǣ�"+ score);
				break;
			}else{
				count++ ;
				System.out.println("GuessingGame==>��¶���"+ result[1] +"��ĸ������"+ result[0]
				        +"����ĸ��λ����ȷ�����ܴ�����"+count+"������exit���˳���" );
			}
		}
		scan.close();
	}
	//1.������ĸ����ķ���
	public static char[] generate(){
		char[] chs = new char[5];
		char[] letters ={'A','B','C','D','E','F','G','H','I','J','K','L','M',
				'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'} ;//��ĸ
		boolean[] flags = new boolean[letters.length];//ʹ�����
		for(int i = 0; i < chs.length; i++ ){
			int n;
			do{
				Random ran = new Random();
				n = ran.nextInt(26);//�������26�������е�һ������Ϊ��letters��ѡȡ��ĸ���±�
//				n = (int)(Math.random() * (letters.length));//������ɵ���һ�ַ���
			}while(flags[n]);//�ж��Ƿ�ʹ�ù������ʹ�ù�����ѭ��do...while���
			chs[i] = letters[n];
			flags[n] = true;
		};
		return chs;
	}
	//2.�Ա�2����ĸ����ķ�������2�����������1�����û���������飬1�����Զ����ɵ�����
	public static int[] check(char[] input,char[] chs){
		int[] result = new int[2];//2��Ԫ�أ��ڶ���Ԫ�����û��¶Ե���ĸ��������һ��Ԫ���ǲ¶Ե���ĸλ��Ҳ��ȷ������
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				if(input[i] == chs[j]){
					result[1]++;
					if(i == j){
						result[0]++;
					}
					break;
				}
			}
		}
		return result;
	}
	
}
