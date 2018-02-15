

import java.sql.SQLException;
import org.junit.Test;

public class JDBCTest {

	TestJDBC testJDBC = new TestJDBC();
	
	@Test(expected = SQLException.class)
	public void testStart() {
		testJDBC.start();
	}

}
