package com.dy.springIOC.test;


import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dy.springIOC.action.UserAction;
import com.dy.springIOC.model.User;


public class TestSpring {
	

	//private BeanFactory factory = new ClassPathXmlApplicationContext("bean.xml");
	
	@Test
	public void test01(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		//UserAction userAction = factory.getBean("userAction", UserAction.class);
		UserAction userAction = context.getBean("userAction",UserAction.class);
		User user1 = new User("amy", "123");
		userAction.setUser(user1);
		userAction.add();
	
		//如果action不设置成为多例，那么多个action都添加的是相同的值
		//UserAction userAction2 = factory.getBean("userAction",UserAction.class);
		UserAction userAction2 = context.getBean("userAction",UserAction.class);
		User user2 = new User("456", "Lily");
		//userAction2.setUser(user2);
		userAction2.add();
		
		//context.close();
	
	}

}
