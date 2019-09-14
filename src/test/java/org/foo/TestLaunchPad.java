package org.foo;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class TestLaunchPad {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/test";

	// Database credentials
	static final String USER = "sa";
	static final String PASS = "";

	@Test
	public void test() throws ClassNotFoundException, SQLException {

		Class.forName(JDBC_DRIVER);

		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement st = conn.createStatement();
		st.executeUpdate("CREATE TABLE USER");
		conn.close();

		fail("Not yet implemented");
	}

}
