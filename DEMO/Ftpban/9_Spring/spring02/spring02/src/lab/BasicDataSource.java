package lab;
/**
 * ��ȡ�����ļ�(db.properties)�����
 * ������ֵ��ע�롣
 *
 */
public class BasicDataSource {
	private String username;
	private String pwd;
	private String url;
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
