package testJDBC;

import java.sql.*;

public class TestJDBC {
	// com.mysql.jdbc.Driver.  Driver with uppercase D.
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/test";

	static final String USER = "sx";
	static final String PASS= "songxuan";
	
	public static void main(String[] args) {
		try{
			// to register the driver
			Class.forName(JDBC_DRIVER);
			
			//open a connection.
			System.out.println("Connecting to database");

			try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)){

				// Execute a query;
				System.out.println("Creating Statement..");
				try(Statement stmt = conn.createStatement()){

					String sql = "SELECT * FROM user";
					ResultSet rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						int id;
						id = rs.getInt("id");
						System.out.println("ID:" + id);
					} // end while
				}//end try stmt
				
			}//end try conn
		}catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			// Error handler for class.for name. what could be the exception?? 
			e.printStackTrace();
		} // end catch 
		
		System.out.println("That's all byebye");
	}//end main
}// end class
