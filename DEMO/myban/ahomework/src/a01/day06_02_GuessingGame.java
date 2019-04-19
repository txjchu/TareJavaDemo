package a01;

import java.util.Scanner;

/**
 * ����ĸ��Ϸ�����棨����Ϸ�ȼ���
 * 1.���ݽṹ
 * 1)int count�û�����ĸ�Ĵ���
 * 2)char[] input�û�������ĸ����
 * 3)char[] chs�Զ����ɵ���ĸ����
 * 4)int[] resultÿ�ν�2����ĸ�������ԱȺ�Ľ��
 * 5)int level��Ϸ�ȼ�
 * 2.�㷨����
 * 1)generate(int level);�Զ�������ĸ����ķ���������level��Ϸ�ȼ���ʾ����Ԫ�ظ���
 * 2)check(char[] input,char[] chs);��2���������Աȵķ���
 * 3)������a.�����û��������Ϸ�ȼ���b.�����û��������ĸ��������ת��Ϊ���飬
 * 			c.����������ĸ����ķ��������öԱ����鷽��
 * @author Administrator
 *
 */
public class day06_02_GuessingGame {
	public static void main(String[] args) {
		//1.�������
		int count = 0;//���ڼ����û�����ĸ�Ĵ���
		char[] input = null;//���ڽ����û�����
		char[] chs = null;//���ڽ����Զ����ɵ���ĸ����
		int[] result = new int[2];//���նԱȽ��
		int level = 5;//Ĭ����Ϸ�ȼ�Ϊ5
		//3)���������
		Scanner scan = new Scanner(System.in);
		System.out.println("GuessingGame==>��ӭ���Բ���ĸ��Ϸ��");
		do{//a.�û�����������Ϸ����
			System.out.println("GuessingGame==>��������Ϸ����5��7��9����");
			level = scan.nextInt();
		}while(level != 5 && level != 7 && level != 9);
		//b.�����û����������ĸ
		chs = generate(level);//���÷������������ĸ����
		System.out.println(chs);//����
		System.out.println("GuessingGame==>��Ϸ��ʼ�������������µ�"+ level +"����ĸ���У�exit--�˳�����");
		while(true){
			String inputStr = scan.next().trim().toUpperCase();
			if("EXIT".equals(inputStr)){
				System.out.println("GuessingGame==>лл���Բ���ĸ��Ϸ���ټ���");
				break;
			}
			input = inputStr.toCharArray();
			result = check(input,chs);
			int score = 100 * chs.length - 10 * count;
			if(result[0] == chs.length){
				System.out.println("GuessingGame==>��ϲ��ȫ�¶��ˣ��ܵ÷�Ϊ"+ score);
				break;
			}else{
				count++;
				System.out.println("GuessingGame==>��¶���"+ result[1] +"����ĸ������"
						+ result[0] +"����ĸλ����ȷ���ܴ���Ϊ"+ count +",exit--�˳���");
			}
		}
		
		
		scan.close();
	}
	//2.�㷨����
	//1)�Զ�������ĸ����ķ���
	public static char[] generate(int level){
		char[] chs = new char[level];
		char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L',
				'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		boolean[] flags = new boolean[letters.length];
		int index;
		for(int i = 0; i < chs.length; i++){//�Զ�����chs.length���ַ�Ԫ��
			do{
				index = (int)(Math.random() * (letters.length));//���������ĸ�±�				
			}while(flags[index]);//��������±��Ӧ��flags[index]Ϊtrue�����������ɣ������ظ�
			chs[i] = letters[index];
			flags[index] = true;
		}
		return chs;
	}
	//2)��2����ĸ�������Աȵķ���
	public static int[] check(char[] input,char[] chs){
		int[] result = new int[2];//���ڴ���ԱȽ��
		for(int i = 0; i < input.length; i++){
			for(int j = 0; j < chs.length; j++){
				if(input[i] == chs[j]){
					result[1]++;//�����ĸ��ͬ����ڶ���Ԫ�ؼ�1
					if(i == j){
						result[0]++;//�����ͬ��ĸ���±�Ҳ��ȣ����һ��Ԫ�ؼ�1
					}
					break;//��ĸ��ͬ�����˳���ѭ����
				}
			}
		}
		return result;
	}
}
