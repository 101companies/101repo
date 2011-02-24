package org.softlang.company;

import org.softlang.util.MyConnection;
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

	public Company createCompany() {
		Company company = new Company();
		try {
			// get all "top departments" (departments with no upper department)
			String sqlDepts = "SELECT deptId FROM dept WHERE upperDeptId IS NULL";
			PreparedStatement pstmtDepts = myConnection.getConn()
					.prepareStatement(sqlDepts);
			ResultSet deptIdsR = pstmtDepts.executeQuery();
			// create each department from it's database primary key and add it
			// the company's department list
			while (deptIdsR.next()) {
				Dept dept = new Dept(deptIdsR.getInt("deptId"));
				dept.setObjectFactory(this);
				dept.setLoaded(false);
				company.getDepts().add(dept);
			}
			// reset flags
			company.setUnchanged();
			company.getDepts().setUnchanged();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return company;
	}

	public Dept loadDept(Dept dept) {
		try {
			int deptId = dept.getDeptid();
			// get department entry from database
			String sqlDept = "SELECT * FROM dept WHERE deptId = ?";
			PreparedStatement pstmtDept = myConnection.getConn()
					.prepareStatement(sqlDept);
			pstmtDept.setInt(1, deptId);
			ResultSet deptR = pstmtDept.executeQuery();
			deptR.next();
			dept.setName(deptR.getString("name"));
			Employee manager = new Employee(deptR.getInt("managerId"));
			manager.setObjectFactory(this);
			manager.setLoaded(false);
			dept.setManager(manager);
			// get all department's employees
			String sqlEmployees = "SELECT employeeId FROM employee WHERE deptId = ?";
			PreparedStatement pstmtEmployees = myConnection.getConn()
					.prepareStatement(sqlEmployees);
			pstmtEmployees.setInt(1, deptId);
			ResultSet employeesR = pstmtEmployees.executeQuery();
			while (employeesR.next()) {
				Employee employee = new Employee(employeesR
						.getInt("employeeId"));
				employee.setObjectFactory(this);
				employee.setLoaded(false);
				dept.getEmployees().add(employee);
			}
			// get all sub departments
			String sqlSubDepts = "SELECT deptId FROM dept WHERE upperDeptId = ?";
			PreparedStatement pstmtSubDepts = myConnection.getConn()
					.prepareStatement(sqlSubDepts);
			pstmtSubDepts.setInt(1, deptId);
			ResultSet subDeptsR = pstmtSubDepts.executeQuery();
			while (subDeptsR.next()) {
				Dept subDept = new Dept(subDeptsR.getInt("deptId"));
				subDept.setObjectFactory(this);
				subDept.setLoaded(false);
				dept.getSubDepartments().add(subDept);
			}
			// reset flags
			dept.setUnchanged();
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
			String sqlEmployee = "SELECT * FROM employee WHERE employeeId = ?";
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
			employee.setUnchanged();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}
}
