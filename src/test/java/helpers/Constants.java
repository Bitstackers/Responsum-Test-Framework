package test.java.helpers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Constants {
	public static final String EMPLOYEE_1_NR = null;
	public static final String DEFAULT_ADDRESS_CUSTOMER = "http://192.168.2.192/";
	public static final String DEFAULT_ADDRESS_RECEPTIONIST = "http://192.168.2.190/";
	public static final String DEFAULT_ADDRESS_EMPLOYEE = "http://192.168.2.196/";
	public static final String DEFAULT_EMPLOYEE_2 = "Thomas";
	public static String DEFAULT_COMPANY = "BitStackers";
	public static String DEFAULT_EMPLOYEE_1 = "Kim Rostgaard Christensen";
	public static int CALENDAR_ENTRIES_BS = 2;
	public static int EVENTS_ENTRIES_KIM = 0;
	public static int EVENTS_ENTRIES_THOMAS = 4;
	public static Map<String, String> NUMBERS;
	static {
		Map<String, String> aMap = new HashMap<>();
		aMap.put(DEFAULT_COMPANY, "39990141");
		aMap.put(DEFAULT_EMPLOYEE_1, "39990145");
		NUMBERS = Collections.unmodifiableMap(aMap);
	}
}
