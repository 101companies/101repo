package de.uni_koblenz.oneoonecompanies;

import de.uni_koblenz.jgralab.greql2.evaluator.GreqlEvaluator;
import de.uni_koblenz.jgralab.greql2.jvalue.JValue;
import de.uni_koblenz.oneoonecompanies.schema.CompaniesGraph;

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

	public long totalSumOfSalaries() {
		return Math.round(greqlEval(
				"sum(from p: V{Person} reportSet p.salary end)").toDouble());
	}

	private JValue greqlEval(String query) {
		eval.setQuery(query);
		eval.startEvaluation();
		return eval.getEvaluationResult();
	}

	public static void main(String[] args) {
		System.out.println(CompanyServices.instance().totalSumOfSalaries());
	}
}
