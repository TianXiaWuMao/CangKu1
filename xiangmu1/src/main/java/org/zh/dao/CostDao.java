package org.zh.dao;

import java.util.List;

import org.zh.entity.Cost_info;

public interface CostDao {
	public List listAll();
	public int insert(Cost_info co);
	public List like(String name);
	public Cost_info findById(int id);
	public int delete(int id);
	public int update(Cost_info co);
	
}
