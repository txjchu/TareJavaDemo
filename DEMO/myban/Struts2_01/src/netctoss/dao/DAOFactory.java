package netctoss.dao;
/**
 * 创建DAO的工厂类		此为工具类
 * @author Administrator
 *
 */
public class DAOFactory {

	/*
	 * 资费DAO的实例
	 */
	private static CostDAOImpl costDAO = new CostDAOImpl();
	/*
	 * 用户AdminDAO的实例
	 */
	private static LoginDAO loginDAO = new LoginDAOImpl();
	
	/*
	 * 获取CostDAO的实现类对象的方法
	 */
	public static CostDAOImpl getCostDAO(){//返回了一个DAO的实现类，这样是不对的。应该返回一个指向DAO的实现类对象的DAO接口引用，这样有助于代码的健壮性。
		return costDAO;
	}
	/*
	 * 获取AdminDAO的实现类对象的方法
	 */
	public static LoginDAO getLoginDAO(){
		return loginDAO;
	}
}
