package day02;
/**
 * java�����е��඼ֱ�ӻ��ӵļ̳���Object
 * �������ڱ���Դ����ʱ�����ֵ�ǰ��û��ʹ��extends
 * �̳��κ���ʱ��������ֱ�Ӽ̳���Object
 * @author Administrator
 *
 */
public class Point {
	private int x;
	private int y;
	
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	/**
	 * ��дObject�ṩ��toString����
	 * ���ص��ַ�����ʽû�о���Ҫ�󣬽������԰�����
	 * �е��������������ͨ���ַ�����Ӧ��������Ҫ�˽�
	 * ��ǰ�����е�������Ϣ��
	 */
	public String toString(){
		return "(" + x + "," + y + ")";
	}
	/**
	 * ��дObject�ṩ��equals������
	 * equals������������ж��������������
	 * �Ƿ�һ��(����)������equals����Ҫ��
	 * ��������ֵ��������ͬ����һ�ж���������
	 * �������ؼ�����ֵ��һֱ���ɡ�
	 */
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(obj == this){
			return true;
		}
		if(obj instanceof Point){
			Point p = (Point)obj;
			return p.x==this.x&&p.y==this.y;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		Point p = new Point(1,2);
		/*
		 * ������дtoString()������ʹ�õ�����
		 * ��Object�м̳еģ���ô���ص��ַ���
		 * ��ʽΪ:����@��ַ �����岻��
		 * ����Ҫ�˽⵱ǰ�������Ϣ������Ҫ��д
		 * �ö����������toString������
		 * 
		 */
//		String str = p.toString();
//		System.out.println(str);
		/*
		 * System.out.println(Object obj)
		 * �÷����Ὣ�����Ķ����toString()����
		 * ���ص��ַ������������̨��
		 */
		System.out.println(p);
		
		
		Point p1 = new Point(1,2);
		/*
		 * �����������ͱ����б�����Ƕ���ĵ�ַ��
		 * ==�Ƚϵ���ֵ�Ƿ���ͬ�����Զ�������
		 * �������ͱ����Ƚϣ����ǱȽϵ�ַ�Ƿ���ͬ
		 * ����ͬ���ʾΪͬһ������
		 * ����"=="�Ƚϵ���:�ǲ���ͬһ��
		 */
		System.out.println(p==p1);//false
		/*
		 * ����Object�е�equals�����ıȽϾ���
		 * ʹ��"=="�����Բ���дequals�Ļ����Ƚ�
		 * ��û������ġ�
		 */
		System.out.println(p.equals(p1));
	}
}









