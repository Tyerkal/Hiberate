package com.services;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.AdharCard;
import com.entity.Person;
import com.util.HibernateUtil;

public class ServiceImpl implements Services {

	Scanner sc = new Scanner(System.in);

	SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public void addPersonWithAdharCard() {

		Session session = sf.openSession();
		Person p = new Person();
		System.out.println("Enter person name");
		p.setPname(sc.next());

		AdharCard a = new AdharCard();
		System.out.println("Enter AdharCard name");
		a.setAname(sc.next());

		p.setAdharCard(a);
		a.setPerson(p);

		session.save(p);
		session.beginTransaction().commit();
		System.out.println("Success");

	}

	@Override
	public void addAdharCardWithPerson() {

		Session session = sf.openSession();
		Person p = new Person();
		System.out.println("Enter person name");
		p.setPname(sc.next());

		AdharCard a = new AdharCard();
		System.out.println("Enter AdharCard name");
		a.setAname(sc.next());

		p.setAdharCard(a);
		a.setPerson(p);

		session.save(a);
		session.beginTransaction().commit();
		System.out.println("Success");
	}

	@Override
	public void getPersonWithAdharCard() {

		Session session = sf.openSession();
		System.out.println("Enter pid");
		Person p = session.get(Person.class, sc.nextInt());
		if (p != null) {

			System.out.println(p);
		} else {
			System.out.println("Invalid");

		}
	}

	@Override
	public void getAdharCardWithPerson() {

		Session session = sf.openSession();
		System.out.println("Enter aid");
		AdharCard a = session.get(AdharCard.class, sc.nextInt());
		if (a != null) {

			System.out.println(a.getPerson());
		} else {
			System.out.println("Invalid");

		}
	}

	
	
	
	@Override
	public void updatePersonUsingAId() {

		Session session = sf.openSession();
		System.out.println("Enter aid");
		AdharCard a = session.get(AdharCard.class, sc.nextInt());
		if (a != null) {
			System.out.println("Enter pname");
			a.setAname(sc.next());

			session.update(a);
			session.beginTransaction().commit();
		} else {
			System.out.println("Invalid");

		}
	}

	@Override
	public void updateAdharCardUsingPid() {

		Session session = sf.openSession();
		System.out.println("Enter aid");
		AdharCard a = session.get(AdharCard.class, sc.nextInt());
		if (a != null) {
			System.out.println("Enter aname");
			a.setAname(sc.next());
			session.update(a);
			session.beginTransaction().commit();
		} else {
			System.out.println("Invalid");

		}
	}

	@Override
	public void deleteAdharCardWithPerson() {
		Session session = sf.openSession();
		System.out.println("Enter adhar_Id");
		AdharCard a = session.get(AdharCard.class, sc.nextInt());
		if (a != null) {
			session.delete(a);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid ID");
		}

	}

	@Override
	public void deletePersonWithAdharCard() {

		Session session = sf.openSession();
		System.out.println("Enter Person_Id");
		Person p = session.get(Person.class, sc.nextInt());
		if (p != null) {

			session.delete(p);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid ID");
		}
	}

	@Override
	public void deletePersonOnly() {
		Session session = sf.openSession();
		System.out.println("Enter Person_Id");
		Person p = session.get(Person.class, sc.nextInt());
		if (p != null) {
			AdharCard a = p.getAdharCard();
			a.setPerson(null);

			p.setAdharCard(null);

			session.update(p);

			session.delete(p);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid ID");
		}

	}

	@Override
	public void deleteAdharCardOnly() {
		Session session = sf.openSession();
		System.out.println("Enter Adhar_Id");
		AdharCard a = session.get(AdharCard.class, sc.nextInt());
		if (a != null) {
			Person p = a.getPerson();
			p.setAdharCard(null);
			a.setPerson(null);
			session.update(a);
		

			session.delete(a);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid ID");
		}

	}
}