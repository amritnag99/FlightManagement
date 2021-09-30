package com.nagarro.flight.controller;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarro.flight.model.Flight;
import com.nagarro.flight.service.ProvideService;

/*
 * @amrinder01
 */

@Controller
public class FlightController {

	private static final String NO_FLIGHT_FOUND = "Sorry, no flight found";
	private static final String MESSAGE = "message";
	private static final String ARR_LOCATION_LISTS = "arr_lists";
	private static final String FLIGHT_LISTS = "flight_lists";
	private static final String DEP_LOCATION_LISTS = "dep_lists";

	@RequestMapping("/home")
	public String home(final Model m) {

		final Set<String> arr_list = ProvideService.provideArrLocList();
		final Set<String> dep_list = ProvideService.provideDepLocList();

		m.addAttribute(ARR_LOCATION_LISTS, arr_list);
		m.addAttribute(DEP_LOCATION_LISTS, dep_list);

		return "search";

	}

	@RequestMapping("/search")
	public void welcome(final FlightSearch search, final Model m) {

			if (FlightValidator.validate(search).equals("")) {

				final List<Flight> list = ProvideService.provideList(search);

				m.addAttribute(FLIGHT_LISTS, list);
				if(list.size()==0) {
					m.addAttribute(MESSAGE, NO_FLIGHT_FOUND);
				}

			} else {

				m.addAttribute(MESSAGE, FlightValidator.validate(search));
			}
			
			final Set<String> arr_list = ProvideService.provideArrLocList();
			final Set<String> dep_list = ProvideService.provideDepLocList();

			m.addAttribute(ARR_LOCATION_LISTS, arr_list);
			m.addAttribute(DEP_LOCATION_LISTS, dep_list);

	}
}
