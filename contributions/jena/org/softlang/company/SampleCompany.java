package org.softlang.company;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Construct a sample RDF company.
 * This simple also gets saved in sampleCompany.rdf. 
 */
public class SampleCompany {

	public static Model getSample() {

		CompanyModel builder = new CompanyModel();

		builder
				.createCompany(builder
						.getModel()
						.createBag()
						.add(
								builder
										.createDept(
												builder.NS_COMPANY
														+ "research",
												"Research",
												builder
														.createEmployee(
																builder.NS_COMPANY
																		+ "craig",
																builder
																		.createPerson(
																				"Craig",
																				"Redmond"),
																123456.0, null),
												builder
														.getModel()
														.createBag()
														.add(
																builder
																		.createEmployee(
																				builder.NS_COMPANY
																						+ "erik",
																				builder
																						.createPerson(
																								"Erik",
																								"Utrecht"),
																				12345.0,
																				builder
																						.getModel()
																						.getResource(
																								builder.NS_COMPANY
																										+ "craig")))
														.add(
																builder
																		.createEmployee(
																				builder.NS_COMPANY
																						+ "ralf",
																				builder
																						.createPerson(
																								"Ralf",
																								"Koblenz"),
																				1234.0,
																				builder
																						.getModel()
																						.getResource(
																								builder.NS_COMPANY
																										+ "erik"))),
												builder.getModel().createBag()))
						.add(
								builder
										.createDept(
												builder.NS_COMPANY
														+ "development",
												"Development",
												builder
														.createEmployee(
																builder.NS_COMPANY
																		+ "ray",
																builder
																		.createPerson(
																				"Ray",
																				"Redmond"),
																234567.0, null),
												builder.getModel().createBag(),
												builder
														.getModel()
														.createBag()
														.add(
																builder
																		.createDept(
																				builder.NS_COMPANY
																						+ "Dev1",
																				"Dev1",
																				builder
																						.createEmployee(
																								builder.NS_COMPANY
																										+ "klaus",
																								builder
																										.createPerson(
																												"Klaus",
																												"Boston"),
																								23456.0,
																								builder
																										.getModel()
																										.getResource(
																												builder.NS_COMPANY
																														+ "ray")),
																				builder
																						.getModel()
																						.createBag(),
																				builder
																						.getModel()
																						.createBag()
																						.add(
																								builder
																										.createDept(
																												builder.NS_COMPANY
																														+ "Dev1.1",
																												"Dev1.1",
																												builder
																														.createEmployee(
																																builder.NS_COMPANY
																																		+ "karl",
																																builder
																																		.createPerson(
																																				"Karl",
																																				"Riga"),
																																2345.0,
																																builder
																																		.getModel()
																																		.getResource(
																																				builder.NS_COMPANY
																																						+ "klaus")),
																												builder
																														.getModel()
																														.createBag()
																														.add(
																																builder
																																		.createEmployee(
																																				builder.NS_COMPANY
																																						+ "joe",
																																				builder
																																						.createPerson(
																																								"Joe",
																																								"Wifi City"),
																																				2344.0,
																																				builder
																																						.getModel()
																																						.getResource(
																																								builder.NS_COMPANY
																																										+ "karl"))),
																												builder
																														.getModel()
																														.createBag())))))));
		return builder.getModel();

	}

}
