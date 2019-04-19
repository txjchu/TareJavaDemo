package org.tare.test;

import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.tare.dao.DeptMapper;
import org.tare.dao.EmpMapper;
import org.tare.dao.MyBatisEmpDao;
import org.tare.entity.Dept;
import org.tare.entity.Emp;
import org.tare.util.MyBatisUtil;

/**
 * 测试MyBatisEmpDao中的方法
 * @author Administrator
 *
 */
public class TestMyBatisEmpDao {

	//测试创建连接
	@Test
	public void test(){
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		String conf = "SqlMapConfig.xml";
		InputStream is = TestCase.class.getClassLoader().getResourceAsStream(conf);
		SqlSessionFactory sf = sfb.build(is);
		SqlSession session = sf.openSession();
		System.out.println(session);
		session.close();
	}
	
	@Test
	public void testFindAll(){
		MyBatisEmpDao dao = new MyBatisEmpDao();
		List<Emp> emps = dao.findAll();
		for(Emp emp : emps){
			System.out.println(emp);
		}
	}							
								// ambiguous
	@Test						// argument 论证论据争吵内容提要	illegal 非法违规的 	IllegalArgumentException	persistence 持续固执存留
	public void testFindById(){	// collection 采集征收募捐 	contain 包含控制容纳		statement 声明 	query database 查询数据库
		MyBatisEmpDao dao = new MyBatisEmpDao();
		Emp emp = dao.findById(3731);
		System.out.println(emp);
	}
	@Test
	public void testSave(){
		MyBatisEmpDao dao = new MyBatisEmpDao();
		Emp emp = new Emp();
		emp.setEname("沙和尚");
		emp.setJob("搬运工");
		emp.setSal(5566.66);
		emp.setComm(55.66);
		emp.setHiredate(new Date(System.currentTimeMillis()));//获取系统当前事件
		emp.setMgr(3724);
		emp.setDeptno(10);
		dao.save(emp);
	}
	@Test
	public void update(){
		MyBatisEmpDao dao = new MyBatisEmpDao();
		Emp emp = dao.findById(3727);
		emp.setEname("猪八戒");
		emp.setJob("陪聊的");
		emp.setSal(5555.0);
//		//出异常ClassCastException，类型转换异常，java.util.Date不可以强转为java.sql.Date		
//		try {
//			emp.setHiredate((Date) new SimpleDateFormat("yyyy-MM-dd").parse("2011-11-11"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		dao.update(emp);
		System.out.println(dao.findById(emp.getEmpno()));
	}
	@Test
	public void testDelete(){
		MyBatisEmpDao dao = new MyBatisEmpDao();
		Emp emp = dao.findById(3733);
		System.out.println(emp);
		dao.delete(emp.getEmpno());
		System.out.println(dao.findById(emp.getEmpno()));
	}
	@Test
	public void testFindByDeptno(){
		MyBatisEmpDao dao = new MyBatisEmpDao();
		List<Map<String, Object>> list = dao.findByDeptno(10);
		for(Map<String, Object> map : list){
			System.out.println(map);//放入Map中的key字段名全部是大写的字符串。
			System.out.println(map.get("EMPNO") +","+ map.get("ENAME") +","+ map.get("JOB") +","+ map.get("MGR"));
		}
	}
	
	//测试使用Mapper映射器	此处接口名应为EmpMapper，可以尝试改成EmpDAO
	@Test
	public void testFindAll2(){
		SqlSession session = MyBatisUtil.getSession();
		EmpMapper dao = session.getMapper(EmpMapper.class);
		List<Emp> emps = dao.findAll();
		for(Emp emp : emps){
			System.out.println(emp);
		}
	}
	@Test
	public void testSave2(){
		SqlSession session = MyBatisUtil.getSession();
		EmpMapper dao = session.getMapper(EmpMapper.class);
		Emp emp = new Emp();
		emp.setEname("蜘蛛精");
		emp.setJob("抓人");
		emp.setSal(1234.0);
		emp.setComm(1234.0);
		emp.setMgr(1);
		emp.setDeptno(10);
		emp.setHiredate(new Date(System.currentTimeMillis()));
		int i = dao.save(emp);
		System.out.println("插入了"+ i +"条数据.");
		session.commit();
		session.close();
	}
	//测试DeptMapper使用的ResultMap映射
	@Test
	public void testFindAll3(){
		SqlSession session = MyBatisUtil.getSession();
		DeptMapper dao = session.getMapper(DeptMapper.class);
		List<Dept> depts = dao.findAll();
		for(Dept d : depts){
			System.out.println(d);
		}
	}
	@Test
	public void testFindById2(){
		SqlSession session = MyBatisUtil.getSession();
		DeptMapper dao = session.getMapper(DeptMapper.class);
		Dept dept = dao.findById(15);
		System.out.println(dept);
	}
}
