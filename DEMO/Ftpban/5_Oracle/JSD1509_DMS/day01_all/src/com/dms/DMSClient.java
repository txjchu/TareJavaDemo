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
 * DMS客户端
 * 用来周期性的读取UNIX系统日志文件wtmpx，将日志
 * 解析出来，并进行上下线配对，最终将这些配对日志
 * 发送给服务端完成数据搜集工作。
 * @author Administrator
 *
 */
public class DMSClient {
	/*
	 * 属性定义
	 */
	/*
	 * 第一步，解析日志需要用到的属性
	 */
	//unix系统日志文件wtmpx
	private File logFile;
	//保存解析后日志的文件
	private File textLogFile;
	//书签文件
	private File lastPositionFile;
	//每次解析日志的条目数
	private int batch;
	
	
	/**
	 * 构造方法，用来初始化客户端
	 */
	public DMSClient()throws Exception{
		try {
			//1加载配置文件
			Map<String,String> config
				= loadConfig();
			
			//打桩
//			System.out.println(config);
			
			//2根据配置项初始化相关属性
			init(config);
			System.out.println("初始化完毕!");
			
			//打桩
//			System.out.println("batch:"+batch);
		} catch (Exception e) {
			System.out.println("初始化客户端失败!");
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * 根据给定的配置项初始化客户端属性
	 * @param config
	 * @throws Exception
	 */
	private void init(Map<String,String> config)
							   throws Exception{
		/*
		 * 初始化第一步需要的属性
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
	 * 加载配置文件config.xml中的配置项，并将每个
	 * 标签的名字作为key，标签中间的文本作为value
	 * 存入一个Map后返回。
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
		 * 获取<config>标签中的所有子标签(每一个配置
		 * 项)。然后将标签名作为key,中间的文本作为value
		 * 存入到Map中
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
	 * 客户端启动方法
	 * 循环执行三步:
	 * 1:批量解析unix系统日志文件
	 * 2:将解析出来的日志进行配对
	 * 3:将配对的日志发送至服务端
	 * @throws Exception
	 */
	public void start()throws Exception{
		try {
			//执行第一步:解析工作
			parseLogs();
			
		} catch (Exception e) {
			System.out.println("客户端运行失败!");
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * 第一步解析工作
	 * 
	 * 从logFile文件指定的unix系统日志文件中读取
	 * batch条日志并解析出来，然后以行为单位，写入
	 * 到textLogFile文件中保存。
	 * 每条日志根据需求只需要解析5个内容，所以解析
	 * 后的一行字符串中，只包含这条日志的5个内容，
	 * 格式为:
	 * user,pid,type,time,host
	 * 
	 * @return 解析成功后返回true，否则返回false
	 */
	private boolean parseLogs(){
		/*
		 * 步骤:
		 * 1:必要的判断
		 *   1.1:暂时保留
		 *   1.2:logFile文件必须要有，否则无法解析
		 *   1.3:根据书签文件记录的位置，查看是否还有
		 *       日志可以解析，并返回这次应当解析的起始
		 *       位置
		 * 2:创建RandomAccessFile来读取logFile
		 * 3:创建一个List集合，用于保存所有解析的日志
		 *   若干个LogDate实例
		 * 4:将RandomAccessFile的指针移动到这次应
		 *   当解析的位置处，准备开始解析
		 * 5:循环batch次  
		 *   读取总计372个字节，并将这条日志中的5个
		 *   信息解析出来，并保存到一个LogDate实例
		 *   中，然后将该对象存入集合。
		 * 6:将集合中的每一条日志的toString以行为
		 *   单位写入到textLogFile中保存。
		 * 7:将RandomAccessFile当前指针位置保存
		 *   到lastPositionFile中。          
		 */
		RandomAccessFile raf = null;
		try {
			//1
			//1.1
			
			//1.2
			if(!logFile.exists()){
				System.out.println(logFile+"不存在!");
				return false;
			}
			
			//1.3
			long lastPosition = hasLogs();
			//打桩
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
				 * 每次解析一条日志前，都判断是否还有
				 * 一条可以解析
				 */
				if(logFile.length()-lastPosition
					<LogData.LOG_LENGTH){
					break;
				}		
				
				//解析user
				raf.seek(LogData.USER_OFFSET+lastPosition);
				String user = IOUtil.readString(
					raf, LogData.USER_LENGTH
				).trim();
				
				//解析pid
				raf.seek(LogData.PID_OFFSET+lastPosition);
				int pid = raf.readInt();
				
				//解析type
				raf.seek(LogData.TYPE_OFFSET+lastPosition);
				short type = raf.readShort();
				
				//解析time
				raf.seek(LogData.TIME_OFFSET+lastPosition);
				int time = raf.readInt();
				
				//解析host
				raf.seek(LogData.HOST_OFFSET+lastPosition);
				String host = IOUtil.readString(
					raf, LogData.HOST_LENGTH
				).trim();
				
				lastPosition = raf.getFilePointer();
				
				LogData log = new LogData(
					user, pid, type, time, host
				);
				logs.add(log);
				
				//打桩
//				System.out.println(log);
			}
			
			//6
			IOUtil.saveCollection(logs, textLogFile);
			
			//7
			IOUtil.saveLong(lastPosition, lastPositionFile);
			
			return true;
		} catch (Exception e) {
			System.out.println("解析失败!");
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
	 * 第一步解析工作中的一个环节，根据书签文件记录
	 * 的位置判断wtmpx系统日志文件中是否还有日志
	 * 可以解析，若有则将上次最后读取的位置返回，以便
	 * 从这里开始新的解析工作，若不够一条了，则返回
	 * -1
	 * @return
	 */
	private long hasLogs(){
		//若书签文件不存在，则从文件开头读取即可
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
			System.out.println("客户端启动失败");
		}
	}
	
}




