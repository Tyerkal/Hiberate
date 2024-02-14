package com.student;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Test {

	public static void getAllStudent(SessionFactory sf) {

		Session session = sf.openSession();

		Query<Student> query = session.createQuery("from Student");
		List<Student> slist = query.getResultList();
		System.out.println(slist);
	}

	public static void getStudentMarksUsingName(SessionFactory sf) {

		Session session = sf.openSession();

//		select stu_marks from stu_data where stu_name=?

		Query<Double> query = session.createQuery("select marks from Student where sname=:stu");
		query.setParameter("stu", "TYY");

		Double s = query.getSingleResult();
		System.out.println(s);
	}

	public static void getSnameAndMarks(SessionFactory sf) {

		Session session = sf.openSession();

//		select stu_name,stu_marks from stu_data where stu_marks>50.00;

		Query<Object[]> query = session.createQuery("SelEct sname,marks from Student where sname like 'a%'");
		List<Object[]> list = query.getResultList();

		for (Object[] objArr : list) {
			System.out.println(Arrays.toString(objArr));
		}

	}

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		/*
		 * Student s = new Student(11, "TYY", 96.00); Student s1 = new Student(12,
		 * "Akshay", 73.67); Student s2 = new Student(11, "Zaid", 88.74); Student s3 =
		 * new Student(12, "Prathamesh", 30.75); Student s4 = new Student(11, "Ram",
		 * 48.32); Student s5 = new Student(12, "Sham", 28.45);
		 * 
		 * session.save(s); session.save(s1); session.save(s2); session.save(s3);
		 * session.save(s4); session.save(s5);
		 */

		// getAllStudent(sf);
		//getStudentMarksUsingName(sf);
		
		getSnameAndMarks(sf);
	}
}
