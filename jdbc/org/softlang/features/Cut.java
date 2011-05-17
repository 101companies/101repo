package org.softlang.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cut {

	public static void cut(Connection connection, String companyName) {
		try {
			// cut salaries in all employee columns
			String sqlCut = "UPDATE employee SET salary = salary / 2 "
					+ "WHERE cid = (SELECT id FROM company WHERE name = ?);";
			PreparedStatement pstmtEmployees = connection.prepareStatement(sqlCut);
			pstmtEmployees.setString(1, companyName);
			pstmtEmployees.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
