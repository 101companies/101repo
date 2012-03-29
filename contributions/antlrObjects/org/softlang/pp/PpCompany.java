package org.softlang.pp;

import org.softlang.company.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class PpCompany {

	private Writer writer;
	int indent = 0;

	// Local write that swallows checked exception, too
	private void write(String s) {
		try {
			writer.write(s);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}		
	}

	// Convenient macros for pretty printing
	private void space() { write(" "); }
	private void nl() { write("\n"); }
	private void right() { indent += 3; }
	private void left() { indent -= 3; }
	private void indent() { for(int i=0; i<indent; i++) space(); }		
			
	public void ppCompany(Company c, String s) throws IOException {
		writer = new OutputStreamWriter(new FileOutputStream(s));
		write("company");
		space();
		write(c.getName());
		space();
		write("{");
		right();
		nl();
		for (Department d : c.getDepts())
			ppDept(d);
		left();
		indent();
		write("}");
		writer.close();
	}
	public void ppDept(Department d) {
		indent();
		write("department");
		space();
		write(d.getName());
		space();
		write("{");
		right();
		nl();
		ppEmployee(true,d.getManager());
		for (Employee e : d.getEmployees())
			ppEmployee(false, e);
		for (Department s : d.getSubdepts())
			ppDept(s);
		left();
		indent();
		write("}");
		nl();
	}
	public void ppEmployee(boolean isManager, Employee e) {
		indent();
		if (isManager)
			write("manager");
		else
			write("employee");
		space();
		write(e.getName());
		write("{");
		right();
		nl();
		indent();
		write("address");
		space();
		write(e.getAddress());
		nl();
		indent();
		write("salary");
		space();
		write(Double.toString(e.getSalary()));
		nl();
		left();
		indent();
		write("}");
		nl();
	}
}
