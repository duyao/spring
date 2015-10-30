package com.dy.springIOC.dao;

import com.dy.springIOC.model.User;

public interface IUser {
	 
	void add(User user);
	String delete(int id);
	User load(int id);
	

}
