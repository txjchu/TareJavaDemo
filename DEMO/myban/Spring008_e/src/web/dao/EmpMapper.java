package web.dao;

import java.util.List;

import web.annotation.MyBatisRepository;
import web.entity.Emp;

/**
 * 使用扫描的方式进行MyBatis的整合
 * @author Administrator
 *
 */
@MyBatisRepository
public interface EmpMapper {
	
	List<Emp> findAllEmp();
	Emp findById(Integer empno);
	void update(Emp emp);
//	void save(Emp emp);			//预留功能
	void delete(Integer empno);

}
