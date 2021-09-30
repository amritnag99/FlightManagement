package com.nagarro.flight.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.nagarro.flight.controller.FlightSearch;
import com.nagarro.flight.model.FareComparator;
import com.nagarro.flight.model.Flight;
import com.nagarro.flight.model.FlightDurComparator;
import com.nagarro.flight.utility.Constants;

/*
 * @amrinder01
 */

public class ProvideService {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);

	public static List<Flight> provideList(FlightSearch search) {

		// creating entity manager for persistence unit "flight" and database
		// "db_flights"
		EntityManager em = emf.createEntityManager();

		ArrayList<Flight> flight_list = null;

		try {
			flight_list = FindFlights.generateList(search, em);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sort_flight(flight_list, search);
	}

	public static Set<String> provideArrLocList() {

		EntityManager em = emf.createEntityManager();

		Set<String> arr_loc_list = null;

		try {
			arr_loc_list = FindFlights.generateArrLocList(em);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arr_loc_list;
	}

	public static Set<String> provideDepLocList() {

		EntityManager em = emf.createEntityManager();

		Set<String> dep_loc_list = null;

		try {
			dep_loc_list = FindFlights.generateDepLocList(em);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dep_loc_list;
	}

	// function sort_flight returns sorted array-list in accordance to the
	// preference (0: sort by fare, 1: sort by flight duration)
	public static ArrayList<Flight> sort_flight(ArrayList<Flight> list, FlightSearch search) {

		if (search.getPreference().equals("0")) {
			Collections.sort(list, new FareComparator());
			return list;
		} else {
			Collections.sort(list, new FlightDurComparator());
			return list;
		}
	}

}
