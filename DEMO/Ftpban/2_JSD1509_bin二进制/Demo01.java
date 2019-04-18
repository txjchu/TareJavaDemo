package bin;

public class Demo01 {

	public static void main(String[] args) {
		int n = 234;
		//���234��2����
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
		
		//64λ��������ֵ
		long m = Long.MAX_VALUE;
		System.out.println(
			Long.toBinaryString(m));
		// API: Java ϵͳ�����ĵ��ֳɵ���� 
		// Java �ṩ�˺ܶ��ֳɵĴ���Ρ�
		
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
		// ~ ȡ�����㣺��1->0  0->1
		int y = ~x+1;// ����Գƹ���!
		System.out.println(y);//9
		
		//�������Ŀ:д�����´���Ľ��
		System.out.println(~9); // ~9=-9-1=-10 
		System.out.println(~-9); //~-9 = 9-1 = 8
		//16������2���Ƶ���д.
		int f = 0xf;//0 ~  a b c d e f
		System.out.println(f); //15
		System.out.println(
			Integer.toBinaryString(f)); 
		int k = 0xc1;
		System.out.println(k);//193
		System.out.println(
			Integer.toBinaryString(k));
		//���á�2���ƣ�16������д������b���и�ֵ
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
		//��ѡ�����ϴ������������  ��
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
		
		int name = '��';
		System.out.println(
			Integer.toBinaryString(name));
		//���һ���ַ���16���Ʊ���
		System.out.println(
			Integer.toHexString(name));
		
		//2��������
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
		
		//i=5 ������ٵķ���ʵ�� i*8
		// ��: i<<3
		i=-40;
		j=i>>>2;
		System.out.println(j);//û����ѧ����
		j=i>>2; // j = i/2/2;
		System.out.println(j);//-10 ����ѧ����
		
		// >>> ����ʱ��������û����ѧ���壡
		// >>> ��Ϊ�߼��������㣨û����ѧ���壩
		// >> ��Ϊ��ѧ�������㣨�������ѧ����ģ�
		
		i = -5;
		j = i>>1;// ����ȡ�����Ľ�� -3
		System.out.println(j);//-3
		
		//����ɫ�в����ɫ����
		int color = 0xA9C6EC;
		int blue = color & 0xff;
		System.out.println(blue);
		//����ɫ�в����ɫ����
		int green=(color>>>8) & 0xff;
		System.out.println(green); 
		//����ɫ�в�ֺ�ɫ����
		int red=(color>>>16) & 0xff;
		System.out.println(red); 
		
		//��һ��int���Ͳŷ�Ϊ 4��byte����
		i = 0xb5c4a8f0;
		int b1 = i & 0xff;
		int b2 = (i>>>8) & 0xff;
		int b3 = (i>>>16) & 0xff;
		int b4 = (i>>>24) & 0xff;
		
		//��4��byte�ϲ�Ϊ һ�� int
		//j = (b4<<24)|(b3<<16)|(b2<<8)|b1;
		j = (b4<<24)+(b3<<16)+(b2<<8)+b1;
		System.out.println(
			Integer.toHexString(j)) ;
		//����ɫ�����ϲ�ΪRGB��ɫ: ��
	}
	
}










