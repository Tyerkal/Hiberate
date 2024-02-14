package com.controller;

import java.util.Scanner;

import com.services.ServiceImpl;
import com.services.Services;

public class HomeController {

	public static void main(String[] args) {

		Services s = new ServiceImpl();

		Scanner sc = new Scanner(System.in);

		// s.addPersonWithAdharCard();
		// s.addAdharCardWithPerson();
		// s.getPersonWithAdharCard();
		// s.getAdharCardWithPerson();
		// s.updatePersonUsingAId();
		// s.updateAdharCardUsingPid();
		// s.deletePersonWithAdharCard();
		// s.deleteAdharCardWithPerson();
		// s.deletePersonOnly();

		boolean flag = true;

		while (flag = true) {
			System.out.println(
					"------------------------------------------------------------------------------------------------------");
			System.out.println("------------Enter 1: addPersonWithAdharCard ----------------");
			System.out.println("------------Enter 2: addAdharCardWithPerson ----------------");
			System.out.println("------------Enter 3: getPersonWithAdharCard ----------------");
			System.out.println("------------Enter 4: getAdharCardWithPerson ----------------");
			System.out.println("------------Enter 5: updatePersonUsingAId ------------------");
			System.out.println("------------Enter 6: updateAdharCardUsingPid ---------------");
			System.out.println("------------Enter 7: deletePersonWithAdharCard -------------");
			System.out.println("------------Enter 8: deleteAdharCardWithPerson -------------");
			System.out.println("------------Enter 9: deletePersonOnly ----------------------");
			System.out.println("------------Enter 10: deleteAdharCardOnly ------------------");
			System.out.println("------------Enter 11: Exit ---------------------------------");
			System.out.println("------------------------------------------------------------");
			System.out.println("Enter your choice");
			int ch = sc.nextInt();
			 
			if (ch == 11) {
				System.out.println("Exiting ");
				break;
			}

			switch (ch) {

			case 1:
				s.addPersonWithAdharCard();
				break;

			case 2:
				s.addAdharCardWithPerson();
				break;

			case 3:
				s.getPersonWithAdharCard();
				break;

			case 4:
				s.getAdharCardWithPerson();
				break;

			case 5:
				s.updatePersonUsingAId();
				break;

			case 6:
				s.updateAdharCardUsingPid();
				break;

			case 7:
				s.deletePersonWithAdharCard();
				break;

			case 8:
				s.deleteAdharCardWithPerson();
				break;

			case 9:
				s.deletePersonOnly();
				break;
				
			case 10:
				s.deleteAdharCardOnly();
				break;

			default:
				System.out.println("Invalid choice");

			}

		}
	}

}
