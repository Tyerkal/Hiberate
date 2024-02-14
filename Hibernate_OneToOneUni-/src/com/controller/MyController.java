package com.controller;

import java.security.Provider.Service;
import java.util.Scanner;

import com.services.ServiceImpl;
import com.services.Services;

public class MyController {

	public static void main(String[] args) {

		Services s = new ServiceImpl();

//	s.addCarWithEngine();
//		s.getCarWithEngine();
//		s.updateCar();
		// s.CarWithEngine();
		// s.deleteCarWithEngine();
		// s.deletecarOnly();
		// s.deleteEngineOnly();

		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		while (flag = true) {

			System.out.println("Enter 1: addCarWithEngine ");
			System.out.println("Enter 2: getCarWithEngine ");
			System.out.println("Enter 3: updateCar ");
			System.out.println("Enter 4: CarWithEngine ");
			System.out.println("Enter 5: deleteCarWithEngine ");
			System.out.println("Enter 6: deletecarOnly ");
			System.out.println("Enter 7: deleteEngineOnly ");
			System.out.println("Enter 8: mixCarEngine ");
			System.out.println("Enter 9: Exit ");

			System.out.println("Enter your choice");
			int ch = sc.nextInt();

			if (ch == 9) {
				System.out.println("Exiting ");
				break;
			}

			switch (ch) {

			case 1:
				s.addCarWithEngine();
				break;

			case 2:
				s.getCarWithEngine();
				break;

			case 3:
				s.updateCar();
				break;

			case 4:
				s.CarWithEngine();
				break;

			case 5:
				s.deleteCarWithEngine();
				break;

			case 6:
				s.deletecarOnly();
				break;

			case 7:
				s.deleteEngineOnly();
				break;
				
			case 8:
				s.mixCarEngine();
				break;
				
			default:
				System.out.println("Invalid choice");

			}

		}
	}

}
