package com.dms;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.dms.bo.LogData;
import com.dms.bo.LogRec;
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
	
	/*
	 * �ڶ���,�����־����Ҫ������
	 */
	//���������־���ļ�
	private File logRecFile;
	//����δ��Եĵ�����־���ļ�
	private File loginLogFile;
	
	/*
	 * ��������������־����Ҫ������
	 */
	//����˵�ַ
	private String serverHost;
	
	//����˶˿�
	private int serverPort;
	
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

		/*
		 * ��ʼ���ڶ�����Ҫ������
		 */
		logRecFile = new File(
			config.get("logrecfile")	
		);
		
		loginLogFile = new File(
			config.get("loginlogfile")	
		);
		
		/*
		 * ��ʼ����������Ҫ������
		 */
		serverHost = config.get("serverhost");
		
		serverPort = Integer.parseInt(
			config.get("serverport")	
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
			while(true){
				//ִ�е�һ��:��������
				if(!parseLogs()){
					continue;
				}
				//ִ�еڶ���:��Թ���
				if(!matchLogs()){
					continue;
				}
				//ִ�е�����:���͹���
				sendLogs();
			}
		} catch (Exception e) {
			System.out.println("�ͻ�������ʧ��!");
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * ������������־
	 * @return
	 */
	private boolean sendLogs(){
		Socket socket = null;
		try {
			/*
			 * ����:
			 * 1:�����ж�logRecFile�ļ��Ƿ���ڣ�
			 *   �����������޷����������־
			 * 
			 * 2:��ȡlogRecFile����ÿһ�������־
			 *   ��ȡ��������һ�������еȴ����͡�
			 *   
			 * 3:����Socket����ָ������˵�ַ��˿�
			 *   �������ӡ�
			 * 
			 * 4:ͨ��Socket��ȡ���������ת��Ϊ
			 *   PrintWriter��
			 * 
			 * 5:��ÿһ�������־����Ϊ��λ���͸�
			 *   �����
			 * 
			 * 6:��������һ���ַ���"OVER"����֪
			 *   �����������־���Է��͡�
			 * 
			 * 7:ͨ��Socket��ȡ���������ת��Ϊ
			 *   BufferedReader
			 * 
			 * 8:��ȡ����˷��ͻ�������Ӧ����
			 * 
			 * 9:������˷��ͻ�������Ӧ����Ϊ:
			 *   OK,���ʾ�����ȫ�����ղ����档
			 *   ��ô��logRecFile�ļ�ɾ����
			 *   ���͹�����ϡ�            
			 */
			//1
			if(!logRecFile.exists()){
				System.out.println(logRecFile+"������!");
				return false;
			}
			
			//2
			List<String> matches
				= IOUtil.loadLogRec(logRecFile);
			
			//��׮
//			System.out.println(matches.size());
//			for(String log : matches){
//				System.out.println(log);
//			}
			
			//3
			socket = new Socket(
				serverHost,serverPort
			);
			
			//4
			PrintWriter pw = new PrintWriter(
				new OutputStreamWriter(
					socket.getOutputStream(),
					"UTF-8"
				)	
			);
			
			//5
			for(String log : matches){
				pw.println(log);
			}
			
			//6
			pw.println("OVER");
			pw.flush();
			
			//7
			BufferedReader br = new BufferedReader(
				new InputStreamReader(
					socket.getInputStream(),
					"UTF-8"
				)
			);
			
			//8
			String response = br.readLine();
			
			//9
			if("OK".equals(response)){
				logRecFile.delete();
				return true;
			}	
		} catch (Exception e) {
			System.out.println("������־ʧ��");
			e.printStackTrace();
		} finally{
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	/**
	 * �ڶ��������־
	 * 
	 * ��ȡ��һ�����ɵ���־�ļ��е����д���Ե���־��
	 * �ϴ������Ϻ�û����Գɹ��ĵ�����־�������ǰ���
	 * user,pid,host��ͬ��ԭ���ҳ�����ǳ���־����
	 * ��ԣ�����������Ե���־д��logRecFile�б��棬
	 * �ٽ�û��Գɹ��ĵ�����־д��loginLogFile�б��档
	 * @return
	 */
	private boolean matchLogs(){
		try {
			/*
			 * ����:
			 * 1:��Ҫ���жϹ���
			 *   1.1:���һ����1.1�ж�һ���������
			 *       ��־���ڣ�����Ҫ������ԣ���
			 *       �������ɹ�ִ�У��Ὣ���ļ�ɾ��,
			 *       ���Բ����ڲŽ����µ���Թ���.
			 *   1.2:textLogFile�ļ�������ڣ�����
			 *       û�д������־�����޷���ʼ������
			 *       
			 * 2:��textLogFile�е�������־��ȡ����
			 *   ����LogDataʵ������ʽ����һ��������
			 *   �ȴ����
			 * 3:������loginLogFile�ļ������ϴ�δ
			 *   ��Ե���־Ҳ��ȡ�������뼯���С�        
			 * 4:����һ�����ϣ����ڱ������������־,
			 *   �ٴ�������Map�ֱ������������Ե�
			 *   ������־�͵ǳ���־������:
			 *   key:��ʽΪ user,pid,host
			 *   value:��Ӧ��־��LogDataʵ��
			 * 5:�����������־�ļ��ϣ���ÿһ����־����
			 *   ���ͷֱ���뵽���������Map�С�
			 * 6:��ʼ���
			 *   �����ǳ�Map�����ݵǳ���־��keyȥ����
			 *   Map���ҵ���Եĵ���Map��Ȼ�����һ��
			 *   LogRec���������Լ����У������õ���
			 *   ��־�ӵ���Map��ɾ��������һ�������յ�
			 *   ��Map��ֻʣ��δ��Եĵ�����־�ˡ�
			 * 7:�����������־д��logRecFile��
			 * 8:������δ��Ե���־д��loginLogFile��        
			 */
			//1
			//1.1
			if(logRecFile.exists()){
				return true;
			}
			//1.2
			if(!textLogFile.exists()){
				System.out.println(textLogFile+"������!");
				return false;
			}
			//2
			List<LogData> logs
				= IOUtil.loadLogData(textLogFile);
			
			/*
			 * ��׮
			 */
//			System.out.println("logs.size:"+logs.size());
//			for(LogData log : logs){
//				System.out.println(log);
//			}
			
			//3
			if(loginLogFile.exists()){
				logs.addAll(
					IOUtil.loadLogData(
							loginLogFile)
				);
			}
			
			//4
			List<LogRec> matches 
				= new ArrayList<LogRec>();
			Map<String,LogData> loginMap
				= new HashMap<String,LogData>();
			
			Map<String,LogData> logoutMap
				= new HashMap<String,LogData>();
			
			//5
			for(LogData log : logs){
				String key = log.getUser()+","+
							 log.getPid()+","+
							 log.getHost();
				if(log.getType()==LogData.TYPE_LOGIN){
					loginMap.put(key, log);
				}
				else if(log.getType()==LogData.TYPE_LOGOUT){
					logoutMap.put(key, log);
				}
			}
			
			//��׮
//			System.out.println(
//				"loginMap:"+loginMap.size()
//			);
//			System.out.println(loginMap);
//			
//			System.out.println(
//				"logoutMap:"+logoutMap.size()	
//			);
//			System.out.println(logoutMap);
			
			//6
			Set<Entry<String,LogData>> entrySet
				= logoutMap.entrySet();
			for(Entry<String,LogData> e:entrySet){
				LogData logout = e.getValue();
				LogData login = loginMap.remove(e.getKey());
				LogRec logRec = new LogRec(login,logout);
				matches.add(logRec);
			}
			
			//7
			IOUtil.saveCollection(matches, logRecFile);
			
			//8
			IOUtil.saveCollection(
				loginMap.values(),loginLogFile
			);
			
			textLogFile.delete();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
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
		 *   1.1:�ж�textLogFile�ļ��Ƿ��Ѿ�������
		 *       �����ڣ�˵����һ����ȷִ�й��ˣ�����
		 *       ����û�ɹ�����Ϊ�ڶ����ɹ�ִ����Ϻ�
		 *       �Ὣ���ļ�ɾ�������ԣ������ļ����ڣ�
		 *       �������ظ�ִ�е�һ����
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
			if(textLogFile.exists()){
				return true;
			}
			
			//1.2
			if(!logFile.exists()){
				System.out.println(logFile+"������!");
				return false;
			}
			
			//1.3
			long lastPosition = hasLogs();
			if(lastPosition==-1){
				System.out.println("û����־���Խ�����!");
				return false;
			}
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




