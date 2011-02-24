package org.softlang.company;

import org.softlang.util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashSet;
import java.util.Set;

/**
 * We map from company objects to SQL Data. This tool uses the flag of each
 * object to recognize whether it has to be saved. If so, it checks the id of
 * this object: If the id equals 0, the object is new and a new entry is put
 * into the appropriate table. If the id does not equal 0, the object fields
 * have changed and we have to UPDATE.
 * 
 */
public class PersistenceTool {

	// integer sets to save all departments and employees (by id) that are
	// actually part of the company
	private static Set<Integer> deptIds;
	private static Set<Integer> employeeIds;

	private MyConnection myConnection;

	public PersistenceTool(MyConnection myConnection) {

		this.myConnection = myConnection;
		if (myConnection != null && !myConnection.getIsConnected())
			myConnection.connect();

	}

	// Clearing the database of department and person entries that are no
	// longer part of the company (not in the appropriate integer set)
	private void clear(Set<Integer> ids, String tablename) {
		try {
			String idName = tablename + "Id";
			String sqlSelect = "SELECT " + idName + " FROM " + tablename;
			PreparedStatement pstmtSelect = myConnection.getConn()
					.prepareStatement(sqlSelect);
			ResultSet result = pstmtSelect.executeQuery();
			while (result.next()) {
				if (!ids.contains(result.getInt(idName))) {
					String sqlDelete = "DELETE FROM " + tablename + " WHERE "
							+ idName + " = ?";
					PreparedStatement pstmtDelete = myConnection.getConn()
							.prepareStatement(sqlDelete);
					pstmtDelete.setInt(1, result.getInt(idName));
					pstmtDelete.execute();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void persistCompany(Company company) {
		if (company.isChanged()) {
			deptIds = new HashSet<Integer>();
			employeeIds = new HashSet<Integer>();
			// save all top departments
			for (Dept dept : company.getDepts()) {
				persistDept(dept, null);
			}
			// clear the database
			clear(deptIds, "dept");
			clear(employeeIds, "employee");
			// reset flags
			company.setUnchanged();
			company.getDepts().setUnchanged();
		}

	}

	private void persistDept(Dept dept, Integer upperDeptId) {
		if (dept.isChanged()) {
			try {
				if (dept.getDeptid() == 0) {
					// insert new department entry
					String sqlInsert = "INSERT dept(name, upperDeptId) VALUES (?,?)";
					PreparedStatement pstmtInsert = myConnection.getConn()
							.prepareStatement(sqlInsert);
					pstmtInsert.setString(1, dept.getName());
					if (upperDeptId != null)
						pstmtInsert.setInt(2, upperDeptId);
					else
						pstmtInsert.setNull(2, Types.INTEGER);
					pstmtInsert.execute();
					// get the auto-generated id and store it in the
					// department's field
					String sqlSelectId = "SELECT deptId FROM dept ORDER BY deptid DESC LIMIT 0,1";
					PreparedStatement pstmtSelectId = myConnection.getConn()
							.prepareStatement(sqlSelectId);
					ResultSet idR = pstmtSelectId.executeQuery();
					idR.next();
					dept.setDeptid(idR.getInt("deptId"));
					// save manager
					persistEmployee(dept.getManager(), dept.getDeptid());
					// now that the manager got an id we can store it the
					// department table
					String sqlUpdateManager = "UPDATE dept SET managerId = ? WHERE deptId = ?";
					PreparedStatement pstmtUpdateManager = myConnection
							.getConn().prepareStatement(sqlUpdateManager);
					pstmtUpdateManager.setInt(1, dept.getManager()
							.getEmployeeid());
					pstmtUpdateManager.setInt(2, dept.getDeptid());
					pstmtUpdateManager.executeUpdate();
				} else {
					// update department entry
					String sqlUpdate = "UPDATE dept SET name = ?, upperDeptId = ? WHERE deptId = ?";
					PreparedStatement pstmtUpdate = myConnection.getConn()
							.prepareStatement(sqlUpdate);
					pstmtUpdate.setString(1, dept.getName());
					if (upperDeptId != null)
						pstmtUpdate.setInt(2, upperDeptId);
					else
						pstmtUpdate.setNull(2, Types.INTEGER);
					pstmtUpdate.setInt(3, dept.getDeptid());
					pstmtUpdate.executeUpdate();
					persistEmployee(dept.getManager(), dept.getDeptid());
					// now that the manager got an id we can store it the
					// department table
					String sqlUpdateManager = "UPDATE dept SET managerId = ? WHERE deptId = ?";
					PreparedStatement pstmtUpdateManager = myConnection
							.getConn().prepareStatement(sqlUpdateManager);
					pstmtUpdateManager.setInt(1, dept.getManager()
							.getEmployeeid());
					pstmtUpdateManager.setInt(2, dept.getDeptid());
					pstmtUpdateManager.executeUpdate();

				}
				// reset flag
				dept.setUnchanged();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// persist all employees
		for (Employee employee : dept.getEmployees())
			persistEmployee(employee, dept.getDeptid());
		dept.getEmployees().setUnchanged();
		// persist all sub departments
		for (Dept subDept : dept.getSubDepartments())
			persistDept(subDept, dept.getDeptid());
		dept.getSubDepartments().setUnchanged();

		// register department in the integer set
		deptIds.add(dept.getDeptid());

	}

	private void persistEmployee(Employee employee, Integer deptId) {
		if (employee.isChanged()) {
			try {
				if (employee.getEmployeeid() == 0) {
					// save person
					String sqlInsert = "INSERT employee (name, address, salary, deptId) VALUES (?,?,?,?)";
					PreparedStatement pstmtInsert = myConnection.getConn()
							.prepareStatement(sqlInsert);
					pstmtInsert.setString(1, employee.getName());
					pstmtInsert.setString(2, employee.getAddress());
					pstmtInsert.setDouble(3, employee.getSalary());
					pstmtInsert.setInt(4, deptId);
					pstmtInsert.execute();

					// get the auto-generated id and store it in the employee's
					// field
					String sqlSelectId = "SELECT employeeId FROM employee ORDER BY employeeId DESC LIMIT 0,1";
					PreparedStatement pstmtSelectId = myConnection.getConn()
							.prepareStatement(sqlSelectId);
					ResultSet id = pstmtSelectId.executeQuery();
					id.next();
					employee.setEmploeeid(id.getInt("employeeId"));
				} else {
					// update employee entry
					String sqlUpdate = "UPDATE employee SET name = ?, address = ?, salary = ?, deptId = ? WHERE employeeId = ?";
					PreparedStatement pstmtUpdate = myConnection.getConn()
							.prepareStatement(sqlUpdate);
					pstmtUpdate.setString(1, employee.getName());
					pstmtUpdate.setString(2, employee.getAddress());
					pstmtUpdate.setDouble(3, employee.getSalary());
					pstmtUpdate.setInt(4, deptId);
					pstmtUpdate.setInt(5, employee.getEmployeeid());
					pstmtUpdate.executeUpdate();
				}
				// reset flag
				employee.setUnchanged();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// register employee in the integer set
		employeeIds.add(employee.getEmployeeid());

	}
}
