package com.nagarro.flight.controller;

/*
 * @amrinder01
 */

public class FlightSearch {

	private String departure;
	private String arrival;
	private String date;
	private String flight_class;
	private String preference;

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getFlight_class() {
		return flight_class;
	}

	public void setFlight_class(String flight_class) {
		this.flight_class = flight_class;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
