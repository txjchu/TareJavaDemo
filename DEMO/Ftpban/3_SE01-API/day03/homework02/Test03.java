package homework02;

import java.util.Scanner;

/**
 * ��ҵ������
 * @author Administrator
 *
 */
public class Test03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������һ������:");
		String line = scanner.nextLine();
		
		//�ж��Ƿ�Ϊ����
		if(line.matches("[0-9]+")){
			int i = Integer.parseInt(line);
			System.out.println("����һ������:"+i);
		//�ж��Ƿ�ΪС��
		}else if(line.matches("[0-9]+\\.[0-9]+")){
			double d = Double.parseDouble(line);
			System.out.println("����һ��С��:"+d);
		}else{
			System.out.println("���ָ�ʽ����ȷ");
		}
		
		
	}
}








