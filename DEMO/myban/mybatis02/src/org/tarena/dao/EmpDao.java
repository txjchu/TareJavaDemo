package org.tarena.dao;

import java.util.List;

import org.tarena.entity.Emp;
import org.tarena.util.MyBatisDao;

/**
 * 练习自定义注解@MyBatisDao
 * @author Administrator
 *
 */
@MyBatisDao
public interface EmpDao {
	public int save(Emp emp);
	public List<Emp> findAll();
}
