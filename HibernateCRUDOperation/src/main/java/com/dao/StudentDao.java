package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

import antlr.collections.List;

public class StudentDao {
	public boolean storeStudentInfo(Student student) {
		try {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();//Like a DB Connection
		Session session = sf.openSession();//Like a Statement or Prepared Statement
		Transaction tran = session.getTransaction();
		tran.begin();
		     session.save(student);
		tran.commit();	
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	public int updateStudentInfo(Student student) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();//Like a DB Connection
		Session session = sf.openSession();//Like a Statement or Prepared Statement
		Student ss = session.find(Student.class, student.getSid());
		
		if(ss==null) {
			return 0;
		}else {
			Transaction tran = session.getTransaction();
			tran.begin();
			     ss.setAge(student.getAge());
			     session.update(ss);
			
			tran.commit();
			return 1;
		}
	}
		
		public int deleteStudentInfo(int sid) {
			Configuration con = new Configuration();
			con.configure("hibernate.cfg.xml");
			SessionFactory sf = con.buildSessionFactory();//Like a DB Connection
			Session session = sf.openSession();//Like a Statement or Prepared Statement
			Student ss = session.find(Student.class, sid);
			
			if(ss==null) {
				return 0;
			}else {
				Transaction tran = session.getTransaction();
				tran.begin();
				    session.delete(ss);
				tran.commit();
				return 1;
			}
	}
		
		public Student getStudentInfo(int sid) {
			Configuration con = new Configuration();
			con.configure("hibernate.cfg.xml");
			SessionFactory sf = con.buildSessionFactory();//Like a DB Connection
			Session session = sf.openSession();//Like a Statement or Prepared Statement
			Student ss = session.find(Student.class, sid);
			
			if(ss==null) {
				return null;
			}else {
				return ss;
			}
		}
		
		public java.util.List<Student> getAllStudents(){
			Configuration con = new Configuration();
			con.configure("hibernate.cfg.xml");
			SessionFactory sf = con.buildSessionFactory();//Like a DB Connection
			Session session = sf.openSession();
			Query<Student> qry = session.createQuery("select s from Student s");
			java.util.List<Student>listOfStudent = qry.list();
			return listOfStudent;
			
			
			
		}
}
