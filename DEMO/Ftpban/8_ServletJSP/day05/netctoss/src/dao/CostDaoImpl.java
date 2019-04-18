package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public static void main(String[] args) {
		ICostDao dao = new CostDaoImpl();
		List<Cost> list = dao.findAll();
		for(Cost c : list) {
			System.out.println(
				c.getCostId() + "," +
				c.getName() + "," +
				c.getBaseDuration());
		}
	}

}








