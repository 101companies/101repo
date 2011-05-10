package org.softlang.features;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.softlang.util.MyConnection;

public class Depth {

	public static int depth(MyConnection myConnection, String companyName) {
		int maxDepth = 0;
		try {
			// get top departments
			String sqlDepts = "SELECT id FROM department WHERE did IS NULL AND "
					+ "cid = (SELECT id FROM company WHERE name = ?);";
			PreparedStatement pstmt = myConnection.getConn().prepareStatement(
					sqlDepts);
			pstmt.setString(1, companyName);
			ResultSet deptIds = pstmt.executeQuery();
			// get depth of the "deepest" department
			while (deptIds.next()) {
				maxDepth = 1 + Math.max(maxDepth,
						depth(myConnection, deptIds.getInt("id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxDepth;
	}

	private static int depth(MyConnection myConnection, int deptId) {
		int maxDepth = 0;
		try {
			// get all sub department by id
			String sqlSubDeptIds = "SELECT id FROM department WHERE did = ?";
			PreparedStatement pstmt = myConnection.getConn().prepareStatement(
					sqlSubDeptIds);
			pstmt.setInt(1, deptId);
			ResultSet subunitIds = pstmt.executeQuery();
			// get deepest path
			while (subunitIds.next()) {
				maxDepth = 1 + Math.max(maxDepth,
						depth(myConnection, subunitIds.getInt("id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxDepth;
	}

}
