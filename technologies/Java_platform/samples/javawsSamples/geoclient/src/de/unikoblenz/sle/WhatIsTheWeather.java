package de.unikoblenz.sle;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

/**
 * Retrieve weather forecast
 * 
 * @author pek
 */
public class WhatIsTheWeather {
	
	public static final void main(String[] args) {
		GlobalWeatherSoap weatherService = new GlobalWeather().getGlobalWeatherSoap();
		String weather = weatherService.getWeather(
				"Koeln / Bonn", // city 
				"Germany"		// country
			);
		System.out.println(weather);
	}
}