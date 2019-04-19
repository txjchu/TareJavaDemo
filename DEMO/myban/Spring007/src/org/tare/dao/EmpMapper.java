package org.tare.dao;

import java.util.List;

import org.tare.entity.Emp;

/**
 * EmpDAO�ӿڣ������˲������ݿ�ķ���
 * 
 * MyBatisʵ��SQL����CRUD�����ĵڶ��ַ�ʽ��ʹ��Mapperӳ������
 * ����ֱ��ʹ��SqlSession����XML�����ļ��е�SQL��䣬�����CRUD������
 * ���ǣ�����Mapperӳ��������XML�е�<mapper>Ԫ��ָ��namespace=""��ӳ�����ӿڵ�ȫ����
 * ��ӳ�����ӿ��оͿ��Զ���CRUD��������ʵ�ʲ�����ͨ��SqlSession.getMapper(xxxMapper.class)��ȡ
 * ����ӳ�������󣬾Ϳ��Ե���ӳ���������еķ��������ö�Ӧ��SQL��䣬���CRUD������
 * 
 * @author Administrator
 *
 */

public interface EmpMapper {
	
	public List<Emp> findAll();
	public Emp findById(int empno);
	public int save(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
}	
