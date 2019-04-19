package day02;
/**
 * 验证身份证号码、邮编号码、手机号的工具类
 * @author Administrator
 *
 */
public class RegExUtils {
	public static String IDENTITY_CARD = "^[0-9]{15}([0-9]{2}[0-9xX])?$";//身份证的正则表达式
	public static String ZIP_CODE = "^[1-9][0-9]{5}$";//邮编的正则表达式
	public static String PHONE_NUMBER = "^(\\+86|0086)?\\s*1[0-9]{10}$";//手机号的正则表达式
	
	/** 检查某号码是否正确的方法 */
	public static boolean check(String str, String regex){
		return str.matches(regex);
	}
	
	/** 检查身份证号码是否正确的方法 */
	public static boolean identityCard(String id){
		return RegExUtils.check(id, IDENTITY_CARD);
	}
	/** 检查邮编号码是否正确的方法 */
	public static boolean zipCode(String zipCode){
		return RegExUtils.check(zipCode, ZIP_CODE);
	}
	/** 检查手机号码是否正确的方法 */
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






