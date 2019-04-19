package web.dao;

import java.util.List;

import web.annotation.MyBatisRepository;
import web.entity.Dept;

/**
 * Dept的Mapper映射器，实现DAO组件功能
 * @author Administrator
 *
 */
@MyBatisRepository
public interface DeptMapper {
	
	List<Dept> findAllDept();
}
