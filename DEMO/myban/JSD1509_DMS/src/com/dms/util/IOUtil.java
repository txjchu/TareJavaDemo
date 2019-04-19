package com.dms.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.dms.bo.LogData;

/**
 * ����DOM��Ŀ�ж�д�Ĺ�����
 * 		//----�������еķ�����Ϊ��̬static �ģ�ֱ��.���á����������ֻ����Ϊ��û������������дΪ��̬������
 * 
 * @author Administrator
 *
 */
public class IOUtil {
	/*
	 * �Ӹ������ļ��ж�ȡÿһ���ַ��������ַ���Ӧ����һ�������־��Ȼ����һ���ַ�������һ�������У����ս��ü��Ϸ��ء�
	 */
	public static List<String> loadLogRec(File file) throws Exception{
		
		
		BufferedReader br = null;
		try {
			List<String> list = new ArrayList<String>();		//----
			br = new BufferedReader(
					new InputStreamReader(
						new FileInputStream(
							file							//----
						)	
					)
				);
			String str = null;
			while((str = br.readLine())!=null){
				list.add(str);
			}
			
			return list;
		} catch (Exception e) {
			throw e;
		}finally{
			if(br!=null){
				br.close();
			}
		}
	}
	
	/**
	 * �Ӹ������ļ��ж�ȡÿһ�����ݣ���ת��Ϊһ��LogData ʵ�������뼯�ϣ�
	 * ���ս����Ϸ��ء�
	 * @return
	 */
	public static List<LogData> loadLogData(File file) throws Exception{
		
		BufferedReader br = null;
		try {
			List<LogData> list  = new ArrayList<LogData>();
			
			br = new BufferedReader(		//----����һ��BufferedReader��һ��һ�ж���
					new InputStreamReader(
						new FileInputStream(
							file
						)
					)
				);
			
			String line = null;
			while((line = br.readLine())!=null){		//----��ȡ���ַ�����ʼ����
				LogData log = new LogData(line);
				list.add(log);
			}
			return list;
		} catch (Exception e) {
			throw e;
		}finally{
			if(br !=null){
				br.close();
			}
		}
	}
	
	
	/**
	 * ��������longֵ���ַ�������ʽд�뵽�����ļ��еĵ�һ��
	 */
	public static void saveLong(long l,File file) throws Exception{
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			pw.println(l);
			
		} catch (Exception e) {
			throw e;
		}finally{
			if(pw !=null){
				pw.close();
			}
		}
	}
	
	/**
	 * �������ļ����е�ÿһ��Ԫ�ص�toString���ص��ַ�������Ϊ��λд�뵽�������ļ��С�
	 */
	public static void saveCollection(Collection c,File file) throws Exception{		//collection���� ���滹��list�����Ҳ��ӷ��ͱ�֤����
		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			for(Object o:c){
				pw.println(o);
			}
			
		} catch (Exception e) {
			throw e;
		}finally{
			if(pw !=null){
				pw.close();
			}
		}	
	}
	
	
	/**
	 * �Ӹ�����RandomAccessFile ��ǰλ��������ȡ�������ȵ��ֽ�������ת��Ϊһ���ַ����󷵻ء�
	 * @param raf
	 * @param len
	 * @return
	 * @throws Exception
	 */
	public static String readString(
			
			
			RandomAccessFile raf,int len) throws Exception{
		try {
			byte[] data = new byte[len];
			raf.read(data);			//----data��Ҫ����
			String str = new String(data,"ISO8859-1");
			
			return str;
		} catch (Exception e) {
			throw e;
		}							//----���ܹر�
	}
	
	
	/**
	 * �Ӹ������ļ��ж�ȡ��һ���ַ�����Ȼ����ת��Ϊһ��longֵ�󷵻ء�
	 */
	public static long readLong(File file) throws Exception{		//----�з���ֵ��return *;
		
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
		}finally{
			if(br!=null){
				br.close();
			}
		}
	}
	
}



