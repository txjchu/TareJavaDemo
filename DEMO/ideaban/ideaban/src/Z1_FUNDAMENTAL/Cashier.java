package Z1_FUNDAMENTAL;

import java.util.Scanner;

/**
 * 柜台收银程序
 * @author: Peter
 * @date: 2020/5/23 16:38
 */
public class Cashier {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入单价：");
        double unitPrice = scan.nextDouble();
        System.out.println("请输入数量：");
        double amount = scan.nextDouble();
        System.out.println("请输入金额：");
        double money = scan.nextDouble();

        // 计算总价（单价*数量），且满500打八折
        double totalPrice = unitPrice * amount;
        if(totalPrice >= 500){
            totalPrice *= 0.8;
        }

        if(money >= totalPrice){// 给的 money 足够，需要找零
            double change = money - totalPrice;// 计算找零：金额-总价
            System.out.println("总价为："+ totalPrice +"，找零为："+ change);
        } else { // 若不够，提示补差额
            double balance = totalPrice - money;
            System.out.println("您给的钱不够，还差"+ balance);
        }

    }
}
