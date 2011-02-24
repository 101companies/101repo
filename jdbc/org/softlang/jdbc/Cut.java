package org.softlang.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cut {

	public static void cut(MyConnection myConnection) {
		try {
			// cut salaries in all employee columns 
			String sqlCut = "UPDATE employee SET salary = salary / 2;";
			PreparedStatement pstmtEmployees = myConnection.getConn()
					.prepareStatement(sqlCut);
			pstmtEmployees.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
