package com.dy.stu;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);

	}

	@Override
	public void create(String name, Integer age) {
		String SQL = "insert into Student (name, age) values (?, ?)";

		jdbcTemplateObject.update(SQL, name, age);
		System.out.println("Created Record Name = " + name + " Age = " + age);
		return;

	}

	@Override
	public Student getStudent(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "select id,name,age from student where id = ? ";
		//.queryForObject(String sql, Object[] args, RowMapper<Student> rowMapper)
		//Query given SQL to create a prepared statement from SQL and a list of arguments to bind to the query, mapping a single result row to a Java object via a RowMapper
		Student student = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new StudentMapper());
		return student;
	}

	@Override
	public List<Student> listStudents() {
		String SQL = "select * from student";

		List<Student> list = jdbcTemplateObject.query(SQL, new StudentMapper());

		return list;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "delete from Student where id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
		return;
	}

	@Override
	public void update(Integer id, Integer age) {
		// TODO Auto-generated method stub
		String SQL = "update Student set age = ? where id = ?";
		jdbcTemplateObject.update(SQL, age, id);
		System.out.println("Updated Record with ID = " + id);
		return;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

}
