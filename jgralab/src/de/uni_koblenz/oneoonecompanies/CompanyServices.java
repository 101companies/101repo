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
import de.uni_koblenz.oneoonecompanies.schema.OneOOneSchema;
import de.uni_koblenz.oneoonecompanies.schema.Person;

public class CompanyServices {
	static {
		JGraLab.setLogLevel(Level.OFF);
	}

	private CompaniesGraph graph;
	private static CompanyServices instance;
	private GreqlEvaluator eval;

	private CompanyServices() {
		File gf = new File("companies.tg");
		if (gf.exists()) {
			try {
				graph = OneOOneSchema.instance().loadCompaniesGraph(
						gf.getPath());
			} catch (GraphIOException e) {
				e.printStackTrace();
			}
		}
		if (graph == null) {
			resetGraph();
		}
		eval = new GreqlEvaluator((String) null, graph, null);
	}

	public static CompanyServices instance() {
		if (instance == null) {
			instance = new CompanyServices();
		}
		return instance;
	}

	public long totalSalaries(Company c) {
		return Math.round(greqlEval(
				"sum(from p: V{Person} with getVertex(" + c.getId()
						+ ") <>--* p" + " reportSet p.salary end)").toDouble());
	}

	public void cutSalaries(Company c, float factor) {
		// Use GReQL for iterating many hops in java
		for (Person p : c.reachableVertices("<>--* & {Person}", Person.class)) {
			p.set_salary(Math.round(p.get_salary() / factor));
		}
	}

	public void cutSalariesWithGReTL(Company c, float facor) {
		Context context = new Context(graph);
		new MatchReplace(context, "('$[0]' | salary = 'round($[0].salary / "
				+ facor + ")')", "getVertex(" + c.getId()
				+ ") <>--* & {Person}").execute();
	}

	public int depthOfDeptartmentStructure(Company c) {
		return greqlEval(
				"depth(pathSystem(getVertex(" + c.getId() + "), "
						+ "  <>--{HasDepartment} <>--{HasSubDepartment}*))")
				.toInteger();
	}

	public void resetGraph() {
		graph = CompanyCreator.createCompanyGraph();
		try {
			OneOOneSchema.instance().saveCompaniesGraph(
					new File("companies.tg").getPath(), graph);
		} catch (GraphIOException e) {
			e.printStackTrace();
		}
	}

	public void visualizeCompanies() {
		try {
			final File png = new File("companies.png");
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
			JFrame f = new JFrame("Companies");
			f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			JScrollPane sp = new JScrollPane(panel);
			f.getContentPane().add(sp);
			f.setSize(400, 400);
			f.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private JValue greqlEval(String query) {
		eval.setQuery(query);
		eval.startEvaluation();
		return eval.getEvaluationResult();
	}

	public Company getCompany(String name) {
		for (Company c : graph.getCompanyVertices()) {
			if (c.get_name().equals(name)) {
				return c;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Company meganalysis = CompanyServices.instance().getCompany(
				"Meganalysis");

		System.out.println("Before cut: "
				+ CompanyServices.instance().totalSalaries(meganalysis));

		CompanyServices.instance().cutSalaries(meganalysis, 2);
		System.out.println("After first cut: "
				+ CompanyServices.instance().totalSalaries(meganalysis));

		CompanyServices.instance().cutSalariesWithGReTL(meganalysis, 2);
		System.out.println("After 2nd cut: "
				+ CompanyServices.instance().totalSalaries(meganalysis));

		System.out.println("Depth of department structure: "
				+ CompanyServices.instance().depthOfDeptartmentStructure(
						meganalysis));

		CompanyServices.instance().visualizeCompanies();
	}
}
