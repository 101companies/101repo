package de.unikoblenz.sle;

import net.webservicex.Country;
import net.webservicex.CountrySoap;

/**
 * Retrieve information about Germany
 * 
 * @author pek
 */
public class WhatGMTandISOare {
	
	public static void main(String[] args) {
		CountrySoap countryInfo = new Country().getCountrySoap();
		String countryName = "Germany";
		String GMTzone = countryInfo.getGMTbyCountry(countryName);
		String ISOcode = countryInfo.getISOCountryCodeByCountyName(countryName);
		System.out.println(GMTzone);
		System.out.println(ISOcode);
	}
}
