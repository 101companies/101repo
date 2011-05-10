package org.softlang.features;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.softlang.util.MyConnection;

public class Cut {

	public static void cut(MyConnection myConnection, String companyName) {
		try {
			// cut salaries in all employee columns
			String sqlCut = "UPDATE employee SET salary = salary / 2 "
					+ "WHERE cid = (SELECT id FROM company WHERE name = ?);";
			PreparedStatement pstmtEmployees = myConnection.getConn()
					.prepareStatement(sqlCut);
			pstmtEmployees.setString(1, companyName);
			pstmtEmployees.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
