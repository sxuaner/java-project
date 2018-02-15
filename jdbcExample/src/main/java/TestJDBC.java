import java.sql.*;

public class TestJDBC {
	// com.mysql.jdbc.Driver.  Driver with uppercase D.
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/test";

	static final String USER = "sx";
	static final String PASS= "songxuan";
	
	public void start() {
		try{
			// to register the driver
			Class.forName(JDBC_DRIVER);
			
			//open a connection.
			System.out.println("Connecting to database");
			
			try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement()){
				// Execute a query;
				System.out.println("Creating Statement..");
				String sql = "SELECT * FROM user";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					int id;
					id = rs.getInt("id");
					System.out.println("ID:" + id);
					} // end while
				}catch (SQLException se) {
				se.printStackTrace();
			}//end try 
		}catch (Exception e) {
			// Error handler for class.for name. what could be the exception?? 
			e.printStackTrace();
		}				
		
		System.out.println("That's all byebye");
	}//end main
}// end class
