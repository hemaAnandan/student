package com.student.data.Service;

import java.util.List;

import com.student.data.model.Studentmod;

public interface Studentservice {

	public abstract List<Studentmod> getAllStudents();

	public abstract Studentmod getStudentBasedOnId(int id);

	public abstract String insertStudentData(Studentmod stu);
	
	public abstract String deleteStudentData(Studentmod s);
	
	public abstract Studentmod getStudentBasedOnName(Studentmod su);

	

	
}
