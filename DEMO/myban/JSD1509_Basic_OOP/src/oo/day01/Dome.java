package oo.day01;
//���û��Ⱥ�
public class Dome {
	public static void main(String[] args) {
		int c1=1;
		int c2=c1;
		c1=4;
		System.out.println(c2);
		
		Cell c=new Cell();
		c=null;
		//c.row=2;
		//System.out.println(c);// NullPointerException
		
		Cell c3=new Cell();
		Cell c4=c3;//ָ��ͬһ������
		c3.row=3;
		c4.row=4;
		System.out.println(c4.row);
		System.out.println(c3.row);
	}

}
