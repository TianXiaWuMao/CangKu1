package org.zh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zh.dao.Role_infoDao;
import org.zh.dao.UserDao;
import org.zh.entity.User;
import org.zh.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao user;
	
	public UserDao getUser() {
		return user;
	}

	public void setUser(UserDao user) {
		this.user = user;
	}

	public User login(User us) {
		return user.login(us);
	}

	public List listAll(User us) {

		return user.listAll(us);
	}

	public List chakan(int user_id) {

		return user.chakan(user_id);
	}

	public int insert(User us) {

		return user.insert(us);
	}

	public int update(User us) {

		return user.update(us);
	}

	public User findById(int user_id) {

		return user.findById(user_id);
	}

	public int delete(int user_id) {

		return user.delete(user_id);
	}

	public List findByName() {

		return user.findByName();
	}

	
	public int jiashan(int id) {
		
		return user.jiashan(id);
	}

	
	public int count() {
		
		return user.count();
	}

	
	public List listLike(User us) {
		
		return user.listLike(us);
	}

	
	public int countCX(String user_name) {
		
		return user.countCX(user_name);
	}

}
