package com.tare.netctoss.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tare.netctoss.dao.BaseDao;
import com.tare.netctoss.dao.RoleInfoDao;
import com.tare.netctoss.entity.RoleInfo;

/**
 * RoleInfoDao的实现类
 * @author Administrator
 *
 */
public class RoleInfoDaoImpl extends BaseDao implements RoleInfoDao {
	private static final String findAll = "select * from role_info";
	private static final String INSERT = "insert into role_info(role_id, name) values(role_seq.nextval, ?)";
	private static final String MODIFY = "update role_info set name = ? where role_id = ?";
	
	//查询表中所有记录的方法
	@Override
	public List<RoleInfo> findAll() throws SQLException {
		Connection conn = BaseDao.getConnection();
		List<RoleInfo> list = new ArrayList<RoleInfo>();
		PreparedStatement ps = conn.prepareStatement(findAll);
		ResultSet rs = ps.executeQuery();
		RoleInfo ri = null;
		while(rs.next()){
			ri = new RoleInfo(rs.getInt("role_id"), rs.getString("name"));
			list.add(ri);
		}
		BaseDao.close(rs, ps, conn);	
			
		return list;
	}
	
	//改：修改表中指定的记录的name
	@Override
	public RoleInfo modify(RoleInfo ri) throws SQLException {
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = conn.prepareStatement(MODIFY);
		ps.setString(1, ri.getName());
		ps.setInt(2, ri.getRoleId());
		int flag = ps.executeUpdate();
		
		return (flag > 0) ? ri : null;
	}

	//向表中插入某条记录
	@Override
	public RoleInfo save(RoleInfo ri) throws SQLException {
		Connection conn = BaseDao.getConnection();
		String sql = INSERT;
		PreparedStatement ps = conn.prepareStatement(sql, new String[]{"role_id"});
		ps.setString(1, ri.getName());
		int flag = ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();//不要忘记移动指针
		ri.setRoleId(rs.getInt(1));
		return (flag > 0) ? ri : null;
	}
	
}
