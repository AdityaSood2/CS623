package dbms_assignment;

// Importing all the necessary sql files.
import java.sql.*;




public class project {

	public static void main(String[] args) throws SQLException {
		try {
			
			 System.out.println("Beginning");
			// Loading the MySQL Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		    // Connecting to the database by providing the login credentials
			Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/db_project","root","@1Figosood");
	
	// For Atomicity
	conn.setAutoCommit(false);	
	
	// For Isolation
	conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
	
	Statement stmt1 = null;
	
	try {
	  
	 // Create Statement Object	
	 stmt1 = conn.createStatement();
	 
	 // Performing the necessary deletion operation
	 stmt1.executeUpdate("DELETE FROM `db_project`.`product` WHERE (`prod_number` = 'p1')");
	 
	 // The below statement would be used if ON DELETE CASCADE was not used
	// stmt1.executeUpdate("DELETE FROM `db_project`.`stock` WHERE (`prod_num` = 'p1')");
	
    }  catch (SQLException e) {
    	System.out.println("An exception was thrown");
    	e.printStackTrace();
    	
    	// For Atomicity
    	conn.rollback();
    	stmt1.close();
    	conn.close();
    	return;
    }
	
	conn.commit();
	stmt1.close();
	conn.close();
	System.out.println("End");
	
	}
	
}	


		// TODO Auto-generated method stub

	



