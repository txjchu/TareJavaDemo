package com.tare.Emp.dao;

import java.util.List;

import com.tare.Emp.annotation.MyBatisRepository;
import com.tare.Emp.entity.Vehicle;

/**
 * 通过VehicleMapper映射器操作t_car数据表的DAO
 * @author Administrator
 *
 */
@MyBatisRepository
public interface VehicleMapper {
	
	List<Vehicle> findAll();
}
