package lab;
/**
 * 读取配置文件(db.properties)，完成各属性值的注入。
 */
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bds")
public class BasicDataSource implements Serializable {
	@Value("#{dao.username}")
	private String username;
	@Value("#{dao.pwd}")
	private String pwd;
	@Value("#{dao.url}")
	private String url;
	@Value("#{dao.drivername}")
	private String drivername;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDrivername() {
		return drivername;
	}
	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}
	
}
