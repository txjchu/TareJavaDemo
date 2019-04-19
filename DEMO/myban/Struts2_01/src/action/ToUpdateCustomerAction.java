package action;

import java.util.List;

import dao.CustomerDAO;
import entity.City;
import entity.Customer;

/**
 * ����ȥ�޸�ҳ�������
 * @author Administrator
 *
 */
public class ToUpdateCustomerAction {

	//output
	private Customer customer;
	private List<City> cities;
	
	public ToUpdateCustomerAction() {
		super();
		System.out.println("ʵ������ToUpdateCustomer");
	}
	
	public String execute(){
		CustomerDAO dao = new CustomerDAO();
		//ģ���ѯ�û�
		customer = dao.findById();
		//ģ���ѯ���˳����б�
		cities = dao.findAllCities();
		System.out.println("toUpdateCustomer�е�ҵ�񷽷�...");
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
