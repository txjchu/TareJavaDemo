package day03;
/**
 * ��ҵ���һ��
 * @author Administrator
 * 
 */

public class RegExUtils {
	/**
	 * ���֤��������ʽ
	 */
	public static final String IDENTITY_CARD="[0-9]{15}([0-9]{2}[0-9xX])?";
	
	//�ʱ�������ʽ
	public static final String ZIP_CODE="[0-9]{6}";
	
	//�ֻ���������ʽ
	public static final String PHONE_NUMBER="(\\+86|0086)?\\s*1[0-9]{10}";
	//?��ʾ���п��ޣ�\\s��ʾ�ո�|��ʾ���ߣ�
	public static boolean identityCard(String id){
		return id.matches(IDENTITY_CARD);//----------�Ѳ���
	}
	public static boolean zipcode(String code){
		return code.matches(ZIP_CODE);
	}
	
	public static boolean phoneNumber(String number){
		return number.matches(PHONE_NUMBER);
	}
}
