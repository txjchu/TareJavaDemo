package entity;

import java.sql.Date;

/**
 * 业务账号数据表Service对应的实体类
 * @author Administrator
 *
 */
public class Service {

	private Integer service_id;
//	private Integer account_id;
	private String unix_host;
	private String os_username;
	private String login_passwd;
	private Integer status;
	private Date create_date;
	private Date pause_date;
	private Date close_date;
	private Integer cost_id;
	
	//追加关联属性，多对一的属性，Account，用于封装Account记录中的信息。
	private Account account;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Integer getService_id() {
		return service_id;
	}
	public void setService_id(Integer serviceId) {
		service_id = serviceId;
	}
//	public Integer getAccount_id() {
//		return account_id;
//	}
//	public void setAccount_id(Integer accountId) {
//		account_id = accountId;
//	}
	public String getUnix_host() {
		return unix_host;
	}
	public void setUnix_host(String unixHost) {
		unix_host = unixHost;
	}
	public String getOs_username() {
		return os_username;
	}
	public void setOs_username(String osUsername) {
		os_username = osUsername;
	}
	public String getLogin_passwd() {
		return login_passwd;
	}
	public void setLogin_passwd(String loginPasswd) {
		login_passwd = loginPasswd;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date createDate) {
		create_date = createDate;
	}
	public Date getPause_date() {
		return pause_date;
	}
	public void setPause_date(Date pauseDate) {
		pause_date = pauseDate;
	}
	public Date getClose_date() {
		return close_date;
	}
	public void setClose_date(Date closeDate) {
		close_date = closeDate;
	}
	public Integer getCost_id() {
		return cost_id;
	}
	public void setCost_id(Integer costId) {
		cost_id = costId;
	}
	@Override
	public String toString() {
		return "Service [service_id=" + service_id + ", unix_host=" + unix_host + ", os_username="
				+ os_username + ", login_passwd=" + login_passwd + ", status="
				+ status + ", create_date=" + create_date + ", pause_date="
				+ pause_date + ", close_date=" + close_date + ", cost_id="
				+ cost_id + "]";
	}
	
}
