package com.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Student;
import com.entity.Teacher;
import com.util.HibernateUtil;

public class ServiceImpl implements Services {

	Scanner sc = new Scanner(System.in);
	SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override

	public void addTeacherWithMulipleStudents() {

		Session session = sf.openSession();
		Teacher t = new Teacher();

		System.out.println("Enter tname");
		t.setTname(sc.next());

		System.out.println("How many student u want to add");
		int n = sc.nextInt();

		List<Student> slist = new LinkedList<Student>();

		for (int i = 0; i < n; i++) {
			Student s = new Student();

			System.out.println("Enter sname");
			s.setSname(sc.next());

			s.setTeacher(t);
			slist.add(s);

		}
		t.setSlist(slist);
		session.save(t);
		session.beginTransaction().commit();
	}

	@Override
	public void addStudentWithTeacher() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getTeacherWithMultipleStudents() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getStudentWithTeacher() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTeacherWithAllStudent() {

		Session session = sf.openSession();
		System.out.println("enter tid");
		Teacher t = session.get(Teacher.class, sc.nextInt());

		if (t != null) {
			session.delete(t);
			session.beginTransaction().commit();
		} else {
			System.out.println("Incalid Id");
		}

	}

	@Override
	public void deleteAllStudentOnlyOfTeacher() {

		Session session = sf.openSession();
		System.out.println("enter tid");
		Teacher t = session.get(Teacher.class, sc.nextInt());

		if (t != null) {

			List<Student> slist = t.getSlist();
			t.setSlist(null);
			for (Student s : slist) {
				s.setTeacher(null);

			}
			session.delete(t);
			session.beginTransaction().commit();
		} else {
			System.out.println("Incalid Id");
		}

	}

	@Override
	public void deleteParticularStudentUsingTid() {
		Session session = sf.openSession();
		System.out.println("enter tid");
		Teacher t = session.get(Teacher.class, sc.nextInt());

		if (t != null) {

			List<Student> slist = t.getSlist();
			System.out.println("ENter sid");
			int sid = sc.nextInt();
			
			Student stu=null;
			for (Student s : slist) {
				if (s.getSid() == sid) {
					s.setTeacher(null);
					stu=s;
				}

			}
			slist.remove(stu);
			session.delete(stu);
			session.beginTransaction().commit();
		} else {
			System.out.println("Incalid Id");
		}
	}

	@Override
	public void deleteTeacherUsingSid() {

		Session session = sf.openSession();
		System.out.println("enter sid");
		Student s = session.get(Student.class, sc.nextInt());

		if (s != null) {
			
			Teacher t=s.getTeacher();
			List<Student> list=t.getSlist();
			t.setSlist(null);
			
			for(Student stu:list) {
				stu.setTeacher(null);
			}

			
			session.delete(t);
			session.beginTransaction().commit();
		} else {
			System.out.println("Incalid Id");
		}
	}
}
