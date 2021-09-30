package com.nagarro.flight.utility;

/*
 * @amrinder01
 */

public class Constants {
	
	public static final String PERSISTENCE_UNIT_NAME = "flight";
	public static final String ENTER_DEP = "Enter Departure Location code (Delhi:DEL, Mumbai: MUB, Bangalore:BGR):";
	public static final String ENTER_ARR = "Enter Arrival Location code (Delhi:DEL, Mumbai: MUB, Bangalore:BGR):";
	public static final String ENTER_DATE = "Enter Date in DD-MM-YYYY format:";
	public static final String ENTER_CLASS = "Enter class (E:Economics, B:Business)";
	public static final String ENTER_PREFERENCE = "Enter your preference to sort the available flights \n (0:sort by fare, 1:sort by flight duration)";
	public static final String Y_N = "Do you want to search more flight, if yes enter y/Y or if no enter n/N";
	public static final String FOLDER_PATH = "C:\\Users\\amrindersingh01\\eclipse-web-workspace\\flightmanagement\\Data";
	public static final String NOT_FOUND = "Sorry, no flight find in accordance to the input";

	public static final String OUT_FORMAT = "\t\t| %-10s | %-13s | %-10.2f | %-8s |";
	public static final String OUT_HEAD_FORMAT = "\t\t| %-10s | %-13s | %-10s | %-8s |";
	public static final String OUT_AIR_LINE = "Air Line";
	public static final String OUT_TILL = "Valid Till";
	public static final String OUT_DURATION = "Duration";
	public static final String OUT_FARE = "Fare";
	public static final String BUSINESS_CLASS = "B";
	public static final String LINE_SYMBOL = "=";
	public static final int LENGTH = 54;

	public static final float INC_B_FARE = (float) (1 + 0.4);
	public static final float INC_E_FARE = 1;

	public static final String DATE_PATTERN = "^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4}$";
	public static final String DATE_EXCEPTION = "Invalid date, please enter date in valid format!";
	public static final String[] LOCATIONS_CODE = { "DEL", "MUB", "BGR" };
	public static final String LOC_CODE_EXCEPTION = "Invalid location code, please enter valid code!";
	public static final String[] FLIGHT_CLASSES = { "E", "B" };
	public static final String CLASS_EXCEPTION = "Please enter valid class (E:economics, B:business)";
	public static final String PREFERENCE_EXCEPTION = "Please enter valid preference (0:sort by fare, 1:sort by flight duration)";
	

	public static String FLIGHT_CLASS = ""; // E/B (E:economics, B:business)
	public static int PREFERENCE = 0;


}
