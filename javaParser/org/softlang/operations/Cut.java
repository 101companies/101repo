package org.softlang.operations;

import org.softlang.parser.Parser;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class Cut extends Parser {
	
	private Writer writer;
	int indent = 0;
	
	public void parse(String in, String out) throws IOException {
		writer = new OutputStreamWriter(new FileOutputStream(out));
		super.parse(in);
		writer.close();
	}

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
	
	protected void openCompany(String name) {
		write("company");
		space();
		write(name);
		write("{");
		nl();
		right();
	}

	protected void closeCompany(String name) {
		left();
		indent();
		write("}");
		nl();
	}

	protected void openDept(String name) {
		indent();
		write("department");
		space();
		write(name);
		space();
		write("{");
		nl();
		right();
	}

	protected void closeDept(String name) {
		left();
		indent();
		write("}");
		nl();
	}

	protected void handleEmployee(boolean isManager, String name, String address, Double salary) {
		indent();
		if (isManager)
			write("manager");
		else
			write("employee");
		space();
		write(name);
		space();
		write("{");
		nl();
		right();
		indent();	
		write("address");
		space();
		write(address);
		nl();
		indent();	
		write("salary");
		space();
		write(Double.toString(salary / 2.0d));
		left();		
		nl();
		indent();
		write("}");
		nl();
	}
}
