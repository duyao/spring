package com.dy.sping.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author dy
 * 动态代理的实现
 */
//1.写一个类实现InvocationHandler
public class LogProxy implements InvocationHandler{
	
	

	//2.创建一个代理对象
	private Object target;
	//3.创建一个方法生成代理对象
	//传入的参数o是将要被代理的对象，返回生成的代理对象
	public static Object getInstanceObject(Object o) {
		//3.1创建代理对象
		LogProxy logProxy = new LogProxy();
		//3.2设置代理对象
		logProxy.target = o;
		//3.3通过Proxy设置代理对象
		Object result = Proxy.newProxyInstance(o.getClass().getClassLoader(), 
				o.getClass().getInterfaces(), logProxy);
		return result;
		
	}
	/*
	 * 只要有了代理对象后，不管代理对象执行什么方法，都会使用invoke方法
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws Throwable {
		// TODO Auto-generated method stub
		Logger.info("进行了相应的操作");
		//obj - the object the underlying method is invoked from
		//使用 invoke 的对象
		//args- the arguments used for the method call
		Object object = method.invoke(target, args);
		return object;
	}

}
