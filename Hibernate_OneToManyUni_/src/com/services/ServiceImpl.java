
package com.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Company;
import com.entity.Employee;
import com.util.HibernateUtil;

public class ServiceImpl implements Services {

	Scanner sc = new Scanner(System.in);
	SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public void addComapanyWithManyEmployee() {

		Session session = sf.openSession();

		Company c = new Company();

		System.out.println("Enter cname : ");
		c.setCname(sc.next());

		List<Employee> elsit = new LinkedList<Employee>();

		System.out.println("How many employees u wnat to add : ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			Employee e = new Employee();
			System.out.println("Enter ename : ");
			e.setEname(sc.next());

			elsit.add(e);

		}

		c.setElist(elsit);

		session.save(c);
		session.beginTransaction().commit();

	}

	@Override
	public void getComapnyWithManyEmployees() {
		// TODO Auto-generated method stub

		Session session = sf.openSession();
		System.out.println("Enter cid : ");
		Company c = session.get(Company.class, sc.nextInt());
		if (c != null) {
			System.out.println(c.getCid());
			System.out.println(c.getCname());
			System.out.println(c.getElist());
		}
	}

	@Override
	public void updateComapanyUsingCid() {
		// TODO Auto-generated method stub

		// session
		// sop
		// cid
		// get>>
		Session session = sf.openSession();
		System.out.println("Enter cid : ");
		Company c = session.get(Company.class, sc.nextInt());

		if (c != null) {

			System.out.println("Enter cname : ");
			c.setCname(sc.next());

			session.update(c);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid id");
		}

	}

	@Override
	public void updateEmployeeUsingCid() {
		Session session = sf.openSession();
		System.out.println("Enter cid : ");
		Company c = session.get(Company.class, sc.nextInt());

		if (c != null) {

			List<Employee> elist = c.getElist();

			System.out.println("Enter eid : ");
			int eid = sc.nextInt();
			for (Employee e : elist) {
				if (e.getEid() == eid) {
					System.out.println("Enter ename : ");
					e.setEname(sc.next());

					session.update(e);
					session.beginTransaction().commit();
				}
			}

			session.update(c);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid id");
		}

	}

	@Override
	public void deleteCompanyWithEmployees() {
		Session session = sf.openSession();
		System.out.println("Enter cid : ");
		Company c = session.get(Company.class, sc.nextInt());

		if (c != null) {

			session.delete(c);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid id");
		}

	}

	@Override
	public void deleteEmployeesOnly() {
		Session session = sf.openSession();
		System.out.println("Enter cid : ");
		Company c = session.get(Company.class, sc.nextInt());

		if (c != null) {

			List<Employee> elist = c.getElist();

			c.setElist(null);

			for (Employee e : elist) {
				session.delete(e);
			}
			session.beginTransaction().commit();
		} else {
			System.out.println("Invalid id");
		}

	}

	@Override
	public void deleteParticularEmployee() {

		Session session = sf.openSession();
		System.out.println("Enter cid : ");
		Company c = session.get(Company.class, sc.nextInt());

		if (c != null) {

			System.out.println("Enter eid : ");
			int eid = sc.nextInt();

			List<Employee> elsit = c.getElist();
			Employee emp = null;
			for (Employee e : elsit) {

				if (e.getEid() == eid) {
//					elsit.remove(e);
					emp = e;
				}

			}

			if (emp != null) {
				elsit.remove(emp);
				session.delete(emp);
				session.beginTransaction().commit();
			}

		} else {
			System.out.println("Invalid id");
		}

	}

	@Override
	public void deleteCompanyOnly() {
		Session session = sf.openSession();
		System.out.println("Enter cid : ");
		Company c = session.get(Company.class, sc.nextInt());

		if (c != null) {

			c.setElist(null);

			session.delete(c);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid id");
		}

	}

}
