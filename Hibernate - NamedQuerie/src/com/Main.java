package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Main {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

		Student s = new Student();
		s.setSname("Tushar");
		Student s1 = new Student();
		s1.setSname("pqr");
		Student s2 = new Student();
		s2.setSname("xyz");

		session.save(s);
		session.save(s1);
		session.save(s2);
//
//		Query<Student> query = session.createNamedQuery("getAllData");
//		List<Student> list = query.getResultList();
//		System.out.println(list);

		Query<String> query2 = session.createNamedQuery("getSnameById");
		query2.setParameter("id", 1);
		String sname = query2.getSingleResult();
		System.out.println(sname);
	}
}
