package org.zh.service;

import java.util.List;

import org.zh.entity.Role_info;

public interface Role_infoService {
	public int insert(Role_info ri);
	public int delete(int role_id);
	public List findAll();
	public Role_info findById(int role_id);
	public int update(Role_info ri);
	public List like(String role_name);
	public int jiashan(Role_info ri);
}
