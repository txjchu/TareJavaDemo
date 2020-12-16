package com.pc.netctoss.dao;

import com.pc.netctoss.entity.Cost;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 使用 Spring+JDBC 技术实现 DAO
 * @author: Peter
 * @date: 2020/12/13 0:49
 */
@Repository
public class JdbcCostDAOImpl implements ICostDAO, Serializable {

    // Spring 整合 JDBC 后，使用 JdbcTemplate 对象提供的方法操作数据库交互
    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<Cost> findAll() {
        List<Cost> costs = jdbcTemplate.query("SELECT * FROM cost", new CostRowMapper());
        return costs;
    }

    public Cost findById(Integer costId) {
        return null;
    }

    public void save(Cost cost) {

    }

    public void update(Cost cost) {

    }

    public void delete(Integer costId) {

    }

    public Cost findByName(String name) {
        return null;
    }

    public void updateStatus(Cost cost) {

    }


    class CostRowMapper implements RowMapper {

        public Cost mapRow(ResultSet rs, int i) throws SQLException {
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
