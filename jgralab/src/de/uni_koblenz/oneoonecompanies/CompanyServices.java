package de.uni_koblenz.oneoonecompanies;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import de.uni_koblenz.jgralab.greql2.evaluator.GreqlEvaluator;
import de.uni_koblenz.jgralab.greql2.jvalue.JValue;
import de.uni_koblenz.jgralab.utilities.tg2dot.Tg2Dot;
import de.uni_koblenz.jgralab.utilities.tg2dot.dot.GraphVizOutputFormat;
import de.uni_koblenz.oneoonecompanies.schema.CompaniesGraph;
import de.uni_koblenz.oneoonecompanies.schema.Person;

public class CompanyServices {
	private CompaniesGraph graph;
	private static CompanyServices instance;
	private GreqlEvaluator eval;

	private CompanyServices() {
		graph = CompanyCreator.createCompanyGraph();
		eval = new GreqlEvaluator((String) null, graph, null);
	}

	public static CompanyServices instance() {
		if (instance == null) {
			instance = new CompanyServices();
		}
		return instance;
	}

	public long getSumOfSalaries() {
		return Math.round(greqlEval(
				"sum(from p: V{Person} reportSet p.salary end)").toDouble());
	}

	public void cutSalaries(float factor) {
		for (Person p : graph.getPersonVertices()) {
			p.set_salary(Math.round(p.get_salary() / factor));
		}
	}

	public void visualizeCompanies() {
		try {
			final File png = new File("companies.png");
			Tg2Dot.convertGraph(graph, png.getCanonicalPath(),
					GraphVizOutputFormat.PNG);
			// TODO: add ScrollPanes
			JFrame f = new JFrame() {
				private static final long serialVersionUID = -891941166683362373L;

				@Override
				public void paint(Graphics g) {
					try {
						g.drawImage(ImageIO.read(png), 0, 0, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			};
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

	public static void main(String[] args) {
		System.out.println("Before cut: "
				+ CompanyServices.instance().getSumOfSalaries());
		CompanyServices.instance().cutSalaries(2);
		System.out.println("After cut: "
				+ CompanyServices.instance().getSumOfSalaries());
		CompanyServices.instance().visualizeCompanies();
	}
}
