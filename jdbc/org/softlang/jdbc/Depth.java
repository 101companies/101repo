package org.softlang.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Depth {

	public static int depth(MyConnection myConnection) {
		int maxDepth = 0;
		try {
			// get top departments
			String sqlDepts = "SELECT deptId FROM dept WHERE upperDeptId IS NULL";
			PreparedStatement pstmt = myConnection.getConn().prepareStatement(
					sqlDepts);
			ResultSet deptIds = pstmt.executeQuery();
			// get depth of the "deepest" department
			while (deptIds.next()) {
				maxDepth = 1 + Math.max(maxDepth, depth(myConnection,
						deptIds.getInt("deptId")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxDepth;
	}

	private static int depth(MyConnection myConnection, int deptId) {
		int maxDepth = 0;
		try {
			// get all sub department
			String sqlSubDeptIds = "SELECT deptId FROM dept WHERE upperDeptId = ?";
			PreparedStatement pstmt = myConnection.getConn().prepareStatement(
					sqlSubDeptIds);
			pstmt.setInt(1, deptId);
			ResultSet subunitIds = pstmt.executeQuery();
			// get deepest path
			while (subunitIds.next()) {
				maxDepth = 1 + Math.max(maxDepth, depth(myConnection,
						subunitIds.getInt("deptId")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxDepth;
	}

}
