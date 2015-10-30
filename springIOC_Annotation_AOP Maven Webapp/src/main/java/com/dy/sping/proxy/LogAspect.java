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
	
	//声明@Pointcut后，后面的advice都可以使用，不用重复写
	//@Pointcut返回值为void，且函数为空
	@Pointcut("execution(* com.dy.springIOC.dao.*.add*(..))"
				+"||execution(* com.dy.springIOC.dao.*.delete*(..))"
				+"||execution(* com.dy.springIOC.dao.*.load*(..))")
	public void selectAll(){}//signature
	
	
	@Before("selectAll()")
//	@Before("execution(* com.dy.springIOC.dao.*.add*(..))"
//			+"||execution(* com.dy.springIOC.dao.*.delete*(..))"
//			+"||execution(* com.dy.springIOC.dao.*.load*(..))")
	public void logStart(){
		
		Logger.info("开始记录日志");
	}
	
//	@After("execution(* com.dy.springIOC.dao.*.add*(..))"
//			+"||execution(* com.dy.springIOC.dao.*.delete*(..))"
//			+"||execution(* com.dy.springIOC.dao.*.load*(..))")
	@After("selectAll()")
	public void logEnd(){
		Logger.info("结束日志");
	}

	/**
	 * 传入参数必须是ProceedingJoinPoint，返回值必须是Object
	 * 执行proceed方法得到返回的对象
	 * @throws Throwable 
	 */
	@Around("selectAll()")
//	public void aroundLog(){
//		Logger.info("around Log");
//	}
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("around before");
		Object out = joinPoint.proceed();
		System.out.println("around after");
	
		return out;
	}
}
