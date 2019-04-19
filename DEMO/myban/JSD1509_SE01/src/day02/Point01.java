package day02;
/**
 * java�����е��඼ֱ�ӻ��ӵļ̳���Object���������ڱ���Դ����ʱ�����ֵ�ǰ��û��ʹ��extends�̳��κ���ʱ��
 * ������ֱ�Ӽ̳���Object
 * @author Administrator
 *
 */
public class Point01 {
	private int x;
	private int y;
	
	public Point01(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * ��дObject�ṩ��toString���� constructor
	 * ���ص��ַ�����ʽû�о���Ҫ�󣬽������԰��չ����е�ʵ���������������ͨ���ַ�����Ӧ��������Ҫ�˽⵱ǰ�����е�������Ϣ��
	 */
	
	public String toString(){
		return "(" + x +","+ y +")";
	}
	
	/**
	 * ��дObject�ṩ��equals������
	 * equals������������ж���������������Ƿ�һ�������񣩡�����equals����Ҫ����������ֵ��������ͬ��
	 * ��һ�ж���������������ؼ����Զ�һ�¼��ɡ�
	 * equals()��������ԭ��
	 * 1.�κζ����Null�Ƚϣ�������false;
	 * 2.ͬһ������equals�Ƚϣ�Ӧ�ú����true;
	 * 3.������������ͬһ����ʱ��Ӧ����false.
	 */
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(obj == this){
			return true;
		}
		if(obj instanceof Point01){
			Point01 p = (Point01) obj;
			return p.x == this.x && p.y == this.y;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Point01 p = new Point01(1, 2);
		String str = p.toString();
		System.out.println(p);//�÷����Ὣ���������toString()�����ķ��ص��ַ������������̨��//(1,2)
		System.out.println(str);//(1,2)
		
		Point01 p1 = new Point01(1,2);
		System.out.println(p == p1);//false
		/*
		 * ����Object�е�equals�����ıȽϾ���ʹ�á�==�������Բ���дequals()�����Ļ����Ƚ���û������ġ�
		 */
		System.out.println(p.equals(p1));//true
	}
}













