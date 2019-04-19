package day01;
/**
 * java.lang.StringBuilder
 * �ڲ�ά��һ���ɱ���ַ����飬��������ý���ַ��������޸Ĵ�������Դ�������⡣
 * ����append
 * ɾ��delete
 * �ģ�replace
 * �壺insert
 * @author Administrator
 *
 */
public class StringBuilderDemo01 {
	public static void main(String[] args) {
		String str = "Ŭ��ѧϰjava";
		//��ת��ΪStringBuilder
		StringBuilder builder = new StringBuilder(str);
		
		//StringBuilderת��ΪString
		str = builder.toString();
		System.out.println(str);//Ŭ��ѧϰjava
		
		/*
		 * Ŭ��ѧϰjava��Ϊ���Ҹ��ù���
		 * StringBuilder append(String str)
		 * �ڵ�ǰ�ַ���ĩβ׷��ָ���ַ���������ֵ���ǵ�ǰStringBuilder����
		 */
		builder.append("��Ϊ���Ҹ��ù���");
		System.out.println(builder);//Ŭ��ѧϰjava��Ϊ���Ҹ��ù���
		System.out.println(builder.toString());//Ŭ��ѧϰjava��Ϊ���Ҹ��ù���
		
		/*
		 * Ŭ��ѧϰjava������Ϊ�˸ı�����
		 * StringBuilder replace(int start, int end, String str)
		 * ��ָ����Χ�ڵ��ַ����滻Ϊ��������
		 */
		builder.replace(9, builder.length(), "����Ϊ�˸ı�����!");
		System.out.println(builder.toString());//Ŭ��ѧϰjava������Ϊ�˸ı�����!
		
		/*
		 * ��Ҫ�����������Ϊ�˸ı����磡
		 * StringBuilder delete(int start, int end)
		 * ��ָ����Χ�ڵ��ַ���ɾ��
		 */
		builder.delete(0, 8);
		System.out.println(builder.toString());//������Ϊ�˸ı�����!
		
		/*
		 * ���ţ�����Ϊ�˸ı����磡
		 * StringBuilder insert(int i, String str)
		 * ���������ַ������뵽ָ��λ�ô���ԭλ�ü������ַ���˳����ơ�
		 */
		builder.insert(0, "����");
		System.out.println(builder.toString());//���ţ�����Ϊ�˸ı�����!
		
		//��ת�ַ���
		builder.reverse();
		System.out.println(builder.toString());//!���������Ϊ�Ǿͣ��Ż�
	}
}


















