package com.pc.netctoss.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 笔记
 * 使用 MD5 方式对字符串加密的工具类
 * @author: Peter
 * @date: 2020/11/30 1:22
 */
public class MD5Util {


    /**
     * 使用 MD5 加密方式加密指定字符串
     * @param origStr
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String encrpy(String origStr ) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("md5");
        // 依据指定的加密算法进行加密
        byte[] buf = md.digest(origStr.getBytes());
        // 因为字节数组不方便使用，所以，将其转换成一个字符串
        // BASE64Encoder的encode方法可以将任意的一个字节数组转换成一个字符串
        BASE64Encoder base = new BASE64Encoder();
        String str = base.encode(buf);
        return str;
    }


}
