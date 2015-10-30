package com.dy.springIOC.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dy.springIOC.dao.IUser;
import com.dy.springIOC.dao.IMessage;
import com.dy.springIOC.model.User;

/**
 * @author dy
 * services使用dao提供的方法
 *
 */
@Service("userServices")
public class Services implements IServices {

	private IUser iDao;
	private IMessage iMessage;

	
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		iDao.add(user);
		iMessage.add();

	}

	@Override
	public String delete(int id) {
		iDao.delete(id);
		iMessage.delete();
		return null;
	}

	@Override
	public User load(int id) {
		// TODO Auto-generated method stub
		iDao.load(id);
		iMessage.load();
		return null;
	}

	public IUser getiDao() {
		return iDao;
	}

	@Resource(name = "userDao")
	public void setiDao(IUser iDao) {
		this.iDao = iDao;
	}

	public IMessage getiMessage() {
		return iMessage;
	}

	@Resource(name = "messageDao")
	public void setiMessage(IMessage iMessage) {
		this.iMessage = iMessage;
	}

}
