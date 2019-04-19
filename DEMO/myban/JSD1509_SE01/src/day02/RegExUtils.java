package day02;
/**
 * ��֤���֤���롢�ʱ���롢�ֻ��ŵĹ�����
 * @author Administrator
 *
 */
public class RegExUtils {
	public static String IDENTITY_CARD = "^[0-9]{15}([0-9]{2}[0-9xX])?$";//���֤��������ʽ
	public static String ZIP_CODE = "^[1-9][0-9]{5}$";//�ʱ��������ʽ
	public static String PHONE_NUMBER = "^(\\+86|0086)?\\s*1[0-9]{10}$";//�ֻ��ŵ�������ʽ
	
	/** ���ĳ�����Ƿ���ȷ�ķ��� */
	public static boolean check(String str, String regex){
		return str.matches(regex);
	}
	
	/** ������֤�����Ƿ���ȷ�ķ��� */
	public static boolean identityCard(String id){
		return RegExUtils.check(id, IDENTITY_CARD);
	}
	/** ����ʱ�����Ƿ���ȷ�ķ��� */
	public static boolean zipCode(String zipCode){
		return RegExUtils.check(zipCode, ZIP_CODE);
	}
	/** ����ֻ������Ƿ���ȷ�ķ��� */
	public static boolean phoneNumber(String phoneNumber){
		return RegExUtils.check(phoneNumber, PHONE_NUMBER);
	}
	
	public static void main(String[] args) {
		String ic = "123456789012343353";
		System.out.println(RegExUtils.identityCard(ic));
		
		String zc = "375000";
		System.out.println(RegExUtils.zipCode(zc));
		
		String pn = "123456123456";
		System.out.println(RegExUtils.phoneNumber(pn));
	}
}






