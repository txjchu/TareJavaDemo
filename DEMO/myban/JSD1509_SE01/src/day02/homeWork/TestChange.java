package day02.homeWork;

import java.util.Scanner;

import org.junit.Test;

/** ��ϰ03 */
public class TestChange {
	
	
	@Test
	//�����ַ���ת��Ϊ���ֻ�С���ķ���
	public void testStringTOIntOrDouble(){
		String intRegex = "^[0-9]+$";//������������ʽ
		String decimalRegex = "^[0-9]+\\.[0-9]+$";//С����������ʽ
		
		Scanner scan = new Scanner(System.in);//����ɨ�������󣬽����û�����
		System.out.println("������һ�����֣�");
		String numberStr = scan.nextLine();//���û��������Ϣ����ΪString��������
		//���û���������ݽ����ж�
		if(numberStr.matches(intRegex)){//��ƥ������
			System.out.println("����һ�����֣�"+ Integer.parseInt(numberStr));
		}else if(numberStr.matches(decimalRegex)){//��ƥ��С��
			System.out.println("����һ��С����"+ Double.parseDouble(numberStr));
		}else{
			System.out.println("��������ָ�ʽ����ȷ��");
		}
	}
}









