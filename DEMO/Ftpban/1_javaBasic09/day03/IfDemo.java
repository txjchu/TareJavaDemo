package day03;
//分支结构演示
public class IfDemo {
	public static void main(String[] args) {
		int num = 8;
		switch(num){ //byte,short,int,char
		case 1: //相当于if(num==1)
			System.out.println(111);
			break;
		case 2: //以此为入口
			System.out.println(222);
			break; //跳出switch
		case 3:
			System.out.println(333);
			break;
		default: //无论写在任何位置，都是所有case都没配上时才走
			System.out.println(444);
		}
		
		
		
		
		
		
		
		
		
		
		
		/*
		int num = 5;
		if(num%2==0){
			System.out.println(num+"是偶数");
		}else{
			System.out.println(num+"是奇数");
		}
		System.out.println("over");
		*/
		
		/*
		int num = 5;
		if(num%2==0){
			System.out.println(num+"是偶数");
		}
		System.out.println("over");
		*/
	}
}











