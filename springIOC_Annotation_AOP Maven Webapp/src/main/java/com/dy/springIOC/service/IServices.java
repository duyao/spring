package com.dy.springIOC.service;

import com.dy.springIOC.model.User;

public interface IServices {
	
	void add(User user);
	String delete(int id);
	User load(int id);

}
