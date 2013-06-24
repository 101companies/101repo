package org.softlang.tests;

import java.sql.SQLException;
import java.sql.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * Factored connection code for test cases
 */
public class Connect {

	protected Connection connection;
	protected final String companyName = "Acme Corporation";

	protected void connect() {
		MysqlDataSource ds;
		ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setDatabaseName("test");
		ds.setUser("root");
		ds.setPassword("");
		try {
			connection = ds.getConnection();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
}
