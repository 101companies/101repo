package org.softlang.util;

import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * We build a company from SQL Data.
 * 
 */
public class ObjectFactory {

	private MyConnection myConnection;

	public ObjectFactory(MyConnection myConnection) {
		this.myConnection = myConnection;
		if (!myConnection.getIsConnected())
			myConnection.connect();

	}

	public Company loadCompany(Company company) {
		try {
			// get company id
			String sqlId = "SELECT id FROM company WHERE name = ?";
			PreparedStatement pstmtId = myConnection.getConn()
			.prepareStatement(sqlId);
			pstmtId.setString(1, company.getName());
			ResultSet cIdR = pstmtId.executeQuery();
			cIdR.next();
			company.setCompanyid(cIdR.getInt("id"));
			// get all "top departments" (departments with no upper department)
			String sqlDepts = "SELECT id FROM department WHERE did IS NULL " +
					"AND cid = (SELECT id FROM company WHERE name = ?);";
			PreparedStatement pstmtDepts = myConnection.getConn()
					.prepareStatement(sqlDepts);
			pstmtDepts.setString(1, company.getName());
			ResultSet deptIdsR = pstmtDepts.executeQuery();
			// create each department from it's database primary key and add it
			// the company's department list
			while (deptIdsR.next()) {
				Department dept = new Department(deptIdsR.getInt("id"));
				dept.setObjectFactory(this);
				dept.setLoaded(false);
				company.getDepts().add(dept);
			}
			// reset flags
			company.setChanged(false);
			company.getDepts().setUnchanged();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return company;
	}

	public Department loadDept(Department dept) {
		try {
			int deptId = dept.getDeptid();
			// get department entry from database
			String sqlDept = "SELECT * FROM department WHERE id = ?";
			PreparedStatement pstmtDept = myConnection.getConn()
					.prepareStatement(sqlDept);
			pstmtDept.setInt(1, deptId);
			ResultSet deptR = pstmtDept.executeQuery();
			deptR.next();
			dept.setName(deptR.getString("name"));
			String sqlManager = "SELECT id FROM employee WHERE did = ? AND manager";
			PreparedStatement pstmtManager = myConnection.getConn()
			.prepareStatement(sqlManager);
			pstmtManager.setInt(1, deptId);
			ResultSet deptManager = pstmtManager.executeQuery();
			deptManager.next();
			Employee manager = new Employee(deptManager.getInt("id"));
			manager.setObjectFactory(this);
			manager.setLoaded(false);
			dept.setManager(manager);
			// get all department's employees
			String sqlEmployees = "SELECT id FROM employee WHERE did = ? AND NOT manager";
			PreparedStatement pstmtEmployees = myConnection.getConn()
					.prepareStatement(sqlEmployees);
			pstmtEmployees.setInt(1, deptId);
			ResultSet employeesR = pstmtEmployees.executeQuery();
			while (employeesR.next()) {
				Employee employee = new Employee(employeesR
						.getInt("id"));
				employee.setObjectFactory(this);
				employee.setLoaded(false);
				dept.getEmployees().add(employee);
			}
			// get all sub departments
			String sqlSubDepts = "SELECT id FROM department WHERE did = ?";
			PreparedStatement pstmtSubDepts = myConnection.getConn()
					.prepareStatement(sqlSubDepts);
			pstmtSubDepts.setInt(1, deptId);
			ResultSet subDeptsR = pstmtSubDepts.executeQuery();
			while (subDeptsR.next()) {
				Department subDept = new Department(subDeptsR.getInt("id"));
				subDept.setObjectFactory(this);
				subDept.setLoaded(false);
				dept.getSubDepartments().add(subDept);
			}
			// reset flags
			dept.setChanged(false);
			dept.getSubDepartments().setUnchanged();
			dept.getEmployees().setUnchanged();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dept;
	}

	public Employee loadEmployee(Employee employee) {
		try {
			int employeeId = employee.getEmployeeid();
			// get employee entry from database
			String sqlEmployee = "SELECT * FROM employee WHERE id = ?";
			PreparedStatement pstmtEmployee = myConnection.getConn()
					.prepareStatement(sqlEmployee);
			pstmtEmployee.setInt(1, employeeId);
			ResultSet employeeR = pstmtEmployee.executeQuery();
			employeeR.next();
			// set salary and person information
			employee.setSalary(employeeR.getDouble("salary"));
			employee.setName(employeeR.getString("name"));
			employee.setAddress(employeeR.getString("address"));
			// reset flag
			employee.setChanged(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}
}
