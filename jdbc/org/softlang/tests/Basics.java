package org.softlang.tests;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import static org.softlang.features.Total.*;
import static org.softlang.features.Cut.*;
import static org.softlang.features.Depth.*;

import java.sql.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import static org.junit.Assert.*;

/**
 * Testing the company scenarios.
 */
public class Basics {

	private Connection connection;

	@Before
	public void connect() {
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

	@Test
	public void testTotal() {
		double total = total(connection, "meganalysis");
		assertEquals(399747, total, 0.0);
	}

	@Test
	public void testCut() {
		cut(connection, "meganalysis");
		double total = total(connection, "meganalysis");
		assertEquals(399747 / 2.0d, total, 0.0);
	}

	@Test
	public void testDepth() {
		int depth = depth(connection, "meganalysis");
		assertEquals(3, depth);
	}

}
