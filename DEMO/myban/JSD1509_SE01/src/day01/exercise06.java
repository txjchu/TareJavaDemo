package day01;
/**
 * ��ҵ������
 * ����StringBuilder
 * ��ӡ��Unicode���еĺ��֣�U4E00 - U9FA5����50���ֻ�һ�С�
 * @author Administrator
 *
 */
public class exercise06 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for(char c = '\u4E00', i = 1; c <= '\u9FA5'; i ++, c ++){
			sb = sb.append(c);//����append(str)�������
			
			//*****�������鳤�ȼ���50�ı���������ֵ�һ��50���ַ��������ж���49���ַ������������
			//*****ԭ��"\n"Ҳ��һ���ַ�����sb���ַ����ȵ���50ʱ�������һ���ַ�"\n"���У����ʵ���ϵ�һ����51���ַ���
			//*****��������49������+һ�����з���sb.length()�а�����ÿһ��"\n"�ַ���
//			if(sb.length()  % 50 == 0){//��50���������ʾ��x��50��ÿ50����һ����
//				sb.append("\n");//ÿ50�����ֺ����һ�����з�
//			}
			if(i % 50 == 0){
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
