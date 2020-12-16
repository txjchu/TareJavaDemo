package com.pc.netctoss.dao;

import com.pc.netctoss.entity.Cost;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Cost DAO 接口的实现类
 * @author: Peter
 * @date: 2020/12/11 21:56
 */
@Repository
public class CostDAOImpl implements ICostDAO, Serializable {

    @Resource
    private DataSource dataSource;

    public List<Cost> findAll() {
        List<Cost> costs = new ArrayList<Cost>();
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM cost");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                costs.add(createCost(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询资费列表失败！", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return costs;
    }

    /**
     * 根据 ID 查找记录
     */
    public Cost findById(Integer costId) {
        Cost cost = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement("SELECT * FROM COST WHERE cost_id = ?");
            ps.setInt(1, costId);
            rs = ps.executeQuery();
            while (rs.next()){
                cost = createCost(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("根据ID查询资费失败！", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cost;
    }

    /**
     * 添加新记录
     */
    public void save(Cost cost) {
        if(cost == null){
            return;
        }
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement("INSERT INTO cost(cost_id, name, base_duration, base_cost, unit_cost, descr, cost_type) VALUES(" +
                    "null, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, cost.getName());
            //setInt,setDouble必须传入数字，且
            //不能为null，否则会报错。
            //如果业务中该字段是可以为null的，那么
            //改用setObject方法，ps会帮你处理数据类型。
            ps.setObject(2, cost.getBaseDuration());
            ps.setObject(3, cost.getBaseCost());
            ps.setObject(4, cost.getUnitCost());
            ps.setString(5, cost.getDescr());
            ps.setString(6, cost.getCostType());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("添加资费记录失败！", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 修改记录
     */
    public void update(Cost cost) {
        if(cost == null){
            return;
        }
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement("UPDATE cost SET name=?, base_duration=?,base_cost=?, unit_cost=?,descr=?, cost_type=? WHERE cost_id=?");
            ps.setString(1, cost.getName());
            ps.setObject(2, cost.getBaseDuration());
            ps.setObject(3, cost.getBaseCost());
            ps.setObject(4, cost.getUnitCost());
            ps.setString(5, cost.getDescr());
            ps.setString(6, cost.getCostType());
            ps.setObject(7, cost.getCostId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("修改资费记录失败！", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 删除记录
     */
    public void delete(Integer costId) {
        if(costId == null){
            return;
        }
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement("DELETE from cost WHERE cost_id = ?");
            ps.setObject(1, costId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("删除资费记录失败！", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据 name 查找记录(假定 name 无重复)
     */
    public Cost findByName(String name) {
        if("".equals(name) || name == null){
            return null;
        }
        Connection conn = null;
        PreparedStatement ps = null;
        Cost cost = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement("SELECT * FROM cost WHERE name = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()){
                cost = createCost(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("根据name查找记录失败！", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return cost;
    }

    /**
     * 修改资费的开通与暂停状态。开通0 暂停1
     * @param cost
     */
    public void updateStatus(Cost cost) {
        if(cost == null){
            return;
        }
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement("UPDATE cost SET status = ? WHERE cost_id = ?");
            ps.setObject(1, cost.getStatus());
            ps.setObject(2, cost.getCostId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("修改资费开通状态失败！", e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Cost createCost(ResultSet rs) throws SQLException {
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
