package com.zh.service;

import java.util.List;

import com.zh.entity.User;

public interface UserService {
	public User login(User us);
	public List listAll();
	public List listLike(String name);
	public List chakan(int user_id);
	public int insert(User us);
	public int update(User us);
	public User findById(int user_id);
	public int delete(int user_id);
}
