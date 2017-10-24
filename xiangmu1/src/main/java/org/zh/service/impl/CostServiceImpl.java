package org.zh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zh.dao.CostDao;
import org.zh.entity.Cost_info;
import org.zh.service.CostService;

@Service
@Transactional
public class CostServiceImpl implements CostService {
	@Autowired
	private CostDao cdo;
	public List listAll() {
		
		return cdo.listAll();
	}

	
	public List like(String name) {
		
		return cdo.like(name);
	}

	public int delete(int id) {
		
		return cdo.delete(id);
	}

	
	public int update(Cost_info co) {
		
		return cdo.update(co);
	}



	public int insert(Cost_info co) {
		
		return cdo.insert(co);
	}


	
	public Cost_info findById(int id) {
		
		return cdo.findById(id);
	}

}
