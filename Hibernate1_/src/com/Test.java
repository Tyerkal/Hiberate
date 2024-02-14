package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		student s = new student();
		s.setSid(4);
		s.setSname("Vrushabh");

		Configuration cfg = new Configuration().configure("Hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();

		Session session =  sf.openSession();
		session.save(s);
		session.beginTransaction().commit();

		System.out.println("Success");

	}
}
