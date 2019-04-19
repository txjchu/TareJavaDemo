package a01;

import java.util.Scanner;

/**
 * ����ĸ��Ϸ09������Ϸ�ȼ����ܣ�
 * 1.���ݽṹ���
 * 1) int count ���ڼ������û��²�Ĵ���
 * 2) int level ���ڴ�����Ϸ�ȼ�
 * 3) char[] input ���ڴ����û��������ĸ����
 * 4) char[] chs ���ڴ����Զ����ɵ���ĸ����
 * 5) int[] result ���ڴ����������ݶԱȺ�Ľ��
 * 2.�㷨�������
 * 1) generate() �Զ�������ĸ����ķ�����������level������ֵ��char[] chs
 * 2) check() ��������Աȵķ�����������input,chs������ֵ��int[] result
 * 3.������
 * 1) ��Ϸ�ȼ�����
 * 2) �����û��������ĸ���飬�������������鷽�������ñȽ����鷽�����˻�����
 * @author Administrator
 *
 */
public class aaa {
	public static void main(String[] args) {
		//1.���ݽṹ
		int count = 0;//�û��²�Ĵ���
		int[] result = new int[2];//��������ԱȺ�Ľ��
		Scanner scan = new Scanner(System.in);
		System.out.println("GuessingGame==>��ӭ���Բ���ĸ��Ϸ�������õȼ����ܣ���");
		int level = 5;//��Ϸ�ȼ�
		do{//�û�������Ϸ�ȼ�
			System.out.println("GuessingGame==>��������Ϸ�ȼ���5��7��9��");
			level = scan.nextInt();
		}while(level != 5 && level != 7 && level !=9);
		char[] chs = generate(level);//�Զ����ɵ���ĸ����
		System.out.println(chs);//����
		System.out.println("GuessingGame==>��Ϸ��ʼ�������������²��"+ level +"����ĸ���У�����exit=�˳���");
		
		while(true){
			String inputStr = scan.next().trim().toUpperCase();//�����û��������ĸ���У���ȥ�հף�����д��
			if("EXIT".equals(inputStr)){//����û�����exit�����˳���Ϸ
				System.out.println("GuessingGame==>лл���Բ���ĸ��Ϸ���ټ���");
				break;
			}
			char[] input = inputStr.toCharArray();//�û��������ĸ����,������ת��Ϊ�ַ�������
			result = check(input,chs);//���öԱ�����ķ���
			if(result[0] == chs.length){//����û�ȫ�¶ԣ��������Ϸ���������÷�
				int score = 100 * chs.length - 10 * count;
				System.out.println("GuessingGame==>��ϲ��ȫ�¶��ˣ���ĵ÷���"+ score);
				break;
			}else{
				count++;//����´�����²������1
				System.out.println("GuessingGame==>��¶���"+ result[1] +"����ĸ������"
						+ result[0] +"����ĸλ����ȷ�����ܲ²����Ϊ��"+ count +"�Σ�exit=�˳���");
			}
		}
		scan.close();
	}
	//2.�㷨�ṹ
	/**
	 * 2.1 �Զ���������ķ���
	 * @param level
	 * 			��Ϸ�ȼ�����Ϊchs����ĳ���
	 * @return chs
	 * 			�Զ����ɵ���ĸ����
	 */
	public static char[] generate(int level){
		char[] chs = new char[level];//�洢�Զ����ɵ�����
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z'};
		boolean[] flags = new boolean[letters.length];
		for(int i = 0; i < chs.length; i++){
			int index;//�±�
			do{
				index = (int)(Math.random() * (letters.length));
			}while(flags[index]);//ȥ�ظ�
			chs[i] = letters[index];
			flags[index] = true;	
		}		
		return chs;
	}
	/**
	 * 2.2 �����������Աȵķ���
	 * @param input
	 * 			�û��������ĸ����
	 * @param chs
	 * 			�Զ����ɵ���ĸ����
	 * @return result
	 * 			�����������ԱȺ�Ľ��
	 */
	public static int[] check(char[] input,char[] chs){
		int[] result = new int[2];
		for(int i = 0; i < input.length; i++){
			for(int j = 0; j < chs.length; j++){
				if(input[i] == chs[j]){//�����ĸ��ͬ����ڶ���Ԫ�ؼ�1
					result[1]++;
					if(i == j){//�����ͬ��ĸ��λ��Ҳ��ͬ�����һ��Ԫ�ؼ�1
						result[0]++;
					}
					break;
				}
			}
		}
		return result;
	}
}
