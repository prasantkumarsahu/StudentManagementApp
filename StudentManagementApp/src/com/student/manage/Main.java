package com.student.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			System.out.println("Welcome to my Student Management App -->");

			System.out.println("PRESS 1 TO ADD STUDENT :");
			System.out.println("PRESS 2 TO DELETE STUDENT :");
			System.out.println("PRESS 3 TO UPDATE STUDENT :");
			System.out.println("PRESS 4 TO DISPLAY STUDENT :");
			System.out.println("PRESS 5 TO DISPLAY ALL STUDENTS :");
			System.out.println("PRESS 6 TO EXIT APP : ");

			int c = Integer.parseInt(br.readLine());

			if (c == 1) {
				// Add Student
				System.out.println("Enter Student Name : ");
				String name = br.readLine();

				System.out.println("Enter Student Phone : ");
				String phone = br.readLine();

				System.out.println("Enter Student City : ");
				String city = br.readLine();

				// Create Student Object To Store Student
				Student st = new Student(name, phone, city);

				boolean ans = StudentDao.insertStudentToDB(st);

				if (ans) {
					System.out.println("Student added successfully...");
				} else {
					System.out.println("Something went wrong...");
				}
			} else if (c == 2) {
				// Delete Student
				System.out.println("Enter Student ID You Want To Delete : ");
				int id = Integer.parseInt(br.readLine());

				boolean ans = StudentDao.deleteStudent(id);

				if (ans) {
					System.out.println("Student deleted successfully...");
				} else {
					System.out.println("Something went wrong...");
				}
			} else if (c == 3) {
				// Update Student
				System.out.println("Enter Student ID You Want To Update : ");
				int id = Integer.parseInt(br.readLine());

				System.out.println("Enter New Student Name : ");
				String name = br.readLine();

				System.out.println("Enter New Student Phone : ");
				String phone = br.readLine();

				System.out.println("Enter New Student City : ");
				String city = br.readLine();

				// Create Student Object To Store Student
				Student st = new Student(id, name, phone, city);

				boolean ans = StudentDao.updateStudent(st);

				if (ans) {
					System.out.println("Student updated successfully...");
				} else {
					System.out.println("Something went wrong...");
				}
			} else if (c == 4) {
				// Display Student
				System.out.println("Enter Student ID You Want To Display : ");
				int id = Integer.parseInt(br.readLine());

				StudentDao.displayStudent(id);
			} else if (c == 5) {
				// Display All Students
				StudentDao.displayAllStudents();
			} else if (c == 6) {
				// Exit App
				break;
			} else {
				// Empty
			}

		}

		System.out.println("Thank you for using my application...");
		System.out.println("See you soon...");
	}
}
