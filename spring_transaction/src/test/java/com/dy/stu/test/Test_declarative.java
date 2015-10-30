package com.dy.stu.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dy.stu.StudentDAO;
import com.dy.stu.StudentMarks;

public class Test_declarative {

	
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext_declarative.xml");
	
	// java.lang.ClassCastException: com.sun.proxy.$Proxy2 cannot be cast to
	// com.dy.stu.StudentJDBCTemplate
	//error?why?
//		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context
//				.getBean("studentJDBCTemplate");
	
	StudentDAO studentJDBCTemplate = context.getBean("studentJDBCTemplate",StudentDAO.class);
	
	@Test
	public void test01() {
		System.out.println("------Records creation--------");
		studentJDBCTemplate.create("Zara", 11, 99, 2010);
		studentJDBCTemplate.create("Nuha", 20, 97, 2010);
		studentJDBCTemplate.create("Ayan", 25, 100, 2011);
	}
	
	@Test
	public void test02() {
		System.out.println("------Listing all the records--------");
		List<StudentMarks> studentMarks = studentJDBCTemplate.listStudents();
		for (StudentMarks record : studentMarks) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.print(", Marks : " + record.getMarks());
			System.out.print(", Year : " + record.getYear());
			System.out.println(", Age : " + record.getAge());
		}
	}
	
		



}
