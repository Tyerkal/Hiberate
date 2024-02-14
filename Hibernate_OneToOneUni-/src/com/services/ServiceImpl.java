package com.services;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Engine;
import com.entity.car;
import com.util.HibernateUtil;

public class ServiceImpl implements Services {

	Scanner sc = new Scanner(System.in);
	SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public void addCarWithEngine() {
		Session session = sf.openSession();
		car car = new car();
		System.out.println("Enter carName");
		car.setCname(sc.next());

		Engine e = new Engine();
		System.out.println("Enter EngineName");
		e.setEname(sc.next());
		car.setEngine(e);
		session.save(car);
		session.save(e);

		session.beginTransaction().commit();
		System.out.println("SUCCESS");
	}

	@Override
	public void getCarWithEngine() {

		Session session = sf.openSession();
		System.out.println("Enter id");

		int cid = sc.nextInt();
		car c = session.get(car.class, cid);
		if (c != null) {
			System.out.println(c);

		} else {
			System.out.println("Invalid ID");
		}

	}

	@Override
	public void updateCar() {

		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();

		System.out.println("Enter cname from id");
		int cid = sc.nextInt();

		car c = session.get(car.class, cid);
		if (c != null) {
			System.out.println("Enter name to update");
			c.setCname(sc.next());

			session.update(c);

			session.beginTransaction().commit();
			System.out.println("SUCCESSFULLY ");

		} else {
			System.out.println("Invalid ID");
		}

	}

	@Override
	public void CarWithEngine() {

		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();

		System.out.println("Enter  id");

		car c = session.get(car.class, sc.nextInt());
		if (c != null) {
			System.out.println("Enter Car name:");
			c.setCname(sc.next());

			Engine engine = c.getEngine();
			System.out.println("Enter Engine name:");
			engine.setEname(sc.next());

			session.update(c);

			session.beginTransaction().commit();
			System.out.println("SUCCESSFULLY ");

		} else {
			System.out.println("Invalid ID");
		}

	}

	@Override
	public void deleteCarWithEngine() {

		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();

		System.out.println("Enter Car_id");
		car c = session.get(car.class, sc.nextInt());
		if (c != null) {
			session.delete(c);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid ID");
		}

	}

	@Override
	public void deletecarOnly() {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();

		System.out.println("Enter Car_id");
		car c = session.get(car.class, sc.nextInt());
		if (c != null) {
			
			c.setEngine(null);
			session.update(c);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid ID");
		}
	
	}

	@Override
	public void deleteEngineOnly() {

		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();

		System.out.println("Enter Car_id");
		car c = session.get(car.class, sc.nextInt());
		if (c != null) {
			
			Engine e=c.getEngine();
			c.setEngine(null);
			session.update(c);
			session.delete(e);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid ID");
		}
	}

	@Override
	public void mixCarEngine() {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();

		System.out.println("Enter Car_id");
		car c = session.get(car.class, sc.nextInt());
		
		System.out.println("Enter Engine_id");
		Engine e = session.get(Engine.class, sc.nextInt());
		if (c != null && e!=null ) {
			
			c.getEngine();
			
			session.update(c);
			
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid ID");
		}
		
	}
	
	
	
}
