package netctoss.dao;
/**
 * ����DAO�Ĺ�����		��Ϊ������
 * @author Administrator
 *
 */
public class DAOFactory {

	/*
	 * �ʷ�DAO��ʵ��
	 */
	private static CostDAOImpl costDAO = new CostDAOImpl();
	/*
	 * �û�AdminDAO��ʵ��
	 */
	private static LoginDAO loginDAO = new LoginDAOImpl();
	
	/*
	 * ��ȡCostDAO��ʵ�������ķ���
	 */
	public static CostDAOImpl getCostDAO(){//������һ��DAO��ʵ���࣬�����ǲ��Եġ�Ӧ�÷���һ��ָ��DAO��ʵ��������DAO�ӿ����ã����������ڴ���Ľ�׳�ԡ�
		return costDAO;
	}
	/*
	 * ��ȡAdminDAO��ʵ�������ķ���
	 */
	public static LoginDAO getLoginDAO(){
		return loginDAO;
	}
}
