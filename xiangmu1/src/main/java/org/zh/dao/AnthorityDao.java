package org.zh.dao;

import java.util.List;

import org.zh.entity.Role_info;
import org.zh.entity.Role_menu_info;

public interface AnthorityDao {
	public List listAll();
	public List like(String name);
	public List findById(int id);
	public List findAll();
	public int delete(int menu_id);
	public int update(Role_menu_info rmi);
	//用于修改权限界面上的角色
	public Role_info touXX(int id);
}
