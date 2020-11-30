package test;

import dao.CostDAOImpl;
import entity.Cost;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author: Peter
 * @date: 2020/10/3 22:59
 */
public class TestCostDAO {

    CostDAOImpl dao = null;
    @Before
    public void before(){
        dao = new CostDAOImpl();
    }

    @Test
    public void testFindAll(){
        List<Cost> costs = null;
        try {
            costs = dao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(costs);
    }

    @Test
    public void testFindById(){
        Cost cost = dao.findById(1);
        System.out.println(cost);
    }

    @Test
    public void testSave(){
        Cost cost = new Cost();
        cost.setName("测试cost");
        cost.setBaseDuration(111);
        cost.setBaseCost(123.0);
        cost.setUnitCost(123.0);
        cost.setDescr("测试数据");
        cost.setCostType("2");
        dao.save(cost);

        Cost c = dao.findByName("测试cost");
        if(c != null){
            System.out.println(this.getClass().getName() +":"+ c.toString());
        }
    }

    @Test
    public void testUpdate(){
        Cost cost = dao.findById(7);
        cost.setDescr("测试数据测试数据");
        dao.update(cost);
        System.out.println(this.getClass().getName() +":"+ dao.findById(7));
    }

    @Test
    public void testDelete(){
        dao.delete(7);
        System.out.println(this.getClass().getName() +":"+ (dao.findById(7) == null ? "null" : dao.findById(7)));
    }

}
