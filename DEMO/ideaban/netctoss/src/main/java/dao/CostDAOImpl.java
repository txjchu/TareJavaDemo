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
 * 1.以impl结尾是一种规范，便于识别实现类。 此规范看企业而定，未必都如此
 * @author: Peter
 * @date: 2020/10/3 22:49
 */
public class CostDAOImpl implements ICostDAO {


    /**
     * 从 ResultSet 映射到 Cost
     * 将 rs 中的当前指针所在的数据转化为 Cost 对象。
     * 该方法应放在判断 rs.next() 之后，且抛出 SQLException.
     */
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

    /**
     * 查询所有的 cost 记录
     * @return
     */
    public List<Cost> findAll() {
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
//                cost.setCostId(rs.getInt("cost_id"));
//                cost.setName(rs.getString("name"));
//                cost.setBaseDuration(rs.getInt("base_duration"));
//                cost.setBaseCost(rs.getDouble("base_cost"));
//                cost.setUnitCost(rs.getDouble("unit_cost"));
//                cost.setStatus(rs.getString("status"));
//                cost.setDescr(rs.getString("descr"));
//                cost.setCreatime(rs.getTimestamp("creatime"));
//                cost.setStartime(rs.getTimestamp("startime"));
//                cost.setCostType(rs.getString("cost_type"));
                cost = createCost(rs);
                costs.add(cost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有资费数据失败！", e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }

        return costs;
    }

    /**
     * 根据 ID 查找记录
     */
    public Cost findById(Integer costId){
        Cost cost = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.openConnection();
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
            JDBCUtil.closeConnection(conn);
        }
        return cost;
    }

    /**
     * 添加新记录
     */
    public void save(Cost cost){
        if(cost == null){
            return;
        }
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
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
            JDBCUtil.closeConnection(conn);
        }
    }

    /**
     * 修改记录
     */
    public void update(Cost cost){
        if(cost == null){
            return;
        }
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
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
            JDBCUtil.closeConnection(conn);
        }
    }

    /**
     * 删除记录
     */
    public void delete(Integer costId){
        if(costId == null){
            return;
        }
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("DELETE from cost WHERE cost_id = ?");
            ps.setObject(1, costId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("删除资费记录失败！", e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }

    /**
     * 根据 name 查找记录(假定 name 无重复)
     */
    public Cost findByName(String name){
        if("".equals(name) || name == null){
            return null;
        }
        Connection conn = null;
        PreparedStatement ps = null;
        Cost cost = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.openConnection();
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
            JDBCUtil.closeConnection(conn);
        }

        return cost;
    }


    /**
     * 修改资费的开通与暂停状态。开通0 暂停1
     * @param cost
     */
    @Override
    public void updateStatus(Cost cost) {
        if(cost == null){
            return;
        }
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("UPDATE cost SET status = ? WHERE cost_id = ?");
            ps.setObject(1, cost.getStatus());
            ps.setObject(2, cost.getCostId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("修改资费开通状态失败！", e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }

    }


}
