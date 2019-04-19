package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Emp;
import entity.User;

/**
 * 练习：Action控制器
 * @author Administrator
 *
 */
public class HelloAction {
	
	//基本类型
	private Integer id = 1;
	private String name = "张三";
	private User user = new User();//必须new出对象来，才能给其赋值属性。否则空指针异常。
	//数组、集合、Map对象
	private String[] langArr = new String[]{"java", "PHP", "C++"};
	private List<String> cityList = new ArrayList<String>();
	private Map<String, String> cityMap = new HashMap<String, String>();
	//对象集合
	private List<Emp> emps = new ArrayList<Emp>();
	//迭代数字
	private Integer from = 1;
	private Integer to = 3;
	
	
	public String sayHello(){
		System.out.println("进入了HelloAction控制器，开始sayHello业务方法...");
		user.setUsername("李四");
		user.setPassword("1234");
		//初始化集合
		cityList.add("北京");
		cityList.add("上海");
		cityList.add("广州");
		//初始化Map
		cityMap.put("北京", "2000千万");
		cityMap.put("上海", "2100千万");
		cityMap.put("广州", "2300千万");
		//初始化对象集合
		Emp emp = new Emp();
		emp.setEmpno(1);
		emp.setEname("刘备");
		emp.setJob("皇叔");
		emp.setSal(3333.33);
		emps.add(emp);
		Emp emp2 = new Emp();
		emp2.setEmpno(2);
		emp2.setEname("关羽");
		emp2.setJob("关内侯");
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
