package org.zh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zh.dao.MenuDao;
import org.zh.entity.Menu_info;
import org.zh.service.MenuService;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao mdo;
	public int update(Menu_info mo) {
		
		return mdo.update(mo);
	}

	
	public int delete(int menu_id) {
		
		return mdo.delete(menu_id);
	}

	
	public int insert(Menu_info mo) {
		
		return mdo.insert(mo);
	}

	
	public Menu_info findByIdU(int menu_id) {
		
		return mdo.findByIdU(menu_id);
	}


	
	public List list() {
		
		return mdo.list();
	}


	
	public List findName() {
		
		return mdo.findName();
	}
	
}
