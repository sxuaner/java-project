package JunitTests;

import java.sql.SQLException;
import org.junit.Test;

import myFirstJDBCProgram.TestJDBC;

public class JDBCTest {

	TestJDBC testJDBC = new TestJDBC();
	
	@Test(expected = SQLException.class)
	public void testStart() {
		testJDBC.start();
	}

}
