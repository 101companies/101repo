package org.softlang.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Total {

	public static double total(MyConnection myConnection)
			throws SQLException {
		double total = 0;
		String query =
			"SELECT salary FROM employee";
		PreparedStatement pstmtEmployees =
			myConnection
				.getConn()
				.prepareStatement(query);
		ResultSet salaries = pstmtEmployees.executeQuery();
		while (salaries.next())
			total += salaries.getDouble("salary");
		return total;
	}
}
