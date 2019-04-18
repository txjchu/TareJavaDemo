package bin;

public class Demo01 {

	public static void main(String[] args) {
		int n = 234;
		//输出234的2进制
		System.out.println(
			Integer.toBinaryString(n)); 
		
		int max = 2147483647;//Integer.MAX_VALUE;//1
		System.out.println(max); 
		System.out.println(
			Integer.toBinaryString(max));
		int min = max+1;//2
		System.out.println(min);//3
		System.out.println(
			Integer.toBinaryString(min));
		// A 2147483647
		// B 2147483648
		// C -2147483648
		// D -2147483647
		
		//64位补码的最大值
		long m = Long.MAX_VALUE;
		System.out.println(
			Long.toBinaryString(m));
		// API: Java 系统带来的的现成的类库 
		// Java 提供了很多现成的代码段。
		
		n = -1;//int
		System.out.println(
			Integer.toBinaryString(n));
		//A -1
		//B -111111111111111111111111111
		//C 1111111111111111111111111111
		//D -000000000000000000000000001
		
		long l = -1L;
		System.out.println(
			Long.toBinaryString(l));
		
		
		int x=9+(Integer.MAX_VALUE+1)*2;
		System.out.println(x); //9
		
		
		x = -9;
		// ~ 取反运算：将1->0  0->1
		int y = ~x+1;// 补码对称规律!
		System.out.println(y);//9
		
		//经典的题目:写出如下代码的结果
		System.out.println(~9); // ~9=-9-1=-10 
		System.out.println(~-9); //~-9 = 9-1 = 8
		//16进制是2进制的缩写.
		int f = 0xf;//0 ~  a b c d e f
		System.out.println(f); //15
		System.out.println(
			Integer.toBinaryString(f)); 
		int k = 0xc1;
		System.out.println(k);//193
		System.out.println(
			Integer.toBinaryString(k));
		//利用“2进制（16进制缩写）”对b进行赋值
		int b = 0xea;
		System.out.println(b);//234
		
		max = 0x7fffffff;
		System.out.println(max);
		System.out.println(
			Integer.toBinaryString(max));
	
		min = 0x80000000;
		System.out.println(min);
		System.out.println(
			Integer.toBinaryString(min));
		
		long c = 0x8000000000000000L;
		System.out.println(c); 
	
		int i = 0xffffffff; 
		System.out.println(i); 
		//请选择如上代码的输出结果（  ）
		// A ffffffff
		// B -1
		// C 2147483647
		// D 2147483648
		
		i = 0xfffffffe; 
		//11111111 11111111 11111111 11111110 
		System.out.println(i); //-2
		
		int g = 281282;
		System.out.println(
			Integer.toBinaryString(g));
		System.out.println(
			Integer.toHexString(g)); 
		
		int name = '刘';
		System.out.println(
			Integer.toBinaryString(name));
		//输出一个字符的16进制编码
		System.out.println(
			Integer.toHexString(name));
		
		//2进制运算
		i=0x292bd7eb;
		System.out.println(
			Integer.toBinaryString(i));
		int j = i>>>1;
		System.out.println(
			Integer.toBinaryString(j));
		
		i=0xa92bd7eb;
		System.out.println(
			Integer.toBinaryString(i));
		j = i>>>1;
		System.out.println(
			Integer.toBinaryString(j));
		
		i = 0xa;
		System.out.println(i);//10
		j = i<<1;
		System.out.println(j);//20
		j = i<<2;
		System.out.println(j);//40
		
		i = 100;
		j = i>>2;
		System.out.println(j);
		
		//i=5 用最快速的方法实现 i*8
		// 答案: i<<3
		i=-40;
		j=i>>>2;
		System.out.println(j);//没有数学意义
		j=i>>2; // j = i/2/2;
		System.out.println(j);//-10 有数学意义
		
		// >>> 负数时候运算结果没有数学意义！
		// >>> 称为逻辑右移运算（没有数学意义）
		// >> 称为数学右移运算（结果有数学意义的）
		
		i = -5;
		j = i>>1;// 向下取整数的结果 -3
		System.out.println(j);//-3
		
		//从颜色中拆分蓝色分量
		int color = 0xA9C6EC;
		int blue = color & 0xff;
		System.out.println(blue);
		//从颜色中拆分绿色分量
		int green=(color>>>8) & 0xff;
		System.out.println(green); 
		//从颜色中拆分红色分量
		int red=(color>>>16) & 0xff;
		System.out.println(red); 
		
		//将一个int类型才分为 4个byte数据
		i = 0xb5c4a8f0;
		int b1 = i & 0xff;
		int b2 = (i>>>8) & 0xff;
		int b3 = (i>>>16) & 0xff;
		int b4 = (i>>>24) & 0xff;
		
		//将4个byte合并为 一个 int
		//j = (b4<<24)|(b3<<16)|(b2<<8)|b1;
		j = (b4<<24)+(b3<<16)+(b2<<8)+b1;
		System.out.println(
			Integer.toHexString(j)) ;
		//将颜色分量合并为RGB颜色: 略
	}
	
}










