import com.pc.netctoss.dao.CostMapper;
import com.pc.netctoss.entity.Cost;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author: Peter
 * @date: 2020/12/17 2:42
 */


public class TestCostMapper {

    ApplicationContext ac;
    CostMapper mapper;

    @Before
    public void b(){
        ac = new ClassPathXmlApplicationContext("WEB-INF/dispatcher-servlet.xml");
//        mapper = ac.getBean(CostMapper.class, "costMapper");
        mapper = ac.getBean("costMapper", CostMapper.class);
    }

    @Test
    public void t(){
        System.out.println(ac);
        System.out.println(mapper);
    }

    @Test
    public void t1(){
        List<Cost> costs = mapper.findAll();
        for(Cost cost : costs){
            System.out.println(cost);
        }
    }
}
