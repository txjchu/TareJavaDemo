package day02.copy;

import java.util.Scanner;

/**
 * ������������Ƿ񽡿�
 * �Ƿ񽡿��� a = (���� * 0.45359237)/((��� * 0.0254)*(��� * 0.0254))
 * @author Administrator
 *
 */
public class �������� {
	public static void main(String[] args) {
		final double pound = 0.45359237;//pound:Ӣ�����мƣ��ô�	����ϵ��
		final double inch = 0.0254;//inch:Ӣ�磬��ߣ�	���ϵ��
		System.out.println("Input your weight and your height :");
		Scanner scan = new Scanner(System.in);
		double weight = scan.nextDouble();
		double height = scan.nextDouble();
		if(weight <= 0 || height <= 0){
			System.out.println("Wrong Input , Input again:");
			weight = scan.nextDouble();
			height = scan.nextDouble();
		}else{
			weight *= pound;
			height *= inch;
			double a = weight / (height * height);
			if(a < 18.5){
				System.out.println("ƫ�ݣ�");
			}else if(a < 25.0){
				System.out.println("������");
			}else if(a < 30.0){
				System.out.println("���أ�");
			}else{
				System.out.println("���֣�");
			}
		}		
	}
}
