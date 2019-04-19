package netctoss.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import netctoss.dao.CostDAO;
import netctoss.entity.Cost;

import org.springframework.stereotype.Service;
/**
 * ��ѯ�ʷ��б��ҵ�����
 * @author Administrator
 *
 */
@Service
public class CostService implements Serializable{
	
	//����ע��costDAOImpl������Ϊû��ע��CostDAO������ע����Ǹ�DAO��ʵ���ࡣ
	//ʹ��Spring����Jdbc�����ع���ָ��ע��SpringJdbcCostDAO����ʹ�ø�DAO�����ɶ����ݿ��Ĳ�����
	@Resource(name = "springJdbcCostDAO")
	private CostDAO costDao;
	
	public List<Cost> findAll(){
		List<Cost> list = costDao.findAll();
		return list;
	}
}
