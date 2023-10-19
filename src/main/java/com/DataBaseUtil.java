package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.UserDTO;

public class DataBaseUtil {

	Connection conn = null;
	static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	static String dbURL = "jdbc:mysql://localhost:3306/employeedb2023";
	static String userName = "root";
	static String password = "BrucciDirt7552";

	public Connection createConnection() {
		try {
			Class.forName(jdbcDriver);
			try {
				conn = DriverManager.getConnection(dbURL, userName, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int insertData(String email, String password, String fullName, String gender, String age) {
		int insertedRows = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("insert into employee_table values(?,?,?,?,?)");
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, fullName);
			ps.setString(4, gender);
			ps.setString(5, age);

			insertedRows = ps.executeUpdate();
			if (insertedRows > 0) {
				System.out.println("Record inserted successfully!!");
				System.out.println("Number of record inserted: " + insertedRows);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		finally {
//			try {
//				conn.close();
//				System.out.println("Connection Closed!!");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		return insertedRows;
	}

	public List<UserDTO> retriveAll() {
		List<UserDTO> usersList = new ArrayList<UserDTO>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from employee_table");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("Email: " + rs.getString(1) + " , Password: " + rs.getString(2) + " ,Full Name: "
						+ rs.getString(3) + " ,Gender: " + rs.getString(4) + " ,Age: " + rs.getString(5));
				String e = rs.getString(1);
				String p = rs.getString(2);
				String f = rs.getString(3);
				String g = rs.getString(4);
				String a = rs.getString(5);

				UserDTO udto = new UserDTO(e, p, f, g, a);// in first iteration , first object will be added in the
															// UserDTO
				usersList.add(udto);
			}
			System.out.println("Record retrieved successfully!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// finally {
//			try {
//				conn.close();
//				System.out.println("Connection Closed!!");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return usersList;
	}

	public ArrayList<String> loginUsingEmailPassword(String email, String password) {
		ArrayList<String> al = new ArrayList<String>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from employee_table where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) { // for valid user
				System.out.println("Email: " + rs.getString(1) + " , Password: " + rs.getString(2) + " ,Full Name: "
						+ rs.getString(3) + " ,Gender: " + rs.getString(4) + " ,Age: " + rs.getString(5));
				String e = rs.getString(1);
				String p = rs.getString(2);
				String f = rs.getString(3);
				String g = rs.getString(4);
				String a = rs.getString(5);

				al.add(e);
				al.add(p);
				al.add(f);
				al.add(g);
				al.add(a);

			}
			System.out.println("Record retrieved successfully!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// finally {
//			closeConnection();
//			System.out.println("Connection Closed!!");
//		}
		return al;
	}

	public ArrayList<String> retriveUsingEmail(String email) {
		ArrayList<String> al = new ArrayList<String>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from employee_table where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) { // for valid user
				System.out.println("Email: " + rs.getString(1) + " , Password: " + rs.getString(2) + " ,Full Name: "
						+ rs.getString(3) + " ,Gender: " + rs.getString(4) + " ,Age: " + rs.getString(5));
				String e = rs.getString(1);
				String p = rs.getString(2);
				String f = rs.getString(3);
				String g = rs.getString(4);
				String a = rs.getString(5);

				al.add(e);
				al.add(p);
				al.add(f);
				al.add(g);
				al.add(a);

			}
			System.out.println("Record retrieved successfully!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// finally {
//			closeConnection();
//			System.out.println("Connection Closed!!");
//		}
		return al;
	}

	public int deleteUsingEmail(String email) {
		int deletedRows = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("delete from employee_table where email=?");
			ps.setString(1, email);
			deletedRows = ps.executeUpdate();
			if (deletedRows > 0) {
				System.out.println("Number of deleted record/s: " + deletedRows);
				System.out.println("Record deleted successfully!!");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		finally {
//			try {
//				conn.close();
//				System.out.println("Connection Closed!!");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return deletedRows;
	}

	public int updateUsingID(String email, String password, String fullName, String gender, String age) {
		int updatedRows = 0;
		try {
			PreparedStatement ps = conn
					.prepareStatement("update employee_table set password=?,fullName=?,gender=?, age=? where email=?");
			ps.setString(1, password);
			ps.setString(2, fullName);
			ps.setString(3, gender);
			ps.setString(4, age);
			ps.setString(5, email);
			updatedRows = ps.executeUpdate();
			if (updatedRows > 0) {
				System.out.println("Number of updated record/s: " + updatedRows);
				System.out.println("Record updated successfully!!");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		finally {
//			try {
//				conn.close();
//				System.out.println("Connection Closed!!");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
		return updatedRows;
	}

//	public void searchData(String data) {
//		List<UserDTO> searchResultList = new ArrayList<UserDTO>();
//
//		// if user search with no data entered, just provide them with dummy data
//		if (data == null || data.trim().length() == 0) {
//			searchResultList = registrationList;
//		} else { // else give them data based on their search
//			for (UserDTO userDTO : registrationList) {
//				if (data.equals(userDTO.getEmail()) || data.equals(userDTO.getPassword())
//						|| data.equals(userDTO.getFullName()) || data.equals(userDTO.getGender())
//						|| data.equals(userDTO.getAge())) {
//					searchResultList.add(userDTO);
//				}
//			}
//
//		}
//
//	}
}
