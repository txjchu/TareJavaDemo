package org.tare.dao;

import java.util.List;

import org.tare.entity.Dept;

/**
 * Mapperӳ��������ϰ���ؽ��ResultMapӳ��
 * @author Administrator
 *
 */
public interface DeptMapper {
	
	public List<Dept> findAll();
	public Dept findById(Integer id);
}
