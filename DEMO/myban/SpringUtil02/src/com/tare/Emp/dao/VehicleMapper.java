package com.tare.Emp.dao;

import java.util.List;

import com.tare.Emp.annotation.MyBatisRepository;
import com.tare.Emp.entity.Vehicle;

/**
 * ͨ��VehicleMapperӳ��������t_car���ݱ��DAO
 * @author Administrator
 *
 */
@MyBatisRepository
public interface VehicleMapper {
	
	List<Vehicle> findAll();
}
