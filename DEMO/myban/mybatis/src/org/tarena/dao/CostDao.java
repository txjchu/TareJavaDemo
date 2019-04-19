package org.tarena.dao;

import java.util.List;
import java.util.Map;

import org.tarena.entity.Cost;

public interface CostDao {
	public List<Cost> findAll();
	public Cost findById(Integer id);
	public int save(Cost cost);		//---int,���ص�����Ӱ��ļ�¼������
	public Map findNameById(Integer id);
	public int start(Map map);
	public int delete(Integer id);
}
