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

@Repository("costDAOImpl")		//�־ò�ע��
public class CostDAOImpl implements CostDAO, Serializable{
	
	@Resource		//����ע��
	private DataSource dataSource;//���ݿ����ӳض���
	
	public List<Cost> findAll() {
		Connection conn = null;
		List<Cost> list = new ArrayList<Cost>();
		try {
			conn = dataSource.getConnection();
			String sql = "select * from cost";
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){//����ѯ�����ļ�¼����list������
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
			throw new RuntimeException("��ѯ�ʷ��б�ʧ�ܣ�", e);//�����׳��쳣
		} finally {
			try {
				conn.close();//�黹����
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	
}
