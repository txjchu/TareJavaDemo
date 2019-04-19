package org.tarena.note.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class NoteUtil {
	/**
	 * 生成ID
	 */
	public static String createId(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}	
	/**
	 * 密码加密处理	MD5算法不可逆,处理的是字节数组，不仅限于文字----【摘要算法】，可以将任意长度信息变成等长信息。
	 * @param msg 明文
	 * @return 加密之后的密文
	 */
	public static String md5(String msg){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] input = msg.getBytes();
			byte[] output = md.digest(input);
			//将md5处理后的output结果转成字符串-----转换后是乱码
			//利用Base64算法转成字符串
			String str = Base64.encodeBase64String(output);
			return str;
		} catch (Exception ex) {
			System.out.println("密码加密失败");
			return "";
		}
	}
	public static void main(String[] args) {
		System.out.println(md5("123456"));//----4QrcOUm6Wau+VuBX8g+IPg==
		System.out.println(md5("a"));
		System.out.println(md5("第三方"));
		System.out.println(md5("aaadfdsfsadf"));
		
		System.out.println(createId());
		System.out.println(createId());
	}
	
}
