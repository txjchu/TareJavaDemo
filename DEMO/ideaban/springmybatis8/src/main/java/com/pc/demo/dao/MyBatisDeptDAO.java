package com.pc.demo.dao;

import com.pc.demo.entity.Dept;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * spring+mybatis 方式三 ： 使用 SqlSessionTemplate
 * @author: Peter
 * @date: 2020/12/16 22:29
 */
@Repository
public class MyBatisDeptDAO implements Serializable {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    private String path = "com.pc.demo.dao.DeptMapper";

    public List<Dept> findAll(){
        List<Dept> depts ;
        depts = sqlSessionTemplate.selectList("com.pc.demo.dao.DeptMapper.findAll");

        return depts;
    }

    public Dept findById(Integer deptno){
        return sqlSessionTemplate.selectOne("com.pc.demo.dao.DeptMapper.findById", deptno);
    }

    public int save(Dept dept){
        return sqlSessionTemplate.insert(path +".save", dept);
    }

    public int update(Dept dept){
        return sqlSessionTemplate.update(path +".update", dept);
    }

    public int delete(Integer deptno){
        return sqlSessionTemplate.delete(path +".delete", deptno);
    }
}
