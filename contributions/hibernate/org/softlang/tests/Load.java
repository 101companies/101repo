package org.softlang.tests;

import org.junit.Test;
import org.softlang.features.Persistence;

// See README for detailed usage instructions

public class Load {

	@Test
	public void test() {
		new Persistence().loadCompany("meganalysis");
	}
}
