package netctoss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import netctoss.entity.Cost;

import org.springframework.stereotype.Repository;


@Repository("costDAO")
public class CostDAO{
	
	@Resource(name="dataSource")
	private DataSource dataSource;

	public List<Cost> findAll() {
		ArrayList<Cost> list = 
			new ArrayList<Cost>();
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select * from cost order by cost_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Cost cost = new Cost();
				cost.setCostId(rs.getInt("cost_id"));
				cost.setName(rs.getString("name"));
				cost.setBaseDuration(rs.getInt("base_duration"));
				cost.setBaseCost(rs.getDouble("base_cost"));
				cost.setUnitCost(rs.getDouble("unit_cost"));
				cost.setStatus(rs.getString("status"));
				cost.setDescr(rs.getString("descr"));
				cost.setCreatime(rs.getTimestamp("creatime"));
				cost.setStartime(rs.getTimestamp("startime"));
				cost.setCostType(rs.getString("cost_type"));
				list.add(cost);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("²éÑ¯×Ê·ÑÊ§°Ü", e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
