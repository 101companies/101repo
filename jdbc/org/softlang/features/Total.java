package org.softlang.features;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.softlang.util.MyConnection;

public class Total {

	public static double total(MyConnection myConnection, String companyName){
		double total = 0;
		try {
		String query = "SELECT salary FROM employee "
				+ "WHERE cid = (SELECT id FROM company WHERE name = ?);";
		PreparedStatement pstmtEmployees = myConnection.getConn()
				.prepareStatement(query);
		pstmtEmployees.setString(1, companyName);
		ResultSet salaries = pstmtEmployees.executeQuery();
		while (salaries.next())
			total += salaries.getDouble("salary");
		} catch (SQLException e){
			e.printStackTrace();
		}
		return total;
	}
}
