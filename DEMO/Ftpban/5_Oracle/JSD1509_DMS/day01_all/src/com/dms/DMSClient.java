package com.dms;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.dms.bo.LogData;
import com.dms.util.IOUtil;

/**
 * DMS�ͻ���
 * ���������ԵĶ�ȡUNIXϵͳ��־�ļ�wtmpx������־
 * ������������������������ԣ����ս���Щ�����־
 * ���͸��������������Ѽ�������
 * @author Administrator
 *
 */
public class DMSClient {
	/*
	 * ���Զ���
	 */
	/*
	 * ��һ����������־��Ҫ�õ�������
	 */
	//unixϵͳ��־�ļ�wtmpx
	private File logFile;
	//�����������־���ļ�
	private File textLogFile;
	//��ǩ�ļ�
	private File lastPositionFile;
	//ÿ�ν�����־����Ŀ��
	private int batch;
	
	
	/**
	 * ���췽����������ʼ���ͻ���
	 */
	public DMSClient()throws Exception{
		try {
			//1���������ļ�
			Map<String,String> config
				= loadConfig();
			
			//��׮
//			System.out.println(config);
			
			//2�����������ʼ���������
			init(config);
			System.out.println("��ʼ�����!");
			
			//��׮
//			System.out.println("batch:"+batch);
		} catch (Exception e) {
			System.out.println("��ʼ���ͻ���ʧ��!");
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * ���ݸ������������ʼ���ͻ�������
	 * @param config
	 * @throws Exception
	 */
	private void init(Map<String,String> config)
							   throws Exception{
		/*
		 * ��ʼ����һ����Ҫ������
		 */
		logFile = new File(
			config.get("logfile")
		);
		
		textLogFile = new File(
			config.get("textlogfile")
		);
		
		lastPositionFile = new File(
			config.get("lastpositionfile")
		);
		
		batch = Integer.parseInt(
			config.get("batch")
		);
	}
	
	
	/**
	 * ���������ļ�config.xml�е����������ÿ��
	 * ��ǩ��������Ϊkey����ǩ�м���ı���Ϊvalue
	 * ����һ��Map�󷵻ء�
	 * @return
	 * @throws Exception
	 */
	private Map<String,String> loadConfig()
							throws Exception{
		Map<String,String> config
			= new HashMap<String,String>();
		
		SAXReader reader = new SAXReader();
		Document doc = reader.read(
			new File("config.xml")
		);
		
		Element root = doc.getRootElement();
		/*
		 * ��ȡ<config>��ǩ�е������ӱ�ǩ(ÿһ������
		 * ��)��Ȼ�󽫱�ǩ����Ϊkey,�м���ı���Ϊvalue
		 * ���뵽Map��
		 */
		List<Element> elements = root.elements();
		for(Element element:elements){
			String key = element.getName();
			String value = element.getTextTrim();
			config.put(key, value);
		}

		return config;
	
	}
	
	/**
	 * �ͻ�����������
	 * ѭ��ִ������:
	 * 1:��������unixϵͳ��־�ļ�
	 * 2:��������������־�������
	 * 3:����Ե���־�����������
	 * @throws Exception
	 */
	public void start()throws Exception{
		try {
			//ִ�е�һ��:��������
			parseLogs();
			
		} catch (Exception e) {
			System.out.println("�ͻ�������ʧ��!");
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * ��һ����������
	 * 
	 * ��logFile�ļ�ָ����unixϵͳ��־�ļ��ж�ȡ
	 * batch����־������������Ȼ������Ϊ��λ��д��
	 * ��textLogFile�ļ��б��档
	 * ÿ����־��������ֻ��Ҫ����5�����ݣ����Խ���
	 * ���һ���ַ����У�ֻ����������־��5�����ݣ�
	 * ��ʽΪ:
	 * user,pid,type,time,host
	 * 
	 * @return �����ɹ��󷵻�true�����򷵻�false
	 */
	private boolean parseLogs(){
		/*
		 * ����:
		 * 1:��Ҫ���ж�
		 *   1.1:��ʱ����
		 *   1.2:logFile�ļ�����Ҫ�У������޷�����
		 *   1.3:������ǩ�ļ���¼��λ�ã��鿴�Ƿ���
		 *       ��־���Խ��������������Ӧ����������ʼ
		 *       λ��
		 * 2:����RandomAccessFile����ȡlogFile
		 * 3:����һ��List���ϣ����ڱ������н�������־
		 *   ���ɸ�LogDateʵ��
		 * 4:��RandomAccessFile��ָ���ƶ������Ӧ
		 *   ��������λ�ô���׼����ʼ����
		 * 5:ѭ��batch��  
		 *   ��ȡ�ܼ�372���ֽڣ�����������־�е�5��
		 *   ��Ϣ���������������浽һ��LogDateʵ��
		 *   �У�Ȼ�󽫸ö�����뼯�ϡ�
		 * 6:�������е�ÿһ����־��toString����Ϊ
		 *   ��λд�뵽textLogFile�б��档
		 * 7:��RandomAccessFile��ǰָ��λ�ñ���
		 *   ��lastPositionFile�С�          
		 */
		RandomAccessFile raf = null;
		try {
			//1
			//1.1
			
			//1.2
			if(!logFile.exists()){
				System.out.println(logFile+"������!");
				return false;
			}
			
			//1.3
			long lastPosition = hasLogs();
			//��׮
//			System.out.println("lastPosition:"+lastPosition);
			
			
			//2
			raf = new RandomAccessFile(
				logFile,"r"
			);
			
			//3
			List<LogData> logs 
				= new ArrayList<LogData>();
			
			//4
			raf.seek(lastPosition);
			
			//5
			for(int i=0;i<batch;i++){
				/*
				 * ÿ�ν���һ����־ǰ�����ж��Ƿ���
				 * һ�����Խ���
				 */
				if(logFile.length()-lastPosition
					<LogData.LOG_LENGTH){
					break;
				}		
				
				//����user
				raf.seek(LogData.USER_OFFSET+lastPosition);
				String user = IOUtil.readString(
					raf, LogData.USER_LENGTH
				).trim();
				
				//����pid
				raf.seek(LogData.PID_OFFSET+lastPosition);
				int pid = raf.readInt();
				
				//����type
				raf.seek(LogData.TYPE_OFFSET+lastPosition);
				short type = raf.readShort();
				
				//����time
				raf.seek(LogData.TIME_OFFSET+lastPosition);
				int time = raf.readInt();
				
				//����host
				raf.seek(LogData.HOST_OFFSET+lastPosition);
				String host = IOUtil.readString(
					raf, LogData.HOST_LENGTH
				).trim();
				
				lastPosition = raf.getFilePointer();
				
				LogData log = new LogData(
					user, pid, type, time, host
				);
				logs.add(log);
				
				//��׮
//				System.out.println(log);
			}
			
			//6
			IOUtil.saveCollection(logs, textLogFile);
			
			//7
			IOUtil.saveLong(lastPosition, lastPositionFile);
			
			return true;
		} catch (Exception e) {
			System.out.println("����ʧ��!");
			e.printStackTrace();
		} finally{
			if(raf != null){
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	/**
	 * ��һ�����������е�һ�����ڣ�������ǩ�ļ���¼
	 * ��λ���ж�wtmpxϵͳ��־�ļ����Ƿ�����־
	 * ���Խ������������ϴ�����ȡ��λ�÷��أ��Ա�
	 * �����￪ʼ�µĽ���������������һ���ˣ��򷵻�
	 * -1
	 * @return
	 */
	private long hasLogs(){
		//����ǩ�ļ������ڣ�����ļ���ͷ��ȡ����
		if(!lastPositionFile.exists()){
			return 0;
		}
		try{
			long lastPosition 
				= IOUtil.readLong(lastPositionFile);
			
			if(logFile.length()-lastPosition
				>=
			   LogData.LOG_LENGTH
			){
				return lastPosition;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;
	}
	
	public static void main(String[] args) {
		try {
			DMSClient client = new DMSClient();
			client.start();
		} catch (Exception e) {
			System.out.println("�ͻ�������ʧ��");
		}
	}
	
}




