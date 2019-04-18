package netctoss.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import netctoss.dao.CostDAO;
import netctoss.entity.Cost;

import org.springframework.stereotype.Service;

@Service("costService")
public class CostService implements Serializable {
	
	@Resource(name="costDAO")
	private CostDAO costDAO;
	
	public List<Cost> findAll() {
		return costDAO.findAll();
	}
}
