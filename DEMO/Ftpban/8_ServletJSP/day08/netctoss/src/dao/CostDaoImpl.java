package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import entity.Cost;

/**
 * 1.��impl��β��һ�ֹ淶������ʶ��ʵ���ࡣ
 *  �˹淶����ҵ������δ�ض���ˡ�
 */
public class CostDaoImpl implements ICostDao {

	@Override
	public List<Cost> findAll() {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = "select * from cost " +
				"order by cost_id";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Cost> list = new ArrayList<Cost>();
			while(rs.next()) {
				Cost c = createCost(rs);
				list.add(c);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
				"��ѯԱ��ʧ��.", e);
		} finally {
			DBUtil.close(con);
		}
	}

	/**
	 * Alt+Shift+M
	 */
	private Cost createCost(ResultSet rs) 
		throws SQLException {
		Cost c = new Cost();
		c.setCostId(rs.getInt("cost_id"));
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
		Cost c = dao.findById(102);
		c.setName("777Ԫ�ײ�");
		c.setBaseDuration(777);
		dao.update(c);
	}

	@Override
	public void save(Cost cost) {
		//����Ҫ����������ԣ���Ҫ��������
		//���÷�����Ϊ�÷������ܻ���������
		//ҵ���б����á�
		if(cost == null) {
			return;
		}
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = "insert into cost values" +
				"(cost_seq.nextval,?,?,?,?,'0',?,sysdate,sysdate,?)";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, cost.getName());
			//setInt,setDouble���봫�����֣���
			//����Ϊnull������ᱨ��
			//���ҵ���и��ֶ��ǿ���Ϊnull�ģ���ô
			//����setObject������ps����㴦���������͡�
			ps.setObject(2, cost.getBaseDuration());
			ps.setObject(3, cost.getBaseCost());
			ps.setObject(4, cost.getUnitCost());
			ps.setString(5, cost.getDescr());
			ps.setString(6, cost.getCostType());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
				"�����ʷ�ʧ��.", e);
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public Cost findById(int id) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = "select * from cost " +
					"where cost_id=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return createCost(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
				"����ID��ѯ�ʷ�ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
		
		return null;
	}

	//�޸�ʱ����Ҫ��status/creatime/startime
	@Override
	public void update(Cost cost) {
		if(cost == null) {
			return;
		}
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"update cost set " +
				"name=?,base_duration=?," +
				"base_cost=?,unit_cost=?," +
				"descr=?,cost_type=? " +
				"where cost_id=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, cost.getName());
			ps.setObject(2, cost.getBaseDuration());
			ps.setObject(3, cost.getBaseCost());
			ps.setObject(4, cost.getUnitCost());
			ps.setString(5, cost.getDescr());
			ps.setString(6, cost.getCostType());
			ps.setInt(7, cost.getCostId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
				"�޸��ʷ�ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
	}

}








