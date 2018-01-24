

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Hello World", value = "/hello")
public class HelloWorld extends HttpServlet {

	static final String USER = "sx";
	static final String PASS= "songxuan";
	// Driver is a class. D must be uppercase.
	static final String DRIVER= "com.mysql.jdbc.Driver";
	static final String DB_URL= "jdbc:mysql://localhost/test";

	String query = "SELECT * FROM user";
	
	/*
	 * Try to use logger and annotation. Use gradle to pack the project and output to a .war file??
	 */
	
	/*
	 *  
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// register the driver
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		// print out the debugging infos.
		out.println(query);

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		out.println("Done registering JDBC driver" + "<br>");
		
		// create a connection with mysql
		// if Drivermanager.getConnection() does not throw an exception. It means it has
		// successfully connected to the db.
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement()){
				out.print("An connection to db has been opened");

				try(ResultSet rs = stmt.executeQuery(query)){

				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
			 		out.println("ID:" + id + "<br>");
					out.println("Name:" + name + "<br>");
					}// end while
				} //end try
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				} // end catch
		out.println( "Done printing data" + "<br>");
	}//end doGet
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}// end doPost

}// end HelloWorld

