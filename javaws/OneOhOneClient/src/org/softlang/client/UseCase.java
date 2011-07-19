package org.softlang.client;

import java.net.URL;

import javax.xml.namespace.QName;

import org.softlang.service.*;


public class UseCase {

	public static final void main(String[] args) throws Exception {

		// Connecting to the server
		URL localWSDL = new URL("http://127.0.0.1:8080/OneOhOneCompanies/Portal?wsdl");
		QName qname = new QName("http://service.softlang.org/", "PortalService");		
		Portal service = new PortalService(localWSDL, qname).getPortalPort();
		service.reset(); // because server is statically initialized
		
		/* Use case #1: double checking total */
		System.out.println("/* Use case #1: double checking total */\n");
		
		// Total as provided by the server
		Double totalCompany = service.totalCompany();
		System.out.printf("Total calculated on server side = %.2f\n", totalCompany);
		
		// Total calculated here, on the client side
		CompanyDTO company = service.getCompany();
		double totalCompany_here = 0;
		for (DepartmentDTO dep : company.getDepts()) {
			totalCompany_here += total(dep);
		}
	
		System.out.printf("Total calculated on client side = %.2f\n", totalCompany_here);
		
		/* Use case #2: change company name */
		System.out.println("\n/* Use case #2: change company name */\n");
		
		System.out.printf("Name of the company as it was   = %s\n", company.getName());
		
		//Changing the name
		service.setCompanyName("giganalysis");
		company = service.getCompany();
		System.out.printf("Name of the company as it's now = %s\n", company.getName());

		/* Use case #3: saving some money */
		System.out.println("\n/* Use case #3: saving some money */\n");
		
		System.out.printf("Total salary at the moment     = %.2f\n", service.totalCompany());
		
		// Cut it twice
		service.cutCompany();
		System.out.printf("Total salary after the cut     = %.2f\n", service.totalCompany());
 
		// Cut it some more
		service.cutCompany();
		System.out.printf("Total salary after the 2nd cut = %.2f\n", service.totalCompany());
				
		/* Use case #4: changing name, moving, transferring money to a Swiss bank */
		System.out.println("\n/* Use case #4: changing name, moving, transferring money to a Swiss bank */\n");
		
		// As it's now
		EmployeeDTO ralf = service.getEmployee("Ralf");
		System.out.println("How it is now:\n");
		System.out.printf("Name    = %s \n", ralf.getName());
		System.out.printf("Address = %s \n", ralf.getAddress());
		System.out.printf("Salary  = %.2f \n", ralf.getSalary());
		
		// And now we move
		service.setEmployeeName("Ralf", "Professor F.");
		service.setEmployeeAddress("Professor F.", "Richmond");
		service.setEmployeeSalary("Professor F.", Double.valueOf(12345));
		
		EmployeeDTO prof = service.getEmployee("Professor F.");
		System.out.println("\nLet's see:\n");
		System.out.printf("Name    = %s \n", prof.getName());
		System.out.printf("Address = %s \n", prof.getAddress());
		System.out.printf("Salary  = %.2f \n", prof.getSalary());
	}

	private static double total(DepartmentDTO dep) {
		double res = 0;
		
		res += dep.getManager().getSalary();
		
		for (EmployeeDTO emp : dep.getEmployees()) {
			res += emp.getSalary();
		}
		
		for (DepartmentDTO subdep : dep.getSubdepts()) {
			res += total(subdep);
		}
		
		return res;
	}
	
}
