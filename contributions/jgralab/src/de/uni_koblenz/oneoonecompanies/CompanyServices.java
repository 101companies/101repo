package de.uni_koblenz.oneoonecompanies;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import de.uni_koblenz.jgralab.GraphIOException;
import de.uni_koblenz.jgralab.JGraLab;
import de.uni_koblenz.jgralab.greql2.evaluator.GreqlEvaluator;
import de.uni_koblenz.jgralab.greql2.jvalue.JValue;
import de.uni_koblenz.jgralab.gretl.Context;
import de.uni_koblenz.jgralab.gretl.MatchReplace;
import de.uni_koblenz.jgralab.utilities.tg2dot.Tg2Dot;
import de.uni_koblenz.jgralab.utilities.tg2dot.dot.GraphVizOutputFormat;
import de.uni_koblenz.oneoonecompanies.schema.CompaniesGraph;
import de.uni_koblenz.oneoonecompanies.schema.Company;
import de.uni_koblenz.oneoonecompanies.schema.Employee;
import de.uni_koblenz.oneoonecompanies.schema.OneOOneSchema;

/**
 * Provide many 101companies features through a single service object
 */
public class CompanyServices {

	// Turn off logging
	static {
		JGraLab.setLogLevel(Level.OFF);
	}

	// The singleton for the service object
	private static CompanyServices instance;

	// The graph on which to serve
	private CompaniesGraph graph;

	// A GReQL evaluator
	private GreqlEvaluator eval;

	// The singleton constructor which loads graph into memory
	private CompanyServices() {
	}

	// Accessor for singleton for company services
	public static CompanyServices instance() {
		if (instance == null) {
			instance = new CompanyServices();
		}
		return instance;
	}

	/**
	 * Load previously persisted graph
	 */
	public void loadGraph(String s) {
		File gf = new File(s);
		if (gf.exists()) {
			try {
				graph = OneOOneSchema.instance().loadCompaniesGraph(
						gf.getPath());
			} catch (GraphIOException e) {
				e.printStackTrace();
			}
		}
		eval = new GreqlEvaluator((String) null, graph, null);
	}

	/**
	 * Look up company by name
	 */
	public Company getCompany(String name) {
		for (Company c : graph.getCompanyVertices()) {
			if (c.get_name().equals(name)) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Total all salaries for employees of a company
	 */
	public double totalSalaries(Company c) {
		return greqlEval(
				"sum(from p: V{Employee} with getVertex(" + c.getId()
						+ ") <>--* p" + " reportSet p.salary end)").toDouble();
	}

	/**
	 * Cut all salaries for employees of a company
	 */
	public void cutSalaries(Company c) {
		// Use GReQL for iterating many hops in java
		for (Employee p : c.reachableVertices("<>--* & {Employee}",
				Employee.class)) {
			p.set_salary(p.get_salary() / 2.0d);
		}
	}

	/**
	 * Cut all salaries for employees of a company with GReTL
	 */
	public void cutSalariesWithGReTL(Company c) {
		Context context = new Context(graph);
		new MatchReplace(context, "('$[0]' | salary = '$[0].salary / " + 2.0d
				+ "')", "getVertex(" + c.getId() + ") <>--* & {Employee}")
				.execute();
	}

	/**
	 * Determine depth of department nesting
	 */
	public int depthOfDeptartmentStructure(Company c) {
		return greqlEval(
				"depth(pathSystem(getVertex(" + c.getId() + "), "
						+ "  <>--{HasDepartment} <>--{HasSubDepartment}*))")
				.toInteger();
	}

	/**
	 * Add a mentoring relationship
	 */
	public void addMentor(Company c, String mentorName, String menteeName) {
		Employee mentor = (Employee) greqlEval(
				"theElement(from p: V{Employee} with p.name = '" + mentorName
						+ "' and getVertex(" + c.getId()
						+ ") <>--* p reportSet p end)").toVertex();
		Employee mentee = (Employee) greqlEval(
				"theElement(from p: V{Employee} with p.name = '" + menteeName
						+ "' and getVertex(" + c.getId()
						+ ") <>--* p reportSet p end)").toVertex();

		// Check that mentee doesn't have a mentor already
		if (mentee.get_mentor() != null) {
			throw new RuntimeException(menteeName + " (" + mentee
					+ ") already has a mentor!");
		}

		mentee.add_mentor(mentor);
	}

	/**
	 * Visualize company graph
	 */
	public void visualizeGraph(String s) {
		try {
			final File png = new File(s);
			png.deleteOnExit();
			Tg2Dot.convertGraph(graph, png.getCanonicalPath(),
					GraphVizOutputFormat.PNG);
			final Image i = ImageIO.read(png);
			JPanel panel = new JPanel() {
				private static final long serialVersionUID = -891941166683362373L;

				@Override
				public void paintComponent(Graphics g) {
					g.drawImage(i, 0, 0, null);
				}
			};
			panel.setPreferredSize(new Dimension(i.getWidth(panel), i
					.getHeight(panel)));
			panel.setVisible(true);
			JFrame f = new JFrame("Company Graph");
			f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			JScrollPane sp = new JScrollPane(panel);
			f.getContentPane().add(sp);
			f.setSize(400, 400);
			f.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Helper for GReQL query evaluation
	private JValue greqlEval(String query) {
		eval.setQuery(query);
		eval.startEvaluation();
		return eval.getEvaluationResult();
	}
}
