package com.pc.dao;

import com.pc.entity.Emp;

import java.util.List;
import java.util.Map;

/**
 * 使用 Mapper 映射器
 * 需要注意 EmpMapper.xml 中的 namespace 的修改
 *
 * 即：将 mapper 写为接口形式，只要满足以下2点即可。
 * 1. Mapper接口名和对应的映射文件中的namespace必须一致
 * 2. Mapper接口中的方法必须和映射文件中的对应的SQL元素ID一致
 * @author: Peter
 * @date: 2020/12/16 4:59
 */
public interface IEmpMapper {

    List<Emp> findAll();
    List<Emp> findByName(String ename);
    Emp findById();
    void save(Emp emp);
    void update(Emp emp);
    void delete(Integer empno);
    List<Map<String, Object>> findByDeptno();
}
