package web.dao;

import java.util.List;

import web.annotation.MyBatisRepository;
import web.entity.Dept;

/**
 * Dept��Mapperӳ������ʵ��DAO�������
 * @author Administrator
 *
 */
@MyBatisRepository
public interface DeptMapper {
	
	List<Dept> findAllDept();
}
