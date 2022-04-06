package com.student.data.Daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.student.data.Dao.Studentdao;
import com.student.data.model.Studentmod;

@Component
public class Studentdaoimpl implements Studentdao {

	@Autowired
	JdbcTemplate template;

	@Override
	public List<Studentmod> getAllStudent() {
		List<Studentmod>  stuDataList = template.query("select * from dblearning.stud", new ResultSetExtractor<List<Studentmod>>() {

			List<Studentmod> stuList = new ArrayList<>();

			@Override
			public List<Studentmod> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Studentmod s = new Studentmod();
					s.setId(rs.getInt("id"));
					s.setFirstname(rs.getString("fname"));
					s.setLastname(rs.getString("lname"));
					s.setAddress(rs.getString("address"));
					stuList.add(s);
				}
				return stuList;
			}
		});

		return stuDataList;
	}

	@Override
	public String insertStudent(Studentmod stu) {

		String status = "Data inserted failed";

		String sql = "insert into dblearning.stud(id, fname,lname,address)"
				+ " values("+stu.getId()+",'"+stu.getFirstname() +"','"+stu.getLastname()+"','"+stu.getAddress()+"')";

		try {
			template.execute(sql);
			status = "Data inserted successfully";
		}catch(Exception e) {
			System.out.println(e);
		}

		return status;
	}

	@Override
	public String deleteStudent(Studentmod s) {
		
		
		String status = "Data deleted failed";

		String sql = "delete from dblearning.stud where id = " +s.getId();

		try {
			template.execute(sql);
			status = "Data deleted successfully";
		}catch(Exception e) {
			System.out.println(e);
		}

		return status;
	}

	
	}





	
