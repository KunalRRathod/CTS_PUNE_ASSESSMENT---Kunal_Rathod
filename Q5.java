
// Import packages
package com.cognizant.Assessment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// class name starts here
public class Q5 {
	// handling exceptions
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {		
		Class.forName("com.mysql.jdbc.Driver"); // JDBC Driver Import
			String url = "jdbc:mysql://localhost:3306/ctspune";
			Connection conn = DriverManager.getConnection(url, "root", "ROOT");	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
			
			// Enter details from user 
			System.out.println("Enter employee id : ");
			int employee_id = Integer.parseInt(br.readLine());	
			System.out.println("Enter employee name : ");
			String name = br.readLine();	
			System.out.println("Enter employee designation : ");
			String designation = br.readLine();
			System.out.println("Enter employee department : ");
			String department = br.readLine();	
			String insert_query = "insert into employee_details values(?,?,?,?)";		// for insertion into table
			
			// Using prepared statement
			PreparedStatement ps = conn.prepareStatement(insert_query);
			
				// insertion into table
				ps.setInt(1, employee_id);
				ps.setString(2, name);
				ps.setString(3, designation);
				ps.setString(4, department);	
				
				// Execute Update 
					int insert_result = ps.executeUpdate();
					if (insert_result > 0) {
						System.out.println("Data inserted succesfully");
					} 
					else {
						System.out.println("Something went wrong in insertion");
					}
			}
}
