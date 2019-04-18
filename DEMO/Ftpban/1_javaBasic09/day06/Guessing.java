package day06;
import java.util.Scanner;
//����ĸ��Ϸ
public class Guessing {
	
	//������
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] chs = generate(); //��ȡ����ַ�����
		System.out.println(chs); //����
		int count = 0; //�´�Ĵ���
		while(true){ //������ѭ��
			System.out.println("�°�!");
			String str = scan.next().toUpperCase(); //��ȡ�û�������ַ�������ת��Ϊ��д
			if(str.equals("EXIT")){ //�ж��ַ�����ȣ��������equals()����--������ϸ��
				System.out.println("�´�������!");
				break;
			}
			char[] input = str.toCharArray(); //��strת��Ϊ�ַ�����
			int[] result = check(chs,input); //�Ա�:����ַ�������û�������ַ����飬���ضԱȵĽ��
			if(result[0]==chs.length){ //λ�ö�Ϊ0˵��ȫ��
				int score = 100*chs.length-10*count; //һ���ַ�100�֣���һ�ο�10��
				System.out.println("��ϲ��¶��ˣ��÷�:"+score);
				break;
			}else{ //�´���
				count++; //�´������1
				System.out.println("�ַ���:"+result[1]+"����λ�ö�:"+result[0]+"��");
			}
		}
	}
	
	//��������ַ�����
	public static char[] generate(){
		char[] chs = new char[5];
		
		char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' }; //����ַ���Χ
		boolean[] flags = new boolean[letters.length]; //letters�����Ӧ�Ŀ�������
		for(int i=0;i<chs.length;i++){ //��������ַ�����
			int index; //�ַ������±�
			do{
				index = (int)(Math.random()*letters.length); //����0��25֮��������--�䵱letters������±�
			}while(flags[index]); //index��Ӧ�Ŀ���Ϊtrue˵���Ѵ�������ٴ���������index����index��Ӧ�Ŀ���Ϊfalseʱ������δ��������˳�ѭ��
			chs[i] = letters[index]; //����index�±�ȥletters�л�ȡ��Ӧ���ַ�������ֵ��chs�е�ÿһ��Ԫ��
			flags[index] = true; //��index�±��Ӧ�Ŀ����޸�Ϊtrue��������Ӧ���ַ��Ѵ��
		}
		
		return chs;
	}
	
	//�Ա�:����ַ��������û�������ַ�����
	public static int[] check(char[] chs,char[] input){
		int[] result = new int[2]; //result[1]:�ַ���  result[0]:λ�ö�
		for(int i=0;i<chs.length;i++){ //��������ַ�����
			for(int j=0;j<input.length;j++){ //�����û�������ַ�����
				if(chs[i]==input[j]){ //�ַ���
					result[1]++; //�ַ��Ը�����1
					if(i==j){ //λ�ö�
						result[0]++; //λ�öԸ�����1
					}
					break; //�ַ�ƥ��֮�������ַ��������ж��ˣ���ǰ�˳���ǰѭ��
				}
			}
		}
		return result;
	}
	
}














