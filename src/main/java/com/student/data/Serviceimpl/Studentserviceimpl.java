package com.student.data.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.data.Dao.Studentdao;
import com.student.data.Service.Studentservice;
import com.student.data.model.Studentmod;

@Component
public class Studentserviceimpl implements Studentservice {

	@Autowired
	Studentdao Studentdaoimpl;

	@Override
	public List<Studentmod> getAllStudents() {
		List<Studentmod> stuList = Studentdaoimpl.getAllStudent();
		return stuList;
	}

	@Override
	public Studentmod getStudentBasedOnId(int id) {
		List<Studentmod> stuList = Studentdaoimpl.getAllStudent();
		Studentmod st = stuList.stream().filter(stu->stu.getId()==id).findAny().get();
		return st;
	}

	@Override
	public String insertStudentData(Studentmod stu) {
		return Studentdaoimpl.insertStudent(stu);
	}
	@Override
	public String deleteStudentData(Studentmod s) {
		return Studentdaoimpl.deleteStudent(s);
	}

	@Override
	public Studentmod getStudentBasedOnName(Studentmod s) {
		
		List<Studentmod> stuList = Studentdaoimpl.getAllStudent();
		Studentmod st = stuList.stream().filter(stu->stu.getFirstname().equals(s.getFirstname())).findAny().get();
		return st;
		
		
		
	}
}




