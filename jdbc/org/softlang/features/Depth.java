package org.softlang.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Depth {

	public static int depth(Connection connection, String companyName) {
		int maxDepth = 0;
		try {
			// get top departments
			String sqlDepts = "SELECT id FROM department WHERE did IS NULL AND "
					+ "cid = (SELECT id FROM company WHERE name = ?);";
			PreparedStatement pstmt = connection.prepareStatement(
					sqlDepts);
			pstmt.setString(1, companyName);
			ResultSet deptIds = pstmt.executeQuery();
			// get depth of the "deepest" department
			while (deptIds.next()) {
				maxDepth = 1 + Math.max(maxDepth,
						depth(connection, deptIds.getInt("id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxDepth;
	}

	private static int depth(Connection connection, int deptId) {
		int maxDepth = 0;
		try {
			// get all sub department by id
			String sqlSubDeptIds = "SELECT id FROM department WHERE did = ?";
			PreparedStatement pstmt = connection.prepareStatement(
					sqlSubDeptIds);
			pstmt.setInt(1, deptId);
			ResultSet subunitIds = pstmt.executeQuery();
			// get deepest path
			while (subunitIds.next()) {
				maxDepth = 1 + Math.max(maxDepth,
						depth(connection, subunitIds.getInt("id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxDepth;
	}

}
