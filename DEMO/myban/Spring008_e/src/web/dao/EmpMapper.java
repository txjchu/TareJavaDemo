package web.dao;

import java.util.List;

import web.annotation.MyBatisRepository;
import web.entity.Emp;

/**
 * ʹ��ɨ��ķ�ʽ����MyBatis������
 * @author Administrator
 *
 */
@MyBatisRepository
public interface EmpMapper {
	
	List<Emp> findAllEmp();
	Emp findById(Integer empno);
	void update(Emp emp);
//	void save(Emp emp);			//Ԥ������
	void delete(Integer empno);

}
