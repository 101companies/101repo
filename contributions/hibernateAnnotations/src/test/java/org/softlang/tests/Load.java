package org.softlang.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.softlang.company.Company;
import org.softlang.features.Persistence;

// See online documentation for detailed instructions

public class Load {

	protected Persistence manager;
	protected Company sampleCompany;

	// Making available the load sequence for other tests
	protected void load() {
		manager = new Persistence();
		sampleCompany = manager.loadCompany("Acme Corporation");
	}

	@Test
	public void testLoad() {
		load();
		assertNotNull(sampleCompany);
	}
}