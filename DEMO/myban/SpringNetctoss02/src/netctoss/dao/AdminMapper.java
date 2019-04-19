package netctoss.dao;

import java.util.List;

import netctoss.annotation.MyBatisRepository;
import netctoss.entity.Admin;

/**
 * Admin���ӳ����
 * @author Administrator
 *
 */
@MyBatisRepository
public interface AdminMapper {
	
	List<Admin> findAll();
	Admin findByAdminCode(String adminCode);
}
