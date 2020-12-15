import com.pc.dao.IDeptMapper;
import com.pc.entity.Dept;
import com.pc.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author: Peter
 * @date: 2020/12/16 5:20
 */
public class TestDeptMapper {

    SqlSession session;
    IDeptMapper mapper;

    @Before
    public void before(){
        session = MyBatisUtil.getSession();
        /**
         * 笔记
         * 通过 session 获取单独的 mapper.
         * 当只有1个 mapper 时，可以直接使用 session.select("")等方法。但是当注册有多个 mapper 时，则每次必须获取指定 mapper,
         * 否则当调用多个 mapper 都具有的同名 sql 时，则会报异常：IllegalArgumentException: findAll is ambiguous in Mapped Statements collection (try using the full name including the namespace, or rename one of the entries)
         *
         */

        mapper = session.getMapper(IDeptMapper.class);      //
    }

    @After
    public void after(){
        session.close();
    }

    @Test
    public void t1(){
        List<Dept> depts = mapper.findAll();
        for(Dept dept : depts){
            System.out.println(dept);
        }
    }

    @Test
    public void t2(){
        Dept dept = mapper.findById(10);
        System.out.println(dept);
    }
}
