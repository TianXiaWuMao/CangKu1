package org.zh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zh.dao.Role_infoDao;
import org.zh.entity.Role_info;
import org.zh.service.Role_infoService;

@Service
@Transactional
public class Role_infoServiceImpl implements Role_infoService {
	
	@Autowired
	private Role_infoDao rdao;
	
	public Role_infoDao getRdao() {
		return rdao;
	}

	public void setRdao(Role_infoDao rdao) {
		this.rdao = rdao;
	}

	public int insert(Role_info ri) {
		
		return rdao.insert(ri);
	}

	
	public int delete(int role_id) {
		
		return rdao.delete(role_id);
	}

	
	public List findAll() {
		
		return rdao.findAll();
	}

	
	public Role_info findById(int role_id) {
		
		return rdao.findById(role_id);
	}

	
	public int update(Role_info ri) {
		
		return rdao.update(ri);
	}

	
	public List like(String role_name) {
		
		return rdao.like(role_name);
	}

	
	public int jiashan(Role_info ri) {
		
		return rdao.jiashan(ri);
	}

	

}
