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
	
	/*
	 * 第二步,配对日志所需要的属性
	 */
	//保存配对日志的文件
	private File logRecFile;
	//保存未配对的登入日志的文件
	private File loginLogFile;
	
	/*
	 * 第三步，发送日志所需要的属性
	 */
	//服务端地址
	private String serverHost;
	
	//服务端端口
	private int serverPort;
	
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

		/*
		 * 初始化第二步需要的属性
		 */
		logRecFile = new File(
			config.get("logrecfile")	
		);
		
		loginLogFile = new File(
			config.get("loginlogfile")	
		);
		
		/*
		 * 初始化第三步需要的属性
		 */
		serverHost = config.get("serverhost");
		
		serverPort = Integer.parseInt(
			config.get("serverport")	
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
			while(true){
				//执行第一步:解析工作
				if(!parseLogs()){
					continue;
				}
				//执行第二步:配对工作
				if(!matchLogs()){
					continue;
				}
				//执行第三步:发送工作
				sendLogs();
			}
		} catch (Exception e) {
			System.out.println("客户端运行失败!");
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * 第三步发送日志
	 * @return
	 */
	private boolean sendLogs(){
		Socket socket = null;
		try {
			/*
			 * 步骤:
			 * 1:首先判断logRecFile文件是否存在，
			 *   若不存在则无法发送配对日志
			 * 
			 * 2:读取logRecFile，将每一条配对日志
			 *   读取出来存入一个集合中等待发送。
			 *   
			 * 3:创建Socket，并指定服务端地址与端口
			 *   进行连接。
			 * 
			 * 4:通过Socket获取输出流，并转换为
			 *   PrintWriter。
			 * 
			 * 5:将每一条配对日志以行为单位发送给
			 *   服务端
			 * 
			 * 6:单独发送一个字符串"OVER"，告知
			 *   服务端所有日志均以发送。
			 * 
			 * 7:通过Socket获取输出流，并转换为
			 *   BufferedReader
			 * 
			 * 8:读取服务端发送回来的响应代码
			 * 
			 * 9:若服务端发送回来的响应代码为:
			 *   OK,则表示服务端全部接收并保存。
			 *   那么将logRecFile文件删除。
			 *   发送工作完毕。            
			 */
			//1
			if(!logRecFile.exists()){
				System.out.println(logRecFile+"不存在!");
				return false;
			}
			
			//2
			List<String> matches
				= IOUtil.loadLogRec(logRecFile);
			
			//打桩
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
			System.out.println("发送日志失败");
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
	 * 第二步配对日志
	 * 
	 * 读取第一步生成的日志文件中的所有待配对的日志和
	 * 上次配对完毕后没有配对成功的登入日志，将它们按照
	 * user,pid,host相同的原则，找出登入登出日志进行
	 * 配对，并将所有配对的日志写入logRecFile中保存，
	 * 再将没配对成功的登入日志写入loginLogFile中保存。
	 * @return
	 */
	private boolean matchLogs(){
		try {
			/*
			 * 步骤:
			 * 1:必要的判断工作
			 *   1.1:与第一步的1.1判断一样，若配对
			 *       日志存在，则不需要重新配对，若
			 *       第三步成功执行，会将该文件删除,
			 *       所以不存在才进行新的配对工作.
			 *   1.2:textLogFile文件必须存在，否则
			 *       没有待配对日志，则无法开始工作。
			 *       
			 * 2:将textLogFile中的所有日志读取出来
			 *   并以LogData实例的形式存入一个集合中
			 *   等待配对
			 * 3:若存在loginLogFile文件，则将上次未
			 *   配对的日志也读取出来存入集合中。        
			 * 4:创建一个集合，用于保存所有配对日志,
			 *   再创建两个Map分别用来保存待配对的
			 *   登入日志和登出日志。其中:
			 *   key:格式为 user,pid,host
			 *   value:对应日志的LogData实例
			 * 5:遍历待配对日志的集合，将每一条日志按照
			 *   类型分别存入到登入与登入Map中。
			 * 6:开始配对
			 *   遍历登出Map，根据登出日志的key去登入
			 *   Map中找到配对的登入Map，然后组成一个
			 *   LogRec对象存入配对集合中，并将该登入
			 *   日志从登入Map中删除。这样一来，最终登
			 *   入Map中只剩下未配对的登入日志了。
			 * 7:将所有配对日志写入logRecFile中
			 * 8:将所有未配对的日志写入loginLogFile中        
			 */
			//1
			//1.1
			if(logRecFile.exists()){
				return true;
			}
			//1.2
			if(!textLogFile.exists()){
				System.out.println(textLogFile+"不存在!");
				return false;
			}
			//2
			List<LogData> logs
				= IOUtil.loadLogData(textLogFile);
			
			/*
			 * 打桩
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
			
			//打桩
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
		 *   1.1:判断textLogFile文件是否已经存在了
		 *       若存在，说明第一步正确执行过了，而第
		 *       二步没成功。因为第二步成功执行完毕后
		 *       会将该文件删除。所以，若该文件存在，
		 *       则无需重复执行第一步。
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
			if(textLogFile.exists()){
				return true;
			}
			
			//1.2
			if(!logFile.exists()){
				System.out.println(logFile+"不存在!");
				return false;
			}
			
			//1.3
			long lastPosition = hasLogs();
			if(lastPosition==-1){
				System.out.println("没有日志可以解析了!");
				return false;
			}
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




