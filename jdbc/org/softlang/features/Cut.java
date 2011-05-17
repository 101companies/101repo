package org.softlang.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cut {

	/**
	 * Cut all salaries in half for employees of a given company.
	 */
	public static void cut(Connection connection, String name) {
		try {
			String sqlCut = "UPDATE employee SET salary = salary / 2 "
					+ "WHERE cid = (SELECT id FROM company WHERE name = ?);";
			PreparedStatement stm = connection.prepareStatement(sqlCut);
			stm.setString(1, name);
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
