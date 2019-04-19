package dao;
/**
 * dao��ʵ����
 * 1.��impl��β��һ�ֹ淶������ʶ��ʵ���࣬�˹淶����ҵ������δ�ض���ˡ�
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import entity.Cost;

public class CostDaoImpl implements ICostDao {

	@Override
	public List<Cost> findAll() {
		//�ȴ�������
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = "select * from cost order by cost_id";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();	//----����������ģʽ��Ҫ��while
			List<Cost> list = new ArrayList<Cost>();	//----�������װ��list����
			while(rs.next()){
				Cost c = createCost(rs);
				
				list.add(c);//----
			}
			return list;		//------����
			
		} catch (Exception e) {			
			e.printStackTrace();
			throw new RuntimeException("��ѯԱ��ʧ�ܣ�",e);
		}finally{
			DBUtil.close(con);
		}
	}
	/**
	 * ����������Alt+Shift+M
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Cost createCost(ResultSet rs) throws SQLException {
		Cost c = new Cost();
		c.setCostID(rs.getInt("cost_id"));
		c.setName(rs.getString("name"));
		c.setBaseDuration(rs.getInt("base_duration"));
		c.setBaseCost(rs.getDouble("base_cost"));
		c.setUnitCost(rs.getDouble("unit_cost"));
		c.setStatus(rs.getString("status"));
		c.setDescr(rs.getString("descr"));
		c.setCreatime(rs.getTimestamp("creatime"));
		c.setStartime(rs.getTimestamp("startime"));
		c.setCostType(rs.getString("cost_type"));
		return c;
	}

	public static void main(String[] args) {
		ICostDao dao = new CostDaoImpl();
		List<Cost> list = dao.findAll();
		for(Cost c:list){
			System.out.println(c.getCostID()+","+c.getName()+","+c.getBaseDuration());
		}
//		ICostDao dao1 = new CostDaoImpl();
//		Cost c = new Cost();
//		c.setName("����");
//		c.setBaseDuration(null);
//		c.setBaseCost(288.0);
//		c.setUnitCost(null);
//		c.setDescr("88Ԫ�ײͺ�ʵ��");
//		c.setCostType("2");
//		//ģ�������ݺ󱣴���
//		dao.save(c);
		
		
		Cost c= dao.findById(101);
		System.out.println(c.getName());
		c.setName("����������");
		c.setBaseDuration(230);
		
		
	}

	//@Override �Զ�����
	public void save(Cost cost) {
		//����Ҫ����������ԣ���Ҫ�����������÷�����Ϊ�÷������ܻ���������ҵ���б����á�
		if(cost==null){
			return;
		}
		//��������
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = "insert into cost values(cost_seq.nextval,?,?,?,?,'0',?,sysdate,sysdate,?)";
			//
			PreparedStatement ps = con.prepareStatement(sql);
			//���ʺŸ�ֵ
			ps.setString(1,cost.getName());
			//����setInt,setDouble���봫�����֣��Ҳ���Ϊnull,����ᱨ��
					//���ҵ���и��ֶ��ǿ���Ϊnull�ģ���ô����setObject������ps����㴦����������----����ʵ�������ݶ����Դ�Object��
			ps.setObject(2, cost.getBaseDuration());
			ps.setObject(3, cost.getBaseCost());
			ps.setObject(4,cost.getUnitCost());
			ps.setString(5,cost.getDescr());
			ps.setString(6, cost.getCostType());
			//
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("�����ʷ�ʧ�ܣ�",e);
		}finally{
			DBUtil.close(con);
		}
	}
	//ʵ��һ������
	public Cost findById(int id){
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = "select *from cost where cost_id=?";
			PreparedStatement ps = con.prepareStatement(sql);	//----preparedStatement������ֹע�빥����
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				//findAll�и����õķ�����----����һ��createCost()������ʹ��
				
				return createCost(rs);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("����ID��ѯ�ʷ�ʧ��",e);
		}finally{
			DBUtil.close(con);
		}
		return null;
	}
		//ʵ��һ������
		//�޸�ʱ����Ҫ��status/creatime/startime
		public void update(Cost cost){
			if(cost == null){
				return;
			}
				Connection con = null;
				String sql="update cost set name=?,base_duration=?,"+
							"base_cost=?,unit_cost=?,descr=?,cost_type=?"+
							"where cost_id=?";
				try {
					con = DBUtil.getConnection();
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1,cost.getName());
					ps.setObject(2,cost.getBaseDuration());
					ps.setObject(3, cost.getBaseCost());
					ps.setObject(4,cost.getUnitCost());
					ps.setString(5, cost.getDescr());
					ps.setString(6,cost.getCostType());
					ps.setInt(7,cost.getCostID());
					ps.executeUpdate();
					
				} catch (Exception e) {
					
					e.printStackTrace();
					throw new RuntimeException("�޸��ʷ�ʧ��",e);
				}finally{
					DBUtil.close(con);
				}
			
		}
}
