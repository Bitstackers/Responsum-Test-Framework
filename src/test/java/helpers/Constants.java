package test.java.helpers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Constants {
	public static final String DEFAULT_ADDRESS_CUSTOMER = "http://192.168.2.192/";
	public static final String DEFAULT_ADDRESS_RECEPTIONIST = "http://192.168.2.190/";
	public static final String DEFAULT_ADDRESS_EMPLOYEE = "http://192.168.2.196/";
	public static final String DEFAULT_COMPANY = "BitStackers";
	public static final String DEFAULT_EMPLOYEE_1 = "Kim Rostgaard Christensen";
	public static final String DEFAULT_EMPLOYEE_2 = "Thomas Løcke";
	public static final String DEFAULT_KEYWORD = "yolk";

	public static final int CALENDAR_ENTRIES_BS = 1;
	public static final int EVENTS_ENTRIES_KIM = 1;
	public static final int EVENTS_ENTRIES_THOMAS = 4;
	public static final boolean LOG_TO_STD_OUT = true;
	public static Map<String, String> NUMBERS;
	static {
		Map<String, String> aMap = new HashMap<>();
		aMap.put(DEFAULT_COMPANY, "39990141");
		aMap.put(DEFAULT_EMPLOYEE_1, "39990145");
		NUMBERS = Collections.unmodifiableMap(aMap);
	}
}
