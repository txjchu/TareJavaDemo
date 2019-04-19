package netctoss.dao;

import java.util.List;

import netctoss.annotation.MyBatisRepository;
import netctoss.entity.Cost;

/**
 * Cost类的Mapper映射器接口
 * @author Administrator
 *
 */
@MyBatisRepository
public interface CostMapper {

	List<Cost> findAll();
	
}
