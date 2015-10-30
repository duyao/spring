package com.dy.springIOC.service;

import com.dy.springIOC.dao.IDao;
import com.dy.springIOC.model.User;

/**
 * @author dy
 * services使用dao提供的方法
 *
 */
public class Services implements IServices {

	private IDao iDao;

	
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		iDao.add(user);
		

	}

	@Override
	public String delete(int id) {
		iDao.delete(id);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User load(int id) {
		// TODO Auto-generated method stub
		iDao.load(id);
		return null;
	}

	public IDao getiDao() {
		return iDao;
	}

	public void setiDao(IDao iDao) {
		this.iDao = iDao;
	}

}
