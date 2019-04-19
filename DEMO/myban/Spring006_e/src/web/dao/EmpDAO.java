package web.dao;

import java.util.List;

import web.entity.Emp;

/**
 * EmpDAO�ӿڣ������Emp���ݱ�Ĳ���
 * @author Administrator
 *
 */
public interface EmpDAO {
	
	public List<Emp> findAll();
	public Emp findByNo(int empno);
	public void update(Emp emp);
	public void save(Emp emp);
	public void delete(int empno);
}
