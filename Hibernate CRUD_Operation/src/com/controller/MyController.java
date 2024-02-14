package com.controller;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Student;
import com.util.HibernateUtil;

public class MyController {

	public static void getStudent(SessionFactory sf) {

		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("ENter sid");
		int sid = sc.nextInt();

//		Student s=session.load(Student.class, sid);
		Student s = session.get(Student.class, sid);
		System.out.println(s);

	}

	public static void addStudent(SessionFactory sf) {

		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();
		Student s = new Student();

		System.out.println("Enter ID");
		s.setSid((sc.nextInt()));
		System.out.println("Enter name");
		s.setSname(sc.next());
		session.save(s);
		session.beginTransaction().commit();

	}

	public static void updateData(SessionFactory sf) {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();
		/*
		 * System.out.println("ENter sid"); int sid = sc.nextInt(); Student s =
		 * session.get(Student.class, sid);
		 * 
		 * if (s != null) {
		 */
		Student s = new Student();
		s.setSid(5);
		System.out.println("Enter name");
		s.setSname(sc.next());

//			session.update(s);
		session.saveOrUpdate(s);
		session.beginTransaction().commit();

		/*
		 * } else { System.out.println("Invalid id");
		 * 
		 * }
		 */
	}

	public static void deleteData(SessionFactory sf) {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();
		System.out.println("Enter sid");
		Student s = session.get(Student.class, sc.nextInt());

		if (s != null) {
			session.delete(s);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid id");
		}

	}

	public static void main(String[] args) {

//		s.setSid(1);
//		s.setSname("TUSHAR");

		SessionFactory sf = HibernateUtil.getSessionFactory();
//		addStudent(sf);

//		getStudent(sf);
//		updateData(sf);
//		deleteData(sf);
		
		Session session=sf.openSession();
//		Session session2=sf.openSession();
		
//		Session session=sf.getCurrentSession();
		Session session2=sf.getCurrentSession();
		
		System.out.println(session.hashCode());
		System.out.println(session2.hashCode());
		
		

	}

}
