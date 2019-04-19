package org.tarena.dao;

import java.util.List;

import org.tarena.entity.Cost;
/**
 * 对应映射的Dao接口。实体类搭建好后做此步骤
 * @author Administrator
 *
 */
public interface CostDao {
	public List<Cost> findAll();
}
