package org.zh.service;

import java.util.List;

import org.zh.entity.Role_info;
import org.zh.entity.Role_menu_info;


public interface AnthorityService {
	public List listAll();
	public List like(String name);
	public List findById(int id);
	public List findAll();
	public int delete(int menu_id);
	public int update(Role_menu_info rmi);
	public Role_info touXX(int id);
}
