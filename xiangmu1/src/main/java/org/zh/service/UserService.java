package org.zh.service;

import java.util.List;

import org.zh.entity.User;

public interface UserService {
	public User login(User us);
	public List listAll(User us);
	public List chakan(int user_id);
	public List listLike(User us);
	public int insert(User us);
	public int update(User us);
	public User findById(int user_id);
	public int delete(int user_id);
	public List findByName();
	public int jiashan(int ids);
	public int count();
	public int countCX(String user_name);
}	
