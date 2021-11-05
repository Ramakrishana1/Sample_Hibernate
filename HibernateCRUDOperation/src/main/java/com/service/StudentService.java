package com.service;

import java.util.List;

import com.dao.StudentDao;
import com.entity.Student;

public class StudentService {
	StudentDao studentDao = new StudentDao();
	
	public String storeStudentDao(Student student) {
		if (studentDao.storeStudentInfo(student)) {
			return "Record Stored Successfully";
		}else {
			return "Record did not store";
			
		}
	}
	
	public String updatStudentInfo(Student student) {
		if(studentDao.updateStudentInfo(student)>0) {
			return "Student Info Updated Successfully";
			
		}else {
			return "Student Details did not Update";		
			}
	}
		
		public String deleteStudentInfo(int sid) {
			if(studentDao.deleteStudentInfo(sid)>0) {
				return "Record Deleted Successfully";
				
			}else {
				return "Record Not Present";		
				
			}
		}
		
		public Student getStudentInfo(int sid) {
			return studentDao.getStudentInfo(sid);

			}
		
		public List<Student>getStudentInfo(){
			return studentDao.getAllStudents();
			
		}
		}

