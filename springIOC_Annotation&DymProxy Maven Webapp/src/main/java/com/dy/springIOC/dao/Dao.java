package com.dy.springIOC.dao;


import org.springframework.stereotype.Repository;

import com.dy.springIOC.model.User;

/**
 * @author dy
 * dao中是数据库的方法
 */
@Repository("userDao")
public class Dao implements IDao {

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		System.out.println("add "+ user);

	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		System.out.println("delete "+ id);
		return null;
	}

	@Override
	public User load(int id) {
		// TODO Auto-generated method stub
		System.out.println("load "+ id);
		return null;
	}

}
