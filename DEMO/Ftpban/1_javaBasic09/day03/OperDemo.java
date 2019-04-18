package day03;
//运算符演示
public class OperDemo {

	public static void main(String[] args) {
		/*
		 * 6.三目/条件运算符
		 *   1)语法:
		 *       boolean?数1:数2
		 *   2)执行过程:
		 *       计算boolean的值:
		 *         若为true，则整个表达式的结果为数1
		 *         若为false，则整个表达式的结果为数2
		 */
		int a=8,b=55;
		int max = a>b?a:b;
		System.out.println("max="+max); //max=55
		
		
		
		
		
		
		/*
		 * 5.字符串连接运算符:
		 *   1)+有两种用法:
		 *     1.1)若两边为数字，则做加法运算
		 *     1.2)若有一边为字符串，则做字符串拼接运算
		 */
		/*
		int age = 37;
		System.out.println("age="); //age=，字符串中的原样输出
		System.out.println(age); //37，不在字符串中则为变量，即输出的是变量的值
		System.out.println("age="+age); //age=37
		System.out.println("我的年龄是:"+age); //我的年龄是:37
		System.out.println("我今年"+age+"岁了"); //我今年37岁了
		
		System.out.println(100+200+""+300); //"300300"
		System.out.println(100+200+300+""); //"600"
		System.out.println(""+100+200+300); //"100200300"
		*/
		
		
		
		
		
		/*
		 * 4.赋值运算符:
		 *   1)简单赋值运算符:=
		 *   2)扩展赋值运算符:+=,-=,*=,/=,%=
		 */
		/*
		int a=5;
		a+=10; //相当于a=a+10
		System.out.println(a); //15
		a*=2; //相当于a=a*2
		System.out.println(a); //30
		*/
		
		/*
		 * 3.逻辑运算符:
		 *   1)&&:短路与(并且)，两边都为真则为真，见false则false
		 *        当第1个数为false时，发生短路(后面的不执行了)
		 *     ||:短路或(或者)，有一边为真则为真，见true则true
		 *        当第1个数为true时，发生短路(后面的不执行了)
		 *     ! :逻辑非(取反)，非真则假，非假则真
		 *   2)逻辑运算是建立在关系运算的基础之上的
		 *     逻辑运算的结果也是boolean型
		 */
		/*
		int a=5,b=10,c=5;
		boolean b1 = a<b || c++>2;
		System.out.println(b1); //true
		System.out.println(c);  //5,短路了
		*/
		
		/*
		boolean b1 = a>b && c++>2;
		System.out.println(b1); //false
		System.out.println(c);  //5，短路了
		*/
		
		
		
		
		
		/*
		boolean b1 = !(a>b);
		System.out.println(b1);     //!false=true
		System.out.println(!(b>c)); //!true=false
		*/
		
		/*
		System.out.println(a>b || c<b);  //false||true=true
		System.out.println(a==c || b<c); //true||false=true
		System.out.println(a>b || a!=c); //false||false=false
		System.out.println(a<b || a>=c); //true||true=true
		*/
		
		/*
		boolean b1 = a>b && c<b; 
		System.out.println(b1);          //false&&true=false
		System.out.println(a==c && b<c); //true&&false=false
		System.out.println(a>b && a!=c); //false&&false=false
		System.out.println(a<b && a>=c); //true&&true=true
		*/
		
		
		
		
		/*
		 * 2.关系运算符:
		 *   1)>(大于),<(小于)
		 *     >=(大于或等于),<=(小于或等于)
		 *     ==(等于),!=(不等于)
		 *   2)关系运算的结果为boolean型
		 *     关系成立则为true，关系不成立则为false
		 */
		/*
		int a=5,b=10,c=5;
		boolean b1 = a>b;
		System.out.println(b1);   //false
		System.out.println(a<c);  //false
		System.out.println(a<=c); //true
		System.out.println(a>=c); //true
		System.out.println(a==b); //false
		System.out.println(a!=b); //true
		*/
		
		
		
		
		
		
		/*
		 * 1.算术运算符:+,-,*,/,%,++,--
		 *   1)%:取余/取模，余数为0即为整除
		 *   2)++/--:自增1/自减1，可以写在变量前也可以写在变量后
		 *     2.1)单独使用时，在前在后无差别
		 *     2.2)被使用时，在前在后有差别
		 *           a++的值为a的值
		 *           ++a的值为a+1的值
		 */
		/*
		int a=5,b=5;
		System.out.println(a++); //5
		System.out.println(a);   //6
		System.out.println(++b); //6
		System.out.println(b);   //6
		*/
		/*
		int a=5,b=5;
		int c=a++;
		int d=++b;
		System.out.println(a); //6
		System.out.println(b); //6
		System.out.println(c); //5
		System.out.println(d); //6
		*/
		/*
		int a=5,b=5;
		a++; //相当于a=a+1
		++b; //相当于b=b+1
		System.out.println(a); //6
		System.out.println(b); //6
		*/
		//System.out.println(5%2); //1，商2余1
		//System.out.println(8%2); //0，商4余0---整除
		//System.out.println(2%8); //2，商0余2
		//System.out.println(8.456%2); //0.456
		
	}

}









