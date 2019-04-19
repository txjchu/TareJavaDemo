package org.tare.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.tare.entity.Emp;
import org.tare.util.MyBatisUtil;

/**
 * MyBatis技术的数据访问对象组件DAO
 * @author Administrator
 *
 */
public class MyBatisEmpDao {

	public List<Emp> findAll(){
		SqlSession session = MyBatisUtil.getSession();//获取一个SqlSession
		List<Emp> list = session.selectList("org.tare.dao.EmpMapper.findAll");
													   //执行SqlMapper.xml文件中的相同id的方法
													   //若有多个sqlMapper.xml文件，此处findAll就应该写成全名，即org.tare.sql.EmpMapper.findAll	
		session.close();//释放资源
		return list;
	}
	
	public Emp findById(Integer empno){
		SqlSession session = MyBatisUtil.getSession();
		Emp emp = session.selectOne("org.tare.dao.EmpMapper.findById", empno);
		session.close();
		return emp;
	}
	
	public List<Map<String, Object>> findByDeptno(Integer deptno){
		SqlSession session = MyBatisUtil.getSession();
		List<Map<String, Object>> list = session.selectList("org.tare.dao.EmpMapper.findByDeptno", deptno);
		session.close();
		return list;
	}
	
	public void save(Emp emp){
		SqlSession session = MyBatisUtil.getSession();
		try {
			session.insert("org.tare.dao.EmpMapper.save", emp);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
	
	public void update(Emp emp){
		SqlSession session = MyBatisUtil.getSession();
		try {
			session.update("org.tare.dao.EmpMapper.update", emp);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
	
	public void delete(Integer empno){
		SqlSession session = MyBatisUtil.getSession();
		try {
			session.delete("org.tare.dao.EmpMapper.delete", empno);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
}
