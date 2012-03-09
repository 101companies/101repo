package org.ioicompanies.lang.validation;

import java.util.Iterator;

import org.eclipse.xtext.validation.Check;
import org.ioicompanies.lang.iOI.Company;
import org.ioicompanies.lang.iOI.Department;
import org.ioicompanies.lang.iOI.Employee;
import org.ioicompanies.lang.iOI.IOIPackage;
import org.ioicompanies.lang.iOI.Model;
import org.ioicompanies.lang.iOI.impl.EmployeeImpl;
 

public class IOIJavaValidator extends AbstractIOIJavaValidator {

//	@Check
//	public void checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.getName().charAt(0))) {
//			warning("Name should start with a capital", MyDslPackage.Literals.GREETING__NAME);
//		}
//	}
	
	public static final String SALARY_TOO_LOW = "org.ioicompanies.lang.quickfix.SalaryTooLow";
	public static final String SALARY_TOO_HIGH = "org.ioicompanies.lang.quickfix.SalaryTooHigh";
	
	@Check
	public void raiseSalary(Employee employee) {
		if (employee.getSalary() < 10000) {
			int newSalary = (10000 + employee.getSalary() * 2);
			//warning("Name should start with a capital", MyDslPackage.Literals.GREETING__NAME);
			//error("You should raise the salary to: " + newSalary, IOIPackage.Literals.EMPLOYEE__SALARY);
			//warning(message, feature, code, issueData)
			warning("You should raise the salary to: " + newSalary, IOIPackage.Literals.EMPLOYEE__SALARY, SALARY_TOO_LOW, (new Integer(newSalary)).toString());
		}
	}
	
	@Check
	public void cutSalary(Employee employee) {
		if (employee.getSalary() > 10000) {
			int newSalary = (employee.getSalary() / 2);
			//warning("Name should start with a capital", MyDslPackage.Literals.GREETING__NAME);
			//error("You should raise the salary to: " + newSalary, IOIPackage.Literals.EMPLOYEE__SALARY);
			//warning(message, feature, code, issueData)
			warning("You should cut the salary to: " + newSalary, IOIPackage.Literals.EMPLOYEE__SALARY, SALARY_TOO_HIGH, (new Integer(newSalary)).toString());
		}
	}
	
	
	@Check
	public void totalSalary(Department department) {
		
		int total = 0;
				
//		for (Iterator companies = model.getCompanies().iterator(); companies.hasNext();) {
//			Company company = (Company) companies.next();
			
//			for (Iterator departments = company.getDepartments().iterator(); departments.hasNext();) {
//				Department department = (Department) departments.next();
			
				for (Iterator employees = department.getEmployees().iterator(); employees
						.hasNext();) {
					Employee employee = (Employee) employees.next();
					
					try {
						total = total + employee.getSalary();
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
				
				try {
					total = total + department.getManager().getSalary();
				} catch (Exception e) {
					// TODO: handle exception
				}

//			}
			//System.out.println("OIOIOI" + total);
			//warning("Total salary is: " + total, IOIPackage.Literals.COMPANY__NAME);
//		}  
		info("Total salary is: " + total, IOIPackage.Literals.DEPARTMENT__NAME);
	}
}
