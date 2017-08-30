package com.zh.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.zh.dao.UserDao;
import com.zh.entity.User;

public class UserDaoImpl implements UserDao {

	private SqlSessionFactory ssf;
	public SqlSessionFactory getSsf() {
		return ssf;
	}
	public void setSsf(SqlSessionFactory ssf) {
		this.ssf = ssf;
	}
	public User login(User us) {
		String sta="UserMapper.login";
		SqlSession se=ssf.openSession();
		User user=se.selectOne(sta, us);
		return user;
	}
	
	public List listAll() {
		String sta="UserMapper.listAll";
		SqlSession se=ssf.openSession();
		List list=se.selectList(sta);
		return list;
	}
	
	public List listLike(String name) {
		String sta="UserMapper.listLike";
		SqlSession se=ssf.openSession();
		List list=se.selectList(sta,name);
		return list;
	}
	
	public List chakan(int role_id) {
		String sta="UserMapper.chakan";
		SqlSession se=ssf.openSession();
		List list=se.selectList(sta, role_id);
		return list;
	}
	
	public int insert(User us) {
		String sta="UserMapper.insert";
		SqlSession se=ssf.openSession();
		int i=se.insert(sta,us);
		se.commit();
		se.close();
		return i;
	}
	
	public User findById(int user_id) {
		String sta="UserMapper.findById";
		SqlSession se=ssf.openSession();
		User user=se.selectOne(sta, user_id);
		return user;
	}
	public int update(User us) {
		String sta="UserMapper.update";
		SqlSession se=ssf.openSession();
		int i=se.update(sta,us);
		return i;
	}
	
	public int delete(int user_id) {
		String sta="UserMapper.delete";
		SqlSession se=ssf.openSession();
		int i=se.delete(sta,user_id);
		return i;
	}
	

}
