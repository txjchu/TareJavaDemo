package a01;
//购物计价系统 V1 V2 V3
import java.util.Scanner;

public class shopping {
	public static void main(String[] args) {
//		Scanner console = new Scanner(System.in);
//		System.out.println("请输入商品单价（￥）：");
//		double unitPrice = console.nextDouble();
//		System.out.println("请输入商品数量：");
//		double amount = console.nextDouble();
//		System.out.println("请输入金额（￥）：");
//		double money = console.nextDouble();
//		console.close();
//		//计算商品总价，并计算出找零
//		double amountPrice = unitPrice * amount;
//		if(money >= amountPrice){
//			double remoney = money - amountPrice;		
//			System.out.println("支付金额（￥）："+amountPrice+",找零（￥）："+remoney);
//		}else{
//			double haicha = amountPrice - money; 
//			System.out.println("金额不足，还差（￥）："+haicha);
//		}
		
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入商品单价（￥）：");
		double da1 = scan.nextDouble();
		System.out.println("请输入商品数量（￥）：");
		double sa2 = scan.nextDouble();
		System.out.println("请输入收银金额（￥）：");
		double sa3 = scan.nextDouble();
		scan.close();
		//计算是否有余额，并对大于500的进行折扣处理
		double za4 = da1 * sa2;
		if( 0 <= sa3 && sa3 < za4){
			//当应收金额大于收入金额时，提示补差，或输入错误
			System.out.println("请输入正确收银金额！");
			System.out.println("应收金额（￥）：" + za4 +";请补差额（￥）：" + (za4 - sa3) );
		}else if(za4 <= sa3 && sa3 <500){
			System.out.println("应收金额（￥）：" + za4 + ";应找零（￥）：" + (sa3 - za4));
		}else if(500 <= sa3){
			System.out.println("应收金额（￥）：" + za4 + ";应找零（￥）：" + (sa3 - za4 * 0.8));
		}
		
	}
}