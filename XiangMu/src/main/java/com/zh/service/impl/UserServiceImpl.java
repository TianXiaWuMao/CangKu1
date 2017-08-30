package com.zh.service.impl;

import java.util.List;

import com.zh.dao.UserDao;
import com.zh.entity.User;
import com.zh.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao udao;
	public UserDao getUdao() {
		return udao;
	}
	public void setUdao(UserDao udao) {
		this.udao = udao;
	}
	public User login(User us) {
		
		return udao.login(us);
	}
	
	public List listAll() {
		
		return udao.listAll();
	}
	public List listLike(String name) {
		
		return udao.listLike(name);
	}
	
	public List chakan(int user_id) {
		
		return udao.chakan(user_id);
	}
	
	public int insert(User us) {
		
		return udao.insert(us);
	}
	
	public int update(User us) {
		return udao.update(us);
	}
	
	public User findById(int user_id) {
		
		return udao.findById(user_id);
	}
	
	public int delete(int user_id) {
		
		return udao.delete(user_id);
	}

}
