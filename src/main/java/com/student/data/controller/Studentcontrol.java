package com.student.data.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.data.Service.Studentservice;
import com.student.data.model.Studentmod;


@RestController
public class Studentcontrol {
	
	@Value("${server.port}")
	String serverport;

	@Autowired
	Studentservice Studentserviceimpl;

	@RequestMapping(value="/getstudentdata" , method = RequestMethod.GET)
	public List<Studentmod> getEmployee() {
		System.out.println("=============Working from ServerPort========= :: " + serverport);
		List<Studentmod> stuList = Studentserviceimpl.getAllStudents();
		return stuList;
	}
	

	
	@RequestMapping(value="/getStudentbasedonid" , method = RequestMethod.POST)
	public Studentmod getStudentBasedOnId(@RequestParam("id") int id) {
		Studentmod s1 = Studentserviceimpl. getStudentBasedOnId(id);
		return s1;
	}

	@RequestMapping(value = "/getStudentbasedonname" , method = RequestMethod.POST ,
			consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public Studentmod getStudentBasedOnName(@RequestBody Studentmod su) {
		
		Studentmod s1 = Studentserviceimpl. getStudentBasedOnName(su);
		return s1;

	}

	@RequestMapping(value="/insertStudent",method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String putStudentData(@RequestBody Studentmod s) {

		if(s.getId()==0) {
			throw new IllegalArgumentException("Employee Id is Invalid");
		}

		String status = Studentserviceimpl.insertStudentData(s);

		return status;

	}

	@RequestMapping(value="/deleteStudent" , method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteById(@RequestBody Studentmod s) {

		if(s.getId()==0) {
			throw new IllegalArgumentException("Employee Id is Invalid");
		}

		String status = Studentserviceimpl.deleteStudentData(s);

		return status;

	}

}










