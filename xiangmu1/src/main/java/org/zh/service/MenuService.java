package org.zh.service;

import java.util.List;

import org.zh.entity.Menu_info;

public interface MenuService {
	public List list();
	public int update(Menu_info mo);
	public int delete(int menu_id);
	public int insert(Menu_info mo);
	public Menu_info findByIdU(int menu_id);
	public List findName();
}
