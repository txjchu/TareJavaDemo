package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Emp;
import entity.User;

/**
 * ��ϰ��Action������
 * @author Administrator
 *
 */
public class HelloAction {
	
	//��������
	private Integer id = 1;
	private String name = "����";
	private User user = new User();//����new�������������ܸ��丳ֵ���ԡ������ָ���쳣��
	//���顢���ϡ�Map����
	private String[] langArr = new String[]{"java", "PHP", "C++"};
	private List<String> cityList = new ArrayList<String>();
	private Map<String, String> cityMap = new HashMap<String, String>();
	//���󼯺�
	private List<Emp> emps = new ArrayList<Emp>();
	//��������
	private Integer from = 1;
	private Integer to = 3;
	
	
	public String sayHello(){
		System.out.println("������HelloAction����������ʼsayHelloҵ�񷽷�...");
		user.setUsername("����");
		user.setPassword("1234");
		//��ʼ������
		cityList.add("����");
		cityList.add("�Ϻ�");
		cityList.add("����");
		//��ʼ��Map
		cityMap.put("����", "2000ǧ��");
		cityMap.put("�Ϻ�", "2100ǧ��");
		cityMap.put("����", "2300ǧ��");
		//��ʼ�����󼯺�
		Emp emp = new Emp();
		emp.setEmpno(1);
		emp.setEname("����");
		emp.setJob("����");
		emp.setSal(3333.33);
		emps.add(emp);
		Emp emp2 = new Emp();
		emp2.setEmpno(2);
		emp2.setEname("����");
		emp2.setJob("���ں�");
		emp2.setSal(3322.3322);
		emps.add(emp2);
		
		return "success";
	}

	
	public Integer getFrom() {
		return from;
	}


	public void setFrom(Integer from) {
		this.from = from;
	}


	public Integer getTo() {
		return to;
	}


	public void setTo(Integer to) {
		this.to = to;
	}


	public List<Emp> getEmps() {
		return emps;
	}


	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}


	public String[] getLangArr() {
		return langArr;
	}


	public void setLangArr(String[] langArr) {
		this.langArr = langArr;
	}


	public List<String> getCityList() {
		return cityList;
	}


	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}


	public Map<String, String> getCityMap() {
		return cityMap;
	}


	public void setCityMap(Map<String, String> cityMap) {
		this.cityMap = cityMap;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return this.user;
	}
	
}
