package com.dy.sping.proxy;

import java.util.Date;

public class Logger {
	public static void info(String string){
		System.out.println(new Date()+"--->"+string);
	}

}
