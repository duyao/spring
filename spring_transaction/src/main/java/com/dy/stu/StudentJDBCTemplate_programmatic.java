package com.dy.stu;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class StudentJDBCTemplate_programmatic implements StudentDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private PlatformTransactionManager transactionManager;

	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);

	}

	public void setTransactionManager(
			PlatformTransactionManager platformTransactionManager) {
		this.transactionManager = platformTransactionManager;
	}

	@Override
	public void create(String name, Integer age, Integer marks, Integer year) {
		// TODO Auto-generated method stub

		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		//status can commit or rollback
		TransactionStatus status = this.transactionManager
				.getTransaction(transactionDefinition);

		try {
			String SQL1 = "insert into Student (name, age) values (?, ?)";
			jdbcTemplateObject.update(SQL1, name, age);

			// Get the latest student id to be used in Marks table
			String SQL2 = "select max(id) from Student";
			int sid = jdbcTemplateObject.queryForObject(SQL2, Integer.class);

			String SQL3 = "insert into Marks(sid, marks, year) "
					+ "values (?, ?, ?)";
			jdbcTemplateObject.update(SQL3, sid, marks, year);
			System.out.println("Created Name = " + name + ", Age = " + age);

			//success
			transactionManager.commit(status);

		} catch (DataAccessException e) {
			// TODO: handle exception
			System.out.println("Error in creating record, rolling back");
			
			//fail
			transactionManager.rollback(status);
			throw e;
		}

	}

	@Override
	public List<StudentMarks> listStudents() {
		String SQL = "select * from Student, Marks where Student.id=Marks.sid";

		List<StudentMarks> studentMarks = jdbcTemplateObject.query(SQL,
				new StudentMarksMapper());
		return studentMarks;
	}

}
