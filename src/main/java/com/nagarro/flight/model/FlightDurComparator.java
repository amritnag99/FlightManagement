package com.nagarro.flight.model;

import java.util.Comparator;

/*
 *  @amrindersingh01 
 */

/*
 * class FlightDurComparator provide comparison 
 * logic for the flight duration
 */
public class FlightDurComparator implements Comparator<Flight> {

	public int compare(Flight o1, Flight o2) {

		int compare = o1.flight_dur.compareTo(o2.flight_dur);

		return compare;
	}

}
