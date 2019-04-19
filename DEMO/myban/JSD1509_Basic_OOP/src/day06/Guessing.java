package day06;

import java.util.Scanner;

/**
 * ����ĸ��Ϸ
 * 1.���ݽṹ
 * 1)char[] input�û�����²����ĸ��
 * 2)char[] chs�Զ����ɵ���ĸ��
 * 3)int count����²�Ĵ���
 * 4)int[] result������2����ĸ��ԱȺ�Ľ��
 * 2.�����㷨
 * 1)generate()�Զ�������ĸ��ķ���������һ���ַ�������
 * 2)check(input,chs)��2����ĸ�����Աȵķ���������һ������������int[] result
 * 3)�����򣬽����û����벢ת��Ϊ�ַ������飬�ظ�����2�������������ս����ʾ 
 * @author Administrator
 *
 */
public class Guessing {
	public static void main(String[] args) {
		//1.��������
		int count = 0;//���ڱ�ʾ�²�Ĵ���
		char[] input = null;//���������û��²����ĸ����
		char[] chs = null;//���������Զ����ɵ���ĸ����
		int[] result = new int[2];//��������ÿ�ζԱȺ�Ľ��
		//3)������
		Scanner scan = new Scanner(System.in);
		chs = generate();//�Զ�����һ����ĸ����
		System.out.println("GuessingGame>��ӭ���Բ���ĸ��Ϸ��");
		System.out.println(chs);//����
		System.out.println("GuessingGame>��Ϸ��ʼ�������������µ�5����ĸ���У���exit�����˳���");
		while(true){
			String inputStr = scan.next().trim().toUpperCase();//�����û������5����ĸ����ת���ɴ�д������Ϊ�ַ���
			if("EXIT".equals(inputStr)){//����û�����exit�������
				System.out.println("GuessingGame>лл���Բ���ĸ��Ϸ���ټ���");
				break;
			}
			input = inputStr.toCharArray();//���ַ���ת��Ϊchar[]������
			result = check(input,chs);
			if(result[1] == chs.length){
				int score = 100 * chs.length - 10 * count;
				System.out.println("GuessingGame>��ϲ��¶��ˣ���ĵ÷���"+ score);
				break;
			}else{
				count++;
				System.out.println("GuessingGame>��¶���"+ result[1] +"����ĸ������"
						+ result[0] +"����ĸλ����ȷ�����ܲ���"+ count +"�Σ�exit-�˳���");
			}
		}
		scan.close();
	}
	
	//2.�㷨����
	//1)�Զ�������ĸ����ķ���
	public static char[] generate(){
		char[] chs = new char[5];
		char[] letters ={'A','B','C','D','E','F','G','H','I','J','K','L','M',
				'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		boolean[] flags = new boolean[letters.length];//��������ĸ��ʹ���������ʶ����ֹ��ĸ�ظ�
		for(int i = 0; i < chs.length; i++){
			int num;
			do{
				num = (int)(Math.random()*(letters.length));//�������һ���±�
			}while(flags[num]);//��flags[num]Ϊfalseʱ����ֹͣѭ��
				chs[i] = letters[num];
				flags[num] = true;//flags[num]��Ϊtrue����ʾ�Ѿ�ʹ��
			
		}
		return chs;
	}
	//2)��2����ĸ�����Ƚϵķ���
	public static int[] check(char[] input,char[] chs){
		int[] result = new int[2];//
		for(int i = 0; i < input.length; i++){
			for(int j = 0; j < chs.length; j++){
				if(input[i] == chs[j]){
					result[1]++;//�������ͬ����ĸ����result[]�ڶ���Ԫ��+1
					if(i == j){
						result[0]++;//�����ĸ���±���ͬ����result[]��һ��Ԫ��+1
					}
					break;//����¶���ĳ����ĸ��������input[i]ѭ����������һ��i++�ĶԱ�
				}
			}
		}
		return result;
	}
	

}
