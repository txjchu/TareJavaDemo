package mycase;
/**
 * 两个空杯子：1个11升，1个7升，用程序写出如何得到2升水
 * @author Administrator
 *
 */
public class WaterGame {
	public static void main(String[] args) {
		int B = 0;//大杯初始值		
		int S = 0;//小杯初始值
		int b = 0;//一次活动后大杯剩余多少水
		int s = 0;//一次活动后小杯剩余多少水
		int a = 11 - B;//每次活动中，小杯向大杯中倒多少升水
		int count = 0;//给活动计数
		for(int i = 0; i < 100; i ++){
			if(b == 11){//当大杯中剩余水量到11升时，清零
				B = 0;
			} else {	
				B = b;
			}
			
			if(s == 0){//当小杯中的剩余水量到0升时，重装，7升水
				S = 7;
			} else {	
				S = s;  	
			}
			
			a = 11 - B;//大杯中还能装多少水
			if(a >= S){//若小杯中的水少于a，则a = 小杯中所有的水
				a = S; 	
			}
			
			b = B + a;
			s = S - a;
			
			count ++;
			if(s == 2){
				break;
			}
		}
		System.out.println("第"+ count +"次时，S杯中的水有"+ s +"升.");
	}
}
