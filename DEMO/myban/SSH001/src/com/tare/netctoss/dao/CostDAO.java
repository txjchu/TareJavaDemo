package com.tare.netctoss.dao;

import java.util.List;

import com.tare.netctoss.entity.Cost;

/**
 * Cost���DAO
 * @author Administrator
 *
 */
public interface CostDAO {

	List<Cost> findAll();//��ѯ�����ʷѼ�¼
	
	Cost findById(Integer id);//��ID��ѯ��ĳ����¼
	
	void updateStatus(Integer id);//����ID�޸Ŀ�ͨ��ͣ״̬
	
	List<Cost> findByName(String name);//���ʷ����Ʋ�ѯ��ĳ����¼�����ڼ���ʷ������Ƿ��ظ�
	
	int findTotalPage(int pageSize);//��ѯ��ҳ��
	
	List<Cost> findByPage(int page, int pageSize);//��ҳ����ҳ������ѯָ���ĵڼ�ҳ�ļ�¼
	
	void save(Cost cost);//����ĳ����¼
	
	void update(Cost cost);//����ĳ����¼
	
	void delete(Integer cost_id);//ɾ��ĳ����¼
	
}
