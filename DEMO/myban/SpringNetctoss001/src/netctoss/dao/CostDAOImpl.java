package netctoss.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import netctoss.entity.Cost;

@Repository("costDAOImpl")		//持久层注解
public class CostDAOImpl implements CostDAO, Serializable{
	
	@Resource		//依赖注入
	private DataSource dataSource;//数据库连接池对象
	
	public List<Cost> findAll() {
		Connection conn = null;
		List<Cost> list = new ArrayList<Cost>();
		try {
			conn = dataSource.getConnection();
			String sql = "select * from cost";
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){//将查询出来的记录放入list集合中
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
			throw new RuntimeException("查询资费列表失败！", e);//向外抛出异常
		} finally {
			try {
				conn.close();//归还连接
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	
}
