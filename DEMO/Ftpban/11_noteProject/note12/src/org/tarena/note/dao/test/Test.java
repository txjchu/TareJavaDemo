package org.tarena.note.dao.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	
	public void test() throws SQLException{
		String sql = "insert into....";
		Connection conn = null;
		PreparedStatement stat = 
			conn.prepareStatement(
			sql,Statement.RETURN_GENERATED_KEYS);
		stat.executeUpdate();
		ResultSet rs = stat.getGeneratedKeys();//��ȡ�Զ�����idֵ
		rs.next();//�ƶ�����һ��
		int id = rs.getInt(0);//��ȡ��һ��
	}
	
}
