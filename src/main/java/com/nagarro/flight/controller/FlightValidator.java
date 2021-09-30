package com.nagarro.flight.controller;

import java.util.regex.Pattern;

import com.nagarro.flight.utility.Constants;

/*
 * @amrinder01
 */

public class FlightValidator {

	private static final String CLASS = "Please enter valid class";
	private static final String DATE = "Please enter valid date";
	private static final String ARRIVAL_CODE = "Please enter valid arrival code";
	private static final String DEPARTURE_CODE = "Please enter valid departure code";

	public static String validate(FlightSearch search) {

		if (!search.getDeparture().matches("(" + Constants.LOCATIONS_CODE[0] + "|" + Constants.LOCATIONS_CODE[1] + "|"
				+ Constants.LOCATIONS_CODE[2] + ").*")) {
			return DEPARTURE_CODE;

		} else if (!search.getArrival().matches("(" + Constants.LOCATIONS_CODE[0] + "|" + Constants.LOCATIONS_CODE[1]
				+ "|" + Constants.LOCATIONS_CODE[2] + ").*")) {
			return ARRIVAL_CODE;

		} else if (!Pattern.matches(Constants.DATE_PATTERN, search.getDate())) {
			return DATE;

		} else if (!search.getFlight_class()
				.matches("(" + Constants.FLIGHT_CLASSES[0] + "|" + Constants.FLIGHT_CLASSES[1] + ").*")) {
			return CLASS;

		} else

			return "";

	}

}
