package org.zh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zh.dao.AnthorityDao;
import org.zh.entity.Role_info;
import org.zh.entity.Role_menu_info;
import org.zh.entity.Salary;
import org.zh.service.AnthorityService;

@Service
@Transactional
public class AnthorityServiceImpl implements AnthorityService {

@Autowired
private AnthorityDao ad;
	public List listAll() {
		
		return ad.listAll();
	}

	
	public List like(String name) {
		
		return ad.like(name);
	}
	public List findById(int id) {
		
		return ad.findById(id);
	}


	
	public List findAll() {
		return ad.findAll();
	}

	public int delete(int menu_id) {
		
		return ad.delete(menu_id);
	}

	public int update(Role_menu_info rmi) {
		
		return ad.update(rmi);
	}


	
	public Role_info touXX(int id) {
	
		return ad.touXX(id);
	}
	
	

}
