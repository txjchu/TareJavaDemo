package day05;

public class Demo01 {

	public static void main(String[] args) {
		int n=234;
		//输出234的2进制
		System.out.println(Integer.toBinaryString(n));
		/*
		int max=Integer.MAX_VALUE;//1
		System.out.println(max);
		System.out.println(
			Integer.toBinaryString(max));
		int min=max+1;//2
		System.out.println(min);//3
		System.out.println(
			Integer.toBinaryString(min));
		*/
		/*
		int a=127;
		System.out.println(a);
		System.out.println(
			Integer.toBinaryString(a));
		int b=127+1;
		System.out.println(b);
		System.out.println(
			Integer.toBinaryString(b));
		//a=2147483647
		//b=2147483648
		//c=-2147483647  √
		//d=-2147483648
		*/
		
		byte c=127;
		System.out.println(c);
		System.out.println(
			Integer.toBinaryString(c));//???应该用byte.toBinaryString(),包装类，2进制1的左侧的0自动省略
		byte d=(byte)(127+1);
		System.out.println(d);
		System.out.println(
			Integer.toBinaryString(d));   //
		

		int x;//???
		x=-9;
		//~取反运算：将1->0  0->1
		int y=~x+1;//补码对称规律！
		System.out.println(y);//9
		
		//经典题目：写出如下代码的结果
		//取反加1
		System.out.println(~9);//~9=-9-1=10
		System.out.println(~-9);//~-9=-9+1=8
		
		//16进制是2进制的缩写。
		int f=0xf;  // 0 ~ 9 a b ~ f
		System.out.println(f);//15
		System.out.println(
			Integer.toBinaryString(f));
		int k=0xc1;
		System.out.println(k);//193
		System.out.println(
			Integer.toBinaryString(k));
		
		//利用“2进制（16进制缩写）”对b进行赋值
		int b=0xea;
		System.out.println(b);  //234
		
		int max=0x7fffffff;
		System.out.println(max);
		System.out.println(
			Integer.toBinaryString(max));
		
		int min=0x80000000;
		System.out.println(min);
		System.out.println(
			Integer.toBinaryString(min));
		
		/*
		long c=0x
		int i=0xffffffff;
		System.out.println(i);
		//请选择如上代码的输出结果：
		//A fffffffff
		//B -1
		//C 2147483647
		//D 2147483648
		*/
		
		long w=0xffffffffffffffffL;
		System.out.println(w);
		
		int q=0xfffffffe;
		//11111111 11111111 11111111 11111110
		System.out.println(q);//-2
		System.out.println(
			Integer.toBinaryString(q));
		
		int g=281282;
		System.out.println(
			Integer.toBinaryString(g));//输出2进制
		System.out.println(
			Integer.toHexString(g));//输出16进制
		
		int name='朱';
		System.out.println(
			Integer.toBinaryString(name));
		System.out.println(
			Integer.toHexString(name));//输出一个字符的16进制编码
		
		int i=0x292bd7eb;
		System.out.println(
			Integer.toBinaryString(i));
		int j=i>>>1;
		System.out.println(
			Integer.toBinaryString(j));
		
		int i1=0xa92bd7eb;
		System.out.println(
			Integer.toBinaryString(i1));
		int j1=i>>>1;
		System.out.println(
			Integer.toBinaryString(j1));
		
		System.out.println(i);
		System.out.println(i1);
		
		int i2=0x292bd7eb;
		System.out.println(
			Integer.toBinaryString(i2));
		int j2=i>>1;
		System.out.println(
			Integer.toBinaryString(j2));
			
		int i3=0xa92bd7eb;
		System.out.println(
			Integer.toBinaryString(i3));
		int j3=i>>1;
		System.out.println(
			Integer.toBinaryString(j3));
		
		i=0xa;
		System.out.println(i);//10
		j=i<<1;
		System.out.println(j);//20
		j=i<<2;
		System.out.println(j);//40
		
		i = 100;//(10)
		j = i>>2;
		System.out.println(j);//输出25
		
		i=-5;
		j=i>>1;
		System.out.println(j);//-3(取整运算，当原数为负数的时候【向下】取整运算)
		
		i=-40;
		j=i>>>2;
		System.out.println(j);//没有数学意义
		j=i>>2;               //j/2/2
		System.out.println(j);//-10有数学意义
		/*
		//从颜色中拆分蓝色分量
		int color=0xA9c6EC;
		int blue=color & 0xff;
		System.out.println(blue);
		//从颜色中拆分绿色分量
		int green=(color>>>8)&0xff;
		System.out.println(green);
		//从颜色中拆分红色分量
		int red=(color>>>16)&0xff;
		System.out.println(red);
		*/
		int red=169;
		int green=196;
		int blue=236;
		int color;
		color = (red<<16) | (green<<8) | blue;
		System.out.println(
			Integer.toHexString(color));
		
		//将一个int类型拆分为4个byte数据。
		
		i=0xb5c4a8f0;
		int b1=i & 0xff;
		int b2=(i>>>8 ) & 0xff;
		int b3=(i>>>16) & 0xff;
		int b4=(i>>>24) & 0xff;
		System.out.println(i);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		j=(b4<<24) | (b3<<16) | (b2<<8) | b1;
		System.out.println(
				Integer.toHexString(j));
		
		i = 0xb74eab0f;
		System.out.println(Integer.toHexString(i));
		int c1 = i & 0xff;
		int c2 = (i >> 8) & 0xff;
		System.out.println(Integer.toHexString(i));
		int c3 = (i >> 16) & 0xff;
		int c4 = (i >> 24) & 0xff;
		System.out.println(Long.toHexString(c4)+Long.toHexString(c3)+Long.toHexString(c2)+Long.toHexString(c1));
		
		
	}

}
