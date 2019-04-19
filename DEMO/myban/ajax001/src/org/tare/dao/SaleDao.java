package org.tare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.tare.entity.Sale;
import org.tare.util.JDBCUtil;

/**
 * 操作数据表t_sale的DAO组件
 * @author Administrator
 *
 */
public class SaleDao {
	
	private Connection conn = null;
	
	public List<Sale> findAll(){
		String sql = "select * from t_sale order by qty";
		List<Sale> list = new ArrayList<Sale>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Sale s = new Sale();
				s.setId(rs.getInt("id"));
				s.setProdName(rs.getString("prodname"));
				s.setQty(rs.getInt("qty"));
				list.add(s);
			}		
		} catch (SQLException e) {
			System.out.println("数据库连接异常!");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return list;
	}
	
	//查找销量前三的记录		热销sell销售
	public List<Sale> findSell(){
		String sql = "select * from ( select rownum r, a.* from (select * from t_sale order by qty desc) a) b where b.r < 4";
		List<Sale> list = new ArrayList<Sale>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Sale s = new Sale();
				s.setId(rs.getInt("id"));
				s.setProdName(rs.getString("prodname"));
				s.setQty(rs.getInt("qty"));
				list.add(s);
			}
		} catch (SQLException e) {
			System.out.println("SaleDao中findSall方法：数据库操作异常");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return list;
	}
	
	//向表中插入记录
	public int save(String name){//name  商品名字
		String sql = "insert into t_sale values(sal_id_seq.nextval, ?, ?)";
		int count = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, (int) (Math.random() * 1000));
			count = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("saleDao中save方法：数据库操作异常");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, conn);
		}
		return count;
	}
	public void deleteByName(String name){
		String sql = "delete t_sale where prodname = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("saleDao中delete方法:数据库操作异常!");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, conn);
		}
		
	}
}












