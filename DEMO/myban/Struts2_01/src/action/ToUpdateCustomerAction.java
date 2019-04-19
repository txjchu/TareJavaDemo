package action;

import java.util.List;

import dao.CustomerDAO;
import entity.City;
import entity.Customer;

/**
 * 处理去修改页面的请求
 * @author Administrator
 *
 */
public class ToUpdateCustomerAction {

	//output
	private Customer customer;
	private List<City> cities;
	
	public ToUpdateCustomerAction() {
		super();
		System.out.println("实例化了ToUpdateCustomer");
	}
	
	public String execute(){
		CustomerDAO dao = new CustomerDAO();
		//模拟查询用户
		customer = dao.findById();
		//模拟查询到了城市列表
		cities = dao.findAllCities();
		System.out.println("toUpdateCustomer中的业务方法...");
		return "success";
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
}
