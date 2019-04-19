package dao;
/**
 * dao的实现类
 * 1.以impl结尾是一种规范，便于识别实现类，此规范看企业而定，未必都如此。
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
		//先创建连接
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = "select * from cost order by cost_id";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();	//----产生迭代器模式，要加while
			List<Cost> list = new ArrayList<Cost>();	//----将结果封装到list里面
			while(rs.next()){
				Cost c = createCost(rs);
				
				list.add(c);//----
			}
			return list;		//------【】
			
		} catch (Exception e) {			
			e.printStackTrace();
			throw new RuntimeException("查询员工失败！",e);
		}finally{
			DBUtil.close(con);
		}
	}
	/**
	 * 提炼方法：Alt+Shift+M
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
//		c.setName("包月");
//		c.setBaseDuration(null);
//		c.setBaseCost(288.0);
//		c.setUnitCost(null);
//		c.setDescr("88元套餐很实惠");
//		c.setCostType("2");
//		//模拟完数据后保存下
//		dao.save(c);
		
		
		Cost c= dao.findById(101);
		System.out.println(c.getName());
		c.setName("这是漾包月");
		c.setBaseDuration(230);
		
		
	}

	//@Override 自动生成
	public void save(Cost cost) {
		//方法要保持其独立性，不要过分依赖调用方。因为该方法可能会在其他的业务中被复用。
		if(cost==null){
			return;
		}
		//创建连接
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = "insert into cost values(cost_seq.nextval,?,?,?,?,'0',?,sysdate,sysdate,?)";
			//
			PreparedStatement ps = con.prepareStatement(sql);
			//给问号赋值
			ps.setString(1,cost.getName());
			//【】setInt,setDouble必须传入数字，且不能为null,否则会报错。
					//如果业务中该字段是可以为null的，那么改用setObject方法，ps会帮你处理数据类型----【其实所有数据都可以传Object】
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
			throw new RuntimeException("新增资费失败！",e);
		}finally{
			DBUtil.close(con);
		}
	}
	//实现一个方法
	public Cost findById(int id){
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = "select *from cost where cost_id=?";
			PreparedStatement ps = con.prepareStatement(sql);	//----preparedStatement用来防止注入攻击，
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				//findAll有个公用的方法。----提炼一个createCost()方法，使用
				
				return createCost(rs);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("根据ID查询资费失败",e);
		}finally{
			DBUtil.close(con);
		}
		return null;
	}
		//实现一个方法
		//修改时不需要改status/creatime/startime
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
					throw new RuntimeException("修改资费失败",e);
				}finally{
					DBUtil.close(con);
				}
			
		}
}
