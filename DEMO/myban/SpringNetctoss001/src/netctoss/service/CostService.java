package netctoss.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import netctoss.dao.CostDAO;
import netctoss.entity.Cost;

import org.springframework.stereotype.Service;
/**
 * 查询资费列表的业务处理层
 * @author Administrator
 *
 */
@Service
public class CostService implements Serializable{
	
	//依赖注入costDAOImpl对象，因为没有注解CostDAO，所以注入的是该DAO的实现类。
	//使用Spring整合Jdbc技术重构后，指定注入SpringJdbcCostDAO对象。使用该DAO组件完成对数据库表的操作。
	@Resource(name = "springJdbcCostDAO")
	private CostDAO costDao;
	
	public List<Cost> findAll(){
		List<Cost> list = costDao.findAll();
		return list;
	}
}
