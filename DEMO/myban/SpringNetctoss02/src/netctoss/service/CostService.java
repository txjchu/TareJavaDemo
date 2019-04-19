package netctoss.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import netctoss.dao.CostMapper;
import netctoss.entity.Cost;

import org.springframework.stereotype.Service;

/**
 * 业务层组件：处理Cost相关的业务
 * @author Administrator
 *
 */
@Service
public class CostService implements Serializable{
	
	@Resource
	private CostMapper mapper;
	
	public List<Cost> findAllCost(){
		List<Cost> costs = mapper.findAll();
		return costs;
	}
}
