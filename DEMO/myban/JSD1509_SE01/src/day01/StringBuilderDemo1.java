package day01;
/**
 * java.lang.StringBuilder
 * �ڲ�ά��һ���ɱ���ַ����飬����������ǽ���ַ��������޸Ĵ�������Դ�������⣻
 * �����ṩ�����ڱ༭�ַ������ݵ���ط�����
 * ����append
 * ɾ��delete
 * �ģ�replace
 * �壺insert
 * @author Administrator
 *
 */
public class StringBuilderDemo1 {
	public static void main(String[] args) {
		String str="Ŭ��ѧϰjava";
		//��ת��ΪStringBuilder
		StringBuilder builder=new StringBuilder(str);//------���������Ļ�ֱ���ǿ��ַ���
		
//		//StringBuilderת��ΪString
//		str=builder.toString();
//		System.out.println(str);
//		System.out.println(builder);
//		
//		/**
//		 * Ŭ��ѧϰjava��Ϊ���Ҹ��ù���
//		 * StringBuilder append(String str)
//		 * �ڵ�ǰ�ַ���ĩβ׷��ָ���ַ���������ֵ���ǵ�ǰStringBuilder����
//		 */
//		builder.append(",Ϊ���Ҹ��ù���");
//		System.out.println(builder.toString());
//		
//		/**
//		 * Ŭ��ѧϰjava������Ϊ�˸ı����磡
//		 * StringBuilder replace(int start,int end,String str)
//		 * ��ָ����Χ�ڵ��ַ����滻Ϊ��������
//		 */
//		builder.replace(9,builder.length(),"����Ϊ�˸ı����磡");
//		System.out.println(builder.toString());
//		
//		/**
//		 * ������Ϊ�˸ı����磡
//		 * StringBuilder delete(int start,int end)
//		 * 
//		 */
//		//builder.delete(8, builder.length());
//		//System.out.println(builder.toString());
//		
//		builder.delete(0,8);
//		System.out.println(builder.toString());
//		
//		/**
//		 * ���ţ�����Ϊ�˸ı����磡
//		 * StringBuilder insert(int i,String j);
//		 * ���������ַ������뵽ָ��λ�ô���ԭλ�ü������ַ���˳������ƶ���
//		 */
//		builder.insert(0, "����");
//		System.out.println(builder.toString());
		
		//��ת�ַ���
//		builder.replace(2, 5, str);//----------------------------
		
		builder.reverse();
		System.out.println(builder.toString());
		
		
	}
}
