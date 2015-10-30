package com.dy.springIOC.action;


import java.util.List;

import com.dy.springIOC.model.User;
import com.dy.springIOC.service.IServices;

/**
 * @author dy
 * action使用services提供的方法
 */
public class UserAction {
	//这些属性都是从jsp页面传过来的
	
	public UserAction() {
		// TODO Auto-generated constructor stub
	}
	private IServices services;
	private User user;
	private int id;
	
	private List<String> nameList;
	
	public void add(){
		System.out.println(nameList);
		services.add(user);
	}
	public String delete(){
		services.delete(id);
		return null;
	}
	public User load(){
		services.load(id);
		return null;
		
	}
	public IServices getServices() {
		return services;
	}
	public void setServices(IServices services) {
		this.services = services;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<String> getNameList() {
		return nameList;
	}
	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	
}
