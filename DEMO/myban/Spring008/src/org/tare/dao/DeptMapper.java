package org.tare.dao;

import java.util.List;

import org.tare.annotation.MyBatisRepository;
import org.tare.entity.Dept;

/**
 * Dept���Mapperӳ�����ӿ�
 * @author Administrator
 *
 */
/*
 * ʹ���Զ���ע�⣬���и�ע��Ľӿں���bean�Ķ����������annotationClassָ����
 * MapperScannerConfigurer��ֻע��ʹ���˸�ע���ǵĽӿڡ�
 */
@MyBatisRepository		
public interface DeptMapper {
	
	List<Dept> findAll();				//��ѯ���в�����Ϣ
	Dept findById(Integer deptno);		//���ݲ��ű�Ų��Ҳ���
	int save(Dept dept);				//��Ӳ���
	int update(Dept dept);				//�޸Ĳ���
	void delete(Integer deptno);		//���ݲ��ź�ɾ������
}
