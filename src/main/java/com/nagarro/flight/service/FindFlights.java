package com.nagarro.flight.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.nagarro.flight.controller.FlightSearch;
import com.nagarro.flight.model.Flight;
import com.nagarro.flight.utility.Constants;
import com.opencsv.CSVReader;

/*
 * @amrinder01
 */

public class FindFlights {

	public static HashMap<Flight, Character> map = new HashMap<Flight, Character>();

	public static ArrayList<Flight> generateList(FlightSearch search, EntityManager em) throws IOException, Exception {

		persistData(em);

		// creating query for fetching the required objects from database db_flights
		TypedQuery<Flight> query = em.createQuery("SELECT f FROM Flight f WHERE f.dep_loc='" + search.getDeparture()
				+ "' AND f.arr_loc='" + search.getArrival() + "'", Flight.class);

		List<Flight> results = query.getResultList();

		ArrayList<Flight> finalFlightList = new ArrayList<Flight>();
		for (Flight flight : results) {

			// input checks for date and flight class
			if ((dateCheck(flight, search.getDate()) && classCheck(flight, search.getFlight_class()))) {
				finalFlightList.add(flight);
			}

		}

		return finalFlightList;

	}

	private static void persistData(EntityManager em) throws Exception, IOException {

		File path = new File(Constants.FOLDER_PATH);
		String[] files = path.list();

		// beginning the entity manager transaction to persist the objects
		em.getTransaction().begin();

		for (String file : files) {

			String file_path = Constants.FOLDER_PATH + "\\" + file;
			CSVReader reader = new CSVReader(new FileReader(file_path), '|', '\'', 1);
			String line[];

			while ((line = reader.readNext()) != null) {

				Flight fl = new Flight(line[0], retrieve(file), line[1], line[2], line[3], line[4], line[5],
						Float.parseFloat(line[6]), line[8]);

				// storing value = availability (Y/N)
				char value = line[7].charAt(0);

				// persisting the objects if not already contained by the
				// database and it is available
				if (!map.containsKey(fl) && value == 'Y') {
					em.persist(fl);
					map.put(fl, value);

				// removing the entity if is contained by database and it is not available now
				} else if (map.containsKey(fl) && value == 'N') {
					removeEntity(em, fl);
					map.remove(fl);
				}
			}

		}

		// committing the entity manager transaction
		em.getTransaction().commit();

	}

	// function retrieve air-lines name file name
	private static String retrieve(String file) {

		int index = file.indexOf(".", 0);
		return file.substring(0, index);

	}

	// function to remove the entity which no longer available
	private static void removeEntity(EntityManager em, Flight fl) {

		Flight remove_fl = em.find(Flight.class, fl);
		em.remove(remove_fl);
	}

	// function dateCheck returns true if user entered date is before the flight's
	// valid till date
	public static boolean dateCheck(Flight key, String date) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");

		Date date1 = sdf.parse(date);
		Date date2 = sdf.parse(key.valid_till);

		if (date1.before(date2)) {
			return true;
		} else {
			return false;
		}
	}

	// function classCheck returns true if user entered class is present in flight
	// else false
	public static boolean classCheck(Flight key, String flight_class) {

		if (flight_class.equalsIgnoreCase("B") && !key.flight_class.equalsIgnoreCase("EB"))
			return false;
		else
			return true;
	}

	public static Set<String> generateArrLocList(EntityManager em) throws IOException, Exception {

		HashMap<Flight, Character> map = new HashMap<Flight, Character>();
		persistData(em);

		// creating query for fetching the required objects from database db_flights
		TypedQuery<Flight> query = em.createQuery("SELECT DISTINCT f FROM Flight f", Flight.class);

		List<Flight> results = query.getResultList();

		Set<String> finalLocList = new HashSet<String>();
		for (Flight flight : results) {

			finalLocList.add(flight.arr_loc);

		}

		return finalLocList;

	}

	public static Set<String> generateDepLocList(EntityManager em) throws IOException, Exception {

		// creating query for fetching the required objects from database db_flights
		TypedQuery<Flight> query = em.createQuery("SELECT DISTINCT f FROM Flight f", Flight.class);

		List<Flight> results = query.getResultList();

		Set<String> finalLocList = new HashSet<String>();
		for (Flight flight : results) {

			finalLocList.add(flight.dep_loc);

		}

		return finalLocList;

	}

}
