package netctoss.dao;

import java.util.List;

import netctoss.annotation.MyBatisRepository;
import netctoss.entity.Cost;

/**
 * Cost���Mapperӳ�����ӿ�
 * @author Administrator
 *
 */
@MyBatisRepository
public interface CostMapper {

	List<Cost> findAll();
	
}
