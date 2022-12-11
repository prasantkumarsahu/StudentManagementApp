package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	public static boolean insertStudentToDB(Student st) {
		boolean f = false;

		try {

			// Create Connection
			Connection con = ConnectionProvider.createConnection();
			String q = "insert into student(sname, sphone, scity) values(?, ?, ?)";

			// Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(q);

			// Set Parameterd Values
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());

			// Execute
			pstmt.executeUpdate();

			f = true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return f;
	}

	public static boolean deleteStudent(int id) {
		boolean f = false;

		try {

			// Create Connection
			Connection con = ConnectionProvider.createConnection();
			String q = "delete from student where sid=?";

			// Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(q);

			// Set Parameterd Values
			pstmt.setInt(1, id);

			// Execute
			pstmt.executeUpdate();

			f = true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return f;
	}

	public static boolean updateStudent(Student st) {
		boolean f = false;

		try {

			// Create Connection
			Connection con = ConnectionProvider.createConnection();
			String q = "update student set sname=?, sphone=?, scity=? where sid=?";

			// Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(q);

			// Set Parameterd Values
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			pstmt.setInt(4, st.getStudentID());

			// Execute
			pstmt.executeUpdate();

			f = true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return f;
	}

	public static void displayStudent(int id) {

		try {

			// Create Connection
			Connection con = ConnectionProvider.createConnection();
			String q = "select * from student where sid=?";

			// Statement
			PreparedStatement pstmt = con.prepareStatement(q);

			// Set Parameterd Values
			pstmt.setInt(1, id);

			// Execute & Save data in ResultSet
			ResultSet set = pstmt.executeQuery();

			// Printing Set Value
			while (set.next()) {

				int sid = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);

				System.out.println("**********************************");
				System.out.println("Student ID : " + sid);
				System.out.println("Student Name : " + name);
				System.out.println("Student Phone : " + phone);
				System.out.println("Student City : " + city);
				System.out.println("**********************************");

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	}

	public static void displayAllStudents() {

		try {

			// Create Connection
			Connection con = ConnectionProvider.createConnection();
			String q = "select * from student";

			// Statement
			Statement stmt = con.createStatement();

			// Execute & Save data in ResultSet
			ResultSet set = stmt.executeQuery(q);

			// Printing Set Value
			while (set.next()) {

				int sid = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);

				System.out.println("###################################");
				System.out.println("Student ID : " + sid);
				System.out.println("Student Name : " + name);
				System.out.println("Student Phone : " + phone);
				System.out.println("Student City : " + city);
				System.out.println("###################################");

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

	}
}
