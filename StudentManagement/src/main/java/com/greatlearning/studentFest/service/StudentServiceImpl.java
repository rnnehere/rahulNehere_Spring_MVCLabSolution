package com.greatlearning.studentFest.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.jar.Attributes.Name;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.greatlearning.studentFest.entity.Student;


 

@Repository


public class StudentServiceImpl  implements StudentService{

	private SessionFactory sessionFactory;
	private Session session;
	
	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory) {
		try {
			session = sessionFactory.getCurrentSession();
			
		}catch(HibernateException e) {
			session = sessionFactory.openSession();
		}
	}
	
	@Transactional
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		
		List<Student> students = session.createQuery("from Student").list();
		
		tx.commit();
		
		return students;
	}

	@Transactional
	public Student findById(int theId) {
		
		Student student = new Student();
		
		Transaction tx = session.beginTransaction();
		
		//find record with Id from the database table
		student = session.get(Student.class, theId);
		
		tx.commit();
		
		
		return student;
	}

	@Transactional
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(theStudent);
		
		tx.commit();
	}

	@Transactional
	public void deleteById(int theId) {
		 
		Transaction tx = session.beginTransaction();
		
		//get transaction
		
		Student student = session.get(Student.class, theId);
		
		//delete record
		session.delete(student);
		tx.commit();
	}
	
	// print the loop
	@Transactional
	public void print(List<Student> student) {
		
		for(Student c : student) {
			System.out.println(c);
		}
		
	}

}
