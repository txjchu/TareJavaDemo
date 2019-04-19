package netctoss.dao;

import java.util.List;

import netctoss.entity.Cost;

/**
 * Cost��������ݲ���DAO����ӿ�
 * @author Administrator
 *
 */
public interface CostDAO {
	
	List<Cost> findAll();//��ѯ�����ʷѵķ���
	void delete(int id);//ɾ��ĳ���ʷѵķ���
	Cost findByName(String name);//���ʷ��������ʷѼ�¼�ķ���
	Cost findById(Integer id);
	boolean update(Cost cost);
	boolean save(Cost cost);
	
}
