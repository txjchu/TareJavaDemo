package org.tare.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.tare.entity.Dept;

/**
 * DeptDao的实现类
 * @author Administrator
 *
 */
@Repository
public class DeptDaoImpl implements DeptDao, Serializable{

	@Resource		//依赖注入
	private SqlSessionTemplate template;
	
	public void delete(Integer deptno) {
		template.delete("org.tare.dao.DeptMapper.delete", deptno);
		
	}

	public List<Dept> findAll() {
		List<Dept> list = template.selectList("org.tare.dao.DeptMapper.findAll");
		return list;
	}

	public Dept findById(Integer deptno) {
		Dept dept = template.selectOne("org.tare.dao.DeptMapper.findById", deptno);
		return dept;
	}

	public int save(Dept dept) {
		int num = template.insert("org.tare.dao.DeptMapper.save", dept);
		return num;
	}

	public int update(Dept dept) {
		int num = template.update("org.tare.dao.DeptMapper.update", dept);
		return num;
	}
	
}
