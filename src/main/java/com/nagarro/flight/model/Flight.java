package com.nagarro.flight.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Access;

import javax.persistence.Entity;
import javax.persistence.AccessType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 *  @amrindersingh01 
 */

/*
 * class Flight stored all the detailed information of the flight
 */

@Entity
@Table(name = "Flights")
@Access(AccessType.FIELD)
public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	public String flight_no;
	
	@Id
	public String valid_till;
	
	@Id
	public String flight_time;
	
	public String flight_dur;
	public String air_line;
	public String dep_loc;
	public String arr_loc;
	public float fare;
	public String flight_class;
	
	public Flight() {
		
	}

	public Flight(String flight_no, String air_line, String dep_loc, String arr_loc, String valid_till,
			String flight_time, String flight_dur, float fare, String flight_class) {

		this.flight_no = flight_no;
		this.air_line = air_line;
		this.dep_loc = dep_loc;
		this.arr_loc = arr_loc;
		this.valid_till = valid_till;
		this.flight_time = flight_time;
		this.flight_dur = flight_dur;
		this.flight_class = flight_class;
		this.fare = fare;

	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + flight_no.hashCode();
		result = 31 * result + dep_loc.hashCode();
		result = 31 * result + arr_loc.hashCode();
		result = 31 * result + valid_till.hashCode();
		result = 31 * result + flight_time.hashCode();
		result = (int) (31 * result + fare);
		result = 31 * result + flight_dur.hashCode();
		result = 31 * result + flight_class.hashCode();

		return result;
	}

	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof Flight)) {
			return false;
		}
		Flight flight = (Flight) o;
		return fare == flight.fare  && Objects.equals(flight_no, flight.flight_no)
				&& Objects.equals(dep_loc, flight.dep_loc) && Objects.equals(arr_loc, flight.arr_loc)
				&& Objects.equals(valid_till, flight.valid_till) && Objects.equals(flight_time, flight.flight_time)
				&& Objects.equals(flight_dur, flight.flight_dur) && Objects.equals(flight_class, flight.flight_class);

	}
	
	public String getFlight_no() {
		return flight_no;
	}

	public void setFlight_no(String flight_no) {
		this.flight_no = flight_no;
	}

	public String getValid_till() {
		return valid_till;
	}

	public void setValid_till(String valid_till) {
		this.valid_till = valid_till;
	}

	public String getFlight_time() {
		return flight_time;
	}

	public void setFlight_time(String flight_time) {
		this.flight_time = flight_time;
	}

	public String getFlight_dur() {
		return flight_dur;
	}

	public void setFlight_dur(String flight_dur) {
		this.flight_dur = flight_dur;
	}

	public String getAir_line() {
		return air_line;
	}

	public void setAir_line(String air_line) {
		this.air_line = air_line;
	}

	public String getDep_loc() {
		return dep_loc;
	}

	public void setDep_loc(String dep_loc) {
		this.dep_loc = dep_loc;
	}

	public String getArr_loc() {
		return arr_loc;
	}

	public void setArr_loc(String arr_loc) {
		this.arr_loc = arr_loc;
	}

	public float getFare() {
		return fare;
	}

	public void setFare(float fare) {
		this.fare = fare;
	}

	public String getFlight_class() {
		return flight_class;
	}

	public void setFlight_class(String flight_class) {
		this.flight_class = flight_class;
	}

}

