package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Doctor {

	private Connection connect() {

		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/healthcare", "root", "");
			System.out.println("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}

	// Inserting doctor details
	public String insertDoctor(String docName, String docNIC, String specialization, String gender, String phoneNo) {

		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting";
			}

			// create a prepared statement
			String query = " insert into doctor (`docId`,`docName`,`docNIC`,`specialization`,`gender`,`phoneNo`) values(?,?,?,?,?,?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, docName);
			preparedStmt.setString(3, docNIC);
			preparedStmt.setString(4, specialization);
			preparedStmt.setString(5, gender);
			preparedStmt.setString(6, phoneNo);

			// execute the statement
			preparedStmt.execute();
			con.close();
			
			String newDoctors = readDoctors();
			output = "{\"status\":\"success\", \"data\": \"" +newDoctors + "\"}";

		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the doctor details.\"}";
			System.err.println(e.getMessage()); 
		}

		return output;

	}

	// Reading doctor details
	public String readDoctors() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// prepare the html table to be displayed
			output = "<table border='1'><tr><th>Name</th><th>NIC</th><th>Specialization</th><th>Gender</th><th>Contact Number</th><th>Update</th><th>Remove</th></tr>";

			String query = "select * from doctor";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String docId = Integer.toString(rs.getInt("docId"));
				String docName = rs.getString("docName");
				String docNIC = rs.getString("docNIC");
				String specialization = rs.getString("specialization");
				String gender = rs.getString("gender");
				String phoneNo = rs.getString("phoneNo");

				// Add into the html table
				output += "<tr><td><input id='hidDoctorIDUpdate' name='hidDoctorIDUpdate' type='hidden' value='" + docId + "'>" + docName + "</td>";
				output += "<td>" + docNIC + "</td>";
				output += "<td>" + specialization + "</td>";
				output += "<td>" + gender + "</td>";
				output += "<td>" + phoneNo + "</td>";

				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td><td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-docid='"
						+ docId + "'>" + "</td></tr>";
			}
			con.close();

			// Complete the html
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the doctor list.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// Updating the doctor details
	public String updateDoctor(String docId, String docName, String docNIC, String specialization, String gender,
			String phoneNo) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating";
			}

			// create a prepared statement
			String query = "UPDATE doctor SET docName=?,docNIC=?,specialization=?,gender=?,phoneNo=? WHERE docId=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, docName);
			preparedStmt.setString(2, docNIC);
			preparedStmt.setString(3, specialization);
			preparedStmt.setString(4, gender);
			preparedStmt.setString(5, phoneNo);
			preparedStmt.setInt(6, Integer.parseInt(docId));

			// execute the statement
			preparedStmt.execute();
			con.close();

			String newDoctors = readDoctors();
			output = "{\"status\":\"success\", \"data\": \"" + newDoctors + "\"}"; 
			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while updating the doctor details.\"}";
			System.err.println(e.getMessage()); 
		}
		return output;
	}

	// Deleting doctor details
	public String deleteDoctor(String docId) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// creating a prepared statement
			String query = "delete from doctor where docId=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(docId));

			// execute the statement
			preparedStmt.execute();
			con.close();

			String newDoctors = readDoctors();
			output = "{\"status\":\"success\", \"data\": \"" + newDoctors + "\"}";
			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the doctor details.\"}";
			System.err.println(e.getMessage());
		}

		return output;
	}

}
