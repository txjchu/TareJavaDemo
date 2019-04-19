package org.tare.dao;

import java.util.List;

import org.tare.annotation.MyBatisRepository;
import org.tare.entity.Dept;

/**
 * Dept类的Mapper映射器接口
 * @author Administrator
 *
 */
/*
 * 使用自定义注解，带有该注解的接口后，在bean的定义中添加了annotationClass指定后，
 * MapperScannerConfigurer将只注册使用了该注解标记的接口。
 */
@MyBatisRepository		
public interface DeptMapper {
	
	List<Dept> findAll();				//查询所有部门信息
	Dept findById(Integer deptno);		//根据部门编号查找部门
	int save(Dept dept);				//添加部门
	int update(Dept dept);				//修改部门
	void delete(Integer deptno);		//根据部门号删除部门
}
