package day02;

//数据类型演示
public class DataTypeDemo {
	public static void main(String[] args) {
		
		/*
		 * 类型转换练习:
		 * 1.声明int型变量a并赋值为250
		 *   声明long型变量b并赋值为a
		 *   声明int型变量c并赋值为b
		 * 2.声明long型变量d并赋值为100亿
		 *    声明int型变量e并赋值为d，输出e的值
		 *   声明double型变量f并赋值为25.678
		 *    声明int型变量g并赋值为f，输出g的值
		 * 3.声明byte型变量b1和b2,并分别赋值为5和6
		 *   声明byte型变量b3并赋值为b1+b2的和 
		 */
		
		
		
		/*
		int a = 5;
		long b = a;     //自动类型转换:从小到大
		int c = (int)b; //强制类型转换:从大到小
		
		long d = 250;  //自动类型转换
		double e = 35; //自动类型转换
		float f = (float)3.14; //强制类型转换
		
		long g = 10000000000L;
		int h = (int)g;
		System.out.println(h); //有可能溢出
		
		double i = 3.987654;
		int j = (int)i;
		System.out.println(j); //有可能精度丢失，强转为整数时，小数位无条件舍弃
		
		//常见面试题
		short b1 = 5; //整数直接量可以直接赋值给byte,short,char
		short b2 = 6;
		//short b3 = b1+b2; //编译错误，参与运算时一律转为int
		short b4 = (short)(b1+b2); 
		*/
		
		/*
		 * double、boolean、char的练习:
		 * 1.声明浮点型变量a并赋值为25.678
		 *   声明整型变量b并赋值为5/2，输出b
		 *   声明浮点型变量c并赋值为5/2，输出c
		 *   声明浮点型变量d并赋值为5.0/2，输出d
		 *   声明浮点型变量e和f，分别赋值为3.0和2.9
		 *     输出e-f的值
		 * 2.声明布尔型变量b1并赋值为true
		 *   声明布尔型变量b2并赋值为false
		 *   声明布尔型变量b3并赋值为55----???
		 * 3.声明char型变量c1并赋值为'男'
		 *               c2并赋值为'f'
		 *               c3并赋值为'4'
		 *   输出2+2值，输出'2'+2值，输出'2'+'2'值
		 *   声明char型变量c4并存储65，输出c4
		 *   声明char型变量c5并存储\，输出c5
		 */
		
		/*
		//5.char:字符型，2个字节，单引号中，有且仅有一个
		char c1 = '女';
		char c2 = 'c';
		char c3 = '3';
		char c4 = '*';
		char c5 = ' ';
		//char c6 = ''; //编译错误，必须有
		//char c7 = '你好'; //编译错误，只能有一个
		//char c8 = 女; //编译错误，必须放在单引号中
		
		char c9 = 65;
		System.out.println(c9); //A
		
		System.out.println(2+2);     //4
		System.out.println('2'+'2'); //100，'2'对应的码50再上'2'对应的码50
		
		char c10 = '\\';
		System.out.println(c10);
		*/
		
		
		/*
		//4.boolean:布尔型，1个字节
		boolean b1 = true; //true和false叫boolean型直接量
		boolean b2 = false;
		//boolean b3 = 25; //编译错误，只能存储true和false
		*/
		
		/*
		//3.double:浮点型，8个字节，很大很大
		double a=3.14; //3.14默认为double型
		float b=3.14F;
		
		double c=6.0;
		double d=4.9;
		System.out.println(c-d); //舍入误差，精确运算场合不可使用
		
		int e=5/2;
		System.out.println(e); //2，小数位无条件舍弃
		double f=5/2;
		System.out.println(f); //2.0，小数位无条件舍弃，将2赋值给double，即为2.0
		double g=5.0/2;
		System.out.println(g); //2.5，5.0/2为double型，所以会保留小数位
		*/
		
		
		
		
		/*
		 * int、long类型练习:
		 * 1.声明整型变量a并赋值为250
		 *   声明整型变量b并赋值为100亿-----???
		 *   声明整型变量c并赋值为5/3，输出c
		 *   声明整型变量d并赋值为2147483647
		 *     给d本身增1，输出d的值
		 * 2.声明长整型变量e并赋值为100亿----???
		 *   声明长整型变量f并赋值为100亿L
		 *   声明长整型变量g并存储10亿*2*10L，输出g
		 *   声明长整型变量h并存储10亿*3*10L，输出h
		 *   声明长整型变量i并存储10亿L*3*10，输出i
		 *   声明长整型变量time并存储自1970.1.1零时
		 *     到此时此刻的毫秒数，输出time
		 *   
		 */
		
		
		
		
		/*
		//2.long:长整型，8个字节，很大很大
		long a = 250L; //250L叫long型直接量
		//long b = 10000000000; //编译错误，100亿默认为int型，但超范围了
		long c = 10000000000L;
		
		long d = 1000000000*2*10L;
		System.out.println(d); //200亿
		long e = 1000000000*3*10L;
		System.out.println(e); //溢出
		long f = 1000000000L*3*10;
		System.out.println(f); //300亿，建议L写在第1个数字后
		
		//获取自1970.1.1零时到此时此刻的毫秒数
		long time = System.currentTimeMillis();
		System.out.println(time);
		*/
		
		
		/*
		//1.int:整型，4个字节，-21个多亿到21个多亿
		int a=250; //250叫整数直接量，默认int型
		//int b=10000000000; //编译错误，100亿默认为int型，但超范围了
		
		int c=5/2;
		System.out.println(c); //2，两个整数相除结果还是整数，小数位无条件舍弃
		
		int d = 2147483647;
		d = d + 3;
		System.out.println(d); //溢出，需要避免
		*/
	}
}







