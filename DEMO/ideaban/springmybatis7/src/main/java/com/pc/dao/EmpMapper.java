package com.pc.dao;

import com.pc.entity.Emp;
import com.pc.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Emp DAO
 * @author: Peter
 * @date: 2020/12/16 2:23
 */
public class EmpMapper implements Serializable {

    public List<Emp> findAll(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        List<Emp> emps = sqlSession.selectList("findAll");
        sqlSession.close();
        return emps;
    }

    public Emp findById(Integer empno){
        SqlSession session = MyBatisUtil.getSession();
        Emp emp = session.selectOne("findById", empno);
        session.close();
        return emp;
    }

    public List<Emp> findByName(String ename){
        SqlSession session = MyBatisUtil.getSession();
        List<Emp> emps = session.selectList("findByName", ename);
        session.close();
        return emps;
    }

    public void save(Emp emp){
        SqlSession sqlSession = MyBatisUtil.getSession();
        sqlSession.insert("save", emp);
        sqlSession.commit(); // 笔记： 使用 SqlSession 进行 增删改 操作后需要提交数据库SQL事务，才能最终生效。
        sqlSession.close();
    }

    public void update(Emp emp){
        SqlSession session = MyBatisUtil.getSession();
        session.update("update", emp);
        session.commit();
        session.close();
    }

    public void delete(Integer empno){
        SqlSession session = MyBatisUtil.getSession();
        session.delete("delete", empno);
        session.commit();
        session.close();
    }

    public List<Map<String, Object>> findByDeptno(Integer deptno){
        SqlSession session = MyBatisUtil.getSession();
        // findByDeptno 查询结果封装为 Map，没个 map 的 key 为字段名，value 为该字段中的数据。
        List<Map<String, Object>> maps = session.selectList("findByDeptno", deptno);
        return maps;
    }
}
