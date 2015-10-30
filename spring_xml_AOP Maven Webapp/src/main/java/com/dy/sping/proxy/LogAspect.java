package com.dy.sping.proxy;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("logAspect")
@Aspect//声明这是一个切面
public class LogAspect {
	
	
	
	
	public void logStart(){
		
		Logger.info("开始记录日志");
	}
	

	public void logEnd(){
		Logger.info("结束日志");
	}

	
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("around before");
		Object out = joinPoint.proceed();
		System.out.println("around after");
	
		return out;
	}
}
