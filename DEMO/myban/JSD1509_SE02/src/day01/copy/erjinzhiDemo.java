package day01.copy;
/**
 * ������֪ʶ		binary  adj. [��] �����Ƶģ���Ԫ�ģ���̬��
 * 
 * @author Administrator
 *
 */
public class erjinzhiDemo {
	public static void main(String[] args) {
		int n = 234;
		//���234��2����
		System.out.println(Integer.toBinaryString(n));  //11101010
		System.out.println(Integer.toBinaryString(255));//11111111
		System.out.println(Integer.toBinaryString(225));//11100001
		
		/*
		 * 1.��������
		 * �������ֵ  +1 = ��Сֵ����Сֵ -1 = ���ֵ��  
		 * 4λ2�������ֵΪ7��0111������СֵΪ-8��1000������Ϊ��������Ĵ��ڣ�7+1=-8��1000��
		 * 		      0��0000��                  -1��1111��
		 */
		
		int max = Integer.MAX_VALUE;
		System.out.println("int��MAX = "+ max);//int��MAX = 2147483647
		int min = Integer.MIN_VALUE;
		System.out.println("int��MIN = " + min);//int��MIN = -2147483648
														  // 1111111 11111111 11111111 11111111	
		System.out.println(Integer.toBinaryString(max));  // 1111111 11111111 11111111 11111111
		System.out.println(Integer.toHexString(max));	  //   7   f    f   f    f   f    f   f  ==0x7fffffff(16����)
		System.out.println(Integer.toBinaryString(min));  //10000000 00000000 00000000 00000000
		//����
		int max_1 = max + 1;
		System.out.println(max_1);//-2147483648
		System.out.println(Integer.toBinaryString(max_1));//10000000 00000000 00000000 00000000
		int min_1 = min - 1;
		System.out.println(min_1);//2147483647
		System.out.println(Integer.toBinaryString(min_1));// 1111111 11111111 11111111 11111111
		
		//64λ��������ֵ
		long l = Long.MAX_VALUE;
		System.out.println("long�������͵����ֵΪ��"+ l);//long�������͵����ֵΪ��9223372036854775807
		System.out.println(Long.toBinaryString(l));
					// 1111111 11111111 11111111 11111111 11111111 11111111 11111111 11111111
		long i = -1L;
		System.out.println(Long.toBinaryString(i));
					//11111111 11111111 11111111 11111111 11111111 11111111 11111111 11111111
		
		/**
		 *  2.  2���Ƶ�����
		 *  
		 */
		
		//1��   ȡ�����㣨����Գƹ��ɣ�:~	��xȡ����1����-x����ʽ��~a + 1 = -a.
		
		System.out.println(~ -8);	 //7
		System.out.println(~ -8 + 1);//8
		System.out.println(~ 2);	 //-3
		int x = 9 +(Integer.MAX_VALUE + 1) * 2;	//MAX+1*2 = 0
		System.out.println(x);//9
		x = -9;
		int y = ~x + 1;//����Գƹ��ɣ�
		System.out.println(y);//9
		//������Ŀ��д�����´���Ľ����
		System.out.println(~9);//  ~9 = -9 - 1 = -10 
		System.out.println(~-9);//~-9 = 9 - 1 = 8		
		//16������2���Ƶ���д��
		int f = 0xf;
		System.out.println("f = "+ f);//f = 15
		System.out.println(Integer.toBinaryString(f));//1111
		int k = 0xc1;
		System.out.println("k = "+ k);//k = 193
		System.out.println(Integer.toBinaryString(k));//11000001
		//����"2���ƣ�16������д��"��ʽ��b���и�ֵ
		int b = 0xea;
		System.out.println("b = "+ b);//b = 234
		max = 0x7fffffff;//int��������Ϊ  4�ֽ�  = 8λ16����  = 32λ2����
		System.out.println("max:"+ max);//max:2147483647
		System.out.println("max:"+ Integer.toBinaryString(max));  // 1111111 11111111 11111111 11111111
		min = 0x80000000;
		System.out.println("min:"+ min);//min:-2147483648
		System.out.println("min:"+ Integer.toBinaryString(min));  //10000000 00000000 00000000 00000000
		long c = 0x8000000000000000L;
		System.out.println("c:"+ c);//c:-9223372036854775808
		i = 0xffffffff;//iΪlong����
		System.out.println(i);//-1
//		System.out.println(Integer.toBinaryString(i));
		System.out.println(Long.toBinaryString(i));
							//1111111111111111111111111111111111111111111111111111111111111111
		n = 0xfffffffe;
		  //  11111111 11111111 11111111 11111110
		  //     f   f    f   f    f   f    f   e
		System.out.println(n);//-2
		int g = 281282;		// ==0x44ac2(16����)
		System.out.println(Integer.toBinaryString(g)); // 100 01001010 11000010				
		System.out.println(Integer.toHexString(g));    //   4    4   a    c   2
		int name = '��';                                             // 0x5218
		System.out.println("����"+ Integer.toBinaryString(name)); 	// 1010010 00011000
		System.out.println("����"+ Integer.toHexString(name));	    //   5   2    1   8
		
		System.out.println("===============");
		System.out.println((Integer.MAX_VALUE + 1) * 2);//0
		System.out.println((Double.MAX_VALUE + 1) * 2);//Infinity
		System.out.println((Float.MAX_VALUE + 1) * 2);//Infinity
		System.out.println((Integer.MAX_VALUE + 1) / 2);//-1073741824
		System.out.println((Integer.MIN_VALUE - 1) * 2);//-2
		System.out.println((Double.MIN_VALUE - 1) * 2);//-2.0
		System.out.println((Float.MIN_VALUE - 1) * 2);//-2.0
		System.out.println((Integer.MIN_VALUE - 1) / 2);//1073741823
		System.out.println((Double.MIN_VALUE - 1) / 2);//-0.5
		System.out.println((Float.MIN_VALUE - 1) / 2);//-0.5
		System.out.println("===============");
		
		
		//2��   <<<���߼���λ�ơ�<<����ѧ��λ�ơ�
		int m = 10;
		System.out.println(m +":"+ Integer.toBinaryString(m));//10:1010
		m = m << 1;
		System.out.println(m +":"+ Integer.toBinaryString(m));//20:10100
		m = m << 2;
		System.out.println(m +":"+ Integer.toBinaryString(m));//80:1010000
		int j = 100 >> 2;
		System.out.println(j);//25
		j = -40 >>> 2;//�߼���λ�ƣ�����ѧ����
		System.out.println(j);//1073741814��
		j = -40 >> 2;//��ѧ��λ��
		System.out.println(j);//-10
		
		int a = 0x292bd7eb;
		System.out.println(Integer.toBinaryString(a));//    101001 00101011 11010111 11101011
		b = a >>> 1;
		System.out.println(Integer.toBinaryString(b));//     101001 00101011 11010111 1110101		
		a = 0xa92bd7eb;
		System.out.println(Integer.toBinaryString(a));//  10101001 00101011 11010111 11101011
		b = a >>> 1;
		System.out.println(Integer.toBinaryString(b));//   10101001 00101011 11010111 1110101
		a = 0xa;
		System.out.println(a);//10
		b = a << 1;
		System.out.println(b);//20
		b = a << 2;
		System.out.println(b);//40
		
		a = 100;
		b = a >> 2;
		System.out.println(b);//25
		//i = 5;������ٵķ���ʵ�� i*8 �� �𰸣� i << 3��
		a = -40;
		b = a >>> 2;
		System.out.println(b);//1073741814   û����ѧ����
		b = a >> 2; // b = a / 2 / 2
		System.out.println(b);//-10  ����ѧ����
		
		//>>>����������û����ѧ���塣>>>����Ϊ�߼��������㣨û����ѧ���壩��  >>����Ϊ��ѧ�������㣨�������ѧ���壩��
		a = - 5;
		b = a >> 1;//����ȡ�����Ľ��  -3
		System.out.println(b);//-3
		int q = -1 >> 13;//-1����ѧ��λ���㣨<<��>>����������
		System.out.println("q = "+ q +"  "+ Integer.toBinaryString(q));
						// q = -1  11111111111111111111111111111111
		
		//3. &������
		long aa = 0x12eedfda;
		        //00010010111011101101111111011010	
		long bb = 0xff;
				//00000000000000000000000011111111
				//                        11011010  = 0xda       
		System.out.println(aa +","+ bb);//317644762,255
		System.out.println("aa & bb = "+ (aa & bb) +","+ Long.toBinaryString(aa & bb));
		
		//����ɫ�в����ɫ����
		int color = 0xA9C6EC;
		System.out.println(Integer.toBinaryString(color));
						//  10101001 11000110 11101100
		int blue = color & 0xff;
		System.out.println(blue);//236
		//����ɫ�в����ɫ����
		int green = (color >>> 8) & 0xff;
		System.out.println(green);//198
		//����ɫ�в�ֺ�ɫ����
		int red = (color >>> 16) & 0xff;
		System.out.println(red);//169
		
	}
}














