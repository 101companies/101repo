package org.softlang.util;

import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Employee;

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
	private void clear(Set<Integer> ids, String tablename, Integer companyId) {
		try {
			String sqlSelect = "SELECT id FROM " + tablename + " WHERE cid = ?";
			PreparedStatement pstmtSelect = myConnection.getConn()
					.prepareStatement(sqlSelect);
			pstmtSelect.setInt(1, companyId);
			ResultSet result = pstmtSelect.executeQuery();
			while (result.next()) {
				if (!ids.contains(result.getInt("id"))) {
					String sqlDelete = "DELETE FROM " + tablename
							+ " WHERE id = ?";
					PreparedStatement pstmtDelete = myConnection.getConn()
							.prepareStatement(sqlDelete);
					pstmtDelete.setInt(1, result.getInt("id"));
					pstmtDelete.execute();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void persistCompany(Company company) {
		deptIds = new HashSet<Integer>();
		employeeIds = new HashSet<Integer>();
		if (company.isChanged()) {
			try {
				if (company.getCompanyid() == 0) {
					String sqlInsert = "INSERT company(name) VALUES (?)";
					PreparedStatement pstmtInsert = myConnection.getConn()
							.prepareStatement(sqlInsert);
					// insert new department entry
					pstmtInsert.setString(1, company.getName());
					pstmtInsert.execute();
					// get the auto-generated id and store it in the
					// department's field
					String sqlSelectId = "SELECT max(id) AS maxid FROM company";
					PreparedStatement pstmtSelectId = myConnection.getConn()
							.prepareStatement(sqlSelectId);
					ResultSet idR = pstmtSelectId.executeQuery();
					idR.next();
					company.setCompanyid(idR.getInt("maxid"));
				}

				// save name
				String sqlUpdate = "UPDATE company SET name = ? WHERE id = ?";
				PreparedStatement pstmtUpdate = myConnection.getConn()
						.prepareStatement(sqlUpdate);
				pstmtUpdate.setString(1, company.getName());
				pstmtUpdate.setInt(2, company.getCompanyid());
				pstmtUpdate.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// save all top departments
			for (Department dept : company.getDepts()) {
				persistDept(dept, company.getCompanyid(), null);
			}
			// clear the database
			clear(deptIds, "department", company.getCompanyid());
			clear(employeeIds, "employee", company.getCompanyid());
			// reset flags
			company.setChanged(false);
			company.getDepts().setUnchanged();
		}
		company.setChanged(false);

	}

	private void persistDept(Department dept, Integer companyId,
			Integer upperDeptId) {
		if (dept.isChanged()) {
			try {
				if (dept.getDeptid() == 0) {
					// insert new department entry
					String sqlInsert = "INSERT department(name, cid, did) VALUES (?,?,?)";
					PreparedStatement pstmtInsert = myConnection.getConn()
							.prepareStatement(sqlInsert);
					pstmtInsert.setString(1, dept.getName());
					pstmtInsert.setInt(2, companyId);
					if (upperDeptId != null)
						pstmtInsert.setInt(3, upperDeptId);
					else
						pstmtInsert.setNull(3, Types.INTEGER);
					pstmtInsert.execute();
					// get the auto-generated id and store it in the
					// department's field
					String sqlSelectId = "SELECT max(id) AS maxid FROM department";
					PreparedStatement pstmtSelectId = myConnection.getConn()
							.prepareStatement(sqlSelectId);
					ResultSet idR = pstmtSelectId.executeQuery();
					idR.next();
					// TODO: this is not a reliable method of determining the id
					dept.setDeptid(idR.getInt("maxid"));
				} else {
					// update department entry
					String sqlUpdate = "UPDATE department SET name = ?, cid = ?, did = ? WHERE id = ?";
					PreparedStatement pstmtUpdate = myConnection.getConn()
							.prepareStatement(sqlUpdate);
					pstmtUpdate.setString(1, dept.getName());
					pstmtUpdate.setInt(2, companyId);
					if (upperDeptId != null)
						pstmtUpdate.setInt(3, upperDeptId);
					else
						pstmtUpdate.setNull(3, Types.INTEGER);
					pstmtUpdate.setInt(4, dept.getDeptid());
					pstmtUpdate.executeUpdate();
					persistEmployee(dept.getManager(), companyId,
							dept.getDeptid(), true);

				}
				// reset flag
				dept.setChanged(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// save manager
		persistEmployee(dept.getManager(), companyId, dept.getDeptid(), true);
		// persist all employees
		for (Employee employee : dept.getEmployees())
			persistEmployee(employee, companyId, dept.getDeptid(), false);
		dept.getEmployees().setUnchanged();
		// persist all sub departments
		for (Department subDept : dept.getSubDepts())
			persistDept(subDept, companyId, dept.getDeptid());
		dept.getSubDepts().setUnchanged();

		// register department in the integer set
		deptIds.add(dept.getDeptid());

	}

	private void persistEmployee(Employee employee, Integer companyId,
			Integer deptId, boolean isManager) {
		if (employee.isChanged()) {
			try {
				if (employee.getId() == 0) {
					// save person
					String sqlInsert = "INSERT employee (name, address, salary, manager, cid, did) VALUES (?,?,?,?,?,?)";
					PreparedStatement pstmtInsert = myConnection.getConn()
							.prepareStatement(sqlInsert);
					pstmtInsert.setString(1, employee.getName());
					pstmtInsert.setString(2, employee.getAddress());
					pstmtInsert.setDouble(3, employee.getSalary());
					pstmtInsert.setBoolean(4, isManager);
					pstmtInsert.setInt(5, companyId);
					pstmtInsert.setInt(6, deptId);
					pstmtInsert.execute();

					// get the auto-generated id and store it in the employee's
					// field
					String sqlSelectId = "SELECT max(id) AS maxid FROM employee";
					PreparedStatement pstmtSelectId = myConnection.getConn()
							.prepareStatement(sqlSelectId);
					ResultSet id = pstmtSelectId.executeQuery();
					id.next();
					employee.setId(id.getInt("maxid"));
				} else {
					// update employee entry
					String sqlUpdate = "UPDATE employee SET name = ?, address = ?, salary = ?, manager =  ?, "
							+ "cid = ?, did = ? WHERE id = ?";
					PreparedStatement pstmtUpdate = myConnection.getConn()
							.prepareStatement(sqlUpdate);
					pstmtUpdate.setString(1, employee.getName());
					pstmtUpdate.setString(2, employee.getAddress());
					pstmtUpdate.setDouble(3, employee.getSalary());
					pstmtUpdate.setBoolean(4, isManager);
					pstmtUpdate.setInt(5, companyId);
					pstmtUpdate.setInt(6, deptId);
					pstmtUpdate.setInt(7, employee.getId());
					pstmtUpdate.executeUpdate();
				}
				// reset flag
				employee.setChanged(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// register employee in the integer set
		employeeIds.add(employee.getId());

	}
}
