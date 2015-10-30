package com.dy.springIOC.dao;

import java.util.jar.Attributes.Name;

import org.springframework.stereotype.Repository;

import com.dy.springIOC.model.User;

@Repository("messageDao")
public class MessageDao implements IMessage {

	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("message add!");
		
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		System.out.println("mssage delete!!");
		return null;
	}

	@Override
	public User load() {
		// TODO Auto-generated method stub
		System.out.println("message load!!");
		return null;
	}

}
