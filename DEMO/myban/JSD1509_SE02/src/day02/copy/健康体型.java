package day02.copy;

import java.util.Scanner;

/**
 * 测试身高体重是否健康
 * 是否健康： a = (体重 * 0.45359237)/((身高 * 0.0254)*(身高 * 0.0254))
 * @author Administrator
 *
 */
public class 健康体型 {
	public static void main(String[] args) {
		final double pound = 0.45359237;//pound:英镑，中计，敲打	体重系数
		final double inch = 0.0254;//inch:英寸，身高，	身高系数
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
				System.out.println("偏瘦！");
			}else if(a < 25.0){
				System.out.println("正常！");
			}else if(a < 30.0){
				System.out.println("超重！");
			}else{
				System.out.println("过胖！");
			}
		}		
	}
}
