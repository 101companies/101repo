package org.softlang.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Depth {

	/**
	 * Compute the depth of a given company.
	 */
	public static int depth(Connection connection, String name) {
		int maxDepth = 0;
		try {
			// get top departments
			String sql 	= "SELECT id FROM department WHERE did IS NULL AND "
						+ "cid = (SELECT id FROM company WHERE name = ?);";
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, name);
			ResultSet ids = stm.executeQuery();
			// get depth of the "deepest" department
			while (ids.next())
				maxDepth = 1 + Math.max(
									maxDepth, 
									depth(connection, ids.getInt("id")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxDepth;
	}

	/**
	 * Compute the depth of a given department.
	 */
	private static int depth(Connection connection, int id) {
		int maxDepth = 0;
		try {
			// get all sub-departments by id
			String sql = "SELECT id FROM department WHERE did = ?";
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet ids = stm.executeQuery();
			// get deepest path
			while (ids.next())
				maxDepth = 1 + Math.max(
									maxDepth,
									depth(connection, ids.getInt("id")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxDepth;
	}
}
