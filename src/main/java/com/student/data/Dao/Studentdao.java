package com.student.data.Dao;

import java.util.List;

import com.student.data.model.Studentmod;

public interface Studentdao {

	public abstract List<Studentmod> getAllStudent();

	public abstract String insertStudent(Studentmod stu);

	public abstract String deleteStudent(Studentmod s);
	
	

}



