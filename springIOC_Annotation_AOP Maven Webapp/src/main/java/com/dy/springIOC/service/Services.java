package com.dy.springIOC.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dy.springIOC.dao.IDao;
import com.dy.springIOC.model.User;

/**
 * @author dy
 * services使用dao提供的方法
 *
 */
@Service("userServices")
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

	@Resource(name = "userDao")
	public void setiDao(IDao iDao) {
		this.iDao = iDao;
	}

}
