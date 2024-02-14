package com.controller;

import com.services.ServiceImpl;
import com.services.Services;

public class HomeController {
	
	public static void main(String[] args) {
		
		Services s=new ServiceImpl();
		
//		s.addTeacherWithMulipleStudents();
		
		//s.deleteTeacherWithAllStudent();
		
//		while(true) {}
		
	//s.deleteAllStudentOnlyOfTeacher();
		
	//	s.deleteParticularStudentUsingTid();
		
		s.deleteTeacherUsingSid();
		
		
	}

}
