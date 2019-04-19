package netctoss.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import netctoss.entity.Cost;

@Repository
public class SpringJdbcCostDAO implements CostDAO, Serializable{
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public List<Cost> findAll() {
		String sql = "select * from cost order by cost_id";
		return jdbcTemplate.query(sql, new CostRowMapper());
	}
	
	//实现该内部类需要引用spring-jdbc、spring-tx等jar包。
	class CostRowMapper implements RowMapper<Cost>{
		
		public Cost mapRow(ResultSet rs, int index) throws SQLException{
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
			return cost;
		}
	}
}
