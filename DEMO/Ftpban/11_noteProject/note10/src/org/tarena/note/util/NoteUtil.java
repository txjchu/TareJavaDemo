package org.tarena.note.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class NoteUtil {
	/**
	 * ����ID
	 * @return
	 */
	public static String createId(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	/**
	 * ������ܴ���
	 * @param msg ����
	 * @return ����֮�������
	 */
	public static String md5(String msg){
		try{
			MessageDigest md = 
				MessageDigest.getInstance("MD5");
			byte[] input = msg.getBytes();
			byte[] output = md.digest(input);
			//��md5������output���
			//����Base64�㷨ת���ַ���
			String str = 
				Base64.encodeBase64String(output);
			return str;
		}catch(Exception ex){
			System.out.println("�������ʧ��");
			return "";
		}
	}
	
	public static void main(String[] args){
		System.out.println(createId());
		System.out.println(createId());
		
//		System.out.println(md5("123456"));
//		System.out.println(md5("a"));
//		System.out.println(md5("asdfadfasdfasdfafadsfa"));
	}
	
	
	
}


