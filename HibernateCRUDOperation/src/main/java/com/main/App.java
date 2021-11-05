package com.main;

import com.entity.Student;
import com.service.StudentService;

public class App {

	public static void main(String[] args) {
		/*Student ss = new Student();
		ss.setSid(5);
		ss.setName("Mahesh");
		ss.setAge(24);
		
		StudentService ser = new StudentService();
		String result = ser.storeStudentDao(ss);
		System.out.println(result);
		
		Student ss = new Student();
		ss.setSid(1);
		ss.setAge(25);
		StudentService ser = new StudentService();
		String res = ser.updatStudentInfo(ss);
		System.out.println(res);
		
		StudentService ser = new StudentService();
		String result = ser.deleteStudentInfo(1);
		System.out.println(result);
		
		StudentService ser = new StudentService();
		Student ss = ser.getStudentInfo(2);
		System.out.println(ss);*/
		
		StudentService ser = new StudentService() ;
		ser.getStudentInfo().forEach(s->System.out.println(s));
		
		
		}
		}




