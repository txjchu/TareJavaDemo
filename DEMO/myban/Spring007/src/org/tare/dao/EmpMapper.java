package org.tare.dao;

import java.util.List;

import org.tare.entity.Emp;

/**
 * EmpDAO接口，定义了操作数据库的方法
 * 
 * MyBatis实现SQL语句的CRUD操作的第二种方式，使用Mapper映射器。
 * 即不直接使用SqlSession调用XML配置文件中的SQL语句，来完成CRUD操作。
 * 而是，创建Mapper映射器，将XML中的<mapper>元素指定namespace=""该映射器接口的全名，
 * 该映射器接口中就可以定义CRUD方法。在实际操作中通过SqlSession.getMapper(xxxMapper.class)获取
 * 到该映射器对象，就可以调用映射器对象中的方法来调用对应的SQL语句，完成CRUD操作。
 * 
 * @author Administrator
 *
 */

public interface EmpMapper {
	
	public List<Emp> findAll();
	public Emp findById(int empno);
	public int save(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
}	
