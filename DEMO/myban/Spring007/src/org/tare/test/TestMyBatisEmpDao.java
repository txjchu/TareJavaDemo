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
 * ����MyBatisEmpDao�еķ���
 * @author Administrator
 *
 */
public class TestMyBatisEmpDao {

	//���Դ�������
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
	@Test						// argument ��֤�۾�����������Ҫ	illegal �Ƿ�Υ��� 	IllegalArgumentException	persistence ������ִ����
	public void testFindById(){	// collection �ɼ�����ļ�� 	contain ������������		statement ���� 	query database ��ѯ���ݿ�
		MyBatisEmpDao dao = new MyBatisEmpDao();
		Emp emp = dao.findById(3731);
		System.out.println(emp);
	}
	@Test
	public void testSave(){
		MyBatisEmpDao dao = new MyBatisEmpDao();
		Emp emp = new Emp();
		emp.setEname("ɳ����");
		emp.setJob("���˹�");
		emp.setSal(5566.66);
		emp.setComm(55.66);
		emp.setHiredate(new Date(System.currentTimeMillis()));//��ȡϵͳ��ǰ�¼�
		emp.setMgr(3724);
		emp.setDeptno(10);
		dao.save(emp);
	}
	@Test
	public void update(){
		MyBatisEmpDao dao = new MyBatisEmpDao();
		Emp emp = dao.findById(3727);
		emp.setEname("��˽�");
		emp.setJob("���ĵ�");
		emp.setSal(5555.0);
//		//���쳣ClassCastException������ת���쳣��java.util.Date������ǿתΪjava.sql.Date		
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
			System.out.println(map);//����Map�е�key�ֶ���ȫ���Ǵ�д���ַ�����
			System.out.println(map.get("EMPNO") +","+ map.get("ENAME") +","+ map.get("JOB") +","+ map.get("MGR"));
		}
	}
	
	//����ʹ��Mapperӳ����	�˴��ӿ���ӦΪEmpMapper�����Գ��Ըĳ�EmpDAO
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
		emp.setEname("֩�뾫");
		emp.setJob("ץ��");
		emp.setSal(1234.0);
		emp.setComm(1234.0);
		emp.setMgr(1);
		emp.setDeptno(10);
		emp.setHiredate(new Date(System.currentTimeMillis()));
		int i = dao.save(emp);
		System.out.println("������"+ i +"������.");
		session.commit();
		session.close();
	}
	//����DeptMapperʹ�õ�ResultMapӳ��
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
