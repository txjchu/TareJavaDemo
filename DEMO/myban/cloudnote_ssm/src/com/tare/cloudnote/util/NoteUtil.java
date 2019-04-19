package com.tare.cloudnote.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

/**
 * NoteUtil�����ࣺ
 * 1.md5()����Ϊ�������ַ���ʹ��ժҪ�㷨ת��Ϊһ�εȳ����ַ�����
 * 2.createId()����Ϊ����һ������ַ�����ΪIdʹ�á�
 * @author Administrator
 *
 */
public class NoteUtil {
	
	public static String createId(){
		UUID uuid = UUID.randomUUID();//�������һ��UUID����[��̬��������]
		return uuid.toString();//��������ɵ�UUID���������ΪID
	}
	
	/*
	 * ժҪ�㷨�����û���������롣ժҪ�㷨�����档
	 */
	public static String md5(String msg){
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("md5");//����ժҪ�㷨����
			byte[] input = msg.getBytes();//���ַ���ת��Ϊbyte������
			byte[] output = md.digest(input);//ʹ��ժҪ�㷨������ֽ��������
			String str = Base64.encodeBase64String(output);//��ʹ�ù����ཫ�ֽ�������ת��Ϊ�ַ���
			return str;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";//�����쳣���򷵻ؿ��ַ�������ʾ����ʧ�ܡ�
		}
	}
}
