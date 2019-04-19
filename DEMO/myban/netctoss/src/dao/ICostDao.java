package dao;

import java.util.List;

import entity.Cost;

/**
 * 1.Dao�ľ���д���Ǵ��нӿڵġ����ڽӿڵ�����ѧSpringʱ�Ͷ��ˡ�
 * 2.��I��ͷ����ͽӿ���һ�ֹ淶������ʶ��ýӿڣ��˹淶����ҵ������δ�ض���ˡ�
 * @author Administrator
 *
 */
public interface ICostDao {
	List<Cost> findAll();
	
	//����һ������ķ���
	void save(Cost cost);
	//����һ���޸��õĲ�ѯ����
	Cost findById(int id);
	//����һ���޸ķ���
	void update(Cost cost);
	
}
