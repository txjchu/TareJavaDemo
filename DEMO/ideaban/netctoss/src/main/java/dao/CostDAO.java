package dao;

import entity.Cost;
import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Peter
 * @date: 2020/10/3 22:49
 */
public class CostDAO {

    /**
     * 查询所有的 cost 记录
     * @return
     */
    public List<Cost> findAll() throws SQLException {
        List<Cost> costs = new ArrayList<Cost>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("SELECT * FROM cost");
            rs = ps.executeQuery();
            while (rs.next()){
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
                costs.add(cost);
            }
        } catch (SQLException e) {

            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtil.closeConnection(conn);
        }

        return costs;
    }
}
