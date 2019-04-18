package com.dms.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Collection;

/**
 * ����DMS��Ŀ�ж�д�Ĺ�����
 * @author Administrator
 *
 */
public class IOUtil {
	/**
	 * ��������longֵ���ַ�������ʽд�뵽
	 * �����ļ��еĵ�һ��
	 * @param l
	 * @param file
	 * @throws Exception 
	 */
	public static void saveLong(long l,File file)
							    throws Exception{
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			pw.println(l);
		} catch (Exception e) {
			throw e;
		} finally{
			if(pw != null){
				pw.close();
			}
		}
	}
	
	/**
	 * �������ļ����е�ÿһ��Ԫ�ص�toString���ص�
	 * �ַ�������Ϊ��λд�뵽�������ļ���
	 * @param c
	 * @param file
	 * @throws Exception
	 */
	public static void saveCollection(
					  Collection c,File file)
							throws Exception{
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			for(Object o : c){
				pw.println(o);
			}
		} catch (Exception e) {
			throw e;
		} finally{
			if(pw != null){
				pw.close();
			}
		}
	}
	
	/**
	 * �Ӹ�����RandomAccessFile��ǰλ��������ȡ
	 * �������ȵ��ֽ�������ת��Ϊһ���ַ����󷵻ء�
	 * @param raf
	 * @param len
	 * @return
	 * @throws Exception
	 */
	public static String readString(
			RandomAccessFile raf,int len)
						throws Exception{
		try {
			byte[] data = new byte[len];
			raf.read(data);
			String str = new String(
				data,"ISO8859-1"
			);
			return str;
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * �Ӹ������ļ��ж�ȡ��һ���ַ�����Ȼ����
	 * ת��Ϊһ��longֵ�󷵻�
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static long readLong(File file)
							throws Exception{
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(
						new FileInputStream(
							file	
						)	
					)
				 );
			String line = br.readLine();
			long lon = Long.parseLong(line);
			return lon;
		} catch (Exception e) {
			throw e;
		} finally{
			if(br != null){
				br.close();
			}
		}
	}
}






