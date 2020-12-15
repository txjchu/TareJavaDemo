import com.pc.dao.IEmpMapper;
import com.pc.entity.Emp;
import com.pc.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * 测试 IEmpMapper
 * 需要注意 EmpMapper.xml 中的 namespace 的修改
 * @author: Peter
 * @date: 2020/12/16 5:06
 */
public class TestIEmpMapper {

    SqlSession session;
    IEmpMapper mapper;
    @Before
    public void before(){
        session = MyBatisUtil.getSession();
        mapper = session.getMapper(IEmpMapper.class);
    }

    @After
    public void after(){
        session.close();
    }

    @Test
    public void t1(){
//        SqlSession session = MyBatisUtil.getSession();
        List<Emp> emps = mapper.findAll();
        for(Emp e : emps){
            System.out.println(e);
        }
//        session.close();
    }

    @Test
    public void t2(){
//        Emp emp = session.selectOne("findByName", "李四");
        List<Emp> emps = mapper.findByName("李四");
        System.out.println("----------共查到 "+ emps.size() +" 条记录----------");
        for(Emp emp : emps){
            System.out.println(emp);
        }
    }
}
