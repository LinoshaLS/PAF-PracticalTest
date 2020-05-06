package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class payment {
	
	
	
	
////////////////////db connection	
	
	public Connection connect()
	{
	 Connection con = null;

	 try
	 {
		 	Class.forName("com.mysql.jdbc.Driver");
		 	con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/healthcare",
		 			"root", "");
	 //For testing
		 	System.out.print("Successfully connected");
	 }
	 	catch(Exception e)
	 {
	 		e.printStackTrace();
	 }

	 	return con; 
	}
	
	
///////////////////////////////insert data	
	
	public String insertPayment(String cust, String payAmount , String desc) {
		
		
		String output ="";
		try {
		
			Connection con = connect();
		if(con==null) {
			return "Error while connecting to the database for inserting";
		}
		
		
		String query = "insert into payment(`customerId`,`pamentRef`,`paymentAmount`,`paymentDesc`)" +"values(?, ?, ?, ?)";
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
		
		
		
		preparedStmt.setString(1,cust);
		preparedStmt.setInt(2, 0);
	//	preparedStmt.setString(2, payRef);
		preparedStmt.setString(3, payAmount);
		preparedStmt.setString(4, desc);
		
		preparedStmt.execute();
		con.close();
		
		String newPay = readPayment();
		output = "{\"status\":\"success\",\"data\":\"" +newPay + "\"}";
		
			/* output = "Inserted successfully"; */
	}
	catch(Exception e) {
		
			/* output = "Error while inserting"; */
		output = "{\"status\":\"error\",\"data\":"
				+" \"Error while inserting.\"}";
					
		
	System.err.println(e.getMessage());
	
	}
		
		return output;
	}
	
	
	/////////////////read
	public String readPayment(){
		
		String output="";
		
		
		
		try
		{
		 Connection con = connect();
		if (con == null)
		 {
		 return "Error while connecting to the database for reading.";
		 }
		
		output = "<table border='1'><tr><th>Customer ID</th>"
				+ "<th>Payment(Rs.)</th>"
				+"<th>Description</th>"
				+"<th>Update</th><th>Remove</th></tr>";
		
		//////////////read from database
			String query = "select * from payment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query); 
		 
		 while (rs.next()) 
		 {
			String customerId = rs.getString("customerId");
			String pamentRef = rs.getString("pamentRef");
			String paymentAmount = rs.getString("paymentAmount");
			String paymentDesc = rs.getString("paymentDesc");
			
			
			//////Add to HTML table
			output +="<tr><td><input id='hidenpaymentUpdate' name='hidenpaymentUpdate' type='hidden' value='" + pamentRef + "'>" 
					+ customerId + "</td>";
			//output +="<td>" + pamentRef + "</td>";
			output +="<td>" + paymentAmount + "</td>";
			output +="<td>" + paymentDesc + "</td>";
			
			
			output +="<td><input name='btnUpdate' "
					+ "type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
						/* + "<td><form method=\"post\" action=\"paymentForm.jsp\">" */
					+ "<td><input name='btnRemove'"
					+ "type='button' value='Remove' class='btn btn-danger' data-pamentref='"
					+  pamentRef +"'>"+"</td></tr>";
				/*
				 * + "<input name=\"pamentRef\" type=\"hidden\"" + "value=\"" + pamentRef +
				 * "\"> "+ "</form></td></tr>";
				 */
		 
		 }
		 con.close();
		 
		    output +="</table>";
		 }
		
		
		
		
		catch (Exception e)
		{
		output = "Error while reading the items.";
		 System.err.println(e.getMessage()); 
		
		
	}
	
	return output;
	
	
	
	}
////////////delete data
	
	public String deletepayement(String pamentRef)
	{
	 String output = "";
	 
	 
	 try {
		 Connection con = connect();
		 
		 if (con == null)
		 {
		 return "Error while connecting to the database for deleting.";
		 } 
		 
		 String query = "delete from payment where pamentRef=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		 
		 preparedStmt.setInt(1, Integer.parseInt(pamentRef));
		 
		 preparedStmt.execute();
		 con.close(); 
		 
			/*
			 * output = "Deleted successfully";
			 */
		 String newPay = readPayment();
		 output = "{\"status\":\"success\", \"data\": \"" + newPay + "\"}";
	 
	 }
	 catch (Exception e) {
		 
			/* output = "Error while deleting payment."; */
		 
		 output = "{\"status\":\"error\", \"data\":"
		 		+ "\"Error while deleting the item.\"}"; 
		 System.err.println(e.getMessage()); 
	 }
	 return output;
	

	}
//////////////////update data
	
public String updatePayment(String cust, String payRef, String payAmount , String desc) {
	String output = ""; 
	
	try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for updating."; } 

	 
	 String query = "UPDATE payment SET customerId=?,paymentAmount=?,paymentDesc=? WHERE pamentRef=?";
			 		
	PreparedStatement preparedStmt = con.prepareStatement(query); 	
	
	 
	 preparedStmt.setString(1,cust);
	
	 preparedStmt.setDouble(2,Double.parseDouble(payAmount));
	 preparedStmt.setString(3,desc);
	 preparedStmt.setInt(4,Integer.parseInt(payRef));
	 
	 preparedStmt.execute();
	 con.close(); 
	 
	 String newPay = readPayment();
	 output = "{\"status\":\"success\",\"data\":\""+
	                 newPay + "\"}";
			/* output = "Updated successfully"; */
	 }
	catch (Exception e)
	 {
			/*
			 * output = "Error while updating the item.";
			 */	
		
		output = "{\"status\":\"error\", \"data\":"
				+ "\"Error while updating the item.\"}";
		System.err.println(e.getMessage());
	 } 
	return output; }
	





}
	
	


