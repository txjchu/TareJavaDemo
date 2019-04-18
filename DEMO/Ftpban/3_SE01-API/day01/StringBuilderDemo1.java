package day01;
/**
 * java.lang.StringBuilder
 * �ڲ�ά��һ���ɱ���ַ����飬����������ǽ��
 * �ַ��������޸Ĵ�������Դ�������⡣
 * �����ṩ�����ڱ༭�ַ������ݵ���ط���
 * ��:append
 * ɾ:delete
 * ��:replace
 * ��:insert
 * @author Administrator
 *
 */
public class StringBuilderDemo1 {
	public static void main(String[] args) {
		String str = "Ŭ��ѧϰjava";
		//��ת��ΪStringBuilder
		StringBuffer builder
			= new StringBuffer(str);
		
		//StringBuilderת��ΪString
		str = builder.toString();
		System.out.println(str);
		
		/*
		 * Ŭ��ѧϰjava,Ϊ���Ҹ��ù���
		 * StringBuilder append(String str)
		 * �ڵ�ǰ�ַ���ĩβ׷��ָ���ַ���������ֵ
		 * ���ǵ�ǰStringBuilder����
		 */
		builder.append(",Ϊ���Ҹ��ù���");
		System.out.println(builder.toString());
		
		/*
		 * Ŭ��ѧϰjava,����Ϊ�˸ı�����!
		 * StringBuilder replace(
		 *  int start,int end,String str
		 * )
		 * ��ָ����Χ�ڵ��ַ����滻Ϊ�������� 
		 */
		builder.replace(9, builder.length(), "����Ϊ�˸ı�����!");
		System.out.println(builder.toString());
		
		/*
		 * ,����Ϊ�˸ı�����!
		 * StringBuilder delete(int start,int end)
		 * ��ָ����Χ�ڵ��ַ���ɾ��
		 */
		builder.delete(0, 8);
		System.out.println(builder.toString());
		
		/*
		 * ����,����Ϊ�˸ı�����!
		 * StringBuilder insert(int i,String str)
		 * ���������ַ������뵽ָ��λ�ô���ԭλ�ü�����
		 * �ַ���˳������ƶ���
		 */
		builder.insert(0, "����");
		System.out.println(builder.toString());
		
		//��ת�ַ���
		builder.reverse();
		System.out.println(builder.toString());
		
		
	}
}






