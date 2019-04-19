package org.tare.dao;

import java.util.List;

import org.tare.entity.Dept;

/**
 * MapperÓ³ÉäÆ÷£¬Á·Ï°·µ»Ø½á¹ûResultMapÓ³Éä
 * @author Administrator
 *
 */
public interface DeptMapper {
	
	public List<Dept> findAll();
	public Dept findById(Integer id);
}
