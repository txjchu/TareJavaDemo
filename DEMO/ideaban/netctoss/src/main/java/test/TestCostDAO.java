package test;

import dao.CostDAO;
import entity.Cost;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: Peter
 * @date: 2020/10/3 22:59
 */
public class TestCostDAO {

    CostDAO dao = null;
    @Before
    public void before(){
        dao = new CostDAO();
    }

    @Test
    public void testFindAll(){
        List<Cost> costs = null;
        try {
            costs = dao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(costs);
    }

}
