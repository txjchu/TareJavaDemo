package netctoss.test;

import java.util.List;

import netctoss.dao.CostMapper;
import netctoss.entity.Cost;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ≤‚ ‘CostMapper
 * @author Administrator
 *
 */
public class TestCostMapper {
	
	private CostMapper mapper;
	@Before
	public void testBefore(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		mapper = ac.getBean("costMapper", CostMapper.class);
	}
	@Test
	public void testFindAll(){
		List<Cost> costs = mapper.findAll();
		for(Cost cost : costs){
			System.out.println(cost);
		}
	}
}
