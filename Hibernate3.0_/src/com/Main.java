package com;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class Main {

	public static void main(String[] args) {

		Student s= new Student();
		s.setSid(70);
		s.setSname("TYY");
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		Session session=sf.openSession();
		
		session.save(s);
		session.beginTransaction().commit();
		
		System.out.println("Success ");
	}

}
