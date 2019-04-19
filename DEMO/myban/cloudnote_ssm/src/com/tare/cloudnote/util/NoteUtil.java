package com.tare.cloudnote.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

/**
 * NoteUtil工具类：
 * 1.md5()方法为将给定字符串使用摘要算法转换为一段等长的字符串。
 * 2.createId()方法为生成一个随机字符串作为Id使用。
 * @author Administrator
 *
 */
public class NoteUtil {
	
	public static String createId(){
		UUID uuid = UUID.randomUUID();//随机生成一个UUID对象。[静态工厂方法]
		return uuid.toString();//将随机生成的UUID对象输出作为ID
	}
	
	/*
	 * 摘要算法加密用户输入的密码。摘要算法不可逆。
	 */
	public static String md5(String msg){
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("md5");//创建摘要算法对象
			byte[] input = msg.getBytes();//将字符串转变为byte型数组
			byte[] output = md.digest(input);//使用摘要算法对象对字节数组加密
			String str = Base64.encodeBase64String(output);//再使用工具类将字节型数组转变为字符串
			return str;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";//出现异常，则返回空字符串，表示加密失败。
		}
	}
}
