package dao;

import java.util.List;
import entity.Cost;

/**
 *	1.DAO�ľ���д���Ǵ��нӿڵģ�
 *	  ���ڽӿڵ�����ѧSpringʱ�Ͷ��ˡ�
 *  2.��I��ͷ��һ�ֹ淶������ʶ��ýӿڡ�
 *   �˹淶����ҵ������δ�ض���ˡ�
 */
public interface ICostDao {
	
	List<Cost> findAll();
	
	void save(Cost cost);
	
	Cost findById(int id);
	
	void update(Cost cost);

}





