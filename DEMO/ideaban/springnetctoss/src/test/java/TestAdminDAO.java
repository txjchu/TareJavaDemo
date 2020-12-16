import com.pc.netctoss.dao.IAdminInfoDAO;
import com.pc.netctoss.dao.ICostDAO;
import com.pc.netctoss.entity.AdminInfo;
import com.pc.netctoss.entity.Cost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * 笔记
 * 测试 AdminDAO
 * 测试 JDBC
 * @author: Peter
 * @date: 2020/12/10 2:13
 */
@RunWith(SpringJUnit4ClassRunner.class)//表示整合JUnit4进行测试 WEB-INF/applicationContext.xml
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
@WebAppConfiguration    //声明以 web 形式进行测试
public class TestAdminDAO {

    @Autowired
    IAdminInfoDAO dao ;

    @Resource(name = "jdbcCostDAOImpl")
    ICostDAO costDAO;

    @Test
    public void test1(){

        try {
            AdminInfo adminInfo = dao.findByCode("admin");
            System.out.println(adminInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2() throws SQLException {
        // 该方法会异常，新new 出来的AdminInfoDAOImpl 对象中的 DataSource 对象因为 dao 对象不是容器创建的，因此没有被自动注入。
//        IAdminInfoDAO dao = new AdminInfoDAOImpl();   // 异常
        AdminInfo a = dao.findByCode("admin");
        System.out.println(a);
    }

    @Test
    public void test3(){
        List<Cost> costs = costDAO.findAll();
        for(Cost cost : costs){
            System.out.println(cost.toString());
        }
    }
}
