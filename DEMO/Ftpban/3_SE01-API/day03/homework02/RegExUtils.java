package homework02;
/**
 * 作业第一题
 * @author Administrator
 *
 */
public class RegExUtils {
	/**
	 * 身份证的正则表达式
	 */
	public static final String IDENTITY_CARD
		= "[0-9]{15}([0-9]{2}[0-9xX])?";
	
	public static final String ZIP_CODE
		= "[0-9]{6}";
	/**
	 * 手机号的正则表达式
	 */
	public static final String PHONE_NUMBER
		= "(\\+86|0086)?\\s*1[0-9]{10}";
	
	public static boolean identityCard(String id){
		return id.matches(IDENTITY_CARD);
	}
	
	public static boolean zipcode(String code){
		return code.matches(ZIP_CODE);
	}
	
	public static boolean phoneNumber(String number){
		return number.matches(PHONE_NUMBER);
	}
	
}









