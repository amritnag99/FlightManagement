package com.nagarro.flight.model;

import java.util.Comparator;

/*
 *  @amrindersingh01 
 */

/*
 * class FareComparator provide comparison 
 * logic for the flight fare
 */
public class FareComparator implements Comparator<Flight> {

	public int compare(Flight o1, Flight o2) {
		return (int) (o1.fare - o2.fare);
	}

}