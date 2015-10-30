package com.dy.stu;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMarksMapper implements RowMapper<StudentMarks> {

	@Override
	public StudentMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		StudentMarks sMarks = new StudentMarks();
		sMarks.setAge(rs.getInt("age"));
		sMarks.setName(rs.getString("name"));
		sMarks.setId(rs.getInt("id"));
		sMarks.setMarks(rs.getInt("marks"));
		sMarks.setYear(rs.getInt("year"));
		sMarks.setSid(rs.getInt("sid"));
		return sMarks;
	}

}
